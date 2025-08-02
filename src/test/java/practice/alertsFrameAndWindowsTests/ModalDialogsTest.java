package practice.alertsFrameAndWindowsTests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseLibrary.ManageBrowser;
import practice.alertsFramesAndWindowsPages.ModalDialogsPage;

public class ModalDialogsTest extends ManageBrowser {
	ModalDialogsPage p;
	
	@BeforeTest
	void launch() {
		openBrowser();
		driver.get("https://testingbaba.com/old/");
		p = new ModalDialogsPage();
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
	void clickOnModalDialogs() {
		p.clickModalDialogs();
	}
	@Test(priority=5, dependsOnMethods = "clickOnModalDialogs")
	void smallDialogModal() {
		p.clickSmallDialogsButton();
		String text = p.getSmallDialogText();
		String expectedText = "This is a small modal. It has very less content";
		Assert.assertTrue(text.contains(expectedText));
		p.closeSmallDialog();
	}
	@Test(priority=6)
	void largeDialogModal() {
		p.clickLargeDialogsButton();
		String text = p.getLargeDialogText();
		System.out.println(text);
		String expectedText = "JavaScript";
		Assert.assertTrue(text.contains(expectedText));
		p.closeLargeDialog();
	}
	
	/*
	 * @Test(priority=5) void selectValueOptions(){ p.selectOption(); }
	 */
}
