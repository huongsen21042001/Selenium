
package selenium.webDriver1;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExpathLogin {
	
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	@BeforeClass
	public void beforeClass() {		
		System.setProperty("webdriver.chrome.driver", "Browser/chromedriver.exe");
	    driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	   
	}

				// Login
	@Test
	public void TC_01_Login_Empty_Data() {
		// Login with empty data
		driver.get("https://alada.vn/tai-khoan/dang-nhap.html");
		driver.findElement(By.id("txtLoginUsername")).sendKeys("");
		driver.findElement(By.id("txtLoginPassword")).sendKeys("");	
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG NHẬP'] ")).click();
		
		Assert.assertEquals(driver.findElement(By.id("txtLoginUsername-error")).getText(), "Vui lòng nhập email");
		Assert.assertEquals(driver.findElement(By.id("txtLoginPassword-error")).getText(), "Vui lòng nhập mật khẩu");
	
	}


	@Test
	public void TC_02_Login_Invalid_Email(){
		//Login with invalid Username 
		
		driver.get("https://alada.vn/tai-khoan/dang-nhap.html");
		driver.findElement(By.id("txtLoginUsername")).sendKeys("sen@.com");
		driver.findElement(By.id("txtLoginPassword")).sendKeys("hothiminhthuy1107vlqt");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG NHẬP'] ")).click();
		
		Assert.assertEquals(driver.findElement(By.id("txtLoginUsername-error")).getText(), "Vui lòng nhập email hợp lệ");
	}

	
	@Test
	public void TC_04_Login_Valid_Data(){
		//Login with invalid Password 
		
		driver.get("https://alada.vn/tai-khoan/dang-nhap.html");
		driver.findElement(By.id("txtLoginUsername")).sendKeys("hothihuongsen21042001@gmail.com");
		driver.findElement(By.id("txtLoginPassword")).sendKeys("hothiminhthuy1107vlqt");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG NHẬP'] ")).click();
		
			}

	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
