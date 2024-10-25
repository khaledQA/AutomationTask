package Pages;

import Utilities.Utility;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P05_ShoppingCardPage {
    private final WebDriver driver;
    private final By proceedToCheckoutButton = By.xpath("//button[@data-test='proceed-1']");

    private final By proceedToBillingAddressBtn=By.xpath("//button[@data-test='proceed-2']");
    private final By proceedToPaymentBtn=By.xpath("//button[@data-test='proceed-3']");

    private final By paymentMethods = By.id("payment-method");
    private final By emailTxtBox = By.id("email");
    private final By passwordTxtBox = By.xpath("//input[@data-test='password']");
    private final By loginBtn = By.className("btnSubmit");
    private final By successMessage = By.className("help-block");
    private final By confirmButton = By.xpath("//button[@data-test='finish']");



    public P05_ShoppingCardPage(WebDriver driver) {
        this.driver=driver;
    }

    public P05_ShoppingCardPage CheckOut(String email, String password, String visiblePaymentMethod)
    {
        Allure.step("CheckOut Process");
        Utility.clickOnElement(driver,proceedToCheckoutButton);
        Utility.sendData(driver,emailTxtBox,email);
        Utility.sendData(driver,passwordTxtBox,password);
        Utility.clickOnElement(driver,loginBtn);

        Utility.clickOnElement(driver,proceedToBillingAddressBtn);
        Utility.generalWait(driver);
        Utility.clickOnElement(driver,proceedToPaymentBtn);
        Utility.selectByVisibleText(driver,paymentMethods,visiblePaymentMethod);
        Utility.clickOnElement(driver,confirmButton);

        return new P05_ShoppingCardPage(driver);
    }

    public String getTheConfirmationMessage()
    {
       return Utility.locatorToWebElement(driver,successMessage).getText();
    }

}
