package tests;

import base.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.LoginPage;


public class TestValidLogin extends BaseTest {

//    @Parameters({"correctUserName", "correctPassword"})
    @Test
    public void testLogin(){
        LoginPage loginPage = new LoginPage();
        loginPage.login("upstream","Asd123!.");
    }

}
