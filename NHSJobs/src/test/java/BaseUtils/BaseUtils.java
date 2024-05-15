package BaseUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseUtils {

	public static WebDriver driver;
	String browserName = readProprty();
 
	public void launchBrowser() {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.jobs.nhs.uk/candidate/search");
	}
	
	
	public String readProprty()
	{
		FileInputStream objfile=null;
		try {
			objfile = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Application.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
		Properties prop = new Properties();
		try {
			prop.load(objfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String browserName = prop.getProperty("browser");
		return browserName;
	}
	
	public void enterText(By element, String text) {
		driver.findElement(element).sendKeys(text);
	}

	public void selectDropdown(By element, String text) {
		Select option = new Select(driver.findElement(element));
		option.selectByValue(text);
	}

	public void click(By element) {
		driver.findElement(element).click();
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	
}
