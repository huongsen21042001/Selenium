package selenium.webDriver1;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExpathSelenium {
	
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	@BeforeClass
	public void beforeClass() {		
		System.setProperty("webdriver.chrome.driver", "Browser/chromedriver.exe");
	    driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	   
	}

	@Test
	public void TC_01_Register_Empty_Data() {
		
		//Register with empty data
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		driver.findElement(By.id("txtFirstname")).sendKeys("");
		driver.findElement(By.id("txtEmail")).sendKeys("");
		driver.findElement(By.id("txtCEmail")).sendKeys("");
		driver.findElement(By.id("txtPassword")).sendKeys("");
		driver.findElement(By.id("txtCPassword")).sendKeys("");
		driver.findElement(By.id("txtPhone")).sendKeys("");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ'] ")).click();
		
		Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập lại địa chỉ email");
		Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Vui lòng nhập mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Vui lòng nhập lại mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Vui lòng nhập số điện thoại.");
		
	}

	@Test
	public void TC_02_Register_Invalid_Email() {
		
		// Register with invalid Email 
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		driver.findElement(By.id("txtFirstname")).sendKeys("Huong Sen");
		driver.findElement(By.id("txtEmail")).sendKeys("sen.ho22");
		driver.findElement(By.id("txtCEmail")).sendKeys("sen.ho22");
		driver.findElement(By.id("txtPassword")).sendKeys("hothiminhthuy1107vlqt");
		driver.findElement(By.id("txtCPassword")).sendKeys("hothiminhthuy1107vlqt");
		driver.findElement(By.id("txtPhone")).sendKeys("0947475234");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ'] ")).click();
		
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");
		
	}
	
	@Test
	public void TC_03_Register_Incorrect_Email() {
		//Register with incorrect email 
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		driver.findElement(By.id("txtFirstname")).sendKeys("Huong Sen");
		driver.findElement(By.id("txtEmail")).sendKeys("sen.ho22@student.passerellesnumeriques");
		driver.findElement(By.id("txtCEmail")).sendKeys("sen.ho22@student.passerellesnumeriques.org");
		driver.findElement(By.id("txtPassword")).sendKeys("hothiminhthuy1107vlqt");
		driver.findElement(By.id("txtCPassword")).sendKeys("hothiminhthuy1107vlqt");
		driver.findElement(By.id("txtPhone")).sendKeys("0947475234");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ'] ")).click();
		

		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");
	}

	@Test
	public void TC_04_Register_Password_Less_Than_6_Chars() {
		//Register with password less than 6 chars
		
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		driver.findElement(By.id("txtFirstname")).sendKeys("Huong Sen");
		driver.findElement(By.id("txtEmail")).sendKeys("sen.ho22@student.passerellesnumeriques");
		driver.findElement(By.id("txtCEmail")).sendKeys("sen.ho22@student.passerellesnumeriques");
		driver.findElement(By.id("txtPassword")).sendKeys("2104");
		driver.findElement(By.id("txtCPassword")).sendKeys("2104");
		driver.findElement(By.id("txtPhone")).sendKeys("0947475234");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ'] ")).click();

		Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
	}
	
	@Test
	public void TC_05_Register_Incorect_ConfirmPassword() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("Huong Sen");
		driver.findElement(By.id("txtEmail")).sendKeys("sen.ho22@student.passerellesnumeriques");
		driver.findElement(By.id("txtCEmail")).sendKeys("sen.ho22@student.passerellesnumeriques");
		driver.findElement(By.id("txtPassword")).sendKeys("hothiminhthuy1107vlqt");
		driver.findElement(By.id("txtCPassword")).sendKeys("hothiminhthuy1107vl");
		driver.findElement(By.id("txtPhone")).sendKeys("0947475234");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ'] ")).click();
	
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu bạn nhập không khớp");
	}
	
	@Test
	public void TC_06_Register_Incorect_PhoneNumber() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		driver.findElement(By.id("txtFirstname")).sendKeys("Huong Sen");
		driver.findElement(By.id("txtEmail")).sendKeys("sen.ho22@student.passerellesnumeriques");
		driver.findElement(By.id("txtCEmail")).sendKeys("sen.ho22@student.passerellesnumeriques");
		driver.findElement(By.id("txtPassword")).sendKeys("hothiminhthuy1107vlqt");
		driver.findElement(By.id("txtCPassword")).sendKeys("hothiminhthuy1107vlqt");
		driver.findElement(By.id("txtPhone")).sendKeys("0447475234");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ'] ")).click();

		//Verify error message as expected
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019");
	}

	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
