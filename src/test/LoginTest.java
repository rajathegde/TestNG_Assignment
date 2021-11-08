package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends BaseClass {
	
	@Parameters({"UserName","Password"})
	@Test
	public void negetivelogin(String UserNameval,String Passval) {
		//test = report.startTest("Negetive Login Test");
		LoginPage Login = new LoginPage();
		Login.login(UserNameval,Passval);
		Login.ErrorCheck();
		//report.endTest(test);

	}

	@Parameters({"UserName","CorrectPass"})
	@Test
	public void positivelogin(String UserNameval,String Passval) {
		//test = report.startTest("Possitive Login Test");
		LoginPage Login = new LoginPage();
		Login.login(UserNameval,Passval);
		//report.endTest(test);
	}

}
