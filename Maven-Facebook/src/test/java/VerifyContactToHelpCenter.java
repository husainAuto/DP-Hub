import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.LoginOrSignUpPage;
import pages.MessengerPage;
import pages.RoomsPage;

public class VerifyContactToHelpCenter {

public static void main (String[] args) throws InterruptedException {  
		
		System.setProperty("webdriver.chrome.driver","G:\\Husain\\Velocity Software Testing Course\\Automation\\New folder\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");     
		//Click on Messenger Link
		//Object of POM Class
		
		LoginOrSignUpPage loginOrSignUpPage = new LoginOrSignUpPage(driver);
		loginOrSignUpPage.openMessenger(); Thread.sleep(3000);
		
		MessengerPage messengerPage = new MessengerPage(driver);
		messengerPage.openRooms();
		
		RoomsPage roomsPage = new RoomsPage(driver);
		roomsPage.contactToHelpCenter();
		
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		
		if(url.equals("https://www.messenger.com/help") &&  title.equals("Messenger Help Centre"))
		{
			System.out.println("Test case - PASS");
		}
		else
		{
			System.out.println("Test cas -FAIL");
		}
}
}