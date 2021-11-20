package com.project.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class WishlistPages {


public WebDriver driver;
public WebElement ClickOnWishlist ;
public WebElement CLickOnProduct ;
public WebElement Remove_product;
public WebElement AddToCart;
public WebElement Empty_Wishlist;

String baseUrl = null;
String expectedTitle = null;
String actualTitle = null;
Logger log = Logger.getLogger(WishlistPages.class.getName());


public void wishlist_button() throws InterruptedException {
	
	
	// Click on Wishlist button
	WebElement wishlist = driver.findElement(By.cssSelector("body > header > div.top-bar.animate-dropdown > div > div > div.cnt-account > ul > li:nth-child(2) > a"));
														
	wishlist.click();
	
	
	
	// Scroll down
	JavascriptExecutor js1 =(JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0, 400)");
	log.info("Click on Wishlist ");
	//Thread.sleep(4000);
	


}


public void Remove_product() {
	
	
	// Remove the product from Wishlist
	WebElement remove = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/div/table/tbody/tr[1]/td[3]/a"));
														
	remove.click();
	log.info("Product removed from wishlist");
	
	// Alert handling
	driver.switchTo().alert().accept();

}

public void AddToCart()
{
	  WebElement AddToCart = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/div/table/tbody/tr[1]/td[3]/a"));
		AddToCart.click();
		log.info("Product added to cart successfully ");
		
}


public void CLickOnProduct()
{
	  WebElement Product = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/div/table/tbody/tr[1]/td[2]/div[1]/a"));
	  	Product.click();
		log.info("Product details view ");
		driver.navigate().back(); 
		
}


}
