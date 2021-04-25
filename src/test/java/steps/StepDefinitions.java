package steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import appiumdriver.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.textui.TestRunner;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.*;

import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class StepDefinitions {

    public static String featureName;
    public AndroidDriver driverClass=new AndroidDriver();


    AppiumDriver<MobileElement> driver;

    private ContactsPage contactsPage;
    private ContactsInformationPage contactsInformationPage;
    private AddContactsPage addContactsPage;
    private SettingsPage settingsPage;
    private DownloadsPage downloadsPage;

    @Before
    public void before() throws MalformedURLException {
        driver=driverClass.setUpDriver();
        contactsPage=new ContactsPage(driver);
        addContactsPage=new AddContactsPage(driver);
        contactsInformationPage=new ContactsInformationPage(driver);
        settingsPage=new SettingsPage(driver);
        downloadsPage=new DownloadsPage(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void after(){
        driverClass.closeDriver();
    }

    @Given("I have an contacts app open")
    public void i_have_an_contacts_app_open() throws InterruptedException {
        Assert.assertEquals("Contacts",contactsPage.getTitle());
        contactsPage.addContact();
        //Thread.sleep(5000);
    }
    @Given("I enter {string} and {string}")
    public void i_enter_and(String string, String string2) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        addContactsPage.setName(string);
        addContactsPage.setNumber(string2);
       // Thread.sleep(5000);
    }
    @When("I tap save")
    public void i_tap_save() {
        addContactsPage.saveContact();
    }

    @Then("Contact {string} should be saved in the contact list")
    public void contact_should_be_saved_in_the_contact_list(String string) throws InterruptedException { Thread.sleep(5000);
        //Thread.sleep(5000);
        String contactName=contactsInformationPage.getContactName();
       Assert.assertEquals(string,contactName);
       driver.navigate().back();
    }


    @Given("I enter contacts setting")
    public void i_enter_contacts_setting() {

        contactsPage.clicknavigationDrawer();


    }
    @When("I import {string} file")
    public void i_import_file(String string) throws InterruptedException {
        contactsPage.clickSettings();
        settingsPage.selectImport();
        settingsPage.selectVCFImport();
        downloadsPage.searchBTNClick();
        downloadsPage.searchText(string);
        downloadsPage.searchFileClick();
    }

    @Then("Contacts should be imported to the contact list")
    public void contacts_should_be_imported_to_the_contact_list() {
       int size=contactsPage.getContactListSize();

        Assert.assertTrue("Contacts imported successfully",size>5);

    }



}
