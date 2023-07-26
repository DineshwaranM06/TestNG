package com.testng;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;
import com.google.common.io.Files;

public class ProjectDemo extends BaseClass{

	@Test
	private void browser() {
		browser("firefox");
		driver.get("https://blazedemo.com/");

	}
	
	@Test
	private void homepage() {
		WebElement website = driver.findElement(By.xpath("//h1[text()='Welcome to the Simple Travel Agency!']"));
        boolean displayed = website.isDisplayed();
        System.out.print(displayed);
        WebElement advertisement = driver.findElement(By.xpath("//a[text()='destination of the week! The Beach!']"));
	    advertisement.click();
        driver.navigate().back();
	}
	 
	@Test
	private void location() throws InterruptedException {
		WebElement departure = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select s = new Select(departure);
        s.selectByIndex(5);
        
        WebElement destination = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select s2 = new Select(destination);
        s2.selectByIndex(2);
        
        WebElement click = driver.findElement(By.xpath("//input[@type='submit']"));
        click.click();
        
        WebElement flight = driver.findElement(By.xpath("(//input[@type='submit'])[3]"));
       	Thread.sleep(1000);
  	  flight.click();
	}
	
	@Test
	@Parameters({"firstnam","add","cities","states","zip","number","months","years","names"})
	private void payment(String firstnam,String add,String cities,String states,String zip,String number,String months,String years,String names) {
		WebElement firstname = driver.findElement(By.id("inputName"));
        WebElement address = driver.findElement(By.id("address"));
        WebElement city = driver.findElement(By.id("city"));
        WebElement state = driver.findElement(By.id("state"));
        WebElement zipcode = driver.findElement(By.id("zipCode"));
        WebElement card = driver.findElement(By.xpath("//select[@id='cardType']"));
        WebElement cardnumber = driver.findElement(By.id("creditCardNumber"));
        WebElement month = driver.findElement(By.id("creditCardMonth"));
        WebElement year = driver.findElement(By.id("creditCardYear"));
        WebElement name = driver.findElement(By.id("nameOnCard"));
        WebElement purchase = driver.findElement(By.xpath("//input[@value='Purchase Flight']"));
        
        firstname.sendKeys(firstnam);
        address.sendKeys(add);
        city.sendKeys(cities);
        state.sendKeys(states);
        zipcode.sendKeys(zip);
        Select s3 = new Select(card);
        s3.selectByIndex(0);
        cardnumber.sendKeys(number);
        month.clear();
        month.sendKeys(months);
        year.clear();
        year.sendKeys(years);
        name.sendKeys(names);
        purchase.click();
	}

      	@AfterTest
      	private void screenshot() throws IOException {
      		TakesScreenshot ts = (TakesScreenshot)driver;
    		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
    		File dest = new File("C:\\Users\\Asus\\eclipse-workspace\\TestNg_May\\src\\test\\java\\com\\testng\\ScreenShots\\ThanksOrdered.png");
    		Files.copy(screenshotAs,dest);
      	}
}
