package Programs;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Navigation {
	
	static WebDriver driver;
	static WebDriverWait wait;
	static Actions a;
  @Test
  public void Nav() {
	  
	  WebElement menu = driver.findElement(By.id("mobi"));
		 wait.until(ExpectedConditions.elementToBeClickable(menu));
	  a = new Actions(driver);
		 
	  a.moveToElement(driver.findElement(By.id("mobi"))).build().perform();
	  
	  
	  String xpath1 = "//div[@id='divtop']//ul//li//a//div[contains(text(),'";
	  String xpath2 = "HR')]";
//	  driver.findElement(By.xpath("//div[@id='divtop']//ul//li//a//div[contains(text(),'HR')]"));
	  driver.findElement(By.xpath(xpath1+xpath2)).click();
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
  @BeforeTest
  public void beforeTest() throws InterruptedException 
  {
	  System.setProperty("webdriver.gecko.driver","E:\\Softwares\\Selenium FIles\\geckodriver-v0.24.0-win64\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  driver.navigate().to("http://10.10.10.15:86");
	  driver.findElement(By.id("UserName")).sendKeys("benjamin.dupare");
	  driver.findElement(By.id("Password")).sendKeys("infi");
			
	  //Click on 'Login 
	  driver.findElement(By.id("btnLogIn")).click();
	
	  Thread.sleep(4000);
	  
  }

  @AfterTest
  public void afterTest() throws InterruptedException {
	  Thread.sleep(5000);
	  driver.quit();
  }

}
