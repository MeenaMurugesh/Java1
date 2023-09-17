package com.orgbranch.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.base.BaseClass;

public class ExploreHotelPage extends BaseClass {
	public ExploreHotelPage() {
		PageFactory.initElements(driver, this);
	}

	// Select RoomType single or multiple
	public void selectRoomType(String roomType) {
		String[] split = roomType.split("/");
		for (String text : split) {
			selectOptionByText(txtRoomType, text);
		}
	}
public boolean verifyHotelNameEndsWith(String selectRoomType){
		
		List<WebElement> hotelName = getListOfHotelNames();
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		for (WebElement htName : hotelName) {
			String text = htName.getText();
		if (text.endsWith(selectRoomType)) {
			list1.add(text);
		} else {
		     list2.add(text);
		}
		}boolean empty = list2.isEmpty();
		return empty;
		
			
}
	public void verifydisplayedFilter(String roomType) {
		selectOptionByText(getSelectRoomtype(), roomType);
	
}

	// Login Success msg
	public String getLoginSuccessMsg() {
		String elementGetText = elementGetText(txtLoginSucessMsg);
		return elementGetText;
	}

	// Search hotels with all fields
	// N no of rooms
	public void exploreHotels(String selectState, String selectCity, String selectRoomType, String checkIn,
			String checkOut, String noOfRooms, String noOfAdults, String noOfChildren) {
		selectOptionByText(txtState, selectState);
		selectOptionByText(txtDistrict, selectCity);
		selectOptionByText(txtRoomType, selectRoomType);
		elementSendKeysJS(txtCheckIn, checkIn);
		elementSendKeysJS(txtCheckOut, checkOut);
		selectOptionByText(txtNoRoom, noOfRooms);
		selectOptionByText(txtNoAdult, noOfAdults);
		elementSendKeys(txtNoChild, noOfChildren);		
		switchFrame(getGoToFrame());
		elementClick(getBtnSearch());
		defaultContent();
		//selectRoomType(roomType);
	}
	public void clickSortByHotelPriceHighToLow() {
		elementClickButtonJS(priceHighToLow);
	}

	// Search hotels with mandatory fields

	public void exploreHotels(String selectState, String selectCity, String checkIn, String checkOut,
			String noOfRooms, String noOfAdults) {
		selectOptionByText(txtState, selectState);
		selectOptionByText(txtDistrict, selectCity);
		elementSendKeysJS(txtCheckIn, checkIn);
		elementSendKeysJS(txtCheckOut, checkOut);
		selectOptionByText(txtNoRoom, noOfRooms);
		selectOptionByText(txtNoAdult, noOfAdults);
		switchFrame(getGoToFrame());
		elementClick(getBtnSearch());
		defaultContent();
	}
	// Without enter any fields search hotels

	public void exploreHotelWithOutAnyFieldsGetErrorMsg() {
implicity();
		switchFrame(getGoToFrame());
		elementClick(getBtnSearch());
		defaultContent();
	}
	public void clickSearchHotel() {

		elementClick(btnSearch);
	}

	// Getting Error msg for State
	public String getStateErrorMsg() {
		String elementGetText = elementGetText(errorState);
		return elementGetText;
	}

	// Getting Error msg for City
	public String getCityErrorMsg() {
		String elementGetText = elementGetText(errorDist);
		return elementGetText;
	}

	// Getting Error msg for CheckIn
	public String getCheckInErrorMsg() {
		String elementGetText = elementGetText(errorCheckIn);
		return elementGetText;
	}

	// Getting Error msg for checkOut
	public String getCheckOutErrorMsg() {
		String elementGetText = elementGetText(errorCheckOut);
		return elementGetText;
	}

	// Getting Error msg for No of rooms
	public String getNoofRoomsErrorMsg() {
		String elementGetText = elementGetText(errorNoRoom);
		return elementGetText;
	}

	// Getting Error msg for Adults
	public String getAdultsErrorMsg() {
		String elementGetText = elementGetText(errorAdults);
		return elementGetText;
	}

	// Click the Sort by Hotel Name ASCENDING
	public void clickSortByHotelNameAsc() {
		elementClick(ascendingClick);
	}
	// Click the Sort by Hotel Name DESCENDING

	public void clickSortByHotelNameDsc() {
		elementClick(descendingClick);
	}

	// verify sortBy hotel price ASCENDING
	public boolean verifyHotelNameByAsc() {
		List<String> expectedListOfHotelName = new ArrayList<String>();
		List<String> actualListOfHotelName = new ArrayList<String>();
		for (WebElement element : listOfHotelNames) {
			String elementGetText = elementGetText(element);
			expectedListOfHotelName.add(elementGetText);
		}
		actualListOfHotelName.addAll(expectedListOfHotelName);
		Collections.sort(actualListOfHotelName);
		boolean equals = expectedListOfHotelName.equals(actualListOfHotelName);
		return equals;
	}

	// verify sortBy hotel price DESCENDING
	private void verifyHotelPriceByDsc() {

	}
	@FindBy(xpath = "//h5[text()='Select Hotel']")
	private WebElement afterSearchSuccessMsg;
	public WebElement getAfterSearchSuccessMsg() {
		return afterSearchSuccessMsg;
	}
	public String afterSuccessMsg() {
		String txtSuccessMsg = elementGetText(afterSearchSuccessMsg);
		return txtSuccessMsg;
	}
	public WebElement getTxtLoginSucessMsg() {
		return txtLoginSucessMsg;
	}
	@FindBy(id = "room_type")
	private WebElement selectRoomtype;
	public WebElement getSelectRoomtype() {
		return selectRoomtype;
	}
	@FindBy(xpath = "(//a[@data-toggle='dropdown'])[1]")
	private WebElement txtLoginSucessMsg;
	@FindBy(id = "state")
	private WebElement txtState;
	@FindBy(id = "city")
	private WebElement txtDistrict;
	@FindBy(id = "room_type")
	private WebElement txtRoomType;
	@FindBy(name = "check_in")
	private WebElement txtCheckIn;
	@FindBy(name = "check_out")
	private WebElement txtCheckOut;
	@FindBy(id = "no_rooms")
	private WebElement txtNoRoom;
	@FindBy(id = "no_adults")
	private WebElement txtNoAdult;
	@FindBy(id = "no_child")
	private WebElement txtNoChild;
	@FindBy(id = "hotelsearch_iframe")
	private WebElement goToFrame;
	@FindBy(id = "searchBtn")
	private WebElement btnSearch;
	@FindBy(id = "invalid-state")
	private WebElement errorState;
	@FindBy(id = "invalid-city")
	private WebElement errorDist;
	@FindBy(id = "invalid-check_in")
	private WebElement errorCheckIn;
	@FindBy(id = "invalid-check_out")
	private WebElement errorCheckOut;
	@FindBy(id = "invalid-no_rooms")
	private WebElement errorNoRoom;
	@FindBy(id = "invalid-no_adults")
	private WebElement errorAdults;
	@FindBy(id = "resetBtn")
	private WebElement clear;
	@FindBy(xpath = "(//a[@class='btn filter_btn'])[1]")
	private WebElement filter;
	@FindBy(xpath = "(//div[@class='form-group custom_radio mb-2'])[3]")
	private WebElement ascendingClick;
	@FindBy(xpath = "(//div[@class='form-group custom_radio mb-2'])[4]")
	private WebElement descendingClick;
	@FindBy(xpath = "//label[text()='Price High to low']")
	private WebElement priceHighToLow;
	
	public WebElement getPriceHighToLow() {
		return priceHighToLow;
	}
	@FindBy(xpath = "(//div[@class='form-group custom_radio mb-2'])[1]")
	private WebElement LowToHighClick;
	@FindBy(xpath = "(//div[@class='col-md-5 hotel-suites'])//h5")
	private List<WebElement> listOfHotelNames;

	@FindBy(xpath = "//strong[@class='total-prize']")
	private List<WebElement> listOfHotelPrices;

	public WebElement getSucessMsg() {
		return txtLoginSucessMsg;
	}

	public WebElement getTxtState() {
		return txtState;
	}

	public WebElement getTxtDistrict() {
		return txtDistrict;
	}

	public WebElement getTxtRoomType() {
		return txtRoomType;
	}

	public WebElement getTxtCheckIn() {
		return txtCheckIn;
	}

	public WebElement getTxtCheckOut() {
		return txtCheckOut;
	}

	public WebElement getTxtNoRoom() {
		return txtNoRoom;
	}

	public WebElement getTxtNoAdult() {
		return txtNoAdult;
	}

	public WebElement getTxtNoChild() {
		return txtNoChild;
	}

	public WebElement getGoToFrame() {
		return goToFrame;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}

	public WebElement getErrorState() {
		return errorState;
	}

	public WebElement getErrorDist() {
		return errorDist;
	}

	public WebElement getErrorCheckIn() {
		return errorCheckIn;
	}

	public WebElement getErrorCheckOut() {
		return errorCheckOut;
	}

	public WebElement getErrorNoRoom() {
		return errorNoRoom;
	}

	public WebElement getErrorAdults() {
		return errorAdults;
	}

	public WebElement getClear() {
		return clear;
	}

	public WebElement getFilter() {
		return filter;
	}

	public WebElement getAscendingClick() {
		return ascendingClick;
	}

	public WebElement getDescendingClick() {
		return descendingClick;
	}

	public WebElement getLowToHighClick() {
		return LowToHighClick;
	}

	public List<WebElement> getListOfHotelNames() {
		return listOfHotelNames;
	}

	public List<WebElement> getListOfHotelPrices() {
		return listOfHotelPrices;
	}

	

}
