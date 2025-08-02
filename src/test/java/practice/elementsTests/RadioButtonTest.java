package practice.elementsTests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseLibrary.ManageBrowser;
import practice.elementsPages.RadioButtonPage;

public class RadioButtonTest extends ManageBrowser {
	RadioButtonPage p;
	
	@BeforeTest(groups = {"smoke","sanity","regression"})
	void launch() {
		openBrowser();
		p = new RadioButtonPage();
	}
	@Test(priority=1, groups = {"smoke","sanity","regression"})
	void clickOnClose(){
		p.registerModalClose();
	}
	@Test(priority=2, groups = {"smoke","sanity","regression"})
	void clickOnPractice(){
		p.clickPractice();
	}
	@Test(priority=3, groups = {"smoke","sanity","regression"})
	void clickOnElements() {
		p.clickElements();
	}
	@Test(priority=4, groups = {"sanity","regression"})
	void clickOnRadioButtons() {
		p.clickRadioButtons();;
	}
	@Test(priority=5, groups = {"sanity","regression"})
	void clickOnYesRadioButton() {
		p.yesRadioButton();
	}
	@Test(priority=6, groups = {"sanity","regression"})
	void clickOnImpressiveRadioButton() {
		p.impressiveRadioButton();
	}
	@Test(priority=7, groups = {"sanity","regression"})
	void clickOnNoRadioButton() {
		p.noRadioButton();
	}
}
