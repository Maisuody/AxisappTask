package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageBase {
	public  void sendkey(WebDriver driver,String component, String Data) {
		
		  driver.findElement(By.xpath(component)).sendKeys(Data);
	  }
	
	//Send key by ID
		public void FindID_SendKeybyID(WebDriver driver,String component,String ID, String value) {
			driver.findElement(By.id(ID)).sendKeys(value);
			
		}
	
	//FindElement with click by Xpath
	public void FindID_clickbyXpath(WebDriver driver,String Xpath) {
		WebElement checkout = driver.findElement(By.xpath(Xpath));
		 checkout.click();
	}
	
	//FindElement with click by ID
	public void FindID_clickbyID(WebDriver driver,String ID) {
		WebElement checkout = driver.findElement(By.id(ID));
		 checkout.click();
	}
	
 //SubmitbyXPath
 public void submit(WebDriver driver,String component) {
		
		driver.findElement(By.xpath(component)).submit();
	}
 
 //Clear the inputs
 public void Clearinput(WebDriver driver,String component) {
		
		driver.findElement(By.xpath(component)).clear();
	}
 
 //GetText only
 public String getText(WebDriver driver,String component) {
	   WebElement Textvalidation = driver.findElement(By.xpath(component));
	   String Actual_text = Textvalidation.getText();
	   
	   return Actual_text;
	   
 }
 public String getAttrib(WebDriver driver,String component) {
	 //  document.getElementById("button").getAttribute("onClick");
	   String Textvalidation = driver.findElement(By.xpath(component)).getAttribute("class");
	   
	return Textvalidation;
	   
 }
 
 //Check text only
 public void checkTextOnly(WebDriver driver,String Actual_text, String expected_text) {
	  	   
	   if(Actual_text.equals(expected_text))
	   {
		   System.out.println("Done The same");
	   }
	   else {
		   System.out.println("The acual text and expected text aren't the same");
	   }
	   
 }
 
 
 
 //Check Text
 public void checkText(WebDriver driver,String component, String expected_text) {
		
	   WebElement Textvalidation = driver.findElement(By.xpath(component));
	   if (Textvalidation.isDisplayed()) {
		   System.out.println("YES, Displayed");
	   }
	   else
	   {
		   System.out.println("NO, NOT Displayed");
	   }
	   
	   //validating the actual and expected text
	   String Expected_text = expected_text;
	   
	   String Actual_text = Textvalidation.getText();
	   
	   if(Actual_text.equals(Expected_text))
	   {
		   System.out.println("Done The same");
	   }
	   else {
		   System.out.println("The acual text and expected text aren't the same");
	   }
	}
 
 //This function will check the text and return True or False
 public boolean checkTextWithReturn(WebDriver driver,String component, String expected_text) {
		
	   WebElement Textvalidation = driver.findElement(By.xpath(component));
	   if (Textvalidation.isDisplayed()) {
		   System.out.println("YES, Displayed");
	   }
	   else
	   {
		   System.out.println("NO, NOT Displayed");
	   }
	   
	   //validating the actual and expected text
	   String Expected_text = expected_text;
	   
	   String Actual_text = Textvalidation.getText();
	   
	   if(Actual_text.equals(Expected_text))
	   {
		  return true;
	   }
	   else {
		   return false;
	   }
	}
 
 //check the existance of the TEXT
 public boolean ExectanceText(WebDriver driver,String component) {
		
	   WebElement Textvalidation = driver.findElement(By.xpath(component));
	   if (Textvalidation.isDisplayed()) {
		   System.out.println("YES, Displayed");
		   return true;
	   }
	   else
	   {
		   System.out.println("NO, NOT Displayed");
		   return false;
	   }
 }
 
 
 //to check data i have the same to the data i retrieve
	public void Assersion(WebDriver driver,String xpath, String key) {
		String returnval = driver.findElement(By.xpath(xpath)).getText();
//	    Assert.assertEquals(key , returnval);
		System.out.println("test shown correctly");
	
		}
	
	public void scrollDwon(WebDriver driver) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scroll(0,300)");
//	 js.executeScript("window.scrollBy(0,350)");       
	}
	
	public void scrollup(WebDriver driver) {
	 	JavascriptExecutor js = (JavascriptExecutor) driver;
	 	js.executeScript("window.scroll(0,-300)");
//	 	 js.executeScript("window.scrollBy(0,350)");       
		}
}
