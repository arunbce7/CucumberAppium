package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SettingsPage {

    AppiumDriver<MobileElement> driver;

    public SettingsPage(AppiumDriver<MobileElement> driver)
    {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(className = "android.widget.TextView")
    private List<MobileElement> listElements;

    @FindBy(className = "android.widget.TextView")
    private List<MobileElement> importlistElements;

    public void selectImport()
    {
        listElements.get(13).click();
    }

    public void selectVCFImport()
    {
        importlistElements.get(1).click();
    }
}
