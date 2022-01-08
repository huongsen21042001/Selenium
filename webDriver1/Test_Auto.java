package selenium.webDriver1;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test_Auto {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	@BeforeClass
	public void beforeClass() {		
		System.setProperty("webdriver.chrome.driver", "Browser/chromedriver.exe");
	    driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	    driver.get("https://www.facebook.com/");
	}

	@Test
	public void TC_01_ValidateCurrentUrl() {
		// Login Page Url matching
		String loginPageUrl = driver.getCurrentUrl();
		Assert.assertEquals(loginPageUrl, "https://www.facebook.com/");
	}

	@Test
	public void TC_02_ValidatePageTitle() {
		// Login Page title
		String loginPageTitle = driver.getTitle();
		Assert.assertEquals(loginPageTitle, "Facebook – log in or sign up");
		
	}

	@Test
	public void TC_03_LoginFormDisplayed() {
		// Login form displayed
		Assert.assertTrue(driver.findElement(By.xpath("//form[@data-testid='royal_login_form']")).isDisplayed());
	}
	
	@Test
	public void TC_04_RegisterWithEmptyDate(){
		
	}
	
	/*
	 * @Test public void TC_04_Login() { // Login
	 * 
	 * WebElement username = driver.findElement(By.id("//*[@id=\"email\"]"));
	 * WebElement password = driver.findElement(By.id("//*[@id=\"pass\"]"));
	 * WebElement login_button =
	 * driver.findElement(By.id("//*[@id=\"loginbutton\"]"));
	 * 
	 * username.sendKeys("thaotran260899"); password.sendKeys("thaotran260899");
	 * login_button.click();
	 * 
	 * }
	 */

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}