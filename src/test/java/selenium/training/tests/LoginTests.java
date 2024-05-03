package selenium.training.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import selenium.training.pages.DashboardPage;
import selenium.training.pages.LoginPage;

public class LoginTests {

    private final LoginPage loginPage;
    private final DashboardPage dashboardPage;

    public LoginTests() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
    }

    @AfterMethod
    public void afterEach() {
        dashboardPage.logout();
    }

    @Test
    public void successfulLoginTest() {
        loginPage.login("Admin", "admin123");
        //dashboardPage.logout();
    }

    @Test
    public void successfulLoginTest2() {
        loginPage.login("Admin", "admin123");
        Assert.fail();
        //loginPage.tearDown();
    }

    @Test
    public void successfulLoginTest3() {
        loginPage.login("Admin", "admin123");
    }


    /*
        1️⃣ Implement below test by following POM architecture:
        1.Go to https://opensource-demo.orangehrmlive.com/
        2.In the field 'Username' enter: WrongUsername
        3.In the 'Password' field enter: WrongPassword
        4.Click the Login button
        5.Make sure that user is not logged in successfully and
        an error message with text “Invalid credentials” is displayed
    */

    @Test
    public void unsuccessfulLoginTest() {
        loginPage.login("WrongUsername", "WrongPassword");
        Assert.assertEquals("Invalid credentials", loginPage.getErrorMessage());
    }
}
