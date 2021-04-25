package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ContactsInformationPage {

    AppiumDriver<MobileElement> driver;

    public ContactsInformationPage(AppiumDriver<MobileElement> driver)
    {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id="com.android.contacts:id/large_title")
    private MobileElement titleTXT;


    public String getContactName()
    {
        return titleTXT.getText();
    }
}
