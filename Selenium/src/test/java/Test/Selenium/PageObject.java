package Test.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObject {
	WebDriver driver =new ChromeDriver();
	WebElement fname = driver.findElement(By.id("fname"));
	WebElement lname = driver.findElement(By.id("lname"));
	WebElement phone = driver.findElement(By.id("phone"));
	WebElement submitBtn = driver.findElement(By.id("submit"));
	
}
