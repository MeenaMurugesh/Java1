package com.orgbranch.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.base.BaseClass;

public class MyBookingPage extends BaseClass {
	public MyBookingPage() {
		PageFactory.initElements(driver, this);
	}

	// Navigate to My Booking Page
	public void navigateToMyBookingPage() {
		elementClick(myAccount);
	}

	// Get the Booking Success Msg
	public String getBookingSuccessMsg() {
		String elementGetText = elementGetText(booking);
		return elementGetText;
	}

	// Search Order Id
	public void searchOrderId(String txtorderId) {
		elementSendKeys(orderId, txtorderId);
	}

	// Get OrderId Te
	public String getOrderIdMsg() {
		String elementGetText = elementGetText(orderId);
		return elementGetText;
	}

	// Get Hotel Name
	public String getHotelNameSuccessMsg() {
		String elementGetText = elementGetText(hotelNamae);
		return elementGetText;
	}

	// Get Hotel Price
	public String getHotelNamePriceSuccessMsg() {
		String elementGetText = elementGetText(price);
		return elementGetText;
	}

	// Modify the CheckInDate
	public void modifyCheckInDate(String checkInDate) {
		elementSendKeysJS(checkIn, checkInDate);
		elementClick(confirm);
	}

	// Change Booking Success Msg
	public String getChangeBookingSuccessMsg() {
		String elementGetText = elementGetText(bookingUpdatedMsg);
		return elementGetText;
	}

	// Modify FirstOrderId
	public void clickFirstOrderIdEditButton() {
		elementClick(edit);
	}

	// Cancel OrderId
	public void cancelOrderId() {
		elementClick(cancel);
		clickokAlert();
	}

	// Get the Cancel Booking Success Msg
	public String getCancelBookingSucessMsg() {
		String elementGetText = elementGetText(cancelBookingMsg);
		return elementGetText;
	}

	// Cancel First Order Id Button
	public void clickFirstOrderIdCancelButton() {
		elementClick(cancel);
		clickokAlert();
	}

	@FindBy(xpath = "//a[@data-testid='username']")
	private WebElement userName;

	@FindBy(xpath = "//a[text()='My Account']")
	private WebElement myAccount;

	@FindBy(xpath = "//h4[contains(text(),'Bookings ')]")
	private WebElement booking;

	@FindBy(name = "search")
	private WebElement searchId;

	@FindBy(xpath = "//span[text()='#WHTIW49898']")
	private WebElement orderId;

	@FindBy(xpath = "//h5[text()='Evoma Studio']")
	private WebElement hotelNamae;

	@FindBy(xpath = "//strong[text()='Rs 40,356']")
	private WebElement price;

	@FindBy(xpath = "//button[text()='Edit']")
	private WebElement edit;

	@FindBy(name = "check_in")
	private WebElement checkIn;

	@FindBy(name = "check_out")
	private WebElement checkOut;

	@FindBy(xpath = "//button[text()='Confirm']")
	private WebElement confirm;

	@FindBy(xpath = "//li[contains(text(),'Booking updated successfully')]")
	private WebElement bookingUpdatedMsg;

	@FindBy(name = "search")
	private WebElement search;

	@FindBy(xpath = "//span[text()='#LYUNR78366']")
	private WebElement orderId2;

	@FindBy(xpath = "//h5[text()='Evoma Studio']")
	private WebElement hotelName2;

	@FindBy(xpath = "//strong[text()='Rs 40,356']")
	private WebElement price2;

	@FindBy(xpath = "//a[contains(text(),'Cancel')]")
	private WebElement cancel;

	@FindBy(xpath = "//li[contains(text(),'Your booking cancelled successfully')]")
	private WebElement cancelBookingMsg;

	

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getMyAccount() {
		return myAccount;
	}

	public WebElement getBooking() {
		return booking;
	}

	public WebElement getSearchId() {
		return searchId;
	}

	public WebElement getOrderId() {
		return orderId;
	}

	public WebElement getHotelNamae() {
		return hotelNamae;
	}

	public WebElement getPrice() {
		return price;
	}

	public WebElement getEdit() {
		return edit;
	}

	public WebElement getCheckIn() {
		return checkIn;
	}

	public WebElement getCheckOut() {
		return checkOut;
	}

	public WebElement getConfirm() {
		return confirm;
	}

	public WebElement getBookingUpdatedMsg() {
		return bookingUpdatedMsg;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getOrderId2() {
		return orderId2;
	}

	public WebElement getHotelName2() {
		return hotelName2;
	}

	public WebElement getPrice2() {
		return price2;
	}

	public WebElement getCancel() {
		return cancel;
	}

	public WebElement getCancelBookingMsg() {
		return cancelBookingMsg;
	}

}
