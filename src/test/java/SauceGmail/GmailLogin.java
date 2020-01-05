package SauceGmail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailLogin {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();

		String url = "https://accounts.google.com/signin";

		driver.get(url);

		driver.findElement(By.id("identifierId")).sendKeys("smartcoQE@gmail.com",Keys.ENTER);
	      Thread.sleep(3000);
	      driver.findElement(By.name("password")).sendKeys("Password!@#",Keys.ENTER);
	      Thread.sleep(4000);
	}

}
