package com.ipt.practice;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {
	public static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// Product Search
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		WebElement search = driver.findElement(By.xpath("//input[@type='text']"));
		search.sendKeys("samsung s23 ultra");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		WebElement product = driver
				.findElement(By.xpath("//div[text()='SAMSUNG Galaxy S23 Ultra 5G (Green, 256 GB)']"));
		String text = product.getText();
		System.out.println(text);
		String currentWindow = driver.getWindowHandle();

		product.click();
		Set<String> allWindow = driver.getWindowHandles();

		for (String nextPage : allWindow) {
			if (!currentWindow.contentEquals(nextPage)) {
				driver.switchTo().window(nextPage);

			}
			WebElement cart = driver.findElement(By.xpath("//button[text()='Add to cart']"));
			cart.click();

		}

		// add to cart

	}

}
