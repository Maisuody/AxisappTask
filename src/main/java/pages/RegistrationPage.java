package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Alert;

import base.PageBase;
import io.qameta.allure.Step;
import junit.framework.Assert;


public class RegistrationPage extends PageBase {
	static String myAccount = "//*[@class=\"account-cart-wrapper\"]/a"; 
    static String RegistrationPath = "//*[@title=\"Register\"]";
    static String FirstNamePath = "//*[@id=\"firstname\"]";
    static String FirstName = "Mai";
    static String middlenamePath = "//*[@id=\"middlename\"]";
    static String middlename = "S";
    static String lastNamePath = "//*[@id=\"lastname\"]";
    static String lastName = "Suody";
    static String emailPath = "//*[@id=\"email_address\"]";
    static String email = "mai.suody03@gmail.com";
    static String invEmail = "mai.suody03gmail.com";
    static String passwordPath = "//*[@id=\"password\"]";
    static String password = "12345678";
    static String repasswordPath = "//*[@id=\"confirmation\"]";
    static String repassword = "12345678";
    static String remembermeCheckBox = "//*[@title=\"Remember Me\"]";
    static String Registrationbutton = "//div[@class=\"buttons-set\"]/button[@class=\"button\"]/span";
    static String optinPath = "//*[@id=\"privacy_pref_optout\"]";
	static String submitpathpopup = "//*[@id=\"consent_prompt_submit\"]";
    static String SuccessmsgValidRegPath = "//div[@class=\"dashboard\"]/ul/li/ul/li/span";
    static String SuccessmsgValidReg = "Thank you for registering with Tealium Ecommerce.";
    static String Alertmsg = "Please include an '@' in the email address. 'mai.suody03gmail.com' is missinf an '@'.";
    static String ErrormsgEmailPath = "//*[@id=\"advice-required-entry-email_address\"]";
    static String ErrormsgEmail = "This is a required field.";
    
    WebDriver driver;
	
    

    public RegistrationPage(WebDriver driver) {
    	 this.driver = driver;
    	// TODO Auto-generated constructor stub
    }
    
    @Step("Valid Registration 1- open browser 2- submit the popup window 3- click on account and Registration 4- enter all require data then click on Regitration bottun")
    public void ValidRegistration() throws InterruptedException {
    	FindID_clickbyXpath(driver,optinPath);
    	FindID_clickbyXpath(driver,submitpathpopup);
    	FindID_clickbyXpath(driver ,myAccount);
    	Thread.sleep(2000);
    	FindID_clickbyXpath(driver,RegistrationPath);
    	Thread.sleep(2000);
    	//FindID_clickbyXpath(driver,popUpCancel);
    	sendkey(driver ,FirstNamePath, FirstName);
    	sendkey(driver ,middlenamePath, middlename);
    	sendkey(driver ,lastNamePath, lastName);
    	Thread.sleep(2000);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,350)", "");
    	Thread.sleep(5000);
    	sendkey(driver ,emailPath, email);
    	sendkey(driver ,passwordPath, password);
    	sendkey(driver ,repasswordPath, repassword);
    	Thread.sleep(2000);
  //  	JavascriptExecutor js = (JavascriptExecutor) driver;
   // 	js.executeScript("window.scrollBy(0,250)", "");
    	Thread.sleep(2000);	   	
    	FindID_clickbyXpath(driver ,remembermeCheckBox);	
    	FindID_clickbyXpath(driver ,Registrationbutton);	
    	checkText( driver, SuccessmsgValidRegPath, SuccessmsgValidReg);
     }
    
    @Step("Valid Registration 1- open browser 2- submit the popup window 3- click on account and Registration 4- enter all require data then click missing email part on Regitration bottun")
    public void inValidEmailRegistration() throws InterruptedException {
    	FindID_clickbyXpath(driver,optinPath);
    	FindID_clickbyXpath(driver,submitpathpopup);
    	FindID_clickbyXpath(driver ,myAccount);
    	Thread.sleep(2000);
    	FindID_clickbyXpath(driver,RegistrationPath);
    	Thread.sleep(2000);
    	//FindID_clickbyXpath(driver,popUpCancel);
    	sendkey(driver ,FirstNamePath, FirstName);
    	sendkey(driver ,middlenamePath, middlename);
    	sendkey(driver ,lastNamePath, lastName);
    	Thread.sleep(2000);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,350)", "");
    	Thread.sleep(5000);
  //  	sendkey(driver ,emailPath, invEmail);
    	sendkey(driver ,passwordPath, password);
    	sendkey(driver ,repasswordPath, repassword);
    	Thread.sleep(2000);
  //  	JavascriptExecutor js = (JavascriptExecutor) driver;
   // 	js.executeScript("window.scrollBy(0,250)", "");
    	Thread.sleep(2000);	   	
    	FindID_clickbyXpath(driver ,remembermeCheckBox);	
    	FindID_clickbyXpath(driver ,Registrationbutton);	
    	
    	checkText( driver, ErrormsgEmailPath, ErrormsgEmail);
	  }
}
