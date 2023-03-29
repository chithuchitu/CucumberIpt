package com.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

	public static WebDriver driver ;

		public static WebDriver launchBrowser(String browsername) {

				if (browsername.equalsIgnoreCase("Chrome")) {
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					driver.manage().window().maximize();
					
				} else if (browsername.equalsIgnoreCase("firefox")) {
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					driver.manage().window().maximize();
				}
					else if (browsername.equalsIgnoreCase("edge")) {
						
					WebDriverManager.edgedriver().setup();
					 driver = new EdgeDriver();
					 driver.manage().window().maximize();
					
				}
					else {
						System.out.println("Invalid Browser");
					}
				 return driver;

			}

	public static void chromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
	}
	

	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public static String title() {
		String t = driver.getTitle();
		return t;
	}

	public static String currentUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}

	public static void closeBrowser() {
		driver.close();
	}

	public static void passValue(WebElement element, String value) {
		element.sendKeys(value);

	}

	public static void Click(WebElement element) {
		element.click();

	}

//   ===========Take screenshot======

	public static void screenshot(String fileName) throws IOException {
		// (child refname = (child) parent ref;
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\mithun\\eclipse-workspace\\CucumberIpt\\Screenshot" + fileName);
		FileUtils.copyFile(src, dest);

	}

//	===Actions===
	static Actions a;

	public static void mouseHover(WebElement element, WebDriver driver) {
		a = new Actions(driver);
		a.click(element);

	}

	// ==== ACTIONS =======//
	// Actions a = new Actions(driver);

	// Actions ---- Drag and Drop
	public void dragAndDrop(WebElement source, WebElement destination) {
		// a= new Actions(driver);
		a.dragAndDrop(source, destination).perform();
		;
	}

	// Actions =--moveToElement////
	public static void moveToElement(WebElement element, String options) {
		if (options.equalsIgnoreCase("click")) {
			a.click(element);
		} else if (options.equalsIgnoreCase("move")) {
			a.moveToElement(element).perform();

		} else if (options.equalsIgnoreCase("right")) {
			a.contextClick(element).perform();

		} else if (options.equalsIgnoreCase("double")) {
			a.doubleClick(element).perform();

		} else if (options.equalsIgnoreCase("hold")) {
			a.clickAndHold(element);

		}
	}

	public static void copy() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);

	}

//	        =========Js Executor======
	static JavascriptExecutor js;

	public static void passValueJS(WebElement element, String value) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);

	}

//                 ====Alert======
	static Alert al;

	public static void acceptAlert() {
		al = driver.switchTo().alert();
		al.accept();

	}

	public static void dismissAlert() {
		al = driver.switchTo().alert();
		al.dismiss();
	}

	public static void switchToframe(int index, String id, WebElement element) {
		driver.switchTo().frame(index);
	}

	// Use Drop Doon
	public static Select useDropDown(WebElement element) {

		Select s = new Select(element);
		return s;
	}

	// Select By Value
	public static void selectByValue(WebElement element, String value) {
		useDropDown(element).selectByValue(value);
	}

	// Select By Index
	public static void selectByIndex(WebElement element, int indexValue) {
		useDropDown(element).selectByIndex(indexValue);
	}

	// Select by VisibleText
	public void selectByVisibleText(WebElement element, String visibleText) {
		useDropDown(element).selectByVisibleText(visibleText);
	}

	// JavaScriptExecutor - Scroll up and Down
	public static void scrollUpDown(WebElement element, String scroll) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(scroll, element);

	}

	// get window handles
	public static void windowhandles() {
		Set<String> allid = driver.getWindowHandles();
		System.out.println(allid);
		for (String id : allid) {
			String title = driver.switchTo().window(id).getTitle();
			System.out.println(title);
	}
	}
//get window handle
	public static void windowhandle() {
		String id = driver.getWindowHandle();
		System.out.println(id);
	}
	

	//enable
		public static void isenable(WebElement element) {
			System.out.println(element.isEnabled());
		}

	// displayed
		public static void isdisplayed(WebElement element) {
			System.out.println(element.isDisplayed());
		}
	//	selected
		public static void isselected(WebElement element) {
			System.out.println(element.isSelected());
		}
		//implicit wait
		public static void implicitwait(int sec) {
			driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
		}

	// web-table AllDatas

		public static void webtableAllDatas(List<WebElement> elements) {
			List<WebElement> datas = elements;
			for (WebElement allDatas : datas) {
				System.out.println(allDatas.getText());
			}
		}
	//web-table rowDatas

		public static void webtableRowDatas(List<WebElement> elements) {
			List<WebElement> rDatas = elements;
			for (WebElement rowDatas : rDatas) {
				System.out.println(rowDatas.getText());
			}
		}
	//web-table columnDatas
		public static void webtableCoulmnDatas(List<WebElement> elements) {
			List<WebElement> cDatas = elements;
			for (WebElement columnDatas : cDatas) {
				System.out.println(columnDatas.getText());
			}
		}
	// web-table singleDatas
	public static void webtableSingleData(WebElement element) {
	System.out.println(element.getText());
	}
	
	
	
	
	

	// Navigator

	public static void navigateBack() {
		driver.navigate().back();
	}

	public static void navigateRefresh() {
		driver.navigate().refresh();
	}

	// Radio Button
	public static void clickRadioButton(WebElement element) {
		element.click();
	}

//	
	public static void writeExcel(String sheetName, int row, int cell, String value) throws IOException {
		// File Path
		//C:\Users\mithun\eclipse-workspace\CucumberIpt\Screenshot
		File f = new File("C:\\Users\\mithun\\eclipse-workspace\\CucumberIpt\\Excel\\text.xlsx");

//Create Workbook
		// workbook-- sheet -->> row-->cell--> data
		Workbook workbook = new XSSFWorkbook();
//	   create sheet
		Sheet sh = workbook.createSheet(sheetName);
//	   Create row
		Row r = sh.createRow(row);

//	   Create cell
		Cell c = r.createCell(cell);
		// Set cell data
		c.setCellValue(value);
//write to excel file
		FileOutputStream fos = new FileOutputStream(f);
		workbook.write(fos);
		System.out.println("write...");

	}

//  Create new cell in existing workbook
//    create cell
	public static void creteCell(String sheetName, int row, int cell, String Value) throws IOException {
		// file path
		File f = new File("C:\\Users\\KEERTHI\\eclipse-workspace\\Revision_Frameworks\\Excel\\test.xlsx");
		// Read file
		FileInputStream fis = new FileInputStream(f);
		// Exisiting workbook-->--exisiting sheet --> new cell-->data
//	    read workbook
		Workbook workbook = new XSSFWorkbook(fis);
//	    Get sheet
		Sheet sh = workbook.getSheet(sheetName);
//	    get row
		Row r = sh.createRow(row);
//	    create cell
		Cell c = r.createCell(cell);
//	    set cell data
		c.setCellValue(Value);
//	    write file
		FileOutputStream fos = new FileOutputStream(f);
		workbook.write(fos);
		System.out.println("write...");

	}

	public static void updateCell(String sheetName, int row, int cell, String newValue, String oldValue)
			throws IOException {
//	file path
		File f = new File("C:\\Users\\KEERTHI\\eclipse-workspace\\Revision_Frameworks\\Excel\\test.xlsx");
//	  read file 
		FileInputStream fis = new FileInputStream(f);
		Workbook workbook = new XSSFWorkbook();
		// existing workobbok--> existing sheet---> exsiting row--->>exisiting
		// cell--->data
		Sheet sh = workbook.getSheet(sheetName);
		Row r = sh.getRow(row);
		Cell c = r.getCell(cell);
		String existingValue = c.getStringCellValue();
		if (existingValue.equals(oldValue)) {

			// set cell data
			c.setCellValue(newValue);

		}
		// write file
		FileOutputStream fos = new FileOutputStream(f);
		workbook.write(fos);

	}
}
	
