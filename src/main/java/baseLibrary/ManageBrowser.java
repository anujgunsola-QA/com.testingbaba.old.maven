package baseLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;

import actions.MouseAndKeyboardActions;
import applicationUtility.ApplicationUtility;
import applicationUtility.JavascriptUtility;
import applicationUtility.SelectDropdown;
import excelUtility.ExcelData;
import propertyUtility.RadioButtonData;
import propertyUtility.TextBoxPageData;
import screeenshotUtility.TakeScreenshot;
import waitUtility.AlertWait;
import waitUtility.ExplicitWait;

public class ManageBrowser implements ExcelData, TextBoxPageData, RadioButtonData, ExplicitWait, ApplicationUtility, TakeScreenshot, 
									  AlertWait, JavascriptUtility, SelectDropdown, MouseAndKeyboardActions{
	public static WebDriver driver = null;
	
	public void openBrowser() {
		String path = System.getProperty("user.dir")+"\\webdrivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testingbaba.com/old/");
	}
	
	public void openBrowser(String browserName) {
		if(browserName.equals("chrome")){
		String path = System.getProperty("user.dir")+"\\webdrivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		}
		else
			if(browserName.equals("firefox")) {
				String path = System.getProperty("user.dir")+"\\webdrivers\\geckodriver.exe";
				System.setProperty("webdriver.gecko.driver", path);
				driver = new FirefoxDriver();
			}
			else
				if(browserName.equals("edge")) {
					String path = System.getProperty("user.dir")+"\\webdrivers\\msedgedriver.exe";
					System.setProperty("webdriver.edge.driver", path);
					driver = new EdgeDriver();
				}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@SuppressWarnings("resource")
	public List<String> dataTest(int sheetNumber, int row) {
		List<String> list = new ArrayList<String>();
	
		try {
			String path = System.getProperty("user.dir")+"\\ExcelDataFiles\\User_Credentials.xlsx";
			FileInputStream fis = new FileInputStream(path);
			XSSFWorkbook file = new XSSFWorkbook(fis);
			XSSFSheet sheet = file.getSheetAt(sheetNumber);
			if(row<=sheet.getLastRowNum()) {
			for(int i = 0; i<sheet.getRow(row).getLastCellNum(); i++) {
				String s = sheet.getRow(row).getCell(i).toString();
				list.add(s);
			}
			}
		} catch (IOException e) {
			System.out.println("File not found:-"+e);
			
		}
		return list;
	}
	
	public void quitBrowser() {
		driver.quit();
	}

	@Override
	public String dataTest(String key) {
		String val = "";
		try {
			String path = System.getProperty("user.dir")+"\\PropertyFile\\textBoxTextData.properties";
			FileInputStream fis = new FileInputStream(path);
			Properties prop = new Properties();
			prop.load(fis);
			val = prop.getProperty(key);
		}
		catch(Exception e) {
			
		}
		return val;
	}

	@Override
	public String radioButtonTestData(String key) {
		String val = "";
		try {
			String path = System.getProperty("user.dir")+"\\PropertyFile\\radioButtonTextData.properties";
			FileInputStream fis = new FileInputStream(path);
			Properties prop = new Properties();
			prop.load(fis);
			val = prop.getProperty(key);
		}
		catch(IOException e) {
			System.out.println("The radioButton property file has not found: "+e);		//Exception declaration hierarachy
		}
		catch(Exception e) {
			System.out.println("An error occured:-"+e);
		}
		return val;
	}
	
	@DataProvider
	public String[][] dataTest(){
		String[][] data = new String[3][2];
		data[0][0]="Anuj Gunsola";
		data[0][1]="anujgunsolalp@gmail.com";
		data[1][0]="an";
		data[1][1]="anujgunsolalp@gmail.com";
		data[2][0]="Anuj Gunsola";
		data[2][1]="xyz";
		return data;
	}
	
	@Override
	public void waitUntilClickable(WebElement e) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));	
		wait.until(ExpectedConditions.elementToBeClickable(e));
	}

	@Override
	public void waitUntilVisible(WebElement e) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));	
		wait.until(ExpectedConditions.visibilityOf(e));
	}
	
	@Override
	public void waitUntilClickableAndClick(WebElement e) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));	
		wait.until(ExpectedConditions.elementToBeClickable(e)).click();
	}

	@Override
	public void waitUntilVisibleAndClick(WebElement e) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));	
		wait.until(ExpectedConditions.visibilityOf(e)).click();	
	}
	
	@Override
	public void waitUntillAlertVisible() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	@Override
	public void waitUntilinVisible(WebElement e) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(e));
	}

	@Override
	public void doubleClick(WebElement e) {
		Actions a = new Actions(driver);
		a.doubleClick(e).perform();
	}

	@Override
	public void singleClick(WebElement e) {
		Actions a = new Actions(driver);
		a.click(e).perform();
	}

	@Override
	public void rightClick(WebElement e) {
		Actions a = new Actions(driver);
		a.contextClick(e).sendKeys(Keys.ESCAPE).perform();
	}
	
	@Override
	public void ctrlClick(WebElement e) {
		Actions a = new Actions(driver);
		a.keyDown(Keys.CONTROL).click(e).keyUp(Keys.CONTROL).build().perform();
	}
	
	@Override
	public void ctrlClickMultiple(List<WebElement> list) {
		Actions a = new Actions(driver);
		a.keyDown(Keys.CONTROL);
		for(WebElement e:list) {
			a.click(e);
		}
		a.keyUp(Keys.CONTROL).build().perform();
	}
	
	@Override
	public void moveToWebElement(WebElement e) {
		Actions a = new Actions(driver);
		a.moveToElement(e).build().perform();
	}
	
	@Override
	public void dropContentToCordinate(WebElement e, int  x, int y) {
		Actions a = new Actions(driver);
		a.dragAndDropBy(e, x, y);
	}
	
	@Override
	public void slideAction(WebElement e, int x) {
		Actions a = new Actions(driver);
		a.clickAndHold(e).moveByOffset(x, 0).release().perform();
	}
	
	public List<String> openTabsList(){
		Set<String> handles = driver.getWindowHandles();
		List<String> tabsList = new ArrayList<>();
		for(String handle:handles) {
			tabsList.add(handle);
		}
		return tabsList;
	}

	@Override
	public void uploadFile(String path) {
		StringSelection sel = new StringSelection(path);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(sel, null);
		
		try {
			Robot r = new Robot();
			r.delay(250);
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_V);
			r.delay(250);
			r.keyPress(KeyEvent.VK_ENTER);
			r.delay(250);;
			r.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void takeScreenshot(String folderName, String fileName) {
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//EventFiringWebDriver efw = new EventFiringWebDriver(driver);			//We can use two methods for SC but EFW is deprecated in Selenium 4+
		//File src = efw.getScreenshotAs(OutputType.FILE);
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String dir = System.getProperty("user.dir");
		File des = new File(dir+"\\"+folderName+"\\"+fileName+".png");
		try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			System.out.println("destination file cannot be saved"+e);
		}
	}
	
	//@AfterMethod
	public void takeScreenShot(ITestResult result) throws InterruptedException {
		String passFolderName = this.getClass().getName()+"Screenshots"+"\\passed";
		String failFolderName = this.getClass().getName()+"Screenshots"+"\\failed";
		String fileName = result.getMethod().getMethodName();
		if (result.isSuccess())
			takeScreenshot(passFolderName, fileName);
		else
			takeScreenshot(failFolderName, fileName);
	}
	
	public void isVisibleAndClick(WebElement ele) {
		/*--The driver object has to be down-casted to JavascriptExecutor to perform javascript execution--*/
		/*--Here in javascript the webelement 'ele' is passed as a argument/parameter in arguments[0] on which scrollIntoView and click
			 will be performed--*/
		/*--In javascript we write a script and then execute the script with executeScript(script, WebElement)--*/
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(); arguments[0].click();", ele);
	}

	@Override
	public void contentIsVisible(WebElement ele) {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", ele);
	}

	@Override
	public Select selectByIndex(WebElement ele, int i) {
		Select sel = new Select(ele);
		sel.selectByIndex(i);
		return sel;
	}

	@Override
	public Select selectByText(WebElement ele, String text) {
		Select sel = new Select(ele);
		sel.selectByVisibleText(text);
		return sel;
	}

	@Override
	public Select selectByValue(WebElement ele, String value) {
		Select sel = new Select(ele);
		sel.selectByValue(value);
		return sel;
	}
	@DataProvider(name = "logincred")
	public Object[][] getData()
	{
		return new Object[][] 
				{
			{"username1", "password1"},
			{"username2", "password2"},
			{"username3", "password3"}
		};
	}

	@AfterTest(groups = {"smoke","sanity","regression"})
	void quitSession() {
		quitBrowser();
	}
}
