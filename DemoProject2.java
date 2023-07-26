package com.seleniumpractice;





import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;



public class DemoProject2 {

	public static void main (String[] args) throws InterruptedException, AWTException, IOException {
		
		System.setProperty("webdriver.firefox.driver","C:\\Users\\Asus\\eclipse-workspace\\Seleniumpratice\\Drivers\\geckodriver.exe");
		
		WebDriver driver = (WebDriver) new FirefoxDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		driver.manage().window().maximize();
		
		Actions ac = new Actions(driver);
		
		WebElement searchbox = driver.findElement(By.xpath("//input[@class='search-keyword']"));
		searchbox.sendKeys("carrot");
		
		Thread.sleep(2000);
		
		WebElement searchbutton = driver.findElement(By.xpath("//button[@class='search-button']"));
		ac.click(searchbutton).perform();
		
		Thread.sleep(2000);
		
		WebElement add = driver.findElement(By.linkText("+"));
		ac.click(add).perform();
		
		Thread.sleep(2000);
		
		WebElement cart = driver.findElement(By.xpath("//*[@class='product-action']"));
		ac.click(cart).perform();
		
		Thread.sleep(2000);
		
		WebElement bag = driver.findElement(By.xpath("//*[@alt='Cart']"));
		ac.click(bag).perform();
		
		Thread.sleep(2000);
		
		WebElement proceed = driver.findElement(By.xpath("//*[@class='action-block']"));
		ac.click(proceed).perform();
		
		Thread.sleep(3000);
		
		WebElement promo = driver.findElement(By.xpath("//input[@type='text']"));
		promo.sendKeys("12345");
		
		Thread.sleep(2000);
		
		WebElement promocode = driver.findElement(By.xpath("//button[@class='promoBtn']"));
		ac.click(promocode).perform();
		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(2000);
		
		WebElement country = driver.findElement(By.xpath("//*[@style='width: 200px;']"));
		Select c = new Select(country);
		c.selectByVisibleText("India");
		
		WebElement box = driver.findElement(By.xpath("//input[@type='checkbox']"));
		ac.click(box).perform();		
		
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		
		
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(3000);
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Asus\\eclipse-workspace\\Seleniumpratice\\src\\Screenshots\\GroceryOrder.png");
		Files.copy(screenshotAs,dest);
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
