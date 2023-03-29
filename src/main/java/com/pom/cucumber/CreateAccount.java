package com.pom.cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccount {
	public CreateAccount(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	

	public WebElement getCreateAccount() {
		return createAccount;
	}
	public WebElement getFirstName() {
		return firstName;
	}
	public WebElement getLastName() {
		return lastName;
	}
	public WebElement getRegeEmail() {
		return regeEmail;
	}
	public WebElement getRegPassword() {
		return regPassword;
	}
	public WebElement getDay() {
		return day;
	}
	public WebElement getMonth() {
		return month;
	}
	public WebElement getYear() {
		return year;
	}
	public WebElement getRadioBtn() {
		return radioBtn;
	}
	public WebElement getSumbit() {
		return sumbit;
	}

	@FindBy(xpath="//a[text()='Create new account']")
	private WebElement createAccount;
	@FindBy (name="firstname")
	private WebElement firstName;
	@FindBy(name="lastname")
	private WebElement lastName;
	@FindBy(name="reg_email__")
	private WebElement regeEmail;
	@FindBy(name="reg_passwd__")
	private WebElement regPassword;
	@FindBy(name="birthday_day")
	private WebElement day;
	@FindBy(name="birthday_month")
	private WebElement month;
	@FindBy(id="year")
	private WebElement year;
	@FindBy(xpath="(//input[@type='radio'])[1]")
	private WebElement radioBtn;
	@FindBy(name ="websubmit")
	private WebElement sumbit;
	

}
