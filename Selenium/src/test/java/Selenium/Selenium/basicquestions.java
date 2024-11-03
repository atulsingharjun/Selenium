package Selenium.Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;

public class basicquestions {
	public WebDriver driver;
	//insatace variable 
	@BeforeTest
	public void configuration () {
		driver = new ChromeDriver() ;
		
		
	}
	@Test
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
	@Test
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

}
