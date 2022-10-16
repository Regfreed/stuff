package opcua.opcua;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.identity.AnonymousProvider;
import org.eclipse.milo.opcua.sdk.client.api.identity.IdentityProvider;
import org.eclipse.milo.opcua.stack.core.security.SecurityPolicy;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.config.OpcUaClientConfig;
import org.eclipse.milo.opcua.stack.client.UaTcpStackClient;
import org.eclipse.milo.opcua.stack.core.Stack;
import org.eclipse.milo.opcua.stack.core.security.SecurityPolicy;
import org.eclipse.milo.opcua.stack.core.types.builtin.LocalizedText;
import org.eclipse.milo.opcua.stack.core.types.structured.EndpointDescription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.common.collect.ImmutableList;
import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.StatusCode;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;


public class Klijent {
	UInteger c = UInteger.valueOf(5000);
	public final Logger logger = LoggerFactory.getLogger(getClass());
	private final CompletableFuture<OpcUaClient> future = new CompletableFuture<OpcUaClient>();
	private final KeyStoreLoader loader = new KeyStoreLoader();

	public OpcUaClient createClient() throws Exception {
		IdentityProvider provider = new AnonymousProvider();
		KeyStoreLoader security = new KeyStoreLoader();
		EndpointDescription[] endpoints = UaTcpStackClient.getEndpoints("opc.tcp://Narke.Narke:48020").get();
		EndpointDescription endpoint = Arrays.stream(endpoints)
				.filter(e -> e.getSecurityPolicyUri().equals(security)).findFirst()
				.orElseThrow(() -> new Exception("no desired endpoints returned"));
		logger.info("Using endpoint: {} [{}]", endpoint.getEndpointUrl(), security);
		loader.load();
		OpcUaClientConfig config = OpcUaClientConfig.builder()
				.setApplicationName(LocalizedText.english("eclipse milo opc-ua client"))
				.setApplicationUri("urn:eclipse:milo:examples:client").setCertificate(loader.getClientCertificate())
				.setKeyPair(loader.getClientKeyPair()).setEndpoint(endpoint).setIdentityProvider(provider)
				.setRequestTimeout(c).build();
		return new OpcUaClient(config);
	}
	public void run(){
		future.whenComplete((client,ex)->{
			if(client!=null){
				try{
					client.disconnect().get();
					Stack.releaseSharedResources();
				}catch(InterruptedException | ExecutionException e){
					logger.error("Error disconnecting:", e.getMessage(), e);
				}
			}else{
				logger.error("Error running example: {}", ex.getMessage(), ex);
				Stack.releaseSharedResources();
			}
			try{
				Thread.sleep(1000);
				System.exit(0);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		});
		try{
			OpcUaClient client = createClient();
			
		}catch(Throwable t){
			future.completeExceptionally(t);
		}
		try {
            Thread.sleep(999999999);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
}
