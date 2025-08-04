package practice.alertsFrameAndWindowsTests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseLibrary.ManageBrowser;
import practice.alertsFramesAndWindowsPages.NestedFramesPage;

public class NestedFramesTest extends ManageBrowser {
	NestedFramesPage p;

	@BeforeTest
	void launch() {
		openBrowser();
		driver.get("https://testingbaba.com/old/");
		p = new NestedFramesPage();
	}

	@Test(priority = 1)
	void clickOnClose() {
		p.registerModalClose();
	}

	@Test(priority = 2, dependsOnMethods = "clickOnClose")
	void clickOnPractice() {
		p.clickPractice();
	}

	@Test(priority = 3, dependsOnMethods = "clickOnPractice")
	void clickOnAlertsFrameAndWindows() {
		p.clickAlertsFrameAndWindows();
	}

	@Test(priority = 4, dependsOnMethods = "clickOnAlertsFrameAndWindows")
	void clickOnNestedFrames() {
		p.clickNestedFrames();
	}
	
	@Test(priority = 5, dependsOnMethods = "clickOnNestedFrames")
	void getInnerFrameText() {
		p.enterInnerFrameAndClick();
	}
}
