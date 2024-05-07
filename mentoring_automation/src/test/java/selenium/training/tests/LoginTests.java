package selenium.training.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import selenium.training.pages.DashboardPage;
import selenium.training.pages.LoginPage;

public class LoginTests {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;

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

}
