package page;

import base.BasePage;
import base.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BooksPage extends BasePage {

    WebDriver driver;

    WebDriverWait wait;

    private final String PAGE_URL="https://demoqa.com/books";

    // Web Elements of the page
    @FindBy(css="button#login")
    private WebElement loginButton;

    @FindBy(css="label#userName-value")
    private WebElement username;

    // Constructor
    public BooksPage() {
        driver = DriverFactory.getWebDriver();
    }


    public void clickLoginButton() {
        loginButton.click();
    }

    public Boolean amOnPage() {
        return driver.getCurrentUrl().equals(PAGE_URL);
    }

}
