package practice.elementsTests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseLibrary.ManageBrowser;
import practice.elementsPages.ButtonPage;

public class ButtonTest extends ManageBrowser {
	ButtonPage p;
	
	@BeforeTest(groups = {"smoke","sanity","regression"})
	@Parameters("browser")
	void launch(String browserName) {
		openBrowser(browserName);
		p = new ButtonPage();
	}
	@Test(priority=1, groups = {"smoke","sanity","regression"})
	void clickOnClose(){
		p.registerModalClose();
	}
	@Test(priority=2,  groups = {"smoke","sanity","regression"})
	void clickOnPractice(){
		p.clickPractice();
	}
	@Test(priority=3, groups = {"sanity","regression"})
	void clickOnElements() {
		p.clickElements();
	}
	@Test(priority=4, groups = {"sanity","regression"})
	void clickOnButtons() {
		p.clickButtons();
	}
	@Test(priority=5, groups = {"regression"})
	void clickOnDoubleClickButton() {
		p.clickOnDoubleClick();
	}
	@Test(priority=6, groups = {"regression"})
	void clickOnRightClickButton() {
		p.clickOnRightClick();
	}
	@Test(priority=7, groups = {"regression"})
	void clickOnSingleClickButton() {
		p.clickOnSingleClick();
	}
}
