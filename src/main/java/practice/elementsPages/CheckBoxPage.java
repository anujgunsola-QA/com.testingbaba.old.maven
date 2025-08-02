package practice.elementsPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseLibrary.ManageBrowser;

public class CheckBoxPage extends ManageBrowser {
	public CheckBoxPage() {
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
	
	@FindBy(xpath = "//a[text()='check box']")
	private WebElement checkBox;
	
	@FindBy(xpath = "//iframe[@src='Checkbox.html']")
	private WebElement iframe;

	@FindBy(xpath = "//label[text()='Mobile:']/following-sibling::input[@id='myCheck']")
	private WebElement mobile;

	@FindBy(xpath = "//label[text()='Mobile:']/following-sibling::h6")
	private WebElement mobileSelectedText;

	
	@FindBy(xpath = "//input[@id='mylaptop']")
	private WebElement laptop;
	  
	@FindBy(xpath = "//input[@id='mylaptop']/following-sibling::h6")
	private WebElement laptopSelectedText;
	
	@FindBy(xpath = "//input[@id='mydesktop']")
	private WebElement desktop;
	  
	@FindBy(xpath = "//input[@id='mydesktop']/following-sibling::h6")
	private WebElement desktopSelectedText;
	 
	
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
	
	public void checkBox() {
		waitUntilClickableAndClick(checkBox);
	}
	
	public void mobileCheckBox() {
		String val = dataTest("mobile");
		driver.switchTo().frame(iframe);
		waitUntilClickableAndClick(mobile);
		Assert.assertTrue(mobile.isSelected());
		waitUntilVisible(mobileSelectedText);
		Assert.assertEquals(val, mobileSelectedText.getText());
		driver.switchTo().defaultContent();
	}
	
	public void laptopCheckBox() {
		String val = dataTest("laptop");
		driver.switchTo().frame(iframe);
		waitUntilClickableAndClick(laptop);
		Assert.assertTrue(laptop.isSelected());
		waitUntilVisible(laptopSelectedText);
		Assert.assertEquals(val, laptopSelectedText.getText());
		driver.switchTo().defaultContent();
	}
	
	public void desktopCheckBox() {
		String val = dataTest("desktop");
		driver.switchTo().frame(iframe);
		waitUntilClickableAndClick(desktop);
		Assert.assertTrue(desktop.isSelected());
		waitUntilVisible(desktopSelectedText);
		Assert.assertEquals(val, desktopSelectedText.getText());
		driver.switchTo().defaultContent();
	}
}
