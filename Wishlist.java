package com.project.test;


import org.testng.annotations.Test;

import com.project.base.Common;
import com.project.pages.WishlistPages;

import org.testng.annotations.BeforeClass;
import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import org.testng.annotations.AfterClass;

public class Wishlist extends Common {
	WishlistPages myWishlist;
//	Common c = new Common();
	Logger log = Logger.getLogger(WishlistPages.class.getName());
	
  @Test
  public void WishlistNew() throws InterruptedException {
	
	  myWishlist.wishlist_button();
	  myWishlist.AddToCart();
	  myWishlist.Remove_product();
	  myWishlist.CLickOnProduct();
	  
  }
  @BeforeClass
  public void beforeClass() throws DocumentException {
	  myWishlist= new WishlistPages();
	  
	  getsite();
	  login();
	  
	
	  
  }

  @AfterClass
  public void afterClass() {
	  closeBrowser();
	  log.info("closing the Browser");
  }


}
