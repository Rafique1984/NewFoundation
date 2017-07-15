package base;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ReadProperties;


public class Driver extends ReadProperties {


	public static WebDriver driver;

	private void initfirefox() {
		driver = new FirefoxDriver();
	}

	private void setDriverProperties() {
		driver.manage().window().maximize();
	}
	
	// call those method in this method. 
	public void setDriver() {
		if (getProperty("browser").equalsIgnoreCase("firefox")) {
			initfirefox();
		} else {
			initfirefox();
		}
		//customize browser
		setDriverProperties();
		
	}

}
