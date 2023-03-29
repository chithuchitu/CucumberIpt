package com.pom.manager;

import org.openqa.selenium.WebDriver;

import com.baseclass.Baseclass;
import com.pom.cucumber.CreateAccount;
import com.pom.cucumber.Login;

public class PageObjectmanager extends Baseclass

{
	public PageObjectmanager(WebDriver driver) {
		this.driver = driver;
	}

	private CreateAccount createAccount;

	public CreateAccount getCreateAccount() {
		if (createAccount==null) {
			createAccount = new CreateAccount(driver);
					}

		return createAccount;
	}

	private Login login;

	public Login getLogin() {
		if (login==null) {
			login = new Login(driver);
			}
		return login;
		
	}

}
