package page;

import base.BasePage;
import base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BooksPage extends BasePage {

    WebDriver driver;
    private final String PAGE_URL="https://demoqa.com/books";

    // By locators of the  Elements
    By loginButton = By.cssSelector("button#login");
    By username = By.cssSelector("label#userName-value");


    // Constructor
    public BooksPage() {
        driver = DriverFactory.getWebDriver();
    }


    public void clickLoginButton() {
        click(loginButton);
    }

    public Boolean amOnPage() {
        return driver.getCurrentUrl().equals(PAGE_URL);
    }

}
