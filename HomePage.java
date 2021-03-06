package com.project.pages;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.project.base.Common;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePage extends Common
{


	public String getPageTitle()
	{
		WebElement homeButton = driver.findElement(By.xpath("//*[@id=\"mc-horizontal-menu-collapse\"]/div/ul/li[1]/a"));
		homeButton.click();
		String actualTitle = driver.getTitle();
		return(actualTitle);
		
	}
	
	public String brandTitleCheck()
	{
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		WebElement brandEle = driver.findElement(By.xpath("//*[@id=\"brands-carousel\"]/h3"));
		String brandTitle = brandEle.getText();
		return(brandTitle);
	}
	
	public WebElement smartPhoneScroll() throws InterruptedException
	{
		WebElement homeButton = driver.findElement(By.xpath("//*[@id=\"mc-horizontal-menu-collapse\"]/div/ul/li[1]/a"));
		homeButton.click();
		js.executeScript("window.scrollBy(0,700)", "");
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id=\"top-banner-and-menu\"]/div/div/div[3]/div/div[1]/section/h3")));

		WebElement smartphoneLeft = driver.findElement(By.xpath("//*[@id=\"top-banner-and-menu\"]/div/div/div[3]/div/div[1]/section/div/div[1]/div/div[7]/div/div/div/div[2]/h3/a"));
        return(smartphoneLeft);

	}
	
	public WebElement laptopScroll() {
		
		WebElement laptopRightBtn = driver.findElement(By.xpath("//*[@id=\"top-banner-and-menu\"]/div/div/div[3]/div/div[2]/section/div/div[2]/div/div[2]"));
		laptopRightBtn.click();
		
		WebElement laptopRight = driver.findElement(By.xpath("//*[@id=\"top-banner-and-menu\"]/div/div/div[3]/div/div[2]/section/div/div[1]/div/div[1]/div/div/div/div[2]/h3/a"));
        return(laptopRight);
		
	}
	
	public void facebookDirect(String expectedTitle, String expectedColor)
	{
		WebElement brandFacebook = driver.findElement(By.xpath("//*[@class='icon fa fa-facebook']"));
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		String btnColor = driver.findElement(By.cssSelector(".footer .links-social .social-icons a.active")).getCssValue("background-color");
		String actualColor = Color.fromString(btnColor).asHex();
		Assert.assertTrue(expectedColor.equals(actualColor));

		brandFacebook.isDisplayed();
		brandFacebook.click();

		driver.navigate().back();
		driver.navigate().refresh();

	}
	
	public void linkedinDirect(String expectedTitle, String expectedColor)
	{

		WebElement brandLinkedin = driver.findElement(By.xpath("//*[@class='icon fa fa-linkedin']"));
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");

		Actions action = new Actions(driver);
		action.moveToElement(brandLinkedin).perform();
		String btnColor = driver.findElement(By.cssSelector(".footer .links-social .social-icons a.active")).getCssValue("background-color");
		String actualColor = Color.fromString(btnColor).asHex();
		Assert.assertTrue(expectedColor.equals(actualColor));

		brandLinkedin.isDisplayed();
		brandLinkedin.click();

		driver.navigate().back();
		driver.navigate().refresh();
	}
	


	public void closeBrowser()
	{
		driver.quit();
	}
	
	
	
}
