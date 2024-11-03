package Selenium.Selenium;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class InfosysPdf1 {
    public WebDriver driver;
    @BeforeTest
    public void configuration() {
    	driver = new ChromeDriver();
       
    	
    }

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
    @Test(enabled=false)
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
    @Test(enabled=false)
    public void handlemultiplewindows() throws InterruptedException {
    	//window handle = current tab ka=e data ko navigate karega
    	//window handles = jitne khule hinge sbko krega 
    	driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
    	driver.manage().window().maximize();
    	driver.findElement(By.id("newWindowBtn")).click();  
    	String parent = driver.getWindowHandle();
    	System.out.println("parent window is "+parent);
    	
    	 Set<String> handles    =driver.getWindowHandles();
    	 for(String handle : handles) {
    		 System.out.println("all window is "+handle);
    		 if(!handle.equals(parent)) {
    			 driver.switchTo().window(handle);
    			 driver.findElement(By.id("firstName")).sendKeys("arjun");
    			 Thread.sleep(5000);
    			 driver.close();   
    			 
    		 }
    	 }
    	
    	 
    }
    @Test(enabled=false)
    public void waits() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	driver.get("https://edunexttechnologies.com/school-erp.php");
    	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.className("facebook-btn")));
		 element.click();
	 }
    @Test(invocationCount = 4)
    public void singlemetodmultipletime() {
    	driver.get("https://edunexttechnologies.com/school-erp.php");
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
    	
    	driver.findElement(By.xpath("//span[@data-hover='School ERP']")).click();   
    	//driver.close();
    }
    

   @AfterTest
    public void down() {
        driver.close();
       driver.quit();
    }
}
