package SauceGmail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class GmailClickonSubject {

	public static final String USERNAME = "ceverticals";
	public static final String ACCESS_KEY = "01ab271b-b715-40b4-aa91-36dd6a825260";
	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

	public static void main(String[] args) throws InterruptedException, MalformedURLException {

		MutableCapabilities sauceOptions = new MutableCapabilities();

		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setExperimentalOption("w3c", true);
		browserOptions.setCapability("platformName", "Windows 10");
		browserOptions.setCapability("browserVersion", "75.0");
		browserOptions.setCapability("sauce:options", sauceOptions);

		WebDriver driver = new RemoteWebDriver(new URL(URL), browserOptions);
		// WebDriver driver = new RemoteWebDriver(new URL(URL), browserOptions);
		System.out.println("Sauce connection initiated");
		driver.get("https://www.gmail.com/");
		System.out.println("gmail login opened");

		driver.findElement(By.id("identifierId")).sendKeys("smartcoQE@gmail.com", Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		System.out.println("username entered");

		driver.findElement(By.name("password")).sendKeys("Password!@#", Keys.ENTER);
		System.out.println("Password entered");
		// driver.close();

		List<WebElement> a = driver.findElements(By.xpath("//*[@class='yW']/span"));

		System.out.println(a.size());
		for (int i = 0; i <a.size(); i++) {
			System.out.println(a.get(i).getText()); 
		

			if (a.get(i).getText().equals("Google")) {
			a.get(i).click();
			}
		}
		}
	}


