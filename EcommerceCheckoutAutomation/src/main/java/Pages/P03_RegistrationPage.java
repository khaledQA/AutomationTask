package Pages;

import Utilities.Utility;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03_RegistrationPage {

    private final By firstNameTxtBox = By.id("first_name");
    private final By lastNameTxtBox = By.id("last_name");
    private final By dateOfBirthTxtBox = By.id("dob");
    private final By addressTxtBox = By.id("address");
    private final By postcodeTxtBox = By.id("postcode");
    private final By cityTxtBox = By.id("city");
    private final By stateTxtBox = By.id("state");
    private final By countryDropDown = By.xpath("//select[contains(@class,'form-select')]");
    private final By phoneTxtBox = By.id("phone");
    private final By emailTxtBox = By.id("email");
    private final By passwordTxtBox = By.xpath("//input[@data-test='password']");
    private final By registerBtn = By.xpath("//button[contains(@class,'btnSubmit')]");

    private final WebDriver driver;

    public P03_RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public P03_RegistrationPage fillRegistrationForm(String fName, String lName, String dob, String address, String postCode, String city, String state, String phone, String email, String password) {
        Allure.step("Fill the registration form with valid data");
        Utility.sendData(driver, firstNameTxtBox, fName);
        Utility.sendData(driver, lastNameTxtBox, lName);
        Utility.sendData(driver, dateOfBirthTxtBox, dob);
        Utility.sendData(driver, addressTxtBox, address);
        Utility.sendData(driver, postcodeTxtBox, postCode);
        Utility.sendData(driver, cityTxtBox, city);
        Utility.sendData(driver, stateTxtBox, state);
        Utility.selectByVisibleText(driver,countryDropDown,"Egypt");
        Utility.sendData(driver, phoneTxtBox, phone);
        Utility.clearTextBox(driver,emailTxtBox);
        Utility.sendData(driver, emailTxtBox, email);
        Utility.clearTextBox(driver,passwordTxtBox);
        Utility.sendData(driver, passwordTxtBox, password);
        return this;
    }




    public P02_LoginPage clickOnRegisterBtn() {
        Allure.step("Click on Register Button");
        Utility.clickOnElement(driver, registerBtn);
        return new P02_LoginPage(driver);
    }
}
