package hr.siemens.cvc.labsensors.sensors;

import java.util.concurrent.Callable;

import org.apache.log4j.Logger;

import hr.siemens.cvc.labsensors.configuration.sensorConfiguration.SensorConfiguration.Sensor;
import hr.siemens.cvc.labsensors.dataelements.DataElementFactory;
import hr.siemens.cvc.labsensors.dataelements.DataElementType;
import hr.siemens.cvc.labsensors.publishers.Publisher;
import hr.siemens.cvc.labsensors.publishers.PublisherFactory;

public class ShopFloorSensor implements Callable<String> {
	final static Logger log = Logger.getLogger(ShopFloorSensor.class);

	DataElementType[] dataElements;
	DataElementFactory deFactory = new DataElementFactory();

	Publisher publisher;
	PublisherFactory publisherFactory;

	public ShopFloorSensor(Sensor sensor) {
		publisherFactory = new PublisherFactory();
		
		if (sensor == null) {
			log.error("Sensor config was null");
		} else {
			dataElements = new DataElementType[sensor.getDataElements().size()];
			for (int i = 0; i < sensor.getDataElements().size(); i++) {
				String type = sensor.getDataElements().get(i).getElementType();
				if (type != null) {
					log.trace("creating data element of type:" + type);
					dataElements[i] = deFactory.getDataElement(type);
				} else {
					log.error("could not get dataelement type");
				}
			}

			publisher = publisherFactory.getPublisher(sensor.getProtocal());
		}
	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
