package practice.alertsFramesAndWindowsPages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseLibrary.ManageBrowser;
import featureNavigation.AlertsFrameAndWindowsCard;

public class AlertsPage extends ManageBrowser implements AlertsFrameAndWindowsCard{
	public AlertsPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = AlertsFrameAndWindowsCard.MODAL) 
	private WebElement modal; 
	
	@FindBy(xpath = AlertsFrameAndWindowsCard.CLOSE)
	private WebElement close;

	@FindBy(xpath = AlertsFrameAndWindowsCard.PRACTICE)
	private WebElement practice;
	
	@FindBy(xpath = AlertsFrameAndWindowsCard.ALERTS_FRAME_AND_WINDOWS)
	private WebElement alertsFrameAndWindows;
	
	@FindBy(xpath = "//a[text()='alerts']")
	private WebElement alertsCard;
	
	@FindBy(xpath = "//span[text()='Click Button to see alert ']/parent::div/following-sibling::div/button")
	private WebElement seeAlertButton;

	@FindBy(xpath = "//div[@class='mt-4 row']/div/button[@onClick='aftersec5()']")
	private WebElement waitAlertButton;
	
	@FindBy(xpath = "//div[@class='mt-4 row']/div/button[@onClick='myconfirm()']")
	private WebElement acceptAndCancelAlertButton;
	
	@FindBy(xpath = "//div[@class='mt-4 row']/div/span[text()='You pressed OK!']")
	private WebElement pressOkMessage;
	
	@FindBy(xpath = "//div[@class='mt-4 row']/div/span[text()='You pressed Cancel!']")
	private WebElement pressCancelMessage;
	
	@FindBy(xpath = "//div[@class='mt-4 row']/div/button[@onClick='myprompt()']")
	private WebElement prompAlertButton;
	
	@FindBy(xpath = "//span[@id='name-result']")
	private WebElement promptMessage;
	
	public void registerModalClose() {
		waitUntilVisible(modal);
		close.click();
	}
	
	public void clickPractice() {
		waitUntilClickableAndClick(practice);
	}
	
	public void clickAlertsFrameAndWindows() {
		waitUntilClickableAndClick(alertsFrameAndWindows);
	}
	
	public void clickAlerts() {
		waitUntilClickableAndClick(alertsCard);
	}
	
	public void clickSeeAlertAndAccept() {
		seeAlertButton.click();
		waitUntillAlertVisible();
		driver.switchTo().alert().accept();
	}
	
	public void clickWaitAlertAndAccept() {
		waitAlertButton.click();
		waitUntillAlertVisible();
		driver.switchTo().alert().accept();
	}
	
	public void clickAlertAndAccept() {
		acceptAndCancelAlertButton.click();
		waitUntillAlertVisible();
		driver.switchTo().alert().accept();
		
		Assert.assertEquals("You pressed OK!", pressOkMessage.getText());
	}
	
	public void clickAlertAndCancel() {
		acceptAndCancelAlertButton.click();
		waitUntillAlertVisible();
		driver.switchTo().alert().dismiss();
		
		Assert.assertEquals("You pressed Cancel!", pressCancelMessage.getText());
	}
	
	public void clickPromptInputAndAccept() {
		String input="TestData1234";
		prompAlertButton.click();
		waitUntillAlertVisible();
		
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(input);
		alert.accept();
		Assert.assertEquals(input, promptMessage.getText());
	}
	
	public void clickPromptAlertAndCancel() {
		prompAlertButton.click();
		waitUntillAlertVisible();
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
}
