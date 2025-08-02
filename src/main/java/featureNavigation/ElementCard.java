package featureNavigation;

public interface ElementCard extends PracticePageNavigation{
	static final String ELEMENT = "//button[@data-target='#elements']";
	
	public void clickElements();
}
