package com.BISPL.libraries;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;

import com.BISPL.assertions.Assertions;

public class ProjectSpecificLibrary{
	WebDriver driver;
	public ProjectSpecificLibrary(WebDriver driver) {
		this.driver=driver;
	}
	public void doLogin(String eid, String un, String pw){
		
		//Get actual title from the application using getTitle()
	//	String actualTitle = driver.getTitle();
	//	String expectedTitle = "Login Page-Windows Internet explorer";
		//Call assertTitle() static method of Assertions class
		//and compare expected title and actual title
	//	Assertions.assertTitle(expectedTitle, actualTitle);
		//If expected and actual match, print message to reporter
	//	Reporter.log("Application opened successfully");	
	
	//	driver = new InternetExplorerDriver();
	//	driver.get("http://localhost:8080/StellarBolas/");
	//	driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
			//driver = new FirefoxDriver();
		/*	File file = new File("D:/SeAutomation/hybridframework/IEDriverServer.exe");
		    System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			driver = new InternetExplorerDriver();
			driver.get("http://localhost:8080/StellarBolas/");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);   */
		
		// Window Handles when more than 1 Browser are present
		Set<String> winId = driver.getWindowHandles();
		Iterator<String> winIds = winId.iterator();
		List<String> widL = new ArrayList<String>();
		System.out.println("Size of the window hanldes(ID) is " + winId.size());
		for (int i=0; i <winId.size(); i++) {
			//System.out.println("window Id for the browser #" +i+ " is " + winIds.next());
			widL.add(winIds.next()); 
		}
		driver.switchTo().window(widL.get(1));
		
		driver.findElement(By.id("entnameid")).sendKeys(eid);
		System.out.println("Enterprise Name:  " + eid);
		driver.findElement(By.id("uname")).sendKeys(un);
		System.out.println("User Name:  " + un);
		driver.findElement(By.id("pwd")).sendKeys(pw);
		System.out.println("Password:  " + pw);
		driver.findElement(By.id("stellar_button")).click();
		
		 
	/*	 Actions actions = new Actions(driver);
	     //WebElement Mainmenu = driver.findElement(By.xpath("//"));
	     WebElement Mainmenu = driver.findElement(By.xpath(".//*[@id='stellar_menu_id']/ul/li[1]/a"));
	     //WebElement Submenu = driver.findElement(By.xpath("//"));
	     WebElement Submenu=driver.findElement(By.xpath(".//*[@id='stellar_menu_id']/ul/li[1]/ul/li[1]/a"));
	     //WebElement Childsubmenu = driver.findElement(By.xpath("//"));
	     WebElement Childsubmenu=driver.findElement(By.xpath(".//*[@id='stellar_menu_id']/ul/li[1]/ul/li[1]/ul/li[1]/a"));
	     actions.moveToElement(Mainmenu).moveToElement(Submenu).moveToElement(Childsubmenu).click().build().perform();
	     */

		
		
	/*	String actualTxt = driver.findElement(By.xpath("//td[@class='pagetitle']/table/tbody/tr/td[1]")).getText();
		String expectedTxt = "Enter Time-Track";
		Assertions.assertText(expectedTxt, actualTxt);	
		Reporter.log("Login successful"); */
		
	}
	public void doLogout(){
		driver.findElement(By.className("logoutImg")).click();
	}
}
