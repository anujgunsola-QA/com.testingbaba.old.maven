package practice.elementsPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseLibrary.ManageBrowser;

public class LoginPage extends ManageBrowser {

	public LoginPage() {
			PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='modal-content']")
	private WebElement modal;
	
	@FindBy(xpath="//button[text()='×']")
	private WebElement close;
	
	@FindBy(xpath="//*[@class='heading-agileinfo']")
	private WebElement header;
	
	@FindBy(xpath="//label[text()='Email:']//following-sibling::input")
	private WebElement emailBox;
	
	@FindBy(xpath="//label[text()='Password:']//following-sibling::input")
	private WebElement passwordBox;
	
	@FindBy(xpath="//input[@value='Log in']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[@class='message-error']")
	private WebElement errorMessage;
	
	public void registerModalClose() {	
			waitUntilVisible(modal);
			close.click();
	}
	
	public String pageTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public String headerOfPage() { 
		String allText = header.getText();
		return allText;
	}
	
	public void login(String username, String password) {
		driver.get("https://demowebshop.tricentis.com/login");
		waitUntilVisible(emailBox);
		emailBox.sendKeys(username);
		passwordBox.sendKeys(password);
		loginButton.click();
		waitUntilVisible(errorMessage);
	}
}
