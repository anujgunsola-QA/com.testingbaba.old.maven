package practice.alertsFramesAndWindowsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseLibrary.ManageBrowser;
import featureNavigation.AlertsFrameAndWindowsCard;

public class FramesPage extends ManageBrowser {
	public FramesPage() {
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
	
	@FindBy(xpath = "//a[text()='frames']")
	private WebElement framesCard;
	
	@FindBy(xpath = "//div[@id='tab_13']/iframe[1]")
	private WebElement frame1;
	
	@FindBy(xpath = "//div[@id='tab_13']/iframe[2]")
	private WebElement frame2;
	
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
	
	public void clickFrames() {
		waitUntilClickableAndClick(framesCard);
	}
	
	public void enterFrame1() {
		driver.switchTo().frame(frame1);
		String textInFrame = driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals(textInFrame, "This is a sample page");
		driver.switchTo().defaultContent();
	}
	
	public void enterFrame2() {
		driver.switchTo().frame(frame2);
		String textInFrame = driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals(textInFrame, "This is a sample page");
		driver.switchTo().defaultContent();
	}
}
