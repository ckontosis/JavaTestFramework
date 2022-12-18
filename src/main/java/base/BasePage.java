package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page parent class where all the business logic is implemented
 */
public abstract class BasePage {

    private WebDriverWait wait;

    // Default timeout for explicit waits in SECONDS
    private final int TIMEOUT = 10;

    /**
     * Sends text to element
     * @param locator expects Selenium By locator for element to send text
     * @param text to send to element
     */
    public void sendKeys(By locator, String text) {
        clearText(locator);
        DriverFactory.getWebDriver().findElement(locator).sendKeys(text);
    }

    /**
     * Clicks element
     * @param locator expects Selenium By locator for element to click
     */
    public void click(By locator) {
        DriverFactory.getWebDriver().findElement(locator).click();
    }

    /**
     * Gets the text of element
     * @param locator expects Selenium By locator for element to get text from
     * @return element text as String
     */
    public String getText(By locator) {
        return DriverFactory.getWebDriver().findElement(locator).getText();
    }

    /**
     * Clears text of element
     * @param locator expects Selenium By locator for element to clear text
     */
    public void clearText(By locator) {
        DriverFactory.getWebDriver().findElement(locator).clear();
    }

    /**
     * Abstract method returning url for current page
     */
    public abstract String getUrl();

    /**
     * Compares driver current URL with Page object URL
     * @return comparison result as Boolean
     */
    public Boolean amOnPage() {
        return getUrl().compareTo(DriverFactory.getWebDriver().getCurrentUrl()) == 0;
    }

    /**
     * Explicitly waits for element
     * @param locator expects Selenium By locator for element to wait for
     */
    protected void waitForElement(By locator) {
        wait = new WebDriverWait(DriverFactory.getWebDriver(), Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * Explicitly waits for page
     */
    public void waitForPage() {
        wait = new WebDriverWait(DriverFactory.getWebDriver(), Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.urlToBe(getUrl()));
    }

    /**
     * Moves element to the center of the view
     * @param locator expects Selenium By locator for element to move in view
     */
    protected void moveToElement(By locator) {
        ((JavascriptExecutor)DriverFactory.getWebDriver())
                .executeScript(
                        "arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})",
                        DriverFactory.getWebDriver().findElement(locator)
                );
    }

    /**
     * Adds hidden value to element
     * @param locator expects Selenium By locator for element to hide
     */
    protected void hideElement(By locator) {
        ((JavascriptExecutor)DriverFactory.getWebDriver())
                .executeScript(
                        "arguments[0].style.visibility='hidden'",
                        DriverFactory.getWebDriver().findElement(locator)
                );
    }

    /**
     * Checks if element exists
     * @param locator expects Selenium By locator for element to search
     */
    protected Boolean elementExists(By locator) {
        return !DriverFactory.getWebDriver().findElements(locator).isEmpty();
    }

}
