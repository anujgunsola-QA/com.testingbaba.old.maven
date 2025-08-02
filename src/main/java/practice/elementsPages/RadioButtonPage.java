package practice.elementsPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseLibrary.ManageBrowser;

public class RadioButtonPage extends ManageBrowser{
	public RadioButtonPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='modal-content']")
	private WebElement modal;
	
	@FindBy(xpath = "//button[text()='×']")
	private WebElement close;

	@FindBy(xpath = "//a[@href='newdemo.html']")
	private WebElement practice;
	
	@FindBy(xpath = "//button[@data-target='#elements']")
	private WebElement elements;
	
	@FindBy(xpath = "//a[text()='radio buttons']")
	private WebElement radioButtons;
	
	@FindBy(xpath = "//input[@id='yes']")
	private WebElement yesRadioButton;
	
	@FindBy(xpath = "//p[text()='You have selected yes']")
	private WebElement yesSelectedText;
	
	@FindBy(xpath = "//input[@id='impressive']")
	private WebElement impressiveRadioButton;
	
	@FindBy(xpath = "//p[text()='You have selected impressive']")
	private WebElement impressiveSelectedText;
	
	@FindBy(xpath = "//input[@id='no']")
	private WebElement noRadioButton;
	
	@FindBy(xpath = "//p[text()='You have selected no']")
	private WebElement noSelectedText;
	
	public void registerModalClose() {
		waitUntilVisible(modal);
		close.click();
	}

	public void clickPractice() {
		waitUntilClickableAndClick(practice);
	}
	
	public void clickElements() {
		waitUntilClickableAndClick(elements);
	}
	
	public void clickRadioButtons() {
		waitUntilClickableAndClick(radioButtons);
	}
	
	public void yesRadioButton() {
		String val = radioButtonTestData("yes");
		waitUntilClickableAndClick(yesRadioButton);
		Assert.assertTrue(yesRadioButton.isSelected());
		Assert.assertEquals(val, yesSelectedText.getText());
	}
	
	public void impressiveRadioButton() {
		String val = radioButtonTestData("impressive");
		waitUntilClickableAndClick(impressiveRadioButton);
		Assert.assertTrue(impressiveRadioButton.isSelected());
		Assert.assertEquals(val, impressiveSelectedText.getText());
	}
	
	public void noRadioButton() {
		String val = radioButtonTestData("no");
		waitUntilClickableAndClick(noRadioButton);
		Assert.assertTrue(noRadioButton.isSelected());
		Assert.assertEquals(val, noSelectedText.getText());
	}
}
