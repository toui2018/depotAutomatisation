package scriptTests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JpetTest {

	WebDriver driver;
	WebDriverWait wait;
	
	private By EnterTheStoreButton = By.xpath(".//div[@id='Content']/p/a[text()='Enter the Store']");
	private By textToCheck = By.xpath(".//div[@id='PoweredBy']/a");
	
	@Before
	public void setUp() {
		FirefoxOptions options = new FirefoxOptions().setProfile(new FirefoxProfile());
		options.addPreference("browser.tabs.remote.autostart", false);
		
		System.setProperty("webdriver.gecko.driver", "C:/Users/Formation/Downloads/geckodriver-v0.19.1-win64/geckodriver.exe");
		
		driver = new FirefoxDriver(options);
		
		driver.get("http://localhost:8090/jpetstore/");

	}
	
	@Test
	public void test() {
		
		wait = new WebDriverWait(driver, 30);
		
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(EnterTheStoreButton));
		} catch (Exception e) {
		}
		
		driver.findElement(EnterTheStoreButton).click();
		System.out.println("Clic sur le bouton Enter The Store");
		
		assertEquals("www.mybatis.org", driver.findElement(textToCheck).getText());
					
	}
	

	//Ajout commentaire Master

	// Ajout commentaire maintenance 
	
	//Ajout commentaire Maintenance 2
	

	
	@After
	public void quit() {
		driver.close();
		System.out.println("Fermeture du navigateur");
		System.out.println("toto");
	}
}
