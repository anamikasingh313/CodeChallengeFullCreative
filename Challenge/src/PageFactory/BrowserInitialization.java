package PageFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserInitialization {
	public WebDriver driver;
public WebDriver initializeDriver() throws IOException {
	Properties prop=new Properties();
	FileInputStream fis=new FileInputStream("C:\\Users\\Anamika Singh\\eclipse-workspace\\Challenge\\data.properties");
	prop.load(fis);
	String BrowserName=prop.getProperty("browser");
	String st=prop.getProperty("url");
	if(BrowserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Anamika Singh\\Downloads\\Chrome_new\\chromedriver.exe");
		driver=new ChromeDriver();
		
	}
	else if(BrowserName.equals("firefox")) {
		// include code for firefox
}
	else if(BrowserName.equals("IE")) {
		//include code for IE
	}
	driver.get(st);
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	return driver;
}
}
