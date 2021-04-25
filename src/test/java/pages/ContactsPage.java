package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ContactsPage {

    AppiumDriver<MobileElement> driver;

    public ContactsPage(AppiumDriver<MobileElement> driver)
    {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(className = "android.widget.TextView")
    private MobileElement titleTXT;

    @FindBy(id = "com.android.contacts:id/floating_action_button")
    private MobileElement addContactBTN;

    @FindBy(xpath="//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")
    private MobileElement navigationDrawer;

    @FindBy(id = "com.android.contacts:id/drawer")
    private MobileElement settingsFrame;

    @FindBy(className = "android.widget.ImageView")
    private List<MobileElement> settingsITEM;

    @FindBy(className = "android.widget.TextView")
    private List<MobileElement> contactList;

    public String getTitle()
    {
       return titleTXT.getText();
    }

    public void addContact()
    {
        addContactBTN.click();
    }

    public void clicknavigationDrawer()
    {
        navigationDrawer.click();
    }

    public void clickSettings()
    {
       settingsITEM.get(2).click();
    }
    public String getContactName(String name)
    {
        return driver.findElementByAccessibilityId(name).getText();
    }

    public int getContactListSize()
    {
        return contactList.size();
    }
}
