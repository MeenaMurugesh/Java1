package com.omrbranch.stepdefinition;

import org.junit.Assert;

import com.omrbranch.base.BaseClass;
import com.omrbranch.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

public class TC2_ExploreHotelStep extends BaseClass{
	PageObjectManager pom=new PageObjectManager();{
}



	@When("User search hotel {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userSearchHotelAnd(String selectState, String selectCity, String selectRoomType, String checkIn, String checkOut, String noOfRooms, String noOfAdults, String noOfChildren) {
		pom.getExploreHotelPage().exploreHotels(selectState, selectCity, selectRoomType, checkIn, checkOut, noOfRooms, noOfAdults, noOfChildren);
	}
	@Then("User should Verify success message after search hotel {string}")
	public void userShouldVerifySuccessMessageAfterSearchHotel(String expLoginSuccessMsg) {
		String actSearchSuccessMsg = pom.getExploreHotelPage().afterSuccessMsg();
		boolean c = actSearchSuccessMsg.contains(expLoginSuccessMsg);
		Assert.assertTrue("Verify success msg after search", c);
	}

	@When("User search hotel {string},{string},{string},{string},{string} and {string}")
	public void userSearchHotelAnd(String selectState, String selectCity, String checkIn, String checkOut, String noOfRooms, String noOfAdults) {
	pom.getExploreHotelPage().exploreHotels(selectState, selectCity, checkIn, checkOut, noOfRooms, noOfAdults);
	}


	@When("User Search Hotels without selecting any fields")
	public void userSearchHotelsWithoutSelectingAnyFields() {
pom.getExploreHotelPage().exploreHotelWithOutAnyFieldsGetErrorMsg();
	}



	@Then("User should verify error message after search hotel {string},{string},{string},{string},{string} and {string}")
	public void userShouldVerifyErrorMessageAfterSearchHotelAnd(String errorState, String errorDist, String errorCheckIn, String errorCheckOut, String errorNoRoom, String errorAdults) {
		pom.getExploreHotelPage().getErrorState();
		pom.getExploreHotelPage().getErrorDist();
		pom.getExploreHotelPage().getErrorCheckIn();
		pom.getExploreHotelPage().getErrorCheckOut();
		pom.getExploreHotelPage().getErrorAdults();
		pom.getExploreHotelPage().getErrorNoRoom();
	}



	@Then("User should only selected room type are visible in the header {string}")
	public void userShouldOnlySelectedRoomTypeAreVisibleInTheHeader(String roomType) {
		 pom.getExploreHotelPage().verifydisplayedFilter(roomType);
	}


	@When("User click the hotel price sort high to low")
	public void userClickTheHotelPriceSortHighToLow() {
		pom.getExploreHotelPage().clickSortByHotelPriceHighToLow();
	}
	@Then("User should verify sorted in high to low")
	public void userShouldVerifySortedInHighToLow() {
		
	}


	@When("User click the hotel name sort Ascending order")
	public void userClickTheHotelNameSortAscendingOrder() {
		pom.getExploreHotelPage().clickSortByHotelPriceHighToLow();
		}
	@Then("User should verify sorted in the Ascending order")
	public void userShouldVerifySortedInTheAscendingOrder() {
		pom.getExploreHotelPage().verifyHotelNameByAsc();
		
	}


}

	







