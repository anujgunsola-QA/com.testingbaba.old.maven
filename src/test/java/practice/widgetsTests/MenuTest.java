package practice.widgetsTests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseLibrary.ManageBrowser;
import practice.widgetsPages.MenuPage;

public class MenuTest extends ManageBrowser {
MenuPage p;
	
	@BeforeTest
	void launch() {
		openBrowser();
		driver.get("https://testingbaba.com/old/");
		p = new MenuPage();
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
	void clickOnMenu() {
		p.clickMenu();
	}
	@Test(priority=5, dependsOnMethods="clickOnMenu")
	void chooseServicesUITest() {
		p.servicesDropDown();
	}
}
