package practice.alertsFramesAndWindowsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseLibrary.ManageBrowser;
import featureNavigation.AlertsFrameAndWindowsCard;

public class NestedFramesPage extends ManageBrowser {
	public NestedFramesPage() {
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
	
	@FindBy(xpath = "//a[text()='nested frames']")
	private WebElement nestedFramesCard;
	
	@FindBy(xpath = "//iframe[@src='target1.html']")
	private WebElement frameParent;
	
	@FindBy(xpath = "//iframe[@src='text.html']")
	private WebElement frameChild1;
	
	@FindBy(xpath = "//iframe[@src='example.html']")
	private WebElement frameChild2;
	
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
	
	public void clickNestedFrames() {
		waitUntilClickableAndClick(nestedFramesCard);
	}
	
	public void enterInnerFrameAndClick() {
		driver.switchTo().frame(frameParent);
		driver.switchTo().frame(frameChild1);
		String textParent = driver.findElement(By.tagName("h2")).getText();
		Assert.assertEquals(textParent, "Parent");

		driver.switchTo().frame(frameChild2);
		String textChild = driver.findElement(By.tagName("h2")).getText();
		Assert.assertEquals(textChild, "Child");
		
		driver.findElement(By.tagName("a")).click();
		String childFrameMessage = driver.findElement(By.tagName("p")).getText();
		Assert.assertEquals(childFrameMessage, "Hello");
		
		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		String bannerTitle = driver.findElement(By.xpath("//*[@id='bannertitle']")).getText();
		Assert.assertTrue(bannerTitle.equalsIgnoreCase("nested frames"));
	}
}
