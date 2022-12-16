package page;

import base.BasePage;
import base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    WebDriver driver;

    private final String PAGE_URL="https://demoqa.com/login";

    By userNameInput = By.cssSelector("input#userName");
    By passwordInput = By.cssSelector("input#password");
    By loginButton = By.cssSelector("button#login");
    By errorText = By.cssSelector("div#output");

    public LoginPage() {
        driver = DriverFactory.getWebDriver();
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        setUserNameInput(username);
        setPasswordInput(password);
        clickLoginButton();
    }

    public void setUserNameInput(String username) {
        waitForElement(userNameInput);
        sendKeys(userNameInput, username);
    }

    public void setPasswordInput(String password) {
        waitForElement(passwordInput);
        sendKeys(passwordInput, password);
    }

    public void clickLoginButton() {
        waitForElement(loginButton);
        click(loginButton);
    }

    public String GetErrorText() {
        return getText(errorText);
    }

    public Boolean amOnPage() {
        return driver.getCurrentUrl().equals(PAGE_URL);
    }

}
