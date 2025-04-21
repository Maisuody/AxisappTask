package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.ReadProperties;

public class TestBase {
	 public	static WebDriver driver;
	public static void launchbrowser() {
System.setProperty("webdriver.chrome.driver", "C:\\Users\\msuody\\OneDrive - DXC Production\\Documents\\automation\\automation2\\TechTask2\\src\\chromedriver.exe");
 driver = new ChromeDriver();
driver.get("https://ecommerce.tealiumdemo.com/");
	/*
	 * try { driver.get(ReadProperties.Readprop("URL")); } catch (IOException e) {
	 * // TODO Auto-generated catch block e.printStackTrace(); }
	 */
	}
	
	public static void closeBrowser() {
		driver.quit();
	}
	
}
