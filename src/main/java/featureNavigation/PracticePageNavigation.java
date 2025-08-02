package featureNavigation;

public interface PracticePageNavigation {
	static final String MODAL = "//div[@class='modal-content']";
	static final String CLOSE = "//button[text()='×']";
	static final String PRACTICE = "//a[@href='newdemo.html']";
	
	public void registerModalClose();
	public void clickPractice();
}