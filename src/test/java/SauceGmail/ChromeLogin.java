package SauceGmail;

	
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class ChromeLogin {

		public static void main(String[] args) throws InterruptedException {

			System.setProperty("webdriver.chrome.driver","chromedriver.exe");  
		      
		       // Instantiate a ChromeDriver class.       
		    WebDriver driver=new ChromeDriver();  
			driver.manage().window().maximize();

			String url = "https://accounts.google.com/signin";

			driver.get(url);

			driver.findElement(By.id("identifierId")).sendKeys("smartcoQE@gmail.com",Keys.ENTER);
		      Thread.sleep(3000);
		      driver.findElement(By.name("password")).sendKeys("Password!@#",Keys.ENTER);
		      Thread.sleep(4000);
		}

	}



