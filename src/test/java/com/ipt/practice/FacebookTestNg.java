package com.ipt.practice;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookTestNg {
 public static WebDriver driver;
	
	public static  void launchBrowser() {
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.get("https://www.facebook.com/");
		 driver.manage().window().maximize();
		 System.out.println("Browser Launched Successfully");
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		

	}
	 public static void checkLogin() {
		 driver.findElement(By.id("email")).sendKeys("chithra@gmail.com");
		 driver.findElement(By.id("pass")).sendKeys("chithra@123");
		

	}
	 
	 public static void clickLogin() {
		 driver.findElement(By.name("login")).click();
		 System.out.println("Incorect Password!");

	}
	  public static  void screenshotErrorPage() throws IOException {
		  TakesScreenshot scrShot1 = ((TakesScreenshot) driver);

			File SrcFile1 = scrShot1.getScreenshotAs(OutputType.FILE);

			File DestFile1 = new File("C:\\Users\\mithun\\eclipse-workspace\\CucumberIpt\\Screenshot\\wrongpassword.png");
			FileUtils.copyFile(SrcFile1, DestFile1);
			System.out.println("Wrong Password Page Screenshot Taken");

	}
	  public static void goBackToPreviousPage() {
		  driver.navigate().back();

	}
	  public static void createAccount() {
		  WebElement createAccount = driver.findElement(By.xpath("//a[text()='Create new account']"));
		 createAccount.click();
		  WebElement firstName = driver.findElement(By.name("firstname"));
		  firstName.sendKeys("chithra");
		  WebElement lastName = driver.findElement(By.name("lastname"));
		  lastName.sendKeys("pavai");
		  driver.findElement(By.name("reg_email__")).sendKeys("chit@gmail.com");
		  driver.findElement(By.name("reg_passwd__")).sendKeys("56666");
		  WebElement day = driver.findElement(By.name("birthday_day"));
		  Select dropdown1 = new Select(day);
		  dropdown1.selectByValue("8");
		  WebElement month = driver.findElement(By.name("birthday_month"));
		  Select dropdown2 = new Select(month);
		  dropdown2.selectByIndex(2);
		  WebElement year = driver.findElement(By.id("year"));
		  Select dropdown3 = new Select(year);
		  dropdown3.selectByVisibleText("2022");
		  WebElement radio1 = driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
		  radio1.click();
		   driver.findElement(By.name("websubmit")).click();
		   System.out.println("New account Created");
	
	 


	}
	   public static void takeScreenshotFillDetails() throws IOException {
		   TakesScreenshot scrShot1 = ((TakesScreenshot) driver);

			File SrcFile1 = scrShot1.getScreenshotAs(OutputType.FILE);

			File DestFile1 = new File("C:\\Users\\mithun\\eclipse-workspace\\CucumberIpt\\Screenshot\\register.png");
			FileUtils.copyFile(SrcFile1, DestFile1);
			System.out.println("Take Screenshot for Registeration Error Page");

	}

	
	 
	   public static void closebrowser() {
		   driver.quit();

}
		public static void main(String[] args) throws InterruptedException, IOException {
			launchBrowser();
			checkLogin();
			clickLogin();
			screenshotErrorPage();
			goBackToPreviousPage();
			createAccount();
			takeScreenshotFillDetails();
			closebrowser();
			
		}
}

