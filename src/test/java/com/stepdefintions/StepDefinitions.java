package com.stepdefintions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.baseclass.Baseclass;
import com.pom.manager.PageObjectmanager;
import com.runnerclass.FacebookRunner;

import io.cucumber.java.en.*;

public class StepDefinitions extends Baseclass {
	public static WebDriver driver = FacebookRunner.driver;
	PageObjectmanager pom = new PageObjectmanager(driver);

	@Given("user give the Invalid Username and Invalid Password")
	public void user_give_the_invalid_username_and_invalid_password() {
		driver.get("https://www.facebook.com/");
		maximizeWindow();
		System.out.println("Browser Launched Successfully");
		implicitwait(20);
		pom.getLogin().getEmail().sendKeys("chit@gmail.com");
		pom.getLogin().getPassword().sendKeys("ppppppp");
//		WebElement mailId = driver.findElement(By.id("email"));
//		mailId.sendKeys("chithra");
//		WebElement password = driver.findElement(By.id("pass"));
//		password.sendKeys("chithra@1233");
	}
	@When("user Click The Login Button")
	public void user_click_the_login_button() {
		pom.getLogin().getLogin().click();
	//	driver.findElement(By.name("login")).click();
		System.out.println("Incorect Password!");
	}

	@Then("user Take Screenshot For Invalid Credential error Message")
	public void user_take_screenshot_for_invalid_credential_error_message() throws IOException {
		screenshot("wrongpassword.png");
//		TakesScreenshot scrShot1 = ((TakesScreenshot) driver);
//		File SrcFile1 = scrShot1.getScreenshotAs(OutputType.FILE);
//		File DestFile1 = new File("C:\\Users\\mithun\\eclipse-workspace\\CucumberIpt\\Screenshot\\wrongpassword");
//		FileUtils.copyFile(SrcFile1, DestFile1);
		System.out.println("Wrong Password Page Screenshot Taken");
	}
	@Then("user Go Back To The Home Page")
	public void user_go_back_to_the_home_page() {
		navigateBack();

	}

	@Then("user Clik The Create New Account Button and Fill The Details")
	public void user_clik_the_create_new_account_button_and_fill_the_details() {
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

	@Then("user Take Scrrenshot For The Registeration Page")
	public void user_take_scrrenshot_for_the_registeration_page() throws IOException {
		TakesScreenshot scrShot1 = ((TakesScreenshot) driver);

		File SrcFile1 = scrShot1.getScreenshotAs(OutputType.FILE);

		File DestFile1 = new File(
				"C:\\Users\\mithun\\eclipse-workspace\\CucumberIpt\\Screenshot\\Screenshot\\register");
		FileUtils.copyFile(SrcFile1, DestFile1);
		System.out.println("Take Screenshot for Registeration Error Page");

	}

}
