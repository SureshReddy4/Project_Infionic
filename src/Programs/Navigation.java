package Programs;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
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
	
  @Test(dataProvider="dp")
  public void Nav(String Module) throws InterruptedException {
	  a = new Actions(driver);
	  
	  wait = new WebDriverWait(driver,60);
	
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody//tr//td//a//div[@class='menuIcon']")));
	  
	
	  a.moveToElement(driver.findElement(By.xpath("//tbody//tr//td//a//div[@class='menuIcon']"))).build().perform();
	  Thread.sleep(2000);
	  
	  
	  String xpath1 = "//div[@id='divtop']//ul//li//a//div[contains(text(),'";
	
	  String xpath2 = "')]";
	
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath1+Module+xpath2)));
	
	 WebElement mod = driver.findElement(By.xpath(xpath1+Module+xpath2));
	
	 mod.click();
	 
	 Thread.sleep(4000);
	
	  
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
  
  @DataProvider
  public Object[][] dp() throws IOException
  {
	  
		Object[][] SED = new Object[8][1];		
		

		for(int rw = 0; rw<=7;rw++)
			{
				//List<String> arr = Sample.Read_Excel1.readexceldata(".//Book4.xlsx",rw,3);
			List<String> arr = ReadExcel.readexceldata("C:\\Users\\sekhar.ch\\Desktop\\Tabs.xlsx",rw,1);
				{
					SED[rw][0] = arr.get(0);
				
				}	
					
			}
		return SED;

  }

}
