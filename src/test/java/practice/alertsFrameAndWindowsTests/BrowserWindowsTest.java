package practice.alertsFrameAndWindowsTests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseLibrary.ManageBrowser;
import practice.alertsFramesAndWindowsPages.BrowserWindowsPage;

public class BrowserWindowsTest extends ManageBrowser{
	BrowserWindowsPage p;
	
	@BeforeTest
	void launch() {
		openBrowser();
		driver.get("https://testingbaba.com/old/");
		p = new BrowserWindowsPage();
	}
	@Test(priority=1)
	void clickOnClose(){
		p.registerModalClose();
	}
	@Test(priority=2, dependsOnMethods="clickOnClose")
	void clickOnPractice(){
		p.clickPractice();
	}
	@Test(priority=3, dependsOnMethods="clickOnPractice")
	void clickOnAlertsFrameAndWindows() {
		p.clickAlertsFrameAndWindows();
	}
	@Test(priority=4, dependsOnMethods = "clickOnAlertsFrameAndWindows")
	void clickOnAlerts() {
		p.clickBrowserWindows();
	}
	@Test(priority=5)
	void clickOnNewTabButton(){
		p.clickNewTabButton();
	}
	@Test(priority=6)
	void clickOnNewWindowButton(){
		p.clickNewWindowButton();
	}
	@Test(priority=7)
	void clickOnNewWindowMessageButton(){
		p.clickNewWindowMessageButton();
	}
}
