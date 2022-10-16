package hr.siemens.cvc.labsensors.publishers;

import org.apache.log4j.Logger;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import hr.siemens.cvc.labsensors.configuration.brokerConfiguration.BrokerConfig.Protocol.ProtocolSpec;

public class MQTTpublisher implements Publisher {
	final static Logger log = Logger.getLogger(MQTTpublisher.class);

	private ProtocolSpec protocolSpec;
	private long messageCount = 0;

	public MQTTpublisher(ProtocolSpec protocolSpec) {
		this.protocolSpec = protocolSpec;
	}
	
	//the method receives the message content that will be sent
	@Override
	public String publishMessage(String message) {
		String topic = "mqtt.topic";
		int qos = 1;
		String broker = "tcp://localhost";
		String clientId = "ClientId";

		MemoryPersistence persistence = new MemoryPersistence();
		try {
			MqttClient mqttClient = new MqttClient(broker, clientId, persistence);

			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(true);
			mqttClient.connect(connOpts);
			MqttMessage pubMessage = new MqttMessage(message.getBytes());
			pubMessage.setQos(qos);
			System.out.println("Publish message: " + pubMessage);
			mqttClient.publish(topic, pubMessage);
			mqttClient.disconnect();
			System.exit(0);
		} catch (MqttException me) {
			System.out.println("reason " + me.getReasonCode());
			System.out.println("msg " + me.getMessage());
			System.out.println("loc " + me.getLocalizedMessage());
			System.out.println("cause " + me.getCause());
			System.out.println("excep " + me);
			me.printStackTrace();
		}
		return null;
	}

	@Override
	public void setProtocolSpec(ProtocolSpec protocolSpec) {
		this.protocolSpec = protocolSpec;

	}

}
