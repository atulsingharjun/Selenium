package Selenium.Selenium;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login {
	@Test
	public void verifyloginwithvalidcredential() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//a[contains(.,'Login')]")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("atulksingh.15@gmail.com");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		driver.quit();
			
	}
	@Test
	public void verifybyInvalidcredentials() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//a[contains(.,'Login')]")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("atulksingh.15@gma.com");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Warning: No match for E-Mail Address and/or Password.")).isDisplayed());
		driver.quit();
		
	}

}
