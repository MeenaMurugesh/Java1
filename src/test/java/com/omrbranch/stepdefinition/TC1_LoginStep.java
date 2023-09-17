package com.omrbranch.stepdefinition;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.omrbranch.base.BaseClass;
import com.omrbranch.pagemanager.PageObjectManager;
import com.orgbranch.pages.ExploreHotelPage;

import io.cucumber.java.en.*;

public class TC1_LoginStep extends BaseClass {
	PageObjectManager pom=new PageObjectManager();{
}

	@Given("User is on the OMR Branch hotel page")
	public void userIsOnTheOMRBranchHotelPage() throws FileNotFoundException, IOException {

	}
	@When("User login {string},{string}")
	public void userLogin(String userName, String password) {
		pom.getLoginpage().login(userName, password);
	}
	@Then("User should Verify success message after login {string}")
	public void userShouldVerifySuccessMessageAfterLogin(String expLoginSuccessMsg) {
		String actloginSuccessMsg = pom.getExploreHotelPage().getLoginSuccessMsg();
		Assert.assertEquals("verify success msg after login", expLoginSuccessMsg,actloginSuccessMsg);
	}


	@When("User login {string},{string} with Enter key")
	public void userLoginWithEnterKey(String userName, String password) throws AWTException {
		pom.getLoginpage().loginWithEnterKey(userName, password);
	}


	@Then("User should Verify error message after login {string}")
	public void userShouldVerifyErrorMessageAfterLogin(String expLoginSuccessMsg) {
		String actloginErrorMsg = pom.getLoginpage().getLoginErrorMsg();
		boolean b = actloginErrorMsg.contains(expLoginSuccessMsg);
		Assert.assertTrue("verify after login error msg", b);
		
	}





}
