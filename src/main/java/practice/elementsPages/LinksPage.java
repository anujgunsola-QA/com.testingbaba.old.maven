package practice.elementsPages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseLibrary.ManageBrowser;

public class LinksPage extends ManageBrowser{
	public LinksPage() {
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
	
	@FindBy(xpath = "//a[text()='links']")
	private WebElement linksButton;
	
	@FindBy(xpath = "//a[text()='Demo Page']")
	private WebElement demoPageLink;
	
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
	
	public void clickLinks() {
		waitUntilClickableAndClick(linksButton);
	}
	
	public void clickDemoPageLink() {
		demoPageLink.click();
	}
	
	public List<String> getOpenTabsURL(){
		List <String> openTabsURLList=new ArrayList<String>();
		Set <String> tabsSet = driver.getWindowHandles();
		for(String s:tabsSet) {
			String URLs=driver.switchTo().window(s).getCurrentUrl();
			openTabsURLList.add(URLs);
		}
		return openTabsURLList;
	}
}
