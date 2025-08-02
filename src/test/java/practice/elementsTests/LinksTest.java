package practice.elementsTests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseLibrary.ManageBrowser;
import practice.elementsPages.LinksPage;

public class LinksTest extends ManageBrowser{
	LinksPage p;
	
	@BeforeTest(groups = {"smoke","sanity","regression"})
	@Parameters("browser")
	void launch(String browserName) {
		openBrowser(browserName);
		p = new LinksPage();
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
	@Test(priority=4)
	void clickOnLinksButton() {
		p.clickLinks();
	}
	@Test(priority=5)
	void clickOnDemoPageLink() {
		p.clickDemoPageLink();
	}
	@Test(priority=6)
		void validateOpenTabsTitle() {
			System.out.println(p.getOpenTabsURL());
			for(String s:p.getOpenTabsURL()) {
			}
	}
}