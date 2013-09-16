package com.BISPL.assertions;

import org.testng.Assert;
import org.testng.Reporter;

public class Assertions {

	public static void assertText(String expected, String actual){
		Assert.assertEquals(expected, actual);
		Reporter.log("Expected Text "+expected+" matches actual text "+actual);
	}
	public static void assertTitle(String expected, String actual){
		Assert.assertEquals(expected, actual);
		Reporter.log("Expected title "+expected+" matches actual title "+actual);
	}
}
