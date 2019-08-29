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

public class MFTG {
	static WebDriver driver;
	static WebDriverWait wait;
	static Actions a;
  @Test
  public void f() throws InterruptedException {
	  wait = new WebDriverWait(driver,10);
		
		WebElement menu = driver.findElement(By.xpath("/html/body/div[1]/div[1]/table/tbody/tr/td[2]/div[1]/table/tbody/tr/td/a/div"));
	  wait.until(ExpectedConditions.elementToBeClickable(menu));
	  a = new Actions(driver);
	
		
	  		a.moveToElement(menu).build().perform();
	  		
	  		Thread.sleep(1000);
	  		driver.findElement(By.xpath("//div[@id='divtop']//ul//li//a//div[contains(text(),'HR')]")).click();
	  		
	  		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  		
	  		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[1]/div[1]/table/tbody/tr/td[2]/div[1]/table/tbody/tr/td/a/div")));
	  		
	  		a.moveToElement(driver.findElement(By.xpath("/html/body/div[1]/div[1]/table/tbody/tr/td[2]/div[1]/table/tbody/tr/td/a/div"))).build().perform();
	  		
	  		Thread.sleep(1000);
	  		
	  		driver.findElement(By.xpath("//div[@id='divtop']//ul//li//a//div[contains(text(),'Mftg')]")).click();
	  		
	  		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  		
	  		a.moveToElement(driver.findElement(By.xpath("/html/body/div[1]/div[1]/table/tbody/tr/td[2]/div[1]/table/tbody/tr/td/a/div"))).build().perform();
	  		
	  		Thread.sleep(1000);
	  			  		
	  		driver.findElement(By.xpath("//div[@id='divtop']//ul//li//a//div[contains(text(),'Stores')]")).click();
	  		
	  		Thread.sleep(4000);
	  		
	  		driver.quit();
		  
  }
  @BeforeTest
  public void beforeTest() throws InterruptedException {System.setProperty("webdriver.gecko.driver","E:\\Softwares\\Selenium FIles\\geckodriver-v0.24.0-win64\\geckodriver.exe");
  driver = new FirefoxDriver();
  driver.navigate().to("http://10.10.10.15:86");
  driver.findElement(By.id("UserName")).sendKeys("benjamin.dupare");
  driver.findElement(By.id("Password")).sendKeys("infi");
		
  //Click on 'Login 
  driver.findElement(By.id("btnLogIn")).click();

  Thread.sleep(4000);
  }

  @AfterTest
  public void afterTest() {
  }

}
