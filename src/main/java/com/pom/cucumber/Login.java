
package com.pom.cucumber;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Login {
	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getEmail() {
		return email;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getLogin() {
		return login;
	}
	@FindBy(id = "email")
	private WebElement email;
	@FindBy(id = "pass")
	private WebElement password;
	@FindBy(name = "login")
	private WebElement login;

}
