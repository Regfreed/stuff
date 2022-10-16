package hr.siemens.cvc.labsensors.publishers;

import org.apache.log4j.Logger;

import hr.siemens.cvc.labsensors.configuration.brokerConfiguration.BrokerConfig;
import hr.siemens.cvc.labsensors.configuration.brokerConfiguration.BrokerConfig.Protocol.ProtocolSpec;
import hr.siemens.cvc.labsensors.configuration.manager.ConfigurationManager;

public class PublisherFactory {
	final static Logger log = Logger.getLogger(PublisherFactory.class);

	private ConfigurationManager configManager;
	private BrokerConfig brokerConfig;
	private boolean configStatus = false;

	public PublisherFactory() {
		configManager = ConfigurationManager.getInstance();
		if (configManager == null) {
			log.error("configManager was null");
			configStatus = false;
		} else {
			configStatus = true;
			brokerConfig = configManager.getBrokerConfig();
		}
	}

	public Publisher getPublisher(String type) {
		log.trace("creating published based on type:" + type);
		if (configStatus) {
			switch (type) {
			case "MQTT":
			case "mqtt":
				return new MQTTpublisher(findProtocolSpec(type));
			case "AMQP":
			case "amqp":
				return new AMQPpublisher(findProtocolSpec(type));
			case "OPCUA":
			case "opcua":
				return new OPCUApublisher(findProtocolSpec(type));
			default:
				log.error("protocal type not defined");
				return null;
			}
		} else {
			log.error("Configuration was not loaded correctly");
			return null;
		}

	}

	private ProtocolSpec findProtocolSpec(String type) {
		for (int i = 0; i < brokerConfig.getProtocol().size(); i++) {
			if (brokerConfig.getProtocol().get(i).equals(type)) {
				return brokerConfig.getProtocol().get(i).getProtocolSpec();
			}
		}
		log.error("could not find protocal spec for type:" + type);
		return null;
	}
}
