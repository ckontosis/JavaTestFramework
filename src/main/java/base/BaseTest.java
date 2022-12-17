package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

/**
 * Test parent class where we set logic we want to use across Test cases
 * Creating a class for each separate test case is encouraged
 */
public class BaseTest {

    WebDriver driver;

    /**
     * Before class set up method
     * Includes logic to be executed before each test
     * @param hostUrl set at testng.xml test parameter
     */
    @Parameters({"hostUrl"})
    @BeforeClass
    public void setUp(String hostUrl) {

        // Set chrome as default driver
        String browser = System.getProperty("browser", "chrome");

        // Select webdriver by browser system property
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        // Go to hostUrl page
        driver.get(hostUrl);
        // Maximize window to reduce flakiness
        driver.manage().window().maximize();
        // Pass driver to DriverFactory to delegate responsibility
        DriverFactory.setWebDriver(driver);
    }

    /**
     * After class tear down method
     * Includes logic to be executed after each test
     */
    @AfterClass
    public void tearDown() {
        // Clear cookies
        DriverFactory.getWebDriver().manage().deleteAllCookies();
        // Quit driver
        DriverFactory.getWebDriver().quit();
    }

}
