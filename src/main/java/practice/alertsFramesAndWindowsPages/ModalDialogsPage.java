
package practice.alertsFramesAndWindowsPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseLibrary.ManageBrowser;
import featureNavigation.AlertsFrameAndWindowsCard;

public class ModalDialogsPage extends ManageBrowser {
	public ModalDialogsPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = AlertsFrameAndWindowsCard.MODAL) 
	private WebElement modal; 
	
	@FindBy(xpath = AlertsFrameAndWindowsCard.CLOSE)
	private WebElement close;

	@FindBy(xpath = AlertsFrameAndWindowsCard.PRACTICE)
	private WebElement practice;
	
	@FindBy(xpath = AlertsFrameAndWindowsCard.ALERTS_FRAME_AND_WINDOWS)
	private WebElement alertsFrameAndWindows;
	
	@FindBy(xpath = "//a[text()='modal dialogs']")
	private WebElement modalDialogsCard;
	
	@FindBy(xpath = "//*[@data-target=\"#exampleModal1\"]")
	private WebElement smallModalButton;
	
	@FindBy(xpath = "//*[@data-target=\"#exampleModal2\"]")
	private WebElement largeModalButton;
	
	@FindBy(xpath = "//*[@id='exampleModal1']/div/div")
	private WebElement smallModal;
	
	@FindBy(xpath = "//*[@id='exampleModal2']/div/div")
	private WebElement largeModal;
	
	@FindBy(xpath = "//*[@id='exampleModal1']/div/div/div[2]")
	private WebElement smallModalText;
	
	@FindBy(xpath = "//*[@id='exampleModal2']/div/div/div[2]")
	private WebElement largeModalText;
	
	@FindBy(xpath = "//*[@id='exampleModal1']/div/div/div[3]/button")
	private WebElement smallModalClose;
	
	@FindBy(xpath = "//*[@id='exampleModal2']/div/div/div[3]/button")
	private WebElement largeModalClose;
	
	public void registerModalClose() {
		contentIsVisible(modal);
		waitUntilClickableAndClick(close);
	}
	
	public void clickPractice() {
		waitUntilClickableAndClick(practice);
	}
	
	public void clickAlertsFrameAndWindows() {
		waitUntilClickableAndClick(alertsFrameAndWindows);
	}
	
	public void clickModalDialogs() {
		waitUntilClickableAndClick(modalDialogsCard);
	}
	
	public void clickSmallDialogsButton() {
		smallModalButton.click();
	}
	
	public String getSmallDialogText() {
		waitUntilVisible(smallModal);
		String text = smallModalText.getText();
		return text;
	}
	
	public void closeSmallDialog() {
		smallModalClose.click();
	}
	
	public void clickLargeDialogsButton() {
		largeModalButton.click();
	}
	
	public String getLargeDialogText() {
		waitUntilVisible(largeModal);
		String text = largeModalText.getText();
		return text;
	}
	
	public void closeLargeDialog() {
		isVisibleAndClick(largeModalClose);
	}
}

