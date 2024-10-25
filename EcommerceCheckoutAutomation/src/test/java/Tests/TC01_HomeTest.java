package Tests;

import DriverFactory.DriverFactory;
import Pages.P01_HomePage;
import Pages.P05_ShoppingCardPage;
import Utilities.DataUtils;
import io.qameta.allure.Allure;
import jdk.jfr.Description;
import net.bytebuddy.implementation.bytecode.Throw;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Listeners.ITestResultListener;

import java.io.IOException;

import static DriverFactory.DriverFactory.*;
import static Utilities.Utility.takeScreenShot;

@Listeners({ITestResultListener.class})
public class TC01_HomeTest {
    private final String FIRSTNAME = DataUtils.getJsonData("validRegistration", "firstName");
    private final String LASTNAME = DataUtils.getJsonData("validRegistration", "lastName");
    private final String DOB = DataUtils.getJsonData("validRegistration", "dateOfBirth");
    private final String ADDRESS = DataUtils.getJsonData("validRegistration", "address");
    private final String POSTCODE = DataUtils.getJsonData("validRegistration", "postCode");
    private final String CITY = DataUtils.getJsonData("validRegistration", "city");
    private final String STATE = DataUtils.getJsonData("validRegistration", "state");
    private final String PHONE = DataUtils.getJsonData("validRegistration", "phone");
    private final String EMAIL = DataUtils.getJsonData("validRegistration", "email");
    private final String PASSWORD = DataUtils.getJsonData("validRegistration", "password");


    @BeforeMethod
    public void setUp() throws IOException {
        DriverFactory.setUpDriver("chrome");
        driver.get(DataUtils.getPropertyValue("environments", "HOME_URL"));
    }

    @Description("Valid Checkout Test Case")
    @Test(enabled = true)
    public void checkOutProcess() {
        new P01_HomePage(driver)
                .clickOnSignIn()
                .clickOnRegisterYourAccountBtn()
                .fillRegistrationForm(FIRSTNAME, LASTNAME, DOB, ADDRESS, POSTCODE, CITY, STATE, PHONE, EMAIL, PASSWORD)
                .clickOnRegisterBtn()
                .login(EMAIL, PASSWORD)
                .navigateToHomePage()
                .clickOnProduct()
                .clickOnAddToCard()
                .clickOnShoppingCardItem()
                .CheckOut(EMAIL, PASSWORD, "Cash on Delivery");
        Assert.assertTrue(new P05_ShoppingCardPage(driver).getTheConfirmationMessage().equals("Payment was successful"));

    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
