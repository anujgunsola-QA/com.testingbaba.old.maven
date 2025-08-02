package practice.elementsPages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import baseLibrary.ManageBrowser;

public class WebTablePage extends ManageBrowser{
	public WebTablePage() {
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
	
	@FindBy(xpath = "//a[text()='web tables']")
	private WebElement webTables;
	
	@FindBy(xpath = "//iframe[@src='Webtable.html']")
	private WebElement iframe;
	
	@FindBy(xpath="//input[@pattern='^[a-zA-Z][\\sa-zA-Z]{2,32}']")
	private WebElement nameTextBox;
	
	@FindBy(xpath="//div[@class='form-group']/descendant::input[@name='email']")
	private WebElement emailTextBox;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement save;
	
	@FindBy(xpath = "//table[@class='table table-bordered data-table']")
	private WebElement table;
	
	@FindBy(xpath = "//table[@class='table table-bordered data-table']/descendant::tbody/tr")
	private List<WebElement> tableData;
	
	@FindBy (xpath = "//table[@class='table table-bordered data-table']/descendant::tbody/tr/td/button[text()='Edit']")
	private List<WebElement> editButton;
	
	@FindBy (xpath = "//tbody/tr/td/input[@name='edit_name']")
	private WebElement editName;
	
	@FindBy (xpath = "//tbody/tr/td/input[@name='edit_email']")
	private WebElement editEmail;
	
	@FindBy (xpath = "//tbody/tr/td/button[text()='Update']")
	private WebElement updateButton;
	
	@FindBy (xpath = "//tbody/tr/td/button[text()='Cancel']")
	private WebElement cancelButton;
	
	@FindBy (xpath = "//tbody/tr/td/button[text()='Delete']")
	private WebElement deleteButton;
	
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
	
	public void clickWebTables() {
		waitUntilClickableAndClick(webTables);
	}
	
	/*public void fillForm(String name, String email) {		//dataProvider fill form with negative test case, incomplete code
		driver.switchTo().frame(iframe);
		nameTextBox.sendKeys(name);
		emailTextBox.sendKeys(email);
		save.click();
		nameTextBox.clear();
		emailTextBox.clear();
		driver.switchTo().defaultContent();
	}*/
	
	public void fillForm() {
		int row=1;
		
		driver.switchTo().frame(iframe);
		
		while(true) {
			List<String> expected=dataTest(0, row);
			if(expected.isEmpty() || expected.size()<2) {
				break;
			}
			String name = expected.get(0);
			String email = expected.get(1);
			nameTextBox.sendKeys(name);
			emailTextBox.sendKeys(email);
			save.click();
			row++;
		}
		driver.switchTo().defaultContent();
	}
	
	public void editAndUpdateWebTable() {
		int row = 1;
		int j = 0;
		driver.switchTo().frame(iframe);
		while(true) {
			List<String> expected=dataTest(1,row);
			if(expected.isEmpty() || expected.size()<2) {
				break;
			}
			String name = expected.get(0);
			String email = expected.get(1);
			editButton.get(j).click();
			editName.clear();
			editEmail.clear();
			editName.sendKeys(name);
			editEmail.sendKeys(email);
			updateButton.click();
			row++;
			j++;
		}
		driver.switchTo().defaultContent();
	}
	
	public void editAndCancelWebTable() {
		driver.switchTo().frame(iframe);
		for(int i = 0; i<editButton.size(); i++) {
			editButton.get(i).click();
			cancelButton.click();
		}
		driver.switchTo().defaultContent();
	}
	
	public void validateTableData() {
		int row =1;
		SoftAssert softAssert = new SoftAssert();
		driver.switchTo().frame(iframe);
		waitUntilVisible(table);
		HashMap<String, String> actual = new HashMap<String, String>();
		
		for(int i = 0; i<tableData.size(); i++) {
			String key = tableData.get(i).getAttribute("data-name");
			String value = tableData.get(i).getAttribute("data-email");
			actual.put(key, value);
		}
		while(true) {
			List<String> expected=dataTest(0, row);
			if(expected.isEmpty() || expected.size()<2) {
				break;
			}
			String name = expected.get(0);
			String email = expected.get(1);
			//softAssert.assertTrue(actual.containsKey(name));
			softAssert.assertEquals(actual.get(name), email);
			row++;
		}
		softAssert.assertAll();
		driver.switchTo().defaultContent();
	}
}
