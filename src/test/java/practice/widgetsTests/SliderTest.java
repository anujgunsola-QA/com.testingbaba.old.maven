package practice.widgetsTests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseLibrary.ManageBrowser;
import practice.widgetsPages.SliderPage;

public class SliderTest extends ManageBrowser {
SliderPage p;
	
	@BeforeTest
	void launch() {
		openBrowser();
		driver.get("https://testingbaba.com/old/");
		p = new SliderPage();
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
	void clickOnSlider() {
		p.clickSlider();
	}
	@Test(priority=5, dependsOnMethods="clickOnSlider")
	void slidePointer() {
		p.slideTo(90);
	}
	@Test(priority=6)
	void colorSlide() {
		p.testSlide(45);
	}
}
