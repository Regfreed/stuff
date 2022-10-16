package hr.siemens.cvc.labsensors.publishers;

import hr.siemens.cvc.labsensors.configuration.brokerConfiguration.BrokerConfig.Protocol.ProtocolSpec;

public class OPCUApublisher implements Publisher {

	private ProtocolSpec protocolSpec;

	public OPCUApublisher(ProtocolSpec protocolSpec) {
		this.protocolSpec = protocolSpec;
	}

	@Override
	public String publishMessage(String message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProtocolSpec(ProtocolSpec protocolSpec) {
		this.protocolSpec = protocolSpec;

	}

}
