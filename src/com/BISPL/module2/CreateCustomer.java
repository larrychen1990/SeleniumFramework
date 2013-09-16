package com.BISPL.module2;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.BISPL.assertions.Assertions;
import com.BISPL.config.Config;
import com.BISPL.libraries.ExcelLibrary;

public class CreateCustomer extends Config{
	@Test
	public void testTest3(){
		System.out.println("Running CreateCustomer of module 2");
		ExcelLibrary lib = new ExcelLibrary();
		String eid = lib.getExcelData("Test3",1, 0);
		String un = lib.getExcelData("Test3",1, 0);
		String pw = lib.getExcelData("Test3",1,1);
		String custName = lib.getExcelData("Test3",1,2);
		plib.doLogin(eid,un, pw);
		driver.findElement(By.linkText("Projects & Tasks")).click();
		driver.findElement(By.linkText("Projects & Customers")).click();
		driver.findElement(By.cssSelector("input[value='Add New Customer']")).click();
		driver.findElement(By.name("name")).sendKeys(custName);
		driver.findElement(By.name("createCustomerSubmit")).click();
		String actualMsg = driver.findElement(By.className("successmsg")).getText();
		Assertions.assertText("Customer has been successfully registered.", actualMsg);
		Reporter.log("Customer created successfully");
		plib.doLogout();
		
	}
}
