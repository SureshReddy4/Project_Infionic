package Programs;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class LeftMenu {
  
	static WebDriver driver;
	
	@Test
  public void f() {
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
  public void afterTest() {
  }

}
