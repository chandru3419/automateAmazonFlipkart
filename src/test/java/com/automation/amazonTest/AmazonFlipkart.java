package com.automation.amazonTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import genericUtils.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonFlipkart extends BaseClass {
	
	@Test
	public void flipkart(){
		  driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys("Murgesh Bechetti");
		  driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']")).sendKeys("malingagj");
		  driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		  
		 driver.findElement(By.xpath("//button[.='✕']")).click();
		  driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("onion 1 kg",Keys.ENTER);
		  
		 String amt = driver.findElement(By.xpath("//a[.='Onion 1 kg']/ancestor::div[@data-id='VEGF7FJ5UVTDPSRH']//div[.='₹19']")).getText();
		 System.out.println(amt.substring(1));
	}
	
//	@Test
//	public void amazon(){
//		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("onion 1 kg",Keys.ENTER);
//		String amt = driver.findElement(By.xpath("//span[.='Fresh Onion, 1kg']/ancestor::div[@class='a-section a-spacing-base']//span[.='29']")).getText();
//		System.out.println(amt);
//	}
	
	
	

}
