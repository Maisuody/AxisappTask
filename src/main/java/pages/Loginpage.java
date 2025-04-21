package pages;

import base.PageBase;
import base.TestBase;
import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class Loginpage extends PageBase {
	static String myAccount = "//*[@class=\"account-cart-wrapper\"]/a"; 
	static String login = "//*[@title=\"Log In\"]";
	static String EmailPath = "//*[@title=\"Email Address\"]";
	static String PasswordPath = "//*[@id=\"pass\"]";
//	static String Email = "mai.suody21@gmail.com";
	static String invalidEmail = "mai.suody2@gmail.com";
	static String Password1 = "12345678";
	static String loginbutton = "//*[@id=\"send2\"]";
	static String loginpageassert = "Hello, Mai s suody!";
	static String loginpagegetText = "//div/p/strong";
	static String popUpCancel = "//*[@class=\"close_btn_thick\"]";
	static String optinPath = "//*[@id=\"privacy_pref_optout\"]";
	static String submitpathpopup = "//*[@id=\"consent_prompt_submit\"]";
	static String invalidloginmgspath = "//*[@class=\"error-msg\"]/ul/li/span";
	static String invalidloginmgs = "Invalid login or password.";
	WebDriver driver;
	
 

public Loginpage(WebDriver driver) {
	 this.driver = driver;
	// TODO Auto-generated constructor stub
}

@Step("Valid login 1- open browser 2- submit the popup window 3- click on account and legin 4- enter the credential then click on ligin bottun")
public void ValidLogin(String Email,String Password) throws InterruptedException {
	FindID_clickbyXpath(driver,optinPath);
	FindID_clickbyXpath(driver,submitpathpopup);
	FindID_clickbyXpath(driver ,myAccount);
	Thread.sleep(2000);
	FindID_clickbyXpath(driver,login);
	Thread.sleep(2000);
	//FindID_clickbyXpath(driver,popUpCancel);
	sendkey(driver ,EmailPath, Email);
	Thread.sleep(2000);
	sendkey(driver ,PasswordPath, Password);
	Thread.sleep(2000);	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,250)", "");
	FindID_clickbyXpath(driver ,loginbutton);	
	checkText( driver, loginpagegetText, loginpageassert);
 }

@Step("Valid login 1- open browser 2- submit the popup window 3- click on account and legin 4- enter the wrong credential then click on ligin bottun")
public void inValidLogin() throws InterruptedException {
	FindID_clickbyXpath(driver,optinPath);
	FindID_clickbyXpath(driver,submitpathpopup);
	FindID_clickbyXpath(driver ,myAccount);
	Thread.sleep(2000);
	FindID_clickbyXpath(driver,login);
	Thread.sleep(2000);
	//FindID_clickbyXpath(driver,popUpCancel);
	sendkey(driver ,EmailPath, invalidEmail);
	Thread.sleep(2000);
	sendkey(driver ,PasswordPath, Password1);
	Thread.sleep(2000);	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,250)", "");
	FindID_clickbyXpath(driver ,loginbutton);	
	checkText( driver, invalidloginmgspath, invalidloginmgs);
 }
}
