package page;

import base.BasePage;
import base.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    WebDriver driver;

    WebDriverWait wait;

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
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        setUserNameInput(username);
        setPasswordInput(password);
        clickLoginButton();
    }

    public void setUserNameInput(String username) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(userNameInput));
        userNameInput.clear();
        userNameInput.sendKeys(username);
    }

    public void setPasswordInput(String password) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
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
