package Pages;

import Utilities.Utility;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P04_ProductDetailsPage {

    private final By addToCard = By.id("btn-add-to-cart");
    private final By cardIcon = By.xpath("//span[@data-test='cart-quantity']");
    private final WebDriver driver;

    public P04_ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public P04_ProductDetailsPage clickOnAddToCard() {
        Allure.step("Click On Add To Card");
        Utility.clickOnElement(driver, addToCard);
        return this;
    }

    public P05_ShoppingCardPage clickOnShoppingCardItem() {
        Allure.step("Click On Shopping Card Item");
        Utility.clickOnElement(driver, cardIcon);
        return new P05_ShoppingCardPage(driver);
    }

    public boolean assertCheckoutURL(String expectedValue) {
        return driver.getCurrentUrl().equals(expectedValue);
    }
}
