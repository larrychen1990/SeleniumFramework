package com.BISPL.module1;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.BISPL.config.Config;
import com.BISPL.libraries.ExcelLibrary;

public class LoginLogoutExtra extends Config{	
	@Test
	public void testTest2(){	
		ExcelLibrary lib = new ExcelLibrary();
		String eid = lib.getExcelData("Test1", 1, 0);
		String un = lib.getExcelData("Test1", 1, 1);
		String pw = lib.getExcelData("Test1", 1, 2);
		plib.doLogin(eid,un,pw);
		driver.findElement(By.linkText("Reports")).click();
		driver.findElement(By.linkText("Settings")).click();
		plib.doLogout();
	}	
}
