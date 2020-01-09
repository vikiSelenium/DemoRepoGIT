import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class UpskillPractiseFireFox {

	public static void main(String[] args) {
//		System.setProperty("webdriver.chrome.driver", "E:\\Arthi\\workspace\\MavenProject\\drivers\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","E:\\Arthi\\workspace\\MavenProject\\drivers\\geckodriver.exe");

		FirefoxDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://acme-test.uipath.com/account/login");
		driver.findElementByXPath("//input[@id='email']").sendKeys("kumar.testleaf@gmail.com",Keys.TAB);
		driver.findElementByXPath("//input[@id='password']").sendKeys("leaf@12");
		driver.findElementByXPath("//button[@id='buttonLogin']").click();
		
		Actions act = new Actions(driver);
				WebElement findElementByXPath = driver.findElementByXPath("//button[text()=' Invoices']");
		act.moveToElement(findElementByXPath).build().perform();
		driver.findElementByXPath("//a[text()='Search for Invoice']").click();
		
		System.out.println(driver.getTitle());
		
		driver.findElementByXPath("//input[@id='vendorTaxID']").sendKeys("FR121212");
		driver.findElementByXPath("//button[@class='btn btn-primary' and @id='buttonSearch' and text()='Search'] ").click();
		List<WebElement> table = driver.findElementsByXPath("//table[@class='table']/tbody/tr/td[text()='IT Support']/./preceding-sibling::td[2]");
		////table[@class='table']/tbody/tr/td[text()='IT Support']/./preceding-sibling::td[2]
		////table[@class='table']/tbody/tr/td[text()='IT Support']/../td[1]
		for (WebElement ele : table) {
			
			System.out.println("The required invoice numbers are " + ele.getText());
			
		}
		driver.findElementByXPath("//a[text()='Log Out']").click();
		driver.close();

	}

}
