package practice.widgetsTests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseLibrary.ManageBrowser;
import practice.widgetsPages.DatePickerPage;

public class DatePickerTest extends ManageBrowser {
DatePickerPage p;
	
	@BeforeTest
	void launch() {
		openBrowser();
		driver.get("https://testingbaba.com/old/");
		p = new DatePickerPage();
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
	void clickOnDatePicker() {
		p.clickDatePicker();
	}
	@Test(priority=5)
	void enterDate() {
		p.selectDate("05-08-2025");
	}
}
