package com.omrbranch.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.omrbranch.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC4_BookHotelStep {
	PageObjectManager pom = new PageObjectManager();

	@When("User add the guest details {string},{string},{string},{string} and {string}")
	public void userAddTheGuestDetailsAnd(String salutation, String firstName, String lastName, String email, String mobileNo) {
		pom.getBookHotelPage().addGuestDetails(salutation, firstName, lastName, mobileNo, email);
	}
	@When("User add the GST details {string},{string} and {string}")
	public void userAddTheGSTDetailsAnd(String regNo, String companyName, String companyAddress) {
		pom.getBookHotelPage().addGSTDetails(regNo, companyName, companyAddress);

	}
	@When("User add the special request {string}")
	public void userAddTheSpecialRequest(String specialRequestComments) {
		pom.getBookHotelPage().addSpecialRequest(specialRequestComments);

	} 

	@When("User add the payment details proceed with {string}")
	public void userAddThePaymentDetailsProceedWith(String CardType, io.cucumber.datatable.DataTable dataTable) {
		pom.getBookHotelPage().addPaymentWithCardOptions(CardType, dataTable);

	}
	
	@Then("User should verify after booking success message {string} and save the order id")
	public void userShouldVerifyAfterBookingSuccessMessageAndSaveTheOrderId(String expBookingIsConfirmed) {
		String actBookingIsConfirmed = pom.getBookHotelPage().bookHotelGetSuccessMsg();
		//boolean b = actBookingIsConfirmed.contains(expBookingIsConfirmed);
		Assert.assertEquals(expBookingIsConfirmed, actBookingIsConfirmed);

	}
	@Then("User should verify same selected hotel booked or NOT")
	public void userShouldVerifySameSelectedHotelBookedOrNOT() {
		 //boolean verifySameSelectedHotelIsBooked = pom.getBookHotelPage().
				 //Assert.assertTrue(verifySameSelectedHotelIsBooked);
			  
	}


	@Then("User should verify after booking error message {string},{string},{string},{string},{string} and {string}")
	public void userShouldVerifyAfterBookingErrorMessageAnd(String string, String string2, String string3, String string4, String string5, String string6) {
	}











}
