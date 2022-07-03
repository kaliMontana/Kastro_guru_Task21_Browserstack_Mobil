package helpers;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class Browserstack {

	public static String videoUrl(String sessionId) {
		String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

		return given()
				.auth().basic("silver_VJ7IYp", "a9RwR6X6W6AqyQKvZBzo")
				.log().all()
				.when()
				.get(url)
				.then()
				.log().all()
				.statusCode(200)
				.extract()
				.path("automation_session.video_url");
	}
}
