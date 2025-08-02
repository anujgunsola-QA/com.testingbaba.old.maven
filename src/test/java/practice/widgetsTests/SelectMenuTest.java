package practice.widgetsTests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseLibrary.ManageBrowser;
import practice.widgetsPages.SelectMenuPage;

public class SelectMenuTest extends ManageBrowser {
	
	SelectMenuPage p;
	
	@BeforeTest
	void launch() {
		openBrowser();
		driver.get("https://testingbaba.com/old/");
		p = new SelectMenuPage();
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
	void clickOnWidgets() {
		p.clickWidgets();
	}
	@Test(priority=4, dependsOnMethods="clickOnWidgets")
	void clickOnSelectMenu() {
		p.clickSelectMenu();
	}
	@Test(priority=5, dependsOnMethods="clickOnSelectMenu")
	void chooseSelectValueOptions() {
		p.selectOption();
	}
	@Test(priority=6, dependsOnMethods="clickOnSelectMenu")
	void chooseSelectOneOption() {
		p.selectOneOption();
	}
	@Test(priority=7, dependsOnMethods="clickOnSelectMenu")
	void chooseMultipleOptions() {
		p.mulltiSelectOption();
	}
}
