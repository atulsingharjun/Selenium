package Selenium.Selenium;

import java.io.File;
import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;
import java.nio.file.Paths;
import java.io.File;
import java.io.IOException;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.interactions.Actions;

public class basicquestions {
	public WebDriver driver;
	//insatace variable 
	@BeforeTest
	public void configuration () {
		driver = new ChromeDriver() ;
		
		
	}
	@Test(enabled=false)
	public void dropdown() throws InterruptedException {
		driver.get("https://edunexttechnologies.com/Recruitment-Form/index.php?v=1");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
  WebElement dropdown= driver.findElement(By.id("vacancyid"));
  Select vacancy = new Select(dropdown);
  Thread.sleep(5000);
        vacancy.selectByVisibleText("Java Developer");

driver.close();

	}
	@Test(enabled=false)
	public void actionclass() throws InterruptedException {
		driver.get("https://www.browserstack.com/");
		Actions action = new Actions(driver); 
		WebElement element = driver.findElement(By.linkText("Get started free"));
		Thread.sleep(5000);

		action.moveToElement(element).click();
		Thread.sleep(5000);

		driver.close();

		//using click action method
		
	}
	public void takescreenshot() {
		driver.get("https://www.browserstack.com/");
		//Convert web driver object to TakeScreenshot
	TakesScreenshot scr =((TakesScreenshot)driver);
	// Call getScreenshotAs method to create image file
	File SrcFile=scr.getScreenshotAs(OutputType.FILE);
	String destPath = "C:\\Users\\dell\\Desktop\\freelancer\\screenshot.png";

    // Copy the screenshot to the destination path
    //Files.copy(SrcFile.toPath(), Paths.get(destPath));

    System.out.println("Screenshot saved at: " + destPath);
		
	}
	

}
