package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.TestConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;


public class BrowserstackMobileDriver implements WebDriverProvider {
	private TestConfig config = ConfigFactory.create(TestConfig.class);

	@Override
	@Nonnull
	public WebDriver createDriver(Capabilities capabilities) {
		MutableCapabilities mutableCapabilities = new MutableCapabilities();
		mutableCapabilities.merge(capabilities);
		// Set your access credentials
		mutableCapabilities.setCapability("browserstack.user", config.getBrowserstackUser());
		mutableCapabilities.setCapability("browserstack.key", config.getBrowserstackKey());

		// Set URL of the application under test
		mutableCapabilities.setCapability("app", config.getAppId());

		// Specify device and os_version for testing
		mutableCapabilities.setCapability("device", config.getMobilDevice());
		mutableCapabilities.setCapability("os_version", config.getOsVersion());

		// Set other BrowserStack capabilities
		mutableCapabilities.setCapability("project", config.getProjectName());
		mutableCapabilities.setCapability("build", config.getProjectBuild());
		mutableCapabilities.setCapability("name", config.getProjectTestName());
		return new RemoteWebDriver(config.getBaseUrl(), mutableCapabilities);
	}
}
