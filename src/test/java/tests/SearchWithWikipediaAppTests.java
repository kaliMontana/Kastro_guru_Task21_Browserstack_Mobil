package tests;

import com.codeborne.selenide.CollectionCondition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class SearchWithWikipediaAppTests extends TestBase {

	@Test
	@Tag("BrowserStack")
	public void searchBrowserStackTest() {
		step("Type search", () -> {
			$(AppiumBy.accessibilityId("Search Wikipedia")).click();
			$(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
		});
		step("Verify content found", () ->
				$$(AppiumBy.className("android.widget.TextView"))
						.shouldHave(CollectionCondition.sizeGreaterThan(0))
		);
	}

	@Test
	@Tag("Mars")
	public void searchMarsTest() {
		step("Type search", () -> {
			$(AppiumBy.accessibilityId("Search Wikipedia")).click();
			$(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Mars");
		});
		step("Verify content found", () ->
				$$(AppiumBy.className("android.widget.TextView"))
						.shouldHave(CollectionCondition.sizeGreaterThan(0))
		);
	}

	@Test
	@Tag("FreeSearch")
	public void freeSearchTest() {
		step("Type search", () -> {
			$(AppiumBy.accessibilityId("Search Wikipedia")).click();
			$(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys(System.getProperty("FreeSearch", "FreeSearch"));
		});
		step("Verify content found", () ->
				$$(AppiumBy.className("android.widget.TextView"))
						.shouldHave(CollectionCondition.sizeGreaterThan(0))
		);
	}
}
