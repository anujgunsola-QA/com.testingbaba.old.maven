package practice.widgetsPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseLibrary.ManageBrowser;
import featureNavigation.WidgetsCard;

public class SliderPage extends ManageBrowser {
	public SliderPage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = WidgetsCard.MODAL) 
	private WebElement modal; 
	
	@FindBy(xpath = WidgetsCard.CLOSE)
	private WebElement close;

	@FindBy(xpath = WidgetsCard.PRACTICE)
	private WebElement practice;
	
	@FindBy(xpath = WidgetsCard.WIDGETS)
	private WebElement widgets;
	
	@FindBy(xpath = "//a[text()='slider']")
	private WebElement sliderCard;
	
	@FindBy(xpath="//*[@id='range-slider']")
	private WebElement slider;
	
	@FindBy(xpath="(//*[contains(@class, 'slider-handle')])[1]")
	private WebElement colorSlider;
	
	@FindBy(xpath="//*[@class='btn skip']")
	private WebElement adClose;
	
	public void registerModalClose() {
		contentIsVisible(modal);
		waitUntilClickableAndClick(close);
	}
	
	public void clickPractice() {
		waitUntilClickableAndClick(practice);
	}
	
	public void clickWidgets() {
		waitUntilClickableAndClick(widgets);
	}
	
	public void clickSlider() {
		waitUntilClickableAndClick(sliderCard);
	}
	
	public void slideTo(int offSet) {
		slideAction(slider, offSet);
	}
	
	public void testSlide(int offSet) {
		driver.get("https://www.globalsqa.com/demo-site/sliders/");
		slideAction(colorSlider, 30);
		if(adClose.isDisplayed()) {
		adClose.click();
		}
		contentIsVisible(colorSlider);
		slideAction(colorSlider, offSet);
	}
}
