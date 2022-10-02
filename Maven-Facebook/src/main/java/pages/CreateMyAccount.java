package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateMyAccount {
	
	WebDriver driver;
	Select s1;
	
	@FindBy (xpath = "(//input[@type='text'])[2]")
	private WebElement fname;
	
	@FindBy (xpath = "//select[@id='day']")
	private WebElement day;

	public CreateMyAccount(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void sendFname() {
		fname.sendKeys("husain");
	}
	
	public void selectDay() {
		
		s1 = new Select(day);
		
		s1.selectByVisibleText("8");
	}
	
	
}
