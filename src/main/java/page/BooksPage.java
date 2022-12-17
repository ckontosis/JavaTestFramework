package page;

import base.BasePage;
import org.openqa.selenium.By;

/**
 * Page object model for the /books Page
 */
public class BooksPage extends BasePage {

    private final String PAGE_URL="https://demoqa.com/books";

    // By locators for the  Elements
    private final By loginButton = By.cssSelector("button#login");
    private final By username = By.cssSelector("label#userName-value");

    /**
     * @return Returns the url of the page as String
     */
    @Override
    public String getUrl() {
        return PAGE_URL;
    }
}
