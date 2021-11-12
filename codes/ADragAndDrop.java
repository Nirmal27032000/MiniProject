package actionclass;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class ADragAndDrop {
  
	
	String baseurl = "http://cookbook.seleniumacademy.com/DragDropDemo.html";
	WebDriver driver;
	
  @Test
  public void dragdrop()
  {
	  WebElement draggable = driver.findElement(By.id("draggable"));
	  WebElement droppable = driver.findElement(By.id("droppable"));
	  
	  Actions action  = new Actions(driver);
	  action.dragAndDrop(draggable,droppable);
	  action.perform();
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(baseurl);
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException 
  {
	 Thread.sleep(3000);
	 driver.quit();
  }

}
