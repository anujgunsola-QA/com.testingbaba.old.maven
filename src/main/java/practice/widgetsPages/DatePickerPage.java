package practice.widgetsPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseLibrary.ManageBrowser;
import featureNavigation.WidgetsCard;

public class DatePickerPage extends ManageBrowser {
	public DatePickerPage(){
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
	
	@FindBy(xpath = "//a[text()='date picker']")
	private WebElement datePickerCard;
	
	@FindBy(xpath = "//*[@id=\"datePickerContainer\"]/div[1]/div[2]/input")
	private WebElement selectDate;
	
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
	
	public void clickDatePicker() {
		waitUntilClickableAndClick(datePickerCard);
	}
	
	public void selectDate(String enterDate) {
		selectDate.sendKeys(enterDate);
	}
}
