package Tests;

import DriverFactory.DriverFactory;
import Pages.P01_HomePage;
import Utilities.DataUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static DriverFactory.DriverFactory.driver;

public class TC03_RegistrationTests {
    private final String FIRSTNAME = DataUtils.getJsonData("validRegistration", "firstName");
    private final String LASTNAME = DataUtils.getJsonData("validRegistration", "lastName");
    private final String DOD = DataUtils.getJsonData("validRegistration", "dateOfBirth");
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
        driver.get(DataUtils.getPropertyValue("environments","HOME_URL"));
    }

    @Test
    public void register()
    {
        new P01_HomePage(driver)
                .clickOnSignIn()
                .clickOnRegisterYourAccountBtn()
                .fillRegistrationForm(FIRSTNAME,LASTNAME,DOD,ADDRESS,POSTCODE,CITY,STATE,PHONE,EMAIL,PASSWORD)
                .clickOnRegisterBtn();

    }


    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
