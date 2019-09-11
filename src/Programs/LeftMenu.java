package Programs;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class LeftMenu {
  
	static WebDriver driver;
	static Actions a ;
	static WebDriverWait wait;
	
	@Test
  public void f() throws InterruptedException {
		
		a = new Actions(driver);
		
		wait = new WebDriverWait(driver,60);
		
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody//tr//td//a//div[@class='menuIcon']")));
		  
		
		  a.moveToElement(driver.findElement(By.xpath("//tbody//tr//td//a//div[@class='menuIcon']"))).build().perform();
		  
		  Thread.sleep(1000);
		  
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='divtop']//ul//li//a//div[contains(text(),'HR')]"))).click();
		
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  
		List<WebElement> submodules = driver.findElements(By.cssSelector("div#trvLeftMenuItems > ul >li >div > a"));
		
		for(WebElement menu : submodules)
		{
			String name = menu.getText();
			
			System.out.println(name);
		}
  }
  @BeforeTest
  public void beforeTest() throws InterruptedException {
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
