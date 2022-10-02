package BrowserSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Base {
	
	public static WebDriver openChromeBrowser() {
		System.setProperty("webdriver.chrome.driver","G:\\Husain\\Velocity Software Testing Course\\Automation\\New folder\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	
	public static WebDriver openEdgeBrowser() {

		System.setProperty("webdriver.edge.driver","G:\\Husain\\Velocity Software Testing Course\\Automation\\New folder\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		return driver;
	}

}
