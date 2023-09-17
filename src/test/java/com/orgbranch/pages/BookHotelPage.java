package com.orgbranch.pages;

import java.util.Map;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.base.BaseClass;

public class BookHotelPage extends BaseClass {
	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}

	// 1 bookHotelGetSuccessMsg
	public String bookHotelGetSuccessMsg() {
		String bookHotelMsg = elementGetText(bookHotelSuccessMsg);
		return bookHotelMsg;
	}

	// 2 addGuestDetails
	public void addGuestDetails(String salutation1, String firstName1, String lastName1,
			String email1, String mobile) {
		elementClick(bookFor);
		elementClick(salutation);
		elementSendKeys(firstName, firstName1);
		elementSendKeys(lasttName, lastName1);
		elementSendKeys(eMail, email1);
		elementSendKeys(mblNo, mobile);
	}

	// 3 addGSTDetails
	public void addGSTDetails(String gstNumber, String gstCompanyName, String gstComapnyAddress) {
		elementClick(clkGst);
		elementSendKeys(txtReg, gstNumber);
		elementSendKeys(txtCmp, gstCompanyName);
		elementSendKeys(txtCmpAdd, gstComapnyAddress);
		elementClick(clkNext);
	}

	// 4 addSpecialRequest
	public void addSpecialRequest(String anyOtherRequest) {
		elementClick(largeBed);
		elementSendKeys(othrReq, anyOtherRequest);
		elementClick(nextClk);
	}

	// 5 addPayment
public void addPaymentWithCardOptions(String CardType, io.cucumber.datatable.DataTable dataTable){
		
		elementClickButtonJS(getPaymentCard());
		selectOptionByText(getDdnCardType(), CardType);
		
		List<Map<String, String>> outterMap = dataTable.asMaps();
	   
		switch (CardType) {
		case "Debit Card":
			Map<String, String> innerMap = outterMap.get(0);
		    String cardName = innerMap.get("CardType");
		    System.out.println(cardName);
		    selectOptionByText(getDdnCardType(), cardName);
		    String cardNO = innerMap.get("CardNo");
		    elementSendKeys(getCardNo(), cardNO);
		    String name = innerMap.get("Name");
		    elementSendKeys(getCardName(), name);
		    String month  = innerMap.get("Month");
		    selectOptionByText(getCardMonth(), month);
		    String year = innerMap.get("Year");
		    selectOptionByText(getCardYear(), year);
		    String cvv = innerMap.get("Cvv");
		    elementSendKeys(getCardCvv(), cvv);
		    elementClickButtonJS(getSubmit());
			break;
		case "Credit Card":
			Map<String, String> innerMap1 = outterMap.get(4);
		    String cardName1 = innerMap1.get("CardType");
		    System.out.println(cardName1);
		    selectOptionByText(getDdnCardType(), cardName1);
		    String cardNO1 = innerMap1.get("CardNo");
		    elementSendKeys(getCardNo(), cardNO1);
		    String name1 = innerMap1.get("Name");
		    elementSendKeys(getCardName(), name1);
		    String month1  = innerMap1.get("Month");
		    selectOptionByText(getCardMonth(), month1);
		    String year1 = innerMap1.get("Year");
		    selectOptionByText(getCardYear(), year1);
		    String cvv1 = innerMap1.get("Cvv");
		    elementSendKeys(getCardCvv(), cvv1);
		    elementClickButtonJS(getSubmit());
			break;
			
		default:
			break;
		}
		
	}

	

	// 6 getCardOptionErrorMsg
	public String getCardOptionErrorMsg() {
		String elementGetText = elementGetText(errorPayment);
		return elementGetText;
	}

	// 7 getCardTypeErrorMsg
	public String getCardTypeErrorMsg() {
		String elementGetText = elementGetText(errorType);
		return elementGetText;
	}

	// 8 getCardNumberErrorMsg
	public String getCardNumberErrorMsg() {
		String elementGetText = elementGetText(errorCardNo);
		return elementGetText;
	}

	// 9 getCardNameErrorMsg
	public String getCardNameErrorMsg() {
		String elementGetText = elementGetText(errorCardName);
		return elementGetText;
	}

	// 10 getExpMonthErrorMsg
	public String getExpMonthErrorMsg() {
		String elementGetText = elementGetText(errorCardMonth);
		return elementGetText;
	}

	// 11 getCvvErrorMsg
	public String getCvvErrorMsg() {
		String elementGetText = elementGetText(enterCvv);
		return elementGetText;
	}

	@FindBy(xpath = "//h2[contains(text(),'Book Hotel')]")
	private WebElement bookHotelSuccessMsg;
	@FindBy(id = "own")
	private WebElement bookFor;
	@FindBy(id = "user_title")
	private WebElement salutation;
	@FindBy(id = "first_name")
	private WebElement firstName;
	@FindBy(id = "last_name")
	private WebElement lasttName;
	@FindBy(id = "user_phone")
	private WebElement mblNo;
	@FindBy(id = "user_email")
	private WebElement eMail;

	@FindBy(id = "gst")
	private WebElement clkGst;

	@FindBy(id = "gst_registration")
	private WebElement txtReg;

	@FindBy(id = "company_name")
	private WebElement txtCmp;

	@FindBy(id = "company_address")
	private WebElement txtCmpAdd;

	@FindBy(id = "step1next")
	private WebElement clkNext;

	@FindBy(id = "late")
	private WebElement lateCheckIn;

	@FindBy(id = "bed")
	private WebElement largeBed;

	@FindBy(id = "smoking")
	private WebElement smokingRoom;

	@FindBy(id = "early")
	private WebElement earlyCheckIn;

	@FindBy(id = "high")
	private WebElement roomHighFloor;

	@FindBy(id = "other_request")
	private WebElement othrReq;

	@FindBy(id = "step2next")
	private WebElement nextClk;

	@FindBy(xpath = "//div[@class='credit-card pm']")
	private WebElement paymentCard;

	@FindBy(id = "payment_type")
	private WebElement paymentType;

	@FindBy(id = "card_type")
	private WebElement ddnCardType;

	@FindBy(id = "card_no")
	private WebElement cardNo;

	@FindBy(id = "card_name")
	private WebElement cardName;

	@FindBy(id = "card_month")
	private WebElement cardMonth;

	@FindBy(id = "card_year")
	private WebElement cardYear;

	@FindBy(name = "cvv")
	private WebElement cardCvv;
	@FindBy(id = "submitBtn")
	private WebElement submit;

	@FindBy(id = "invalid-payment_type")
	private WebElement errorPayment;

	@FindBy(id = "invalid-card_type")
	private WebElement errorType;

	@FindBy(id = "invalid-card_no")
	private WebElement errorCardNo;

	@FindBy(id = "invalid-card_name")
	private WebElement errorCardName;

	@FindBy(id = "invalid-card_month")
	private WebElement errorCardMonth;

	@FindBy(id = "invalid-cvv")
	private WebElement enterCvv;

	public WebElement getBookFor() {
		return bookFor;
	}

	public WebElement getSalutation() {
		return salutation;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLasttName() {
		return lasttName;
	}

	public WebElement getMblNo() {
		return mblNo;
	}

	public WebElement geteMail() {
		return eMail;
	}

	public WebElement getClkGst() {
		return clkGst;
	}

	public WebElement getTxtReg() {
		return txtReg;
	}

	public WebElement getTxtCmp() {
		return txtCmp;
	}

	public WebElement getTxtCmpAdd() {
		return txtCmpAdd;
	}

	public WebElement getClkNext() {
		return clkNext;
	}

	public WebElement getLateCheckIn() {
		return lateCheckIn;
	}

	public WebElement getLargeBed() {
		return largeBed;
	}

	public WebElement getSmokingRoom() {
		return smokingRoom;
	}

	public WebElement getEarlyCheckIn() {
		return earlyCheckIn;
	}

	public WebElement getRoomHighFloor() {
		return roomHighFloor;
	}

	public WebElement getOthrReq() {
		return othrReq;
	}

	public WebElement getNextClk() {
		return nextClk;
	}

	public WebElement getPaymentCard() {
		return paymentCard;
	}

	public WebElement getPaymentType() {
		return paymentType;
	}

	public WebElement getDdnCardType() {
		return ddnCardType;
	}

	public WebElement getCardNo() {
		return cardNo;
	}

	public WebElement getCardName() {
		return cardName;
	}

	public WebElement getCardMonth() {
		return cardMonth;
	}

	public WebElement getCardYear() {
		return cardYear;
	}

	public WebElement getCardCvv() {
		return cardCvv;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public WebElement getErrorPayment() {
		return errorPayment;
	}

	public WebElement getErrorType() {
		return errorType;
	}

	public WebElement getErrorCardNo() {
		return errorCardNo;
	}

	public WebElement getErrorCardName() {
		return errorCardName;
	}

	public WebElement getErrorCardMonth() {
		return errorCardMonth;
	}

	public WebElement getEnterCvv() {
		return enterCvv;
	}

}
