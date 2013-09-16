package com.BISPL.config;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.BISPL.libraries.ExcelLibrary;
import com.BISPL.libraries.ProjectSpecificLibrary;
public class Config {
	public WebDriver driver;
	public ProjectSpecificLibrary plib;
	@BeforeMethod
	public void launchApplication(){
		//Create object of ExcelLibrary
		ExcelLibrary lib = new ExcelLibrary();
		//Get browser on which application has to be launched
		String browser = lib.getExcelData("settings",1,0);
		//Get url of the application
		String url = lib.getExcelData("settings",1,1);		
		System.out.println("Starting scenario");
		//Compare the browser string and launch the respective browser
		if(browser.equals("firefox")){
			driver = new FirefoxDriver();
		}
		else if(browser.equals("ie")){
					
		//	File file = new File("D:/SeAutomation/hybridframework/IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver","browserdrivers/IEDriverServer.exe");
		//  System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			driver = new InternetExplorerDriver();
		}
		else if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","browserdrivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.get(url);
	//	driver.get("http://localhost:8080/StellarBolas/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		plib = new ProjectSpecificLibrary(driver);
	}
	/*  @AfterMethod
	public void quiteApplication(){
		driver.quit();
		System.out.println("Ending scenario");
	} */
}
