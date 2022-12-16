package tests;

import base.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.LoginPage;


public class TestValidLogin extends BaseTest {

    /**
     * Assert card price matches the shopping cart subtotal value
     */
    @Parameters({"correctUserName", "correctPassword"})
    @Test(description = "Should login with valid credentials")
    public void testLogin(String correctUserName, String correctPassword){
        LoginPage loginPage = new LoginPage();
        loginPage.login(correctUserName,correctPassword);
    }

}
