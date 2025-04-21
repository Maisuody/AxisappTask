package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import base.PageBase;
import pages.Loginpage;
import utilities.ReadProperties;
public class LoginTestcases extends TestBase {
	
	public static Loginpage loginobj ;
	
	@BeforeTest
	public static void SetUp() {
		launchbrowser();
		loginobj = new Loginpage(driver);
	 }
	
	
	@Test(description="valid login")
	@Description("open the brower then enter the credentiail") 
	@Story("To check: login") 
	//Positive scenario valid log in public static void
	public static void login1(String Email, String Password) throws InterruptedException, IOException {
	 Email = "mai.suody@gmail.com"; 
	 Password = "12345678";
	 loginobj.ValidLogin(Email,Password); 
	 }
	 
	
	//incase you want to make not make hard data
		/*
		 * @Test(description="valid login")
		 * 
		 * @Description("open the brower then enter the credentiail")
		 * 
		 * @Story("To check: login") //Positive scenario valid log in public static void
		 * login1(String Email, String Password) throws InterruptedException,
		 * IOException { Email = ReadProperties.Readprop("loginEmail"); Password =
		 * ReadProperties.Readprop("loginPassword");
		 * loginobj.ValidLogin(Email,Password); }
		 */
	
	@Test(description="inValid login")
	@Description("open the brower then enter the wrong credentiail")
	@Story("To check: inValid login")
	//Negative scenario valid log in
	public static void login2() throws InterruptedException {
		loginobj.inValidLogin();
		
		}

	@AfterTest
	public static void close() {
		closeBrowser();
	}
}
