package hr.siemens.cvc.labsensors.dataelements;

import org.apache.log4j.Logger;

public class DataElementFactory {
	final static Logger log = Logger.getLogger(DataElementFactory.class);

	public DataElementType getDataElement(String type) {
		switch (type) {
		case "Temprature":
		case "temprature":
			return new TempratureElement();
		case "Pressure":
		case "pressure":
			return new PressureElement();
		case "Humidity":
		case "humidity":
			return new HumidityElement();
		default:
			log.error("could not find data element type, returning null");
			return null;
		}
	}
}
