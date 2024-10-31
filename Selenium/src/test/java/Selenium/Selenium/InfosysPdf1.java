package Selenium.Selenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class InfosysPdf1 {
    public WebDriver driver;

    @Test
    public void example1() throws InterruptedException {
        // Find element and find elements
        driver = new ChromeDriver();
        driver.get("https://edunexttechnologies.com/school-erp.php");
        driver.manage().window().maximize();
       
        driver.findElement(By.xpath("//span[@data-hover='School ERP']")).click();
        String expected = "School ERP Software";
		Thread.sleep(5000);

        String actual = driver.findElement(By.xpath("//h1[normalize-space()='School ERP Software']")).getText();
        System.out.println("Text found on the page: " + actual);
        Assert.assertEquals(actual, expected, "Text did not match!");  //System.out.println(actual);
       
    }

   @AfterTest
    public void down() {
        driver.close();
       driver.quit();
    }
}
