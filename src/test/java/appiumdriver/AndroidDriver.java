package appiumdriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.junit.runner.RunWith;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


public class AndroidDriver {

	AppiumDriver<MobileElement> driver;
	
	public AppiumDriver<MobileElement> setUpDriver() throws MalformedURLException
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("deviceName", "sdk_gphone_x86_arm");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "11");
		
		cap.setCapability("appPackage", "com.android.contacts");
		cap.setCapability("appActivity", "com.android.contacts.activities.PeopleActivity");
		cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true);


		URL url =new URL("http://127.0.0.1:4723/wd/hub");
		driver=new AppiumDriver<MobileElement>(url,cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Application Started");
		return driver;
	}
	
	
	public void closeDriver(){
		  
		  if(driver!=null) {
		   driver.quit();
		  }
     }

}
