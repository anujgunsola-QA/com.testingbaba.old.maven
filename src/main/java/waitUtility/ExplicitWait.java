package waitUtility;

import org.openqa.selenium.WebElement;

public interface ExplicitWait {
	void waitUntilClickable(WebElement e);
	void waitUntilVisible(WebElement e);
	void waitUntilClickableAndClick(WebElement e);
	void waitUntilVisibleAndClick(WebElement e);
	void waitUntilinVisible(WebElement e);
}
