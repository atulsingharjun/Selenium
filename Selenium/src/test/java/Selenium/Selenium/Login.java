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
	 public void login() {
		 WebDriver driver = new ChromeDriver();
	driver.get("https://www.wellsfargo.com/");
	

	}
}


