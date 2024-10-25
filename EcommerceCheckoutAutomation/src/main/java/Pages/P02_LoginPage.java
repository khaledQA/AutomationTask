package Pages;

import Utilities.Utility;
import io.qameta.allure.Allure;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P02_LoginPage {
    private final WebDriver driver;
    private final By registerYourAccountBtn = By.xpath("//a[text()='Register your account']");
    private final By emailTxtBox = By.id("email");
    private final By loginBtn = By.className("btnSubmit");
    private final By passwordTxtBox = By.xpath("//input[@data-test='password']");
    private final By homeBtn = By.xpath("//a[text()='Home']");

    public P02_LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    public P03_RegistrationPage clickOnRegisterYourAccountBtn()
    {
        Allure.step("Click on Register Your Account Button");
        Utility.clickOnElement(driver,registerYourAccountBtn);
        return new P03_RegistrationPage(driver);
    }

    @Description("This method for login.")
    public P02_LoginPage login(String email, String password)
    {
        Allure.step("Enter Valid Data To Login.");
        Utility.urlToBe(driver,"https://practicesoftwaretesting.com/auth/login");
        Utility.sendData(driver,emailTxtBox,email);
        Utility.sendData(driver,passwordTxtBox,password);
        Utility.clickOnElement(driver,loginBtn);
        return this;
    }

    public P01_HomePage navigateToHomePage()
    {
        Allure.step("Navigate To Home Page");
        Utility.clickOnElement(driver,homeBtn);
        return  new P01_HomePage(driver);
    }


}
