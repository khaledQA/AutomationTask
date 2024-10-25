package Utilities;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Utility {

    private static final String SCREENSHOT_PATH = "test-outputs/ScreenShots";

    public static void clickOnElement(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();

    }

    public static void urlToBe (WebDriver driver, String url)
    {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlToBe(url));
    }
    public static void sendData(WebDriver driver, By locator, String text )
    {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(text);
    }

    public static WebElement locatorToWebElement(WebDriver driver, By locator) {
        return driver.findElement(locator);
    }

    public static void scrollToWebElement(WebDriver driver, By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", locatorToWebElement(driver, locator));

    }
    public static String getTimestamp() {
        return new SimpleDateFormat("yyyy-mm-dd-h-ssa").format(new Date());

    }

    @Attachment(value = "Screenshot on failure", type = "image/png")
    public static void takeScreenShot(WebDriver driver, String screenshotName) {

        try {
            //Capture screenshot using TakeScreenshot
            File screenSource = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            //Save screenshot to a file
            File screenDestination = new File(SCREENSHOT_PATH + screenshotName + "-" + getTimestamp() + ".png");
            FileUtils.copyFile(screenSource, screenDestination);

            //Attach the screenshot to allure
            Allure.addAttachment(screenshotName, Files.newInputStream(Path.of(screenDestination.getPath())));
        } catch (Exception e) {
            e.getMessage();
        }
    }
    public static void selectByVisibleText(WebDriver driver, By locator, String visibleText) {
        Select select = new Select(locatorToWebElement(driver,locator));
        select.selectByVisibleText(visibleText);
    }

    public static void selectByIndex(WebDriver driver, By locator, int index) {
        Select select = new Select(locatorToWebElement(driver,locator));
        select.selectByIndex(index);
    }

    public static void clearTextBox(WebDriver driver, By locator)
    {
        driver.findElement(locator).clear();
    }

    public static WebDriverWait generalWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(5));
    }



}
