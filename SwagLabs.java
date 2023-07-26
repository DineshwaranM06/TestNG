package com.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;
import com.pomclass.PomClass;

public class SwagLabs extends BaseClass{

	@DataProvider
	public Object[][]  testData() {
		return new Object [][] { {"standard_user","incorrectPassword"},
		                       {"incorrectUser","secret_sauce"},                     
		                       {"standard_user","secret_sauce"}  };                        
	}
	
	@BeforeMethod 
	public void browser() throws InterruptedException {
		browser("Firefox");
		driver.get("https://www.saucedemo.com/");
		 Thread.sleep(2000);
	}
	
	@Test (dataProvider= "testData")
	@Parameters({"username","password"})
	
	public void loginpage(String username,String password) throws InterruptedException {
		Thread.sleep(3000);
	      WebElement user = driver.findElement(By.id("user-name"));
	      WebElement pass = driver.findElement(By.id("password"));
	      WebElement login = driver.findElement(By.id("login-button"));
	  
	      user.sendKeys(username);
	      Thread.sleep(2000);
	      pass.sendKeys(password);
	      Thread.sleep(2000); 
	      login.click();
	      Thread.sleep(2000);
	      refresh();
	      
}
	
	
	
}