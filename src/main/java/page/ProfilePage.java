package page;

import base.BasePage;
import base.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage {

    WebDriver driver;

    WebDriverWait wait;

    private final String PAGE_URL="https://demoqa.com/profile";

    @FindBy(xpath = "//button[text()='Log out']")
    private WebElement logoutButton;

    @FindBy(css="label#userName-value")
    private WebElement username;

}
