package practice.elementsTests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseLibrary.ManageBrowser;
import practice.elementsPages.CheckBoxPage;


public class CheckBoxTest extends ManageBrowser{
	CheckBoxPage p;
	
	@BeforeTest( groups = {"smoke","sanity","regression"})
	void launch() {
		openBrowser();
		p=new CheckBoxPage();
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
	@Test(priority=4,  groups = {"sanity","regression"})
	void clickCheckBox() {
		p.checkBox();
	}
	@Test(priority=5,  groups = {"regression"})
	void clickMobileCheckBox() {
		p.mobileCheckBox();
	}
	@Test(priority=6,  groups = {"regression"})
	void clickLaptopCheckBox() {
		p.laptopCheckBox();
	}
	@Test(priority=7, groups = {"regression"})
	void clickDesktopCheckBox() {
		p.desktopCheckBox();
	}
}