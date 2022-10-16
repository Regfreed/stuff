package hr.siemens.cvc.labsensors.configuration.manager;

import java.io.File;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import hr.siemens.cvc.labsensors.configuration.brokerConfiguration.BrokerConfig;
import hr.siemens.cvc.labsensors.configuration.sensorConfiguration.SensorConfiguration;

public class ConfigurationManager {
	final static Logger log = Logger.getLogger(ConfigurationManager.class);

	private SensorConfiguration sensorConfiguration;
	private BrokerConfig brokerConfig;

	private static ConfigurationManager configManger;

	public static ConfigurationManager getInstance(String directory) {
		if (configManger == null) {
			configManger = new ConfigurationManager(directory);
			return configManger;
		} else {
			return configManger;
		}
	}

	public static ConfigurationManager getInstance() {
		return configManger;
	}

	private ConfigurationManager(String directory) {

		String sensorPath = new String(directory + "SensorConfiguration.xml");
		String brokerPath = new String(directory + "BrokerConfiguration.xml");
		log.trace("sensorPath:" + sensorPath);
		log.trace("brokerPath:" + brokerPath);

		JAXBContext jcCert;
		StringWriter sw = new StringWriter();
		try {
			jcCert = JAXBContext.newInstance(SensorConfiguration.class);

			Unmarshaller unmarshaller = jcCert.createUnmarshaller();
			File xml = new File(sensorPath);
			sensorConfiguration = (SensorConfiguration) unmarshaller.unmarshal(xml);
			sw = new StringWriter();

			Marshaller marshaller = jcCert.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(sensorConfiguration, sw);
			log.trace(sw.toString());
			sw.getBuffer().setLength(0);

		} catch (JAXBException e) {
			log.error("Loading of certificate configuration failed");
			log.error(e.toString());
		} finally {
			if (sw != null) {
				sw.getBuffer().setLength(0);
			}
		}

		JAXBContext jcCert1;
		StringWriter sw1 = new StringWriter();
		try {
			jcCert1 = JAXBContext.newInstance(BrokerConfig.class);

			Unmarshaller unmarshaller = jcCert1.createUnmarshaller();
			File xml = new File(brokerPath);
			brokerConfig = (BrokerConfig) unmarshaller.unmarshal(xml);
			sw1 = new StringWriter();

			Marshaller marshaller = jcCert1.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(brokerConfig, sw1);
			log.trace(sw1.toString());
			sw1.getBuffer().setLength(0);

		} catch (JAXBException e) {
			log.error("Loading of certificate configuration failed");
			log.error(e.toString());
		} finally {
			if (sw1 != null) {
				sw1.getBuffer().setLength(0);
			}
		}
	}

	public SensorConfiguration getSensorConfiguration() {
		return sensorConfiguration;
	}

	public void setSensorConfiguration(SensorConfiguration sensorConfiguration) {
		this.sensorConfiguration = sensorConfiguration;
	}

	public BrokerConfig getBrokerConfig() {
		return brokerConfig;
	}

	public void setBrokerConfig(BrokerConfig brokerConfig) {
		this.brokerConfig = brokerConfig;
	}
}
