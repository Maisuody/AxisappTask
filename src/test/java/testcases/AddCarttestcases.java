package testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import pages.Loginpage;
import pages.AddCartPage;

public class AddCarttestcases extends TestBase{
public static Loginpage loginobj ;
public static AddCartPage AddCartobj ;
	
	@BeforeTest
	public static void SetUp() {
		launchbrowser();
		loginobj = new Loginpage(driver);
		AddCartobj = new AddCartPage(driver);
	 }
	
	@Test(description="Add Product Accessories Shopping Cart")
	@Description(" 1- User Login 2- Navigate to Accessories 3- Select Shoes Subcategory 4- Filter Shoes by Price 5- View Shoe Details 6-Select Color and Size 7-Add to Cart")
	@Story("To check: Add Product Accessories Shopping Cart")
	//Positive scenario valid log in 
	public static void AddCart1() throws InterruptedException {	
		//i can get this parameter from excel file or properties file
	loginobj.ValidLogin("mai.suody21@gmail.com","12345678");
	AddCartobj.AddToCart();
	}
	
	@AfterTest
	public static void close() {
		closeBrowser();
	}
}
