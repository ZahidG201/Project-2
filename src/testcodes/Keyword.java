package testcodes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Keyword {
	static WebDriver driver;
	static FileInputStream file;
	static  Properties p;

	
	public void openbrowser() throws FileNotFoundException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\zahid\\Desktop\\appium\\chromedriver.exe");
		driver=new ChromeDriver();
		file = new FileInputStream("C:\\Users\\zahid\\eclipse-workspace\\zahi\\CRM_tools_project\\src\\objectrr.properties");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	     p=new Properties();
	     p.load(file);
	     
		//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//		WebDriverWait w=new WebDriverWait(driver, 30);
		//		w.until(ExpectedConditions.titleIs("google"));
		//		driver.navigate().to("https://accounts.google.com/ServiceLogin/identifier?passive=1209600&continue=https%3A%2F%2Faccounts.google.com%2Fb%2F1%2FAddMailService&followup=https%3A%2F%2Faccounts.google.com%2Fb%2F1%2F"
		//				+ "AddMailService&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		//		driver.manage().window().maximize();
		//		try {
		//			File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//			FileHandler.copy(f, new File("zahidulla.jpg"));
		//		} catch (Exception e) {
		//			// TODO: handle exception
		//			e.printStackTrace();
		//		}

	}
	
	/**
	 * navigating to the given url
	 * @param data
	 */
	public void navigate(String data) {
		driver.navigate().to(data);


	}
  /**
   * inputing the values from excel
   * @param data
   * @param ObjectName
   */

	public void input(String data, String ObjectName) {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath(p.getProperty(ObjectName))).sendKeys(data);
		

	}

	public void click(String objectName) {
		
		 driver.findElement(By.xpath(p.getProperty(objectName))).click();
		 
		
	}
	public void dropdown (String objectName, String data) {
		
		Select sel =new Select( driver.findElement(By.xpath(p.getProperty(objectName))));
		sel.selectByValue(data);
		
		
		
	}
	public String verify() {
		return driver.getTitle();
		
	}
	public void close() {
		driver.close();
	}

 
	

}
