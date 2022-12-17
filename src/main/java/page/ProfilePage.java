package page;

import base.BasePage;
import org.openqa.selenium.By;

/**
 * Page object model for the /profile Page
 */
public class ProfilePage extends BasePage {

    private final String PAGE_URL="https://demoqa.com/profile";

    // Locators for the elements
    private final By logoutButton = By.xpath("//button[text()='Log out']");
    private final By username = By.cssSelector("label#userName-value");

    /**
     * @return Returns the text of the username element as String
     */
    public String getUsername() {
        return getText(username);
    }

    /**
     * Clicks the logout button
     */
    public void logout() {
        waitForElement(logoutButton);
        moveToElement(logoutButton);
        click(logoutButton);
    }

    /**
     * @return Returns the url of the page as String
     */
    @Override
    public String getUrl() {
        return PAGE_URL;
    }
}
