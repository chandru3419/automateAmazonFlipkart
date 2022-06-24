package com.automation.amazonTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.testng.annotations.Test;

import genericUtils.BaseClass;

public class AmazonFlipkart extends BaseClass {
	
	ArrayList<Double> list = new ArrayList<Double>();
	
	@Test(priority=2)
	public void testAmazon(){
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("onion 1 kg",Keys.ENTER);
		driver.findElement(By.xpath("//span[.='Fresh Onion, 1kg']")).click();
		Set<String> WinId = driver.getWindowHandles();
		for (String wn : WinId) 
		{
			driver.switchTo().window(wn);
		}
		String amt = driver.findElement(By.xpath("//span[contains(.,'Fresh Onion, 1kg')]"
				+ "/ancestor::div[@class='centerColAlign centerColAlign-bbcxoverride']/descendant::span[@class='a-size-medium a-color-price']")).getText();
		System.out.println(amt.substring(1));
		System.out.println(Double.parseDouble(amt.substring(1)));
		list.add(Double.parseDouble(amt.substring(1)));	
	}
	
	@Test(priority=3)
	public void testFlipkart() throws Throwable{
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.xpath("//button[.='✕']")).click();
		  driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("onion",Keys.ENTER);
		  
		  driver.findElement(By.xpath("//a[.='Onion 1 kg']")).click();
			Set<String> WinId = driver.getWindowHandles();
			for (String wn : WinId) 
			{
				driver.switchTo().window(wn);
			}
			
//			String price2 = driver.findElement(By.xpath("//span[.='Onion 1 kg']/ancestor::div[@class='aMaAEs']/descendant::div[.='₹19']")).getText();
			String price2=driver.findElement(By.xpath("//span[.='Onion 1 kg']/ancestor::div[@class='aMaAEs']/descendant::div[@class='_30jeq3 _16Jk6d']")).getText();
			Thread.sleep(5000);
			System.out.println(price2);
			 System.out.println(price2.substring(1));
				list.add(Double.parseDouble(price2.substring(1)));	
		
		
		for (Double value : list) {
			System.out.println(value);
		}
		
		//print min value
		Collections.sort(list,Collections.reverseOrder());
		System.out.println(list.size()-1);
		
	}
	
	@Test(priority=1)
	public void bigBasket() throws InterruptedException
	{
		driver.get("https://www.bigbasket.com/");
		driver.findElement(By.xpath("//input[@qa='searchBar']")).sendKeys("onion");
		driver.findElement(By.xpath("//button[@class='btn btn-default bb-search']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[.='Onion - Organically Grown']")).click();
		Thread.sleep(5000);
		String price = driver.findElement(By.xpath("//h1[.='Fresho Onion - Organically Grown, 1 kg  ']/ancestor::div[@id='title']/descendant::td[@data-qa='productPrice']")).getText();
		System.out.println(price.substring(3));
		System.out.println(Double.parseDouble(price.substring(3)));
}
	
	
	
	
	

}
