package SauceGmail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SauceFirefox {

	public static final String USERNAME = "ceverticals";
	public static final String ACCESS_KEY = "01ab271b-b715-40b4-aa91-36dd6a825260";
	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

	public static void main(String[] args) throws InterruptedException, MalformedURLException {

		MutableCapabilities sauceOptions = new MutableCapabilities();

		FirefoxOptions browserOptions = new FirefoxOptions();
		browserOptions.setCapability("platformName", "Windows 10");
		browserOptions.setCapability("browserVersion", "69.0");
		browserOptions.setCapability("sauce:options", sauceOptions);

		WebDriver driver = new RemoteWebDriver(new URL(URL), browserOptions);
		System.out.println("Sauce connection initiated");
		driver.get("https://www.gmail.com/");
		System.out.println("gmail login opened");

		driver.findElement(By.id("identifierId")).sendKeys("smartcoQE@gmail.com", Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		System.out.println("username entered");

		driver.findElement(By.name("password")).sendKeys("Password!@#", Keys.ENTER);
		System.out.println("Password entered");
		// driver.close();
		List<WebElement> email = driver.findElements(By.xpath("//*[@id=\":2a\"]"));

		for(WebElement emailsub : email){
		    if(emailsub.getText().equals("FW: We’ve issued you a refund") == true){

		           emailsub.click();
		           break;
		        }
		    }
	}

}
