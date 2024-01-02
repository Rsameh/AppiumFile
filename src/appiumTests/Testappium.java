package appiumTests;

import java.net.URL;
import java.util.List;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Testappium {
	DesiredCapabilities caps = new DesiredCapabilities();
	AndroidDriver driver;
	
	@BeforeTest
	public void setup() {
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "QA");
		
		File MyApplicationCalculator = new File("src/MyApp/Calculatorapp/calculator.apk");
		caps.setCapability(MobileCapabilityType.APP, MyApplicationCalculator.getAbsolutePath());
	}
	
	
	
	@Test(enabled=false)
	public void Mult() throws MalformedURLException {
		driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
		driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
		driver.findElement(By.id("com.google.android.calculator:id/op_mul")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_2")).click();
		
		String Result = driver.findElement(By.id("com.google.android.calculator:id/result_preview")).getText();
		
		Assert.assertEquals(Result , "18");
	}
	
	@Test(enabled=false) 
	public void ClickAllButtons() throws MalformedURLException {
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
	
		List<WebElement> AllButtons = driver.findElements(By.className("android.widget.ImageButton"));
		for (int i=0; i<AllButtons.size(); i++) {
			if (AllButtons.get(i).getAttribute("resource-id").contains("digit")) {
				AllButtons.get(i).click();
			}
		}
	}
	
	@Test()
	public void ClickOnEvenNumber() throws MalformedURLException {

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
	
		List<WebElement> AllButtons = driver.findElements(By.className("android.widget.ImageButton"));
		for (int i=0; i<AllButtons.size(); i++) {
			if (AllButtons.get(i).getAttribute("resource-id").contains("digit")) {

				int number = Integer.parseInt(AllButtons.get(i).getAttribute("content-desc"));

				if (number % 2 == 0) {
					System.out.println(number);
					AllButtons.get(i).click(); 
				}
			}
		}
		}
	
	
	
	
	
	@AfterTest
	public void posttesting() {}
	
	
	
	
	
	
	
	
}

