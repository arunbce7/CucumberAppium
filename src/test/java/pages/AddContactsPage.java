package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddContactsPage {

    AppiumDriver<MobileElement> driver;

    public AddContactsPage(AppiumDriver<MobileElement> driver)
    {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id="com.android.contacts:id/editor_menu_save_button")
    private MobileElement addContactBTN;

    @FindBy(className = "android.widget.EditText")
    private List<MobileElement> txtInput;




    public void setName(String name)
    {
        txtInput.get(0).sendKeys(name);
    }

    public void setNumber(String number)
    {
        txtInput.get(2).sendKeys(number);
    }

    public void saveContact()
    {
        addContactBTN.click();
    }
}
