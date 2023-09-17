package com.orgbranch.pages;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.base.BaseClass;

public class LoginPage extends BaseClass {
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Valid Login
	// Invalid Login
	public void login(String userName, String password) {
		elementSendKeys(txtUserName, userName);
		elementSendKeys(txtPassword, password);
		elementClick(btnLogin);
	}

	// Login with ENTER key
	public void loginWithEnterKey(String userName, String password) throws AWTException {
		elementSendKeys(txtUserName, userName);
		elementSendKeys(txtPassword, password);
		enterKey(btnLogin);
	}

	// Get the Invalid Login Error Msg
	public String getLoginErrorMsg() {
		String elementGetText = elementGetText(txtLoginErrorMsg);
		return elementGetText;

	}

	@FindBy(id = "email")
	private WebElement txtUserName;
	@FindBy(id = "pass")
	private WebElement txtPassword;
	@FindBy(xpath = "//button[text()='Login']")
	private WebElement btnLogin;
	@FindBy(id = "errorMessage")
	private WebElement txtLoginErrorMsg;

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public WebElement getTxtLoginErrorMsg() {
		return txtLoginErrorMsg;
	}

}
