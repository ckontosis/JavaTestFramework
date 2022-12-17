package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.LoginPage;


public class TestInvalidPassword extends BaseTest {

    /**
     * Assert we get error when user tries to log in with wrong password
     * and gets appropriate error
     * @param username set at testng.xml test parameter
     * @param password set at testng.xml test parameter
     * @param errorText set at testng.xml test parameter
     */
    @Parameters({"username", "password", "errorText"})
    @Test(description = "Should login with valid credentials")
    public void testLoginError(String username, String password, String errorText) {
        LoginPage loginPage = new LoginPage();

        // Verify we are at Login page
        Assert.assertTrue(loginPage.amOnPage());

        // Login with provided credentials
        loginPage.login(username, password + "xx");

        // Verify we get error
        Assert.assertTrue(loginPage.isErrorVisible());

        // Verify error text is as expected
        Assert.assertEquals(loginPage.GetErrorText(), errorText);
    }

}
