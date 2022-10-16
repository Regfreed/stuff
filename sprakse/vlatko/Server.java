package opcua.opcua;

import java.io.File;
import java.util.EnumSet;
import java.util.concurrent.CompletableFuture;

import com.google.common.collect.ImmutableList;
import org.eclipse.milo.opcua.sdk.server.OpcUaServer;
import org.eclipse.milo.opcua.sdk.server.api.config.OpcUaServerConfig;
import org.eclipse.milo.opcua.sdk.server.identity.UsernameIdentityValidator;
import org.eclipse.milo.opcua.stack.core.application.DefaultCertificateManager;
import org.eclipse.milo.opcua.stack.core.application.DefaultCertificateValidator;
import org.eclipse.milo.opcua.stack.core.security.SecurityPolicy;
import org.eclipse.milo.opcua.stack.core.types.builtin.DateTime;
import org.eclipse.milo.opcua.stack.core.types.builtin.LocalizedText;
import org.eclipse.milo.opcua.stack.core.types.structured.BuildInfo;
import org.eclipse.milo.opcua.stack.core.types.structured.ResponseHeader;
import org.eclipse.milo.opcua.stack.core.types.structured.TestStackExRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.TestStackExResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.TestStackRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.TestStackResponse;
import org.eclipse.milo.opcua.stack.core.util.CryptoRestrictions;
import org.slf4j.LoggerFactory;

import static com.google.common.collect.Lists.newArrayList;
import static org.eclipse.milo.opcua.sdk.server.api.config.OpcUaServerConfig.USER_TOKEN_POLICY_ANONYMOUS;
import static org.eclipse.milo.opcua.sdk.server.api.config.OpcUaServerConfig.USER_TOKEN_POLICY_USERNAME;

public class Server {
	public static void main(String[] args) throws Exception {
		Server server = new Server();
		server.startup().get();
		final CompletableFuture<Void> future = new CompletableFuture<>();
		Runtime.getRuntime().addShutdownHook(new Thread(() -> future.complete(null)));
		future.get();
	}

	private final OpcUaServer server;

	public Server() throws Exception {
		CryptoRestrictions.remove();
		KeyStoreLoader loader = new KeyStoreLoader();
		DefaultCertificateManager certificateManager = new DefaultCertificateManager(loader.getServerKeyPair(),
				loader.getServerCertificate());
		File securityTempDir = new File(System.getProperty("java.io.tmpdir"), "security");
		LoggerFactory.getLogger(getClass()).info("security tempdir: {}", securityTempDir.getAbsolutePath());
		DefaultCertificateValidator certificateValidator = new DefaultCertificateValidator(securityTempDir);
		UsernameIdentityValidator identityValidator = new UsernameIdentityValidator(true, authChallenge ->{
			String username = authChallenge.getUsername();
			String password = authChallenge.getPassword();
			boolean userOK="user".equals(username)&&"password1".equals(password);
			boolean adminOK="admin".equals(username)&&"password2".equals(password);
			return userOK||adminOK;
		});
		OpcUaServerConfig serverConfig = OpcUaServerConfig.builder()
				.setApplicationUri("urn:opcua:opcua:Server")
				.setApplicationName(LocalizedText.english("Vlatkov Server"))
				.setBindAddresses(newArrayList("0.0.0.0"))
				.setBindPort(123456)
				.setBuildInfo(new BuildInfo("urn:opcua:opcua:Server",
						"opcua","Vlatko", OpcUaServer.SDK_VERSION, "", DateTime.now()))
				.setCertificateManager(certificateManager)
				.setCertificateValidator(certificateValidator)
				.setIdentityValidator(identityValidator)
				.setProductUri("urn:opcua:opcua:Server")
				.setServerName("Vlatko")
				.setSecurityPolicies(
						EnumSet.of(
						SecurityPolicy.None,
						SecurityPolicy.Basic128Rsa15,
						SecurityPolicy.Basic256,
						SecurityPolicy.Basic256Sha256))
				.setUserTokenPolicies(ImmutableList.of(
						USER_TOKEN_POLICY_ANONYMOUS,
						USER_TOKEN_POLICY_USERNAME))
				.build();
		server =new OpcUaServer(serverConfig);
		server.getNamespaceManager().registerAndAdd(namespaceUri, namespaceFunction)
	}
	public CompletableFuture<OpcUaServer> startup() {
		return server.startup();
	}
}
