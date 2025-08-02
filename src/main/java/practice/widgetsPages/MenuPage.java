package practice.widgetsPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseLibrary.ManageBrowser;
import featureNavigation.WidgetsCard;

public class MenuPage extends ManageBrowser{
	public MenuPage(){
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
	
	@FindBy(xpath = "//a[text()='menu']")
	private WebElement menuCard;
	
	@FindBy(xpath = "//*[@id=\"navbar\"]/ul/li[3]")
	private WebElement services;
	
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
	
	public void clickMenu() {
		waitUntilClickableAndClick(menuCard);
	}
	
	public void servicesDropDown() {
		List<WebElement> list = services.findElements(By.tagName("li"));
		moveToWebElement(services);
		for(WebElement e:list) {
			moveToWebElement(e);
			String bgColor=e.getCssValue("background-color");			//UI testing
			String expected = "rgba(224, 224, 224, 1)";
			Assert.assertEquals(bgColor, expected);
		}
	}
}
