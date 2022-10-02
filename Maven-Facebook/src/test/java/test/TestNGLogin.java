package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BrowserSetup.Base;
import Utils.Utility;
import pages.LoginOrSignUpPage;
import pages.MessengerPage;
import pages.RoomsPage;

public class TestNGLogin extends Base {

	private WebDriver driver;
	private LoginOrSignUpPage loginOrSignUpPage;
	int TestID;
	@BeforeTest
	public void launchBrowser() {
			driver = openChromeBrowser();
	}
	@BeforeClass
	public void createPOMObjects() {
	loginOrSignUpPage = new LoginOrSignUpPage(driver);
	}
	@BeforeMethod
	public void openUrl() throws InterruptedException, EncryptedDocumentException, IOException {
	driver.get("https://www.facebook.com/");
	}
	@Test (priority = 1, invocationCount = 5)
	public void loginToFB() throws IOException, InterruptedException {
	TestID = 101;
	int i = 0;
	String data =Utility.excelData("Facebook", i , 0);
	loginOrSignUpPage.sendUserName(data);
	data = Utility.excelData("Facebook", i, 1);
	loginOrSignUpPage.sendPassord(data); //Thread.sleep(3000);
	loginOrSignUpPage.clickOnLoginButton();
	i++;
	}
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
	if(ITestResult.FAILURE == result.getStatus())
	{
		Utility.captureScreenShot(driver, TestID);
	}
//	if(ITestResult.SUCCESS == result.getStatus())
//	{
//		LogOut Code;
//	}
//	
	}
	@AfterClass
	public void removePOMObjects() throws InterruptedException {
		loginOrSignUpPage = null;
	}
	@AfterTest
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(8000);
		driver.quit();
		driver = null;
		System.gc();   //Garbage Collector
	}
}
