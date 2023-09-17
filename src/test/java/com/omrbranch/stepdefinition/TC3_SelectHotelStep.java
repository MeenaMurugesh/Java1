package com.omrbranch.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.omrbranch.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC3_SelectHotelStep {

	PageObjectManager pom = new PageObjectManager();

	@When("User select first hotel name and save the hotel name, price")
	public void userSelectFirstHotelNameAndSaveTheHotelNamePrice() {
		WebElement hotelName = pom.getSelectHotelPage().getTextFirstHotelName();
		WebElement hotelPrice = pom.getSelectHotelPage().getTextFirstHotelPrice();

	}

	@When("User accept the alert in selected hotel")
	public void userAcceptTheAlertInSelectedHotel() {
		pom.getSelectHotelPage().acceptHotelSelect();

	}

	@Then("User should verify after select hotel sucess message {string}")
	public void userShouldVerifyAfterSelectHotelSucessMessage(String expSelectHotelSuccessMsg) {
		String actSelectHotelSuccessMsgText = pom.getSelectHotelPage().getSelectHotelSuccessMsg();
		Assert.assertEquals("Verify SelectHotel Success Msg", expSelectHotelSuccessMsg, actSelectHotelSuccessMsgText);

	}

	@When("User dismiss the alert in selected hotel")
	public void userDismissTheAlertInSelectedHotel() {
		pom.getSelectHotelPage().dismissHotelSelect();
	}
}
