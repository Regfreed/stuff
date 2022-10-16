package hr.siemens.cvc.labsensors.publishers;

import hr.siemens.cvc.labsensors.configuration.brokerConfiguration.BrokerConfig.Protocol.ProtocolSpec;

public class AMQPpublisher implements Publisher {

	private ProtocolSpec protocolSpec;

	public AMQPpublisher(ProtocolSpec protocolSpec) {
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
