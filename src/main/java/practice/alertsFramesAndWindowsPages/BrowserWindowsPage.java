package practice.alertsFramesAndWindowsPages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseLibrary.ManageBrowser;
import featureNavigation.AlertsFrameAndWindowsCard;

public class BrowserWindowsPage extends ManageBrowser implements AlertsFrameAndWindowsCard{
	public BrowserWindowsPage() {
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
	
	@FindBy(xpath = "//a[text()='browser windows']")
	private WebElement browserWindowsCard;
	
	@FindBy(xpath = "//*[@id=\"tab_11\"]/div[1]/a")
	private WebElement newTabButton;
	
	@FindBy(xpath = "//a[@onClick='win1open()']")
	private WebElement newWindowButton;
	
	@FindBy(xpath = "//a[@onClick='win2open()']")
	private WebElement newWindowMessageButton;
	
	@FindBy(xpath = "//textarea[@class='gLFyf']")
	private WebElement googleSearchBox;
	
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
	
	public void clickBrowserWindows() {
		waitUntilClickableAndClick(browserWindowsCard);
	}
	
	public void clickNewTabButton() {
		waitUntilClickableAndClick(newTabButton);
		List<String> handles = openTabsList();
		String parent = handles.get(0);
		String child = handles.get(1);
		driver.switchTo().window(child);
		
		googleSearchBox.sendKeys("kangaroo");
		
		Actions a = new Actions(driver);
		a.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
		 
		driver.close();
		driver.switchTo().window(parent);
	}
	
	public void clickNewWindowButton() {
		waitUntilClickableAndClick(newWindowButton);
		List<String> handles = openTabsList();
		String parent = handles.get(0);
		String child = handles.get(1);
		driver.switchTo().window(child);
		//driver.manage().window().maximize();
		
		googleSearchBox.sendKeys("kangaroo");
		Actions a = new Actions(driver);
		a.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
		
		driver.close();
		driver.switchTo().window(parent);
	}
	
	public void clickNewWindowMessageButton() {
		waitUntilClickableAndClick(newWindowMessageButton);
		/*
		 * List<String> handles = openTabsList(); String parent = handles.get(0); String
		 * child = handles.get(1); driver.switchTo().window(child);
		 * driver.manage().window().maximize(); String message = driver.getTitle();
		 * System.out.println(message);
		 * 
		 * driver.close(); driver.switchTo().window(parent);
		 */
	}
}
