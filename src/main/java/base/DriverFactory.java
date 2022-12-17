package base;

import org.openqa.selenium.WebDriver;

/**
 * Implement Singleton design pattern
 * pass same instance of the driver across session pages
 * we never expose the webdriver directly
 */
public class DriverFactory {

    // Thread safe Webdriver
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    /**
     * Getter for driver
     * */
    public static WebDriver getWebDriver(){
        return webDriver.get();
    }

    /**
     * Setter for driver
     * */
    public static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }

}
