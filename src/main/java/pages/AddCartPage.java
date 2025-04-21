//package pages;

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import base.PageBase;
import io.qameta.allure.Step;
import junit.framework.Assert;

public class AddCartPage  extends PageBase {
	
static String AccesPath = "(//div[@id=\"header-nav\"]/nav/ol/li/a)[3]";
static String Shoes = "//ol[@class=\"nav-primary\"]/li/ul/li/a[@href=\"https://ecommerce.tealiumdemo.com/accessories/shoes.html\"]";
static String SortbyPath = "//div[@class=\"category-products\"]/div[@class=\"toolbar\"]/div/div/select[@title=\"Sort By\"]";
static String priceByPath = "//div[@class=\"category-products\"]/div[@class=\"toolbar\"]/div/div/select[@title=\"Sort By\"]/option[@value=\"https://ecommerce.tealiumdemo.com/accessories/shoes.html?dir=asc&order=price\"]";
static String viewDetailsCard = "//li[@class=\"item last\"]/div[@class=\"product-info\"]/div[@class=\"actions\"]/a[@href=\"https://ecommerce.tealiumdemo.com/accessories/shoes/hana-flat-charcoal-557.html\"]";
static String SelectColorPath = "//*[@src=\"https://ecommerce.tealiumdemo.com/media/catalog/swatches/1/21x21/media/charcoal.png\"]";
static String SelectSizePath = "//li[@class=\"option-9\"]";
static String addtoCartButtonPath = "//div[@class=\"add-to-cart-buttons\"]/button[@title=\"Add to Cart\"]";
static String SuccessMsgPath ="//li[@class=\"success-msg\"]/ul/li/span";
static String SuccessMsg = "Hana Flat, Charcoal was added to your shopping cart.";
static String GetTextProductName = "//h2[@class=\"product-name\"]/a[@href=\"https://ecommerce.tealiumdemo.com/accessories/shoes/hana-flat-charcoal-557.html\"]";
static String ShoesHeaderPath = "//div[@class=\"page-title category-title\"]/h1";
static String BeforeAllPrices = "//*[@class=\"price-box\"]";
static String instockPath = "//div[@class=\"extra-info\"]/p";
//static String imgPath = "//*[@src=\"https://ecommerce.tealiumdemo.com/media/catalog/swatches/1/21x21/media/charcoal.png\"]";
static String SizePath = "//*[@id=\"option99\"]";
	WebDriver driver;
	
	public AddCartPage(WebDriver driver) {
		 this.driver = driver;
		// TODO Auto-generated constructor stub
	}
	
	@Step(" 1- User Login 2- Navigate to Accessories 3- Select Shoes Subcategory 4- Filter Shoes by Price 5- View Shoe Details 6-Select Color and Size 7-Add to Cart")
	public void AddToCart() throws InterruptedException {
		boolean flag = false;
		String gettext;
		WebElement mainMenu = driver.findElement(By.xpath(AccesPath));
		//Instantiating Actions class
		Actions actions = new Actions(driver);
		//Hovering on main menu
		actions.moveToElement(mainMenu);	 		
		// Locating the element from Sub Menu		
		WebElement subMenu = driver.findElement(By.xpath(Shoes));
		//make sure that accessories drop down list is displayed
	    gettext = subMenu.getText();
		flag = checkTextWithReturn( driver, Shoes, gettext);
		assertTrue(flag, "true");
		//To mouseover on sub menu
		actions.moveToElement(subMenu);
		//build()- used to compile all the actions into a single step 
		actions.click().build().perform();
		Thread.sleep(2000);
		//make sure that shoes page is displayed
		flag = ExectanceText( driver,ShoesHeaderPath);
		assertTrue(flag, "true");
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,350)", ""); Thread.sleep(2000);
		 //make sure that shoes are asserted in ascending
		 List<WebElement> GroupRows = new ArrayList<WebElement>();
		 List<WebElement> beforeAscendingPrices = driver.findElements(By.xpath(BeforeAllPrices));
		 //need to remove dollare sign 
		 List<Double> beforeAscendingPriceslist = new ArrayList<>();
		 for(WebElement x : beforeAscendingPrices) {
			 beforeAscendingPriceslist.add(Double.valueOf(x.getText().replace("$", "")));
		 }
		 FindID_clickbyXpath(driver,SortbyPath);
		 FindID_clickbyXpath(driver,priceByPath);
		 Thread.sleep(2000);
		 List<WebElement> AfterAscendingPrices = driver.findElements(By.xpath(BeforeAllPrices));
		 List<Double> AfterAscendingPriceslist = new ArrayList<>();
		 for(WebElement x : AfterAscendingPrices) {
			 AfterAscendingPriceslist.add(Double.valueOf(x.getText().replace("$", "")));
		 }
		 //Compare the price
		 Collections.sort(beforeAscendingPriceslist);
		 Assert.assertEquals(beforeAscendingPriceslist, AfterAscendingPriceslist);
		 Thread.sleep(2000); // JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,450)", ""); Thread.sleep(2000);
		 WebElement Textvalidation = driver.findElement(By.xpath(GetTextProductName));
		 gettext = Textvalidation.getText(); System.out.println(gettext);
		 
		 Thread.sleep(2000);
		 FindID_clickbyXpath(driver,viewDetailsCard); 
		 Thread.sleep(4000);
		 //make sure that datailed page is opened
		 flag = ExectanceText( driver,instockPath);
		 assertTrue(flag, "true");
		 
		 Thread.sleep(2000); 
		 //Select the color and the size
		 FindID_clickbyXpath(driver,SelectColorPath);
		 Thread.sleep(2000); 
		 FindID_clickbyXpath(driver,SelectSizePath); 
		 //Make sure that color and size is hightlighted
		 WebElement element;
		 element = driver.findElement(By.xpath(SelectColorPath));
		 String Bordercolor = element.getCssValue("border-color");
		 Assert.assertEquals(Bordercolor, "rgb(99, 99, 99)");
		 Thread.sleep(3000); 
		 element = driver.findElement(By.xpath(SizePath));
		 String Bordersize = element.getCssValue("border-color");
		 Assert.assertEquals(Bordersize, "rgb(99, 99, 99)");
		 js.executeScript("window.scrollBy(0,350)", "");
		 FindID_clickbyXpath(driver,addtoCartButtonPath); 
		 Thread.sleep(2000); 
			/*
			 * String SuccessMsg1 = gettext + " was added to your shopping cart.";
			 * System.out.println(SuccessMsg1); WebElement Textvalidation1 =
			 * driver.findElement(By.xpath(SuccessMsgPath)); String gettext1 =
			 * Textvalidation1.getText(); System.out.println(gettext1);
			 */
		 //Make sure that add cart page is displayed
		 checkText( driver, SuccessMsgPath, SuccessMsg);
		 }
	
	
}
