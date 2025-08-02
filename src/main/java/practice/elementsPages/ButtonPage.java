package practice.elementsPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseLibrary.ManageBrowser;

public class ButtonPage extends ManageBrowser{
	public ButtonPage() {
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
	
	@FindBy(xpath = "//a[text()='buttons']")
	private WebElement buttons;
	
	@FindBy(xpath = "//button[@ondblclick='doubletext()']")
	private WebElement doubleClick;
	
	@FindBy(xpath = "//button[@oncontextmenu='righttext()']")
	private WebElement rightClick;
	
	@FindBy(xpath = "//button[@onclick='clicktext()']")
	private WebElement singleClick;
	
	@FindBy(xpath = "//p[text()='you have done a double click']")
	private WebElement doubleClickMessage;
	
	@FindBy(xpath = "//p[text()='you have done a right click']")
	private WebElement rightClickMessage;
	
	@FindBy(xpath = "//p[text()='you have done a dynamic click']")
	private WebElement singleClickMessage;
	
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
	
	public void clickButtons() {
		waitUntilClickableAndClick(buttons);
	}
	
	public void clickOnDoubleClick() {
		doubleClick(doubleClick);
		waitUntilVisible(doubleClickMessage);
		Assert.assertEquals("you have done a double click", doubleClickMessage.getText());
	}
	
	public void clickOnRightClick() {
		rightClick(rightClick);
		waitUntilVisible(rightClickMessage);
		Assert.assertEquals("you have done a right click", rightClickMessage.getText());
	}
	
	public void clickOnSingleClick() {
		singleClick(singleClick);
		waitUntilVisible(singleClickMessage);
		Assert.assertEquals("you have done a dynamic click", singleClickMessage.getText());
	}
}
