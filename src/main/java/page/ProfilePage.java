package page;

import base.BasePage;
import base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage {

    WebDriver driver;

    private final String PAGE_URL="https://demoqa.com/profile";

    By logoutButton = By.xpath("//button[text()='Log out']");
    By username = By.cssSelector("label#userName-value");

    public ProfilePage() {
        driver = DriverFactory.getWebDriver();
    }

}
