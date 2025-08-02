package practice.widgetsPages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import baseLibrary.ManageBrowser;
import featureNavigation.WidgetsCard;

public class SelectMenuPage extends ManageBrowser {
	public SelectMenuPage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = WidgetsCard.MODAL) 
	private WebElement modal; 
	
	@FindBy(xpath = WidgetsCard.CLOSE)
	private WebElement close;

	@FindBy(xpath = WidgetsCard.PRACTICE)
	private WebElement practice;
	
	@FindBy(xpath = WidgetsCard.WIDGETS)
	private WebElement widgets;
	
	@FindBy(xpath = "//a[text()='select menu']")
	private WebElement selectMenuCard;
	
	@FindBy(xpath = "//*[@id=\"tab_24\"]/form/div/div[1]/select")
	private WebElement selectValueDropDown;
	
	@FindBy(xpath = "//*[@id=\"tab_24\"]/form/div/div[2]/select")
	private WebElement selectOneDropDown;
	
	@FindBy(xpath = "(//select[@multiple='multiple'])[2]")
	private WebElement multipleOption;
	
	public void registerModalClose() {
		contentIsVisible(modal);
		waitUntilClickableAndClick(close);
	}
	
	public void clickPractice() {
		waitUntilClickableAndClick(practice);
	}
	
	public void clickWidgets() {
		waitUntilClickableAndClick(widgets);
	}
	
	public void clickSelectMenu() {
		waitUntilClickableAndClick(selectMenuCard);
	}
	
	public void selectOption() {
		Select sel = new Select(selectValueDropDown);
		String defaultValue = sel.getFirstSelectedOption().getText();
		Assert.assertEquals(defaultValue, "Select Option");
		
		sel = selectByIndex(selectValueDropDown, 1);
		String option = sel.getFirstSelectedOption().getText();
		Assert.assertEquals(option, "Group 1, Option 1");

		sel = selectByIndex(selectValueDropDown, 2);
		option = sel.getFirstSelectedOption().getText();
		Assert.assertEquals(option, "Group 1, Option 2");

		sel = selectByIndex(selectValueDropDown, 3);
		option = sel.getFirstSelectedOption().getText();
		Assert.assertEquals(option, "Group 2, Option 1");

		sel = selectByIndex(selectValueDropDown, 4);
		option = sel.getFirstSelectedOption().getText();
		Assert.assertEquals(option, "Group 2, Option 2");
	}
	
	public void selectOneOption() {
		Select sel = new Select(selectOneDropDown);
		String defaultValue = sel.getFirstSelectedOption().getText();
		Assert.assertEquals(defaultValue, "Select Title");
		
		sel = selectByIndex(selectOneDropDown, 1);
		String option = sel.getFirstSelectedOption().getText();
		Assert.assertEquals(option, "HTML");

		sel = selectByIndex(selectOneDropDown, 2);
		option = sel.getFirstSelectedOption().getText();
		Assert.assertEquals(option, "CSS");

		sel = selectByIndex(selectOneDropDown, 3);
		option = sel.getFirstSelectedOption().getText();
		Assert.assertEquals(option, "PHP");

		sel = selectByIndex(selectOneDropDown, 4);
		option = sel.getFirstSelectedOption().getText();
		Assert.assertEquals(option, "Bootstrap");
		
		sel = selectByIndex(selectOneDropDown, 5);
		option = sel.getFirstSelectedOption().getText();
		Assert.assertEquals(option, "Java");
		
		sel = selectByIndex(selectOneDropDown, 6);
		option = sel.getFirstSelectedOption().getText();
		Assert.assertEquals(option, "HTTPS");
	}
	
	public void mulltiSelectOption() {
		Select sel = new Select(multipleOption);

		List<WebElement> multipleOptions = sel.getOptions();
		singleClick(multipleOptions.get(1));
		Assert.assertTrue(multipleOptions.get(1).isSelected());
		ctrlClick(multipleOptions.get(1));
		
		List<WebElement> firstData = new ArrayList<>(multipleOptions);
		List<WebElement> secondData = new ArrayList<>(multipleOptions);
		firstData.remove(2);
		ctrlClickMultiple(firstData);
		for(WebElement e:firstData) {
		Assert.assertTrue(e.isSelected());
		}
		ctrlClickMultiple(firstData);
		
		secondData.remove(1);
		secondData.remove(2);
		ctrlClickMultiple(secondData);
		for(WebElement e:secondData) {
			Assert.assertTrue(e.isSelected());
			}
		ctrlClickMultiple(secondData);
	}
	 
}
