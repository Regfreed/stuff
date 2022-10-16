package hr.siemens.cvc.labsensors;

import org.apache.log4j.Logger;

import hr.siemens.cvc.labsensors.configuration.manager.ConfigurationManager;
import hr.siemens.cvc.labsensors.configuration.sensorConfiguration.SensorConfiguration.Sensor;
import hr.siemens.cvc.labsensors.sensors.ShopFloorSensor;

public class LabSensors {
	final static Logger log = Logger.getLogger(LabSensors.class);

	static String configPath = new String("C:/Work/bcm-WS/labsensors/labsensors/config/");
	static ConfigurationManager configManager = ConfigurationManager.getInstance(configPath);

	static ShopFloorSensor[] SFsensors = new ShopFloorSensor[configManager.getSensorConfiguration().getSensor().size()];

	public static void main(String[] args) {
		log.info("Starting LabSensors");

		for (int i = 0; i < configManager.getSensorConfiguration().getSensor().size(); i++) {
			log.info("Creating shop floor sensor #:" + i);
			Sensor sensor = configManager.getSensorConfiguration().getSensor().get(i);
			if (sensor != null) {
				SFsensors[i] = new ShopFloorSensor(sensor);
			}else{
				log.error("could not get sensor configuration");
			}
		}
	}
}
