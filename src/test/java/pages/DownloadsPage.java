package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DownloadsPage {

    AppiumDriver<MobileElement> driver;

    public DownloadsPage(AppiumDriver<MobileElement> driver)
    {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @FindBy(id="com.google.android.documentsui:id/option_menu_search")
    private MobileElement searchBTN;

    @FindBy(id="com.google.android.documentsui:id/search_src_text")
    private MobileElement searchTXT;

    @FindBy(id="android:id/title")
    private MobileElement searchFile;

    public void searchBTNClick()
    {
        searchBTN.click();
    }

    public void searchText(String text)
    {
        searchTXT.sendKeys(text);
    }

    public void searchFileClick() {
        searchFile.click();
    }
}
