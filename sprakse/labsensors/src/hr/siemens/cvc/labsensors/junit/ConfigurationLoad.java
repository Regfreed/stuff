package hr.siemens.cvc.labsensors.junit;

import org.junit.Assert;
import org.junit.Test;

import hr.siemens.cvc.labsensors.configuration.manager.ConfigurationManager;

public class ConfigurationLoad {

	static String configPath = new String("C:/Work/bcm-WS/labsensors/labsensors/config/");

	@Test
	public void test() {
		ConfigurationManager configManager = ConfigurationManager.getInstance(configPath);
		int seneorCount = 0;
		seneorCount = configManager.getSensorConfiguration().getSensor().size();
		// test that we have more that one sensor in the sensor configuration
		// file, by default this should be true if the file is loaded correctly
		Assert.assertTrue(seneorCount > 0);
	}
}
