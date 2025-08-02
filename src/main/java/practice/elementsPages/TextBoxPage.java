package practice.elementsPages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseLibrary.ManageBrowser;

public class TextBoxPage extends ManageBrowser {
	public TextBoxPage() {
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

	@FindBy(xpath = "//a[text()='text box']")
	private WebElement textBox;

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

	public void clickTextbox() {
		textBox.click();
	}

	@FindBy(xpath = "//input[@id='fullname1']")
	private WebElement firstName;

	@FindBy(xpath = "//input[@id='fullemail1']")
	private WebElement email;

	@FindBy(xpath = "//textarea[@id='fulladdresh1']")
	private WebElement currentAddress;

	@FindBy(xpath = "//textarea[@id='paddresh1']")
	private WebElement permanentAddress;

	@FindBy(xpath = "//input[@value='Submit']")
	private WebElement submit;

	@FindBy(xpath = "//div[@class='col-md-6 mt-5']/label")
	private List<WebElement> actualDataList;

	public void fillForm() {
		int row = 1;

		while (true) {
			List<String> expectedData = dataTest(0,row);
			if (expectedData.isEmpty() || expectedData.size() < 4) {
				break;
			}
			String name = expectedData.get(0);
			String emailAdd = expectedData.get(1);
			String current = expectedData.get(2);
			String homeAdd = expectedData.get(3);
			firstName.sendKeys(name);
			email.sendKeys(emailAdd);
			currentAddress.sendKeys(current);
			permanentAddress.sendKeys(homeAdd);
			submit.click();
			List<String> actualData = new ArrayList<String>();
			int j = 0;
			for (int i = 1; i < actualDataList.size(); i = i + 2) {
				String actual = actualDataList.get(i).getText();
				actualData.add(actual);
				Assert.assertEquals(actual, expectedData.get(j));
				j++;
			}
			row++;
			firstName.clear();
			email.clear();
			currentAddress.clear();
			permanentAddress.clear();
		}
	}
	/*
	 * void validate() { int row=1; int j = 0; List<String> expectedData =
	 * dataTest(row); List<String> actualData = new ArrayList<String>(); for (int i
	 * = 1; i < actualDataList.size(); i = i + 2) { String actual =
	 * actualDataList.get(i).getText(); actualData.add(actual);
	 * Assert.assertEquals(actual, expectedData.get(j)); j++; } row++;
	 * firstName.clear(); email.clear(); currentAddress.clear();
	 * permanentAddress.clear(); }
	 */
	 
}