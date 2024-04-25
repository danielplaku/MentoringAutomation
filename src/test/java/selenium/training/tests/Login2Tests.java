package selenium.training.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import selenium.training.pages.DashboardPage;
import selenium.training.pages.LoginPage;

public class Login2Tests {

    private final LoginPage loginPage;
    private final DashboardPage dashboardPage;

    public Login2Tests() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
    }

//    @AfterClass
//    static void closeDriver() {
//        Driver.getDriver().quit();
//    }

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

        //loginPage.tearDown();
    }

    @Test
    public void successfulLoginTest3() {
        loginPage.login("Admin", "admin123");
    }

}
