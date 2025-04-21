package testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import pages.Loginpage;
import pages.RegistrationPage;

public class RegistrationTestcases extends TestBase {

	public static RegistrationPage Registobj ;
	
	@BeforeTest
	public static void SetUp() {
		launchbrowser();
		Registobj = new RegistrationPage(driver);
	 }
	
	@Test(description="valid Registration")
	@Description("open the brower then enter all inqiure data ")
	@Story("To check: Registration")
	//Positive scenario valid log in 
	public static void Registration1() throws InterruptedException {	
		Registobj.ValidRegistration();
	}
	
	@Test(description="inValid Registration")
	@Description("open the brower then enter all inqiure data missing email-part ")
	@Story("To check: inValid Registration")
	//Positive scenario valid log in 
	public static void invRegistration1() throws InterruptedException {	
		Registobj.inValidEmailRegistration();
	}
	
	@AfterTest
	public static void close() {
		closeBrowser();
	}
}
