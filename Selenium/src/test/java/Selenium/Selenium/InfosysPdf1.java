package Selenium.Selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class InfosysPdf1 {
    public WebDriver driver;

    @Test(enabled=false)
    public void findelement() throws InterruptedException {
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
    @Test
    public void findelements() {
    	driver = new ChromeDriver();
        driver.get("https://edunexttechnologies.com/school-erp.php");
        driver.manage().window().maximize();
        
        List<WebElement> links = driver.findElements(By.tagName("a"));
        
        //count the total links on the page 
        System.out.println("Total links on the page: " + links.size());
        for(WebElement list : links) {
        	System.out.println(list.getText());
        	
        }

    	
    	
    }

   @AfterTest
    public void down() {
        driver.close();
       driver.quit();
    }
}
