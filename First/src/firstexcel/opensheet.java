package firstexcel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class opensheet {

	 public static  void main(String args[]) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Devi Gandhi\\eclipse-workspace\\First\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable notifications");
		DesiredCapabilities dp= new DesiredCapabilities();
		dp.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(dp);
		
		//Excel
		FileInputStream file1 = new FileInputStream("C:\\Users\\Devi Gandhi\\Desktop\\Selenium test.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file1);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("http://172.232.75.138/HR-Management/");
		driver.manage().window().maximize();
		//Login//
		driver.findElement(By.xpath("//*[@id=\"login_email\"]")).sendKeys(sheet.getRow(2).getCell(0).getStringCellValue());
		driver.findElement(By.xpath("//*[@id=\"login_password\"]")).sendKeys(sheet.getRow(2).getCell(1).getStringCellValue());
		driver.findElement(By.xpath("//*[@id=\"login\"]/div[4]/div/div/div/div/button")).click();
		String Title= driver.getTitle();
		System.out.println(Title);
		
		
		workbook.close();
		
		
		driver.close();
		driver.quit();
			}
		



}

