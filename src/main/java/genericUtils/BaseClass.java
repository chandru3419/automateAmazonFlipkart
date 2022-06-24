package genericUtils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;



import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriverUtility wLib=new WebDriverUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public WebDriver driver;

	public void congifBS(){
		System.out.println("DB starts");

	}
	//
	
	@BeforeClass
	public void configBC(){
		System.out.println("Bc executed");
		 
	}
	
	@BeforeMethod
	public void configBM(){
		System.out.println("Bm executed");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver(options);
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		
	}
	
	@AfterMethod
	public void configAM(){
		System.out.println("Am executed");
//		driver.close();
		
		
		
	}
	
	@AfterClass
	public void configAC(){
//		
		System.out.println("After class executed");
	}
	@AfterSuite
	public void configAS(){
		System.out.println("DB closes");
	}	

}
