package com.omrbranch.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * @author Meena
 * @see Use to maintain resuable methods
 * @Date 15-08-2023
 */

public class BaseClass {
	public static WebDriver driver;
	Select select;
	private String value;
	private Date dateCellValue;
/**
 * @param browserType
 * @see getDriver
 * @Date 15-08-2023
 */
	public static void browserLaunch(String browserType) {
		switch (browserType) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "ie":
			driver = new InternetExplorerDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			break;
		}

	}
	/**
	 * @param element
	 * @throws AWTException
	 */
	

	public static void enterKey(WebElement element) throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	/**
	 * 
	 * @param url
	 * @see enter url
	 */

	public static void enterAppUrl(String url) {
		driver.get(url);
	}
	/**
	 * @param maximizeWindow
	 * @see maximize
	 */

	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public static void defaultContent() {

		driver.switchTo().defaultContent();
	}

	public static void elementSendKeys(WebElement element, String data) {
		element.sendKeys(data);
	}

	public void elementClickButtonJS(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("argument[0].click()", element);
	}

	public void elementSendKeysJS(WebElement element, String text) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value', '" + text + "')", element);
	}

	public void elementClick(WebElement element) {
		element.click();
	}

	public String getAppTitle() {
		String title = driver.getTitle();
		return title;
	}

	public WebElement findLocatorById(String attributeValue) {
		WebElement element = driver.findElement(By.id(attributeValue));
		return element;
	}

	public WebElement findLocatorByName(String attributeValue) {
		WebElement element = driver.findElement(By.name(attributeValue));
		return element;
	}

	public WebElement findLocatorByClassName(String attributeValue) {
		WebElement element = driver.findElement(By.className(attributeValue));
		return element;
	}

	public WebElement findLocatorByXpath(String xpathExp) {
		WebElement element = driver.findElement(By.xpath(xpathExp));
		return element;
	}

	public String getApplnUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public static void closeWindow() {
		driver.close();
	}

	public static void quitWindow() {
		driver.quit();
	}

	public String elementGetText(WebElement element) {
		visibilityOfElement(element);
		String attribute = element.getText();
		return attribute;
	}

	// public String elementGetAttributeValue(WebElement element, String
	// attributeName) {
	// element.getAttribute(attributeName);
	// return attributeName;
	// }
	// click ok in alert
	public void clickokAlert() {
		driver.switchTo().alert().accept();
	}

	// click cancel in alert
	public void clickcancelAlert() {
		driver.switchTo().alert().dismiss();
	}

	public void selectOptionByText(WebElement element, String text) {
		select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void selectOptionByAttribute(WebElement element, String value) {
		select = new Select(element);
		select.selectByValue(value);
	}

	public void selectOptionByIndex(WebElement element, int index) {
		select = new Select(element);
		select.selectByIndex(index);
	}

	public void screenshot(String name) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File s = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(s, new File("C:\\Users\\pravi\\eclipse-workspace\\UtilityClass\\Excel " + name + ".xlsx"));
	}

	public void screenshot(WebElement element, String name) throws IOException {
		File s = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(s, new File("C:\\Users\\pravi\\eclipse-workspace\\UtilityClass\\Excel" + name + ".png"));
	}

	public static void implicity() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public void implicity(int secs) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));
	}

	public void thread(int secs) throws InterruptedException {
		Thread.sleep(secs);
	}

	public void visibilityOfElement(WebElement element) {
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driverWait.until(ExpectedConditions.visibilityOf(element));
	}

	public void switchToChildWindow() {
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String eachWindow : allWindows) {
			driver.switchTo().window(eachWindow);
		}
	}

	public void switchFrame(String id) {
		driver.switchTo().frame(id);
	}

	public void switchFrame(WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchFrame(int index) {
		driver.switchTo().frame(index);
	}

	public void dragAndDropId(String source, String destination) {
		WebElement s = driver.findElement(By.id(source));
		WebElement d = driver.findElement(By.id(destination));
		Actions actions = new Actions(driver);
		actions.dragAndDrop(s, d).perform();
	}

	public void dragAndDropName(String source, String destination) {
		WebElement s = driver.findElement(By.name(source));
		WebElement d = driver.findElement(By.name(destination));
		Actions actions = new Actions(driver);
		actions.dragAndDrop(s, d).perform();
	}

	public void dragAndDropClassName(String source, String destination) {
		WebElement s = driver.findElement(By.className(source));
		WebElement d = driver.findElement(By.className(destination));
		Actions actions = new Actions(driver);
		actions.dragAndDrop(s, d).perform();
	}

	public void dragAndDropXpath(String source, String destination) {
		WebElement s = driver.findElement(By.xpath(source));
		WebElement d = driver.findElement(By.xpath(destination));
		Actions actions = new Actions(driver);
		actions.dragAndDrop(s, d).perform();
	}

	public void rightClickId(String data) {
		WebElement rightClick = driver.findElement(By.id(data));
		Actions actions = new Actions(driver);
		actions.contextClick(rightClick).perform();
	}

	public void rightClickName(String data) {
		WebElement rightClick = driver.findElement(By.name(data));
		Actions actions = new Actions(driver);
		actions.contextClick(rightClick).perform();
	}

	public void rightClickClassName(String data) {
		WebElement rightClick = driver.findElement(By.className(data));
		Actions actions = new Actions(driver);
		actions.contextClick(rightClick).perform();
	}

	public void rightClickxpath(String data) {
		WebElement rightClick = driver.findElement(By.xpath(data));
		Actions actions = new Actions(driver);
		actions.contextClick(rightClick).perform();
	}

	public void doubleClickId(String data) {
		WebElement element = driver.findElement(By.id(data));
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	public void doubleClickName(String data) {
		WebElement element = driver.findElement(By.name(data));
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	public void doubleClickClassName(String data) {
		WebElement element = driver.findElement(By.className(data));
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	public void doubleClickxpath(String data) {
		WebElement element = driver.findElement(By.xpath(data));
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();

	}
	public byte[] screenshot() {
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		byte[] b = screenshot.getScreenshotAs(OutputType.BYTES);
		return b;
		
	}

	// Excel
	public String readCellData(String sheetName, int rowNum, int cellNum) throws IOException {

		String value = null;
		File file = new File("C:\\Users\\pravi\\eclipse-workspace\\UtilityClass\\Excel\\logincredentials.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		CellType type = cell.getCellType();
		switch (type) {
		case STRING:
			value = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/YY");
			} else {
				double numericCellValue = cell.getNumericCellValue();
				long round = Math.round(numericCellValue);
				if (round == numericCellValue) {
					value = String.valueOf(round);
				} else {
					value = String.valueOf(numericCellValue);
				}
			}
			break;
		default:
			break;

		}
		return value;

	}

	public void updateCellData(String SheetName, int rowNum, int cellNum, String oldData, String newData)
			throws IOException {
		File file = new File("C:\\Users\\pravi\\eclipse-workspace\\UtilityClass\\Excel\\dm.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(SheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String value = cell.getStringCellValue();
		if (value.equals(oldData)) {
			cell.setCellValue(newData);
		}
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);
	}

	public void writeCellData(String sheetName, int rowNum, int cellNum, String data) throws IOException {
		File file = new File("C:\\Users\\pravi\\eclipse-workspace\\UtilityClass\\Excel\\logincredentials.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row createRow = sheet.createRow(rowNum);
		// Row row = sheet.getRow(rowNum);
		Cell cell = createRow.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);

	}

	public static String getProjectPath() {
		String path = System.getProperty("user.dir");
		return path;
	}

	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(getProjectPath() + "\\Configuration\\Config.properties"));
		Object object = properties.get(key);
		String value = (String) object;
		return value;
	}
}
