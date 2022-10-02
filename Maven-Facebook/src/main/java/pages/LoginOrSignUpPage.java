package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginOrSignUpPage {
	
	//Variable Declaration
	
	@FindBy (xpath = "//input[@id='email']")
	private WebElement username;
	
	@FindBy (xpath = "//input[@id='pass']")
	private WebElement password;
	
	@FindBy (xpath = "//button[text()='Log in']")
	private WebElement loginbutton;
	
	@FindBy (xpath = "//a[text()='Create New Account']")
	private WebElement createMyAcc;
	
	@FindBy (xpath = "//a[text()='Messenger']")
	private WebElement messenger;
	
	//Variable Initialization
	
public LoginOrSignUpPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	//Variable Use - WebElement Action

	public void sendUserName(String str) {
		username.sendKeys(str);
	}
	
	public void sendPassord(String str ) {
		password.sendKeys(str);
	}
	
	public void clickOnLoginButton() {
		loginbutton.click();
	}
	
	public void openMessenger() {
		messenger.click();
	}
	
	public void clickCreateMyAcc() {
		createMyAcc.click();
	}


}
