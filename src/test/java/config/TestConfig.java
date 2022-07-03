package config;

import org.aeonbits.owner.Config;

import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
		"classpath:config/auth.properties",
		"classpath:config/test.properties"
})
public interface TestConfig extends Config {

	@Config.Key("base.url")
	URL getBaseUrl();

	@Config.Key("browserstack.user")
	String getBrowserstackUser();

	@Config.Key("browserstack.key")
	String getBrowserstackKey();

	@Config.Key("app.id")
	String getAppId();

	@Config.Key("mobil.device")
	String getMobilDevice();

	@Config.Key("os.version")
	String getOsVersion();

	@Config.Key("project.name")
	String getProjectName();

	@Config.Key("project.build")
	String getProjectBuild();

	@Config.Key("project.test.name")
	String getProjectTestName();
}
