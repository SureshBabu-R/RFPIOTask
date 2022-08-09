package org.utilities;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseClass {
	public static WebDriver driver;
	public static Robot r;
	public static Actions a;
    public static Alert al;
    public static Select s;
    public static JavascriptExecutor js;
	//1 launch browser
	public static void launch() {
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();}
	    
//2 launch URL
	public static void link(String URL) {
    driver.get(URL);	}
//3 Maximize 
	public static void max() {
    driver.manage().window().maximize();	}
//4 Title
	public static String getitle() {
    System.out.println( driver.getTitle());
	return null;
		}
//5 Getlink
	public static void getlink() {
	System.out.println(driver.getCurrentUrl());	}	
//6 Sendkeys
	public static void fill(WebElement ele,String value) {
	ele.sendKeys(value);}
//7 Click
	public static void clk(WebElement ele) {
	ele.click();}
//8 Close
	public static void clos() {
    driver.close();}
//9 quit
	public static void qit() {
    driver.quit();}
//10 submit
	public void sumit(WebElement ele) {
    ele.submit();}
//clear
	public static void clr(WebElement e) {
		e.clear();}

//11 text
	public static String gettext(WebElement e) {
		String text = e.getText();
		return text;}

//12 Attribute
	public static String getattr(WebElement e) {
		String attribute = e.getAttribute("value");
		return attribute;}
//13 movetoelement
    public static void move(WebElement ele) {
    a.moveToElement(ele).perform();}
//14 dragdrop
	public static void dragdrop(WebElement src, WebElement des) {
    a.dragAndDrop(src, des).perform();}
//15 Doubleclick
	public static void dclick(WebElement ele) {
    a.doubleClick(ele).perform();}
//16 Right click
	public static void rclick(WebElement ele) {
	a.contextClick(ele).perform();}
// Actions click
	public static void aclick(WebElement ele) {
		a.click(ele).perform();
	}
//17 Shift click
	public static void shift(WebElement ele, String value) {
    a.keyDown(Keys.SHIFT).perform();
    a.sendKeys(ele,"value");
    a.keyUp(Keys.SHIFT).perform();}
//18 Enter
	public static void robotEnter() throws AWTException {
	 r=new Robot();
     r.keyPress(KeyEvent.VK_ENTER);
     r.keyRelease(KeyEvent.VK_ENTER); }
//19 Down
     public static void robotDown() throws AWTException {
      r=new Robot();
      r.keyPress(KeyEvent.VK_ENTER);
      r.keyRelease(KeyEvent.VK_ENTER);}
//20 Accept 
     public static void acpt() {
     al=driver.switchTo().alert();
     al.accept(); }
 //21 Dismiss
     public static void Dmiss() {
     al=driver.switchTo().alert();
     al.dismiss();	}
 //21 textaccept
     public static void txtalert() {
 		Alert a = driver.switchTo().alert();
 		a.sendKeys("yes");
 		a.accept();}
   //22 selectByIndex
 	public static void selectByIndex(WebElement e, int index) {
 		 s = new Select(e);
 		s.selectByIndex(index);	} 
 	//23 selectByValue

 	public static void selectByValue(WebElement e, String value) {
 		Select s = new Select(e);
 		s.selectByValue(value);}

 // 24 selectByVisibleText
 	public static void selectByVisibleText(WebElement e, String text) {
 		 s = new Select(e);
 		s.selectByVisibleText(text);}

 //25 deselectByValue
 	public static void deselectByValue(WebElement e, String value) {
 		 s = new Select(e);
 		s.deselectByValue(value);	}

 //26 deselectByIndex
 	public static void deselectByIndex(WebElement e, int index) {
 		 s = new Select(e);
 		s.deselectByIndex(index);	}

 //27 deselectByVisibleText
 	public static void deselectByVisibleText(WebElement e, String text) {
 		 s = new Select(e);
 		s.deselectByVisibleText(text);
 	}

 //28 deselectAll
 	public static void deselectAll(WebElement e) {
 		 s = new Select(e);
 		s.deselectAll();
 	}

 //29 getOptions
 	public static int getOptions(WebElement e) {
 		 s = new Select(e);
 		List<WebElement> options = s.getOptions();
 		int size = options.size();
 		return size;
 	}

 //30 getFirstSelectedOption
 	public static String getFirstSelectedOption(WebElement e, String text) {
 		 s = new Select(e);
 		WebElement firstSelectedOption = s.getFirstSelectedOption();
 		String text2 = firstSelectedOption.getText();
 		return text2;
 	}

 //31 getAllSelectedOption
 	public static String getAllSelectedOption(WebElement e) {
 		 s = new Select(e);
 		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
 		for (int i = 0; i < allSelectedOptions.size(); i++) {
 			WebElement webElement = allSelectedOptions.get(i);
 			String text = webElement.getText();
 		}
 		return null;
 	}

 //32 isMultiple
 	public static boolean isMultiple(WebElement e) {
 		 s = new Select(e);
 		boolean multiple = s.isMultiple();
 		return multiple;
 	}

 //33 frameID
     public static void frameID(String ID) {
    driver.switchTo().frame(ID);	}
 //34 frameName
     public static void frameName(String name) {
    driver.switchTo().frame(name);}
 // 35 frameWebele
     public static void frameweb(WebElement ele) {
    driver.switchTo().frame(ele);}
 // 36 frameint
     public static void frameint(int i) {
	driver.switchTo().frame(i);}
// 37 Screenshot
     public static void getScreenShotAs(String fileName) throws IOException {
 		TakesScreenshot tk = (TakesScreenshot) driver;
 		File src = tk.getScreenshotAs(OutputType.FILE);
 		File des = new File("" + fileName + ".png");
 		FileUtils.copyFile(src, des); 	}
   //38  setAttribute
 	public static void setAttribute(String txt, WebElement e) {
 		 js = (JavascriptExecutor) driver;
 		js.executeScript("arguments[0].setAttribute('value','" + txt + "')", e);
 	}

 //39  getAttribute
 	public static String getAttribute1(WebElement e) {
 		 js = (JavascriptExecutor) driver;
 		Object executeScript = js.executeScript("return argument[0].getAttribute('value')", e);
 		String value = executeScript.toString();
 		return value;
 	}
 	
 	//40  jsClick
	public static void jsClick(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click", e);
	}

 	//41 scrollDown
 		public static void scrollDown(WebElement e) throws InterruptedException {
 			 js = (JavascriptExecutor) driver;
 			js.executeScript("arguments[0].scrollIntoView(true)", e);
 			Thread.sleep(5000);}

 	//42 scrollUp
 		public static void scrollUp(WebElement e) throws InterruptedException {
 			 js = (JavascriptExecutor) driver;
 			js.executeScript("arguments[0].scrollIntoView(false)", e);
 			Thread.sleep(5000);
 		}
 		//43 getWindowHandle
 		public static void getWindowHandle() {
 			String parentId = driver.getWindowHandle();
 			Set<String> allIds = driver.getWindowHandles();
 			for (String eachId : allIds) {
 				if (!parentId.equals(eachId)) {
 					driver.switchTo().window(eachId);
 				}
 			}}
 			//Wait
 			public static void iWait(long time) {
 				driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
 			}
 			//isDisplayed
 
// 44 Date driven excel read
 			public static String getData(int rowNumber ,int cellNumber)throws IOException {
           File f=new File ("C:\\Users\\sanjay\\eclipse\\java-2021-12\\eclipse\\CucumberProject\\target\\Testdata\\One.xlsx");
           FileInputStream fin=new FileInputStream(f);
           Workbook w =new XSSFWorkbook(fin);
    		
    		Sheet sheet = w.getSheet("One");
            Row row = sheet.getRow(rowNumber);
    		Cell cell = row.getCell(cellNumber);
            
    		int cellType = cell.getCellType();
    		String value="";
    		if(cellType==1) {
    			 value = cell.getStringCellValue();
    		}
    		else if(DateUtil.isCellDateFormatted(cell)) {
    			Date d = cell.getDateCellValue();
    			SimpleDateFormat sim=new SimpleDateFormat("dd MMM yyyy z");
    			 value = sim.format(d);
    		}
    		else {
    			double d = cell.getNumericCellValue();
    			long l=(long)d;
    			 value = String.valueOf(l);
    			 
    			
    		}
    		return value;
    		
    			}
 			//navigateUrl
 			public static void navigateUrl(String Url) {
 				driver.navigate().to(Url);
 			}

 		//navigateBack
 			public static void navigateBack() {
 				driver.navigate().back();
 			}

 		//navigateForward
 			public static void navigateForward() {
 				driver.navigate().forward();
 			}

 		//refresh
 			public static void refresh() {
 				driver.navigate().refresh();
 			}

			}




	
