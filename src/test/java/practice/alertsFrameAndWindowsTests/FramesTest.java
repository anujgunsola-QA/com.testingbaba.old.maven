package practice.alertsFrameAndWindowsTests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseLibrary.ManageBrowser;
import practice.alertsFramesAndWindowsPages.FramesPage;

public class FramesTest extends ManageBrowser {
FramesPage p;
	
	@BeforeTest
	void launch() {
		openBrowser();
		driver.get("https://testingbaba.com/old/");
		p = new FramesPage();
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
		p.clickFrames();
	}
	@Test(priority=5)
	void enterInFrame1() {
		p.enterFrame1();
	}
	@Test(priority=6)
	void enterInFrame2() {
		p.enterFrame2();
	}
}
