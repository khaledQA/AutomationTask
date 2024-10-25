package Pages;

import Utilities.Utility;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_HomePage {
    private final WebDriver driver;
    private final By addProductToCart = By.xpath("//h5[text()=' Thor Hammer ']");
    private final By signInBtn = By.xpath("//a[text()='Sign in']");



    public P01_HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public P04_ProductDetailsPage clickOnProduct() {
        Allure.step("Scroll To WebElement");
        Utility.scrollToWebElement(driver,addProductToCart);
        Allure.step("Click on Add Product To Cart");
        Utility.clickOnElement(driver, addProductToCart);
        return new P04_ProductDetailsPage(driver);
    }
    public P02_LoginPage clickOnSignIn()
    {
        Allure.step("Click on Sign in Button");
        Utility.clickOnElement(driver,signInBtn);
        return new P02_LoginPage(driver);

    }
}
