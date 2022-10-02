import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.CreateMyAccount;
import pages.LoginOrSignUpPage;

public class VerifyDropDown {
	
public static void main (String[] args) throws InterruptedException {  
		
		System.setProperty("webdriver.chrome.driver","G:\\Husain\\Velocity Software Testing Course\\Automation\\New folder\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");      
		
		LoginOrSignUpPage loginOrSignUpPage = new LoginOrSignUpPage(driver);
		loginOrSignUpPage.clickCreateMyAcc();
		
		CreateMyAccount createMyAccount = new CreateMyAccount(driver);
		createMyAccount.sendFname();
		createMyAccount.selectDay();

}
} 