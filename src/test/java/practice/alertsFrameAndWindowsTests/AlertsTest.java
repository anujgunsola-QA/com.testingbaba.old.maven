package practice.alertsFrameAndWindowsTests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseLibrary.ManageBrowser;
import practice.alertsFramesAndWindowsPages.AlertsPage;

public class AlertsTest extends ManageBrowser{
AlertsPage p;
	
	@BeforeTest
	void launch() {
		openBrowser();
		driver.get("https://testingbaba.com/old/");
		p = new AlertsPage();
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
		p.clickAlerts();
	}
	@Test(priority=5)
	void clickOnSeeAlertAndAcceptButton(){
		p.clickSeeAlertAndAccept();
	}
	@Test(priority=6)
	void clickOnWaitAlertAndAcceptButton(){
		p.clickWaitAlertAndAccept();
	}
	@Test(priority=7)
	void clickOnAlertAndAcceptButton(){
		p.clickAlertAndAccept();
	}
	@Test(priority=8)
	void clickOnAlertAndCancelButton(){
		p.clickAlertAndCancel();
	}
	@Test(priority=9)
	void clickOnPromptInputAndAccept() {
		p.clickPromptInputAndAccept();
	}
	@Test(priority=10)
	void clickOnPromptAndCancel() {
		p.clickPromptAlertAndCancel();
	}
}
