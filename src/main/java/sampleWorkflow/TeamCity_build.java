package sampleWorkflow;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamCity_build {

	WebDriver driver;
	JavascriptExecutor jse;
		 
	@BeforeMethod
		public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Abha Kumari\\Documents\\INTERVIEW\\SELENIUM\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		launchURL();
		 }

	 public void launchURL() {
		 driver.get("http://formy-project.herokuapp.com/");
		
	 }
	 
	 @Test (priority = 1, groups = "Feature#1")
	 public void autoComplete() {
		   
	launchURL();
	WebDriverWait wait=new WebDriverWait(driver, 10); //Explicit wait
	WebElement btnAutocomplete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-lg' and @href='/autocomplete']")));
	btnAutocomplete.click();
	WebElement Address = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("autocomplete")));
	Address.clear();
	Address.sendKeys("1555 Park Blvd, Palo Alto, CA");
	}
	 
	 @AfterMethod
	 public void tearDown() {
	 	driver.quit();
	 }
	  
	
}
