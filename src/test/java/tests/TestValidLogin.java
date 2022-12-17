package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.LoginPage;
import page.ProfilePage;


public class TestValidLogin extends BaseTest {

    /**
     * Assert user is logged in and is at Profile Page
     * username displayed is correct
     * and after logout user is redirected to Login page
     * @param username set at testng.xml test parameter
     * @param password set at testng.xml test parameter
     */
    @Parameters({"username", "password"})
    @Test(description = "Should login with valid credentials")
    public void testLogin(String username, String password) {
        LoginPage loginPage = new LoginPage();
        ProfilePage profilePage = new ProfilePage();

        // Verify we are at Login page
        Assert.assertTrue(loginPage.amOnPage());

        // Login with provided credentials
        loginPage.login(username,password);

        // Verify we are redirected to Profile page and logged-in user is correct
        profilePage.waitForPage();
        Assert.assertTrue(profilePage.amOnPage());
        Assert.assertEquals(profilePage.getUsername(), username);

        // Logout
        profilePage.logout();

        // verify we are redirected back to Login page
        loginPage.waitForPage();
        Assert.assertTrue(loginPage.amOnPage());
    }

}
