package applicationUtility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public interface SelectDropdown {
	Select selectByIndex(WebElement ele, int i);
	Select selectByText(WebElement ele, String text);
	Select selectByValue(WebElement ele, String value);
}
