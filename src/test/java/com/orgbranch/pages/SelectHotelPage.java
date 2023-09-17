package com.orgbranch.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.base.BaseClass;

public class SelectHotelPage extends BaseClass {

	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}

	public static String firstHotelName;
	public static String firstHotelPrice;

	// select Hotel success msg
	public String getSelectHotelSuccessMsg() {
		String elementGetText = elementGetText(hotelSuccessMsg);
		return elementGetText;
	}

	// Room Type header
	public String getRoomTypeHeaderMsg() {
		String elementGetText = elementGetText(selectRoomTypeHeaderMsg);
		return elementGetText;
	}

	// select the first hotel Name
	public void selectFirstHotelName() {
		firstHotelName = elementGetText(textFirstHotelName);
		firstHotelPrice = elementGetText(textFirstHotelPrice);
		elementClick(btnContinue);
	}

	// Accept the alert
	public void acceptHotelSelect() {
		clickokAlert();
	}

	// Dismiss the alert
	public void dismissHotelSelect() {
		clickcancelAlert();
	}

	@FindBy(xpath = "//div[@class='fliter_box_innermb_4']//h5")
	private WebElement textFirstHotelName;
	@FindBy(xpath = "div[@class='prize']")
	private WebElement textFirstHotelPrice;
	@FindBy(xpath = "//h5[@class='font35 font-weight-bold mb-4']")
	private WebElement hotelSuccessMsg;
	@FindBy(xpath = "//h2[contains(text(),'Room')]")
	private WebElement selectRoomTypeHeaderMsg;
	@FindBy(xpath = "(//a[@class='btn filter_btn'])[1]")
	private WebElement btnContinue;

//	@FindBy(xpath="(//h5[contains(text(),'Le Royal')])[1]")
//	private WebElement hotelName;
//	@FindBy(xpath="(//strong[@class='total-prize'])[1]")
//	private WebElement hotelPrice;

	public WebElement getHotelSuccessMsg() {
		return hotelSuccessMsg;
	}

	public WebElement getSelectRoomTypeHeaderMsg() {
		return selectRoomTypeHeaderMsg;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}

	public WebElement getTextFirstHotelName() {
		return textFirstHotelName;
	}

	public WebElement getTextFirstHotelPrice() {
		return textFirstHotelPrice;
	}

//public WebElement getHotelName() {
//	return hotelName;
//}
//public WebElement getHotelPrice() {
//	return hotelPrice;
//}

}
