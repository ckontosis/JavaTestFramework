package page;

import base.BasePage;
import base.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    WebDriver driver;

    private final String PAGE_URL="https://demoqa.com/login";

    @FindBy(css="input#userName")
    private WebElement userNameInput;

    @FindBy(css="input#password")
    private WebElement passwordInput;

    @FindBy(css="button#login")
    private WebElement loginButton;

    @FindBy(css="div#output")
    private WebElement errorText;

    public LoginPage() {
        driver = DriverFactory.getWebDriver();
    }

    public void login(String username, String password) {
        setUserNameInput(username);
        setPasswordInput(password);
        clickLoginButton();
    }

    public void setUserNameInput(String username) {
        userNameInput.clear();
        userNameInput.sendKeys(username);
    }

    public void setPasswordInput(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String GetErrorText() {
        return errorText.getText();
    }

    public Boolean amOnPage() {
        return driver.getCurrentUrl().equals(PAGE_URL);
    }

}
