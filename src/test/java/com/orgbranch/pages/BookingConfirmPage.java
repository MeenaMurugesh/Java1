package com.orgbranch.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.base.BaseClass;

public class BookingConfirmPage extends BaseClass {
	public BookingConfirmPage() {
		PageFactory.initElements(driver, this);
	}

	// public static String orderIdNo;
	// Get the order id and store
	public String getOrderId() {
		String elementGetText = elementGetText(orderId);
		return elementGetText;
	}

	// Get Booking Success Msg
	public String getBookingSuccessMsg() {
		String elementGetText = elementGetText(bookingConfirmationMsg);
		return elementGetText;
	}

	// Get the hotel Name
	public String getHotelName() {
		String elementGetText = elementGetText(bookingName);
		return elementGetText;
	}

	@FindBy(xpath = "//h2[@class='couppon-code']")
	private WebElement orderId;
	@FindBy(xpath = "//h4[contains(text(),'Booking')]")
	private WebElement bookingConfirmationMsg;

	@FindBy(xpath = "//strong[contains(text(),'Hotel Bangalore')]")
	private WebElement bookingName;

	@FindBy(xpath = "(//a[contains(text(),'My Account')]")
	private WebElement myAccount;

	public WebElement OrderId() {
		return orderId;
	}

	public WebElement getBookingConfirmationMsg() {
		return bookingConfirmationMsg;
	}

	public WebElement getBookingName() {
		return bookingName;
	}

	public WebElement getMyAccount() {
		return myAccount;
	}

}
