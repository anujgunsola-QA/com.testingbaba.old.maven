package practice.elementsTests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseLibrary.ManageBrowser;
import practice.elementsPages.UploadAndDownloadPage;

public class UploadAndDownloadTest extends ManageBrowser{
UploadAndDownloadPage p;
	
	@BeforeTest(groups = {"smoke", "sanity","regression"})
	@Parameters("browser")
	void launch(String browserName) {
		openBrowser(browserName);
		p = new UploadAndDownloadPage();
	}
	@Test(priority=1, groups = {"smoke", "sanity","regression"})
	void clickOnClose(){
		p.registerModalClose();
	}  
	
	@Test(priority=2, groups = {"smoke", "sanity","regression"})
	void clickOnPractice(){
		p.clickPractice();
	}
	@Test(priority=3, groups = {"sanity","regression"})
	void clickOnElements() {
		p.clickElements();
	}
	@Test(priority=4, groups = {"regression"})
	void clickOnUploadAndDownloadButton() {
		p.clickUploadAndDownload();
	}
	@Test(priority=5, enabled=false)
	void clickOnChooseButton() {
		p.clickChoose();
	}
	@Test(priority=6, groups = {"regression"})
	void performUpload() {
		p.uploadFile();
	}
}