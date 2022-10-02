package test;
import java.io.IOException;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
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

public class TestNg1 extends Base {
	
	private WebDriver driver;
	private MessengerPage messengerPage;
	private RoomsPage roomsPage;
	private LoginOrSignUpPage loginOrSignUpPage;
	int TestID;
	@Parameters ("browser")
	@BeforeTest
	public void launchBrowser(String browserName) {
		if (browserName.equals("Chrome"))
		{
			driver = openChromeBrowser();
		}
		if (browserName.equals("Edge"))
		{
			driver = openEdgeBrowser();
		}
	}
	@BeforeClass
	public void createPOMObjects() {
	loginOrSignUpPage = new LoginOrSignUpPage(driver);
	messengerPage = new MessengerPage(driver);
	roomsPage = new RoomsPage(driver);
	}
	@BeforeMethod
	public void openRoomsPage() throws InterruptedException {
	driver.get("https://www.facebook.com/");  
	loginOrSignUpPage.openMessenger(); Thread.sleep(3000);
	messengerPage.openRooms();
	}
	@Test (priority = 1)
	//(priority = 1, invocationCount = 3)
	//(priority = 1, enabled = false)
	//(priority = 1, timeOut=3000)
	//(priority = 1, dependsOnMethods = "verifyHelpCenter")
	public void verifyMessenger() throws IOException {
	TestID = 101;
	roomsPage.goBackToMessenger();
	Utility.captureScreenShot(driver, TestID);
	String url = driver.getCurrentUrl();
	String title = driver.getTitle();
	Assert.assertEquals(url, "https://www.messenger.com/");
	Assert.assertEquals(title, "Messenger");
	//Assert.assertEquals(title, "Messenger", "This is wrong title page");
	}
	@Test (priority = 2)
	public void verifyHelpCenter() {
	roomsPage.contactToHelpCenter();
	String url = driver.getCurrentUrl();
	String title = driver.getTitle();
	SoftAssert soft = new SoftAssert(); 
	soft.assertEquals(url, "https://www.messenger.com/help");
	soft.assertEquals(title, "Messenger Help Centre");
	soft.assertAll();
	}
	@Test (priority = 3)  //For Suite Practice
	public void verifyHelpCenter1() {
	roomsPage.contactToHelpCenter();
	String url = driver.getCurrentUrl();
	String title = driver.getTitle();
	SoftAssert soft = new SoftAssert(); 
	soft.assertEquals(url, "https://www.messenger.com/help");
	soft.assertEquals(title, "Messenger Help Centre");
	soft.assertAll();
	}
	@AfterMethod
	public void logOut() {
	System.out.println("LogOut");
	}
	@AfterClass
	public void removePOMObjects() throws InterruptedException {
		loginOrSignUpPage = null;
		messengerPage = null;
		roomsPage = null;
	}
	@AfterTest
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(8000);
		driver.quit();
		driver = null;
		System.gc();   //Garbage Collector
	}
}
