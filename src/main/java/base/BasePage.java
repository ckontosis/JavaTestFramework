package base;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriverWait wait;

    public void sendKeys(By locator, String text) {
        DriverFactory.getWebDriver().findElement(locator).clear();
        DriverFactory.getWebDriver().findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        DriverFactory.getWebDriver().findElement(locator).click();
    }

    public String getText(By locator) {
        return DriverFactory.getWebDriver().findElement(locator).getText();
    }

    // Set explicit wait for element
    public void waitForElement(By locator) {
        wait = new WebDriverWait(DriverFactory.getWebDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

}
