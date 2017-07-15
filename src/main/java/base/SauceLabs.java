package base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.ReadProperties;

public class SauceLabs extends Driver {
	DesiredCapabilities caps;
	

	public void setSauceLabs() {
		String URL = "https://" + getSaucelabsProperty("userName") + ":" + getSaucelabsProperty("accessKey")
		+ "@ondemand.saucelabs.com:443/wd/hub";
		
		setCapabilities();

		try {
			driver = new RemoteWebDriver(new URL(URL), caps);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public void setCapabilities() {

		if (getSaucelabsProperty("browser").equalsIgnoreCase("chrome")) {
			caps = DesiredCapabilities.chrome();
		} else if (getSaucelabsProperty("browser").equalsIgnoreCase("firefox")) {
			caps = DesiredCapabilities.firefox();
		} else if (getSaucelabsProperty("browser").equalsIgnoreCase("safari")) {
			caps = DesiredCapabilities.safari();
		} else if (getSaucelabsProperty("browser").equalsIgnoreCase("internetExplorer")) {
			caps = DesiredCapabilities.internetExplorer();
		} else {
			caps = DesiredCapabilities.firefox();
		}

		caps.setCapability("platform", getSaucelabsProperty("operatingSystem"));
		caps.setCapability("version", getSaucelabsProperty("browserVersion"));

	}

}
