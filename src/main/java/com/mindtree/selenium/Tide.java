package com.mindtree.selenium;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.FindsByXPath;

public class Tide {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers1\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//Accessing the URL
		driver.get("https://tide.com/en-us");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Test_Case1  :  URL opened sucessfully");
		driver.findElement(By.xpath("//*[@class=\"lilo3746-close-link lilo3746-close-icon\"]")).click();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@class=\"login-register\"]")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Sign up now')]")).click();
		
		Set<String> w = driver.getWindowHandles();
		Iterator<String> t = w.iterator();
		String pw = t.next();
		String cw = t.next();
		driver.switchTo().window(cw);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Account creation
	    driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Goutham");
	    driver.findElement(By.xpath("//input[@type='email']")).sendKeys("goutham@gmail.com");
	    driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Sads@123");
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
	    System.out.println("Test_Case2 :  Account created sucessfully");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   
	    driver.switchTo().window(pw);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //Contact for help 
	    driver.findElement(By.xpath("//span[contains(text(),'Contact Us')]")).click();
	    driver.findElement(By.xpath("//*[@id='clear']")).click();
	    System.out.println("Test_Case3 :  User can contact the company when needed");
	    
	    
	   //Closing the portal
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.switchTo().window(cw);
	    driver.close();
	    driver.switchTo().window(pw);
	    driver.close();
	    
	    System.out.println("Test_Case4  :  Portal closed successfully");
	   
		
		
		
	
		
	}

}
