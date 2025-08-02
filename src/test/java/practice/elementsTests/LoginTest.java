package practice.elementsTests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseLibrary.ManageBrowser;
import practice.elementsPages.LoginPage;

public class LoginTest extends ManageBrowser{
	LoginPage p;
	
	@BeforeTest(groups = {"smoke","sanity","regression"})
	void launch() {
		openBrowser();
		p=new LoginPage();
	}
	/*@Test(priority=1, groups = {"smoke","sanity","regression"})
	void clickOnClose(){
		p.registerModalClose();
	}
	@Test(priority=2, groups = {"regression"})
	void title() {
		String title = p.pageTitle();
		System.out.println(title);
	}
	@Test(priority=3, groups = {"regression"})
	void headerTitle(){
		String header = p.headerOfPage();
		System.out.println(header);
	}*/
	
	@Test(dataProvider = "logincred")
	public void userLogin(String username, String password)
	{
		p.login(username, password);
	}
}