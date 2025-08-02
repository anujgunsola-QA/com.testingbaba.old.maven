package practice.elementsPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseLibrary.ManageBrowser;
import featureNavigation.ElementCard;

public class UploadAndDownloadPage extends ManageBrowser implements ElementCard{
	public UploadAndDownloadPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = ElementCard.MODAL) 
	private WebElement modal;
	
	@FindBy(xpath = ElementCard.CLOSE)
	private WebElement close;

	@FindBy(xpath = ElementCard.PRACTICE)
	private WebElement practice;
	
	@FindBy(xpath = ElementCard.ELEMENT)
	private WebElement elements;
	
	@FindBy(xpath = "//a[text()='upload and download']")
	private WebElement uploadAndDownloadButton;
	
	@FindBy(xpath = "//input[@id='File1']")
	private WebElement chooseButton;
	
	public void registerModalClose() {
		waitUntilVisible(modal);
		close.click();
		waitUntilinVisible(modal);
	}
	
	public void clickPractice() {
		waitUntilClickableAndClick(practice);
	}
	
	public void clickElements() {
		waitUntilClickableAndClick(elements);
	}
	
	public void clickUploadAndDownload() {
		waitUntilClickableAndClick(uploadAndDownloadButton);
	}
	
	public void clickChoose() {
		singleClick(chooseButton);
	}
	
	public void uploadFile() {
		String path = System.getProperty("user.dir")+"\\ExcelDataFiles\\User_Credentials.xlsx";
		//uploadFile(path);
		/*--if the element contains <input type="file"> then we can directly paste the path.--*/
		chooseButton.sendKeys(path);
	}
}
