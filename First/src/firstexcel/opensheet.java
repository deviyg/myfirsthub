package firstexcel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class opensheet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Devi Gandhi\\eclipse-workspace\\First\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		
		options.addArguments("--disable notifications");
		DesiredCapabilities dp= new DesiredCapabilities();
		dp.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(dp);
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("http://172.232.75.138/HR-Management/");
		driver.manage().window().maximize();
		driver.close();
		
		

	}

}
