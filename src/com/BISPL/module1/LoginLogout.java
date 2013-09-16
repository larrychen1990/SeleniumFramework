package com.BISPL.module1;

import org.testng.annotations.Test;
import com.BISPL.config.Config;
import com.BISPL.libraries.ExcelLibrary;

public class LoginLogout extends Config{	
	@Test
	public void testTest1(){
		ExcelLibrary lib = new ExcelLibrary();
		String eid = lib.getExcelData("Test1", 1, 0);
		System.out.println("eid is  "+eid);
		String un = lib.getExcelData("Test1", 1, 1);
		System.out.println("User Name is  "+un);
		String pw = lib.getExcelData("Test1", 1, 2);
		System.out.println("Password is  "+pw);
		plib.doLogin(eid,un,pw);
	//  plib.doLogout();
	}		
}
