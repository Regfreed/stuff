package hr.siemens.cvc.labsensors.publishers;

import hr.siemens.cvc.labsensors.configuration.brokerConfiguration.BrokerConfig.Protocol.ProtocolSpec;

public interface Publisher{

	public String publishMessage(String message);

	public void setProtocolSpec(ProtocolSpec protocolSpec);
}
