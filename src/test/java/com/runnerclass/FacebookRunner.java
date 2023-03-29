package com.runnerclass;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;




@RunWith(Cucumber.class)
@CucumberOptions(features ="C:\\Users\\mithun\\eclipse-workspace\\CucumberIpt\\src\\test\\resources\\FeatureFiles\\Facebook.feature",
glue = "com.stepdefintions")
public class FacebookRunner {
	public static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
	}
	@AfterClass
	public static void tearDown() {
		driver.quit();

	}

}
