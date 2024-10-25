package DriverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    public static WebDriver driver;

    // Method to initialize WebDriver
    public static void setUpDriver(String browser) {

        // Method to initialize WebDriver
        switch (browser.toLowerCase())
        {
            case"chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--start-maximized");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver(edgeOptions);
        }
        // Set default wait times
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    // Method to quit the driver
    public void tearDown() {
         driver.quit();
    }
}
