package page;

import base.BasePage;
import org.openqa.selenium.By;

/**
 * Page object model for the /login Page
 */
public class LoginPage extends BasePage {

    private final String PAGE_URL = "https://demoqa.com/login";

    // Locators for the elements
    private final By userNameInput = By.cssSelector("input#userName");
    private final By passwordInput = By.cssSelector("input#password");
    private final By loginButton = By.cssSelector("button#login");
    private final By errorText = By.cssSelector("div#output");
    private final By upperAddsBanner = By.xpath("//div[@id='app']/div[@class='body-height']/div[@class='container playgound-body']/div[@class='row']/div[2]/div[1]");
    private final By rightAddsBanner = By.cssSelector("section#RightSide_Advertisement");
    private final By bottomAddsBanner = By.cssSelector("div#fixedban");

    /**
     * Enters username and password
     * and clicks the login button
     */
    public void login(String username, String password) {
        setUserNameInput(username);
        setPasswordInput(password);
        clickLoginButton();
    }

    // Enters username after explicitly waiting
    private void setUserNameInput(String username) {
        waitForElement(userNameInput);
        sendKeys(userNameInput, username);
    }

    // Enters password after explicitly waiting
    private void setPasswordInput(String password) {
        waitForElement(passwordInput);
        sendKeys(passwordInput, password);
    }

    // Clicks login button after explicitly waiting and moving to it
    private void clickLoginButton() {
//        hideAdBanners();
        waitForElement(loginButton);
        moveToElement(loginButton);
        click(loginButton);
    }

    // Hides ad banners
    private void hideAdBanners() {
        hideElement(upperAddsBanner);
        hideElement(bottomAddsBanner);
        hideElement(rightAddsBanner);
    }

    /**
     * @return Returns existence of error element as Boolean
     */
    public Boolean isErrorVisible() {
        waitForElement(errorText);
        moveToElement(errorText);
        return elementExists(errorText);
    }

    /**
     * @return Returns the text of the error as String
     */
    public String GetErrorText() {
        return getText(errorText);
    }

    /**
     * @return Returns the url of the page as String
     */
    @Override
    public String getUrl() {
        return PAGE_URL;
    }

}
