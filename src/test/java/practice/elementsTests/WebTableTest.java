package practice.elementsTests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseLibrary.ManageBrowser;
import practice.elementsPages.WebTablePage;

public class WebTableTest extends ManageBrowser{
WebTablePage p;
	
	@BeforeTest
	void launch() {
		openBrowser();
		driver.get("https://testingbaba.com/old/");
		p = new WebTablePage();
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
	void clickOnElements() {
		p.clickElements();
	}
	@Test(priority=4)
	void clickOnWebTable() {
		p.clickWebTables();
	}
	/*@Test(priority=5, dataProvider = "dataTest")
	void enterDataInWebTable(String name, String email) {
		p.fillForm();*/
	@Test(priority=5)
	void enterDataInWebTable() {
		p.fillForm();
	}
	@Test(priority=6, dependsOnMethods="enterDataInWebTable", enabled = false)
	void validateWebTableData() {
		p.validateTableData();
	}
	@Test(priority=7, dependsOnMethods="enterDataInWebTable")
	void clickOnEdit() {
		p.editAndUpdateWebTable();
	}
	@Test(priority=8, dependsOnMethods="enterDataInWebTable")
	void clicOnCancel() {
		p.editAndCancelWebTable();
	}
}
