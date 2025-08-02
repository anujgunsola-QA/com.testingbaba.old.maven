package actions;

import java.util.List;

import org.openqa.selenium.WebElement;

public interface  MouseAndKeyboardActions {
	void doubleClick(WebElement e);
	void singleClick(WebElement e);
	void rightClick(WebElement e);
	void ctrlClick(WebElement e);
	void ctrlClickMultiple(List<WebElement> list);
	void moveToWebElement(WebElement e);
	void dropContentToCordinate(WebElement e, int x, int y);
	void slideAction(WebElement e, int x);
}

