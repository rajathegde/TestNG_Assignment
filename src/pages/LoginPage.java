package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import test.BaseClass;

public class LoginPage {
	WebDriver driver = BaseClass.driver;
	ExtentTest test = BaseClass.test;
	
	
	//*************************WebElements**********************
	@FindBy(xpath="//input[@id='user-name']")
	WebElement username;
	
	@FindBy(css="input[id=password]")
	WebElement password;
	
	@FindBy(css="input[id=login-button]")
	WebElement loginbutton;
	
	@FindBy(xpath="//*[contains(text(),'Username and password do not match a')]")
	WebElement Error;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//***************************************Methods************************
	public void login(String UserNameval,String Passval) {

		//WebDriverWait wait = new WebDriverWait(driver,30);
		//wait.until(ExpectedConditions.visibilityOf(username));

		username.sendKeys(UserNameval);
		//test.log(LogStatus.PASS, "Enter UserName "+UserNameval, "Successfully Entered UserName");
		password.sendKeys(Passval);
		//test.log(LogStatus.PASS, "Enter Password "+Passval, "Successfully Entered Password");
		loginbutton.click();
		//test.log(LogStatus.PASS, "Click on Login Button", "Clicked on Login Button");
	}

	public void ErrorCheck() {
		String ActualMsg = Error.getText();
		System.out.println(ActualMsg);
		String ExpectedMsg = "Epic sadface: Username and password do not match any user in this service";
		//Assert.assertEquals(ActualMsg, ExpectedMsg);

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(ActualMsg, ExpectedMsg);
		//System.out.println("Soft assertion will help to execute this"); //if failure
		soft.assertAll(); //all failures throw here
	}


}
