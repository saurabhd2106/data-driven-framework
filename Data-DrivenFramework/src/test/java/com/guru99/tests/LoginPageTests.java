package com.guru99.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guru99.pages.LoginPage;

import commonLibs.implementation.CommonDriver;

public class LoginPageTests {
	
	CommonDriver cmnDriver;
	
	String url = "http://demo.guru99.com/v4";
	
	LoginPage loginPage;
	
	@BeforeMethod
	public void setup() throws Exception {
		
		cmnDriver  = new CommonDriver("chrome");
		
		cmnDriver.navigateToFirstUrl(url);
		
		loginPage = new LoginPage(cmnDriver.getDriver());
		
	}
	
	@Parameters({"username", "userPassword"})
	@Test
	public void verifyLogin(String sUsername, String sPassword) throws Exception{
		
		loginPage.loginToApplication(sUsername, sPassword);
		
		String actualTile = cmnDriver.getTitle();
		
		String expectedTitle = "Guru99 Bank Manager HomePage";
		
		Assert.assertEquals(actualTile, expectedTitle);
		
	}
	
	@AfterMethod
	public void cleanUp() throws Exception {
		cmnDriver.closeAllBrowsers();
	}

}
