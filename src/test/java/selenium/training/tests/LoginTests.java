package selenium.training.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import selenium.training.pages.DashboardPage;
import selenium.training.pages.LoginPage;
import selenium.training.utils.Driver;

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

    @Test
    public void failureLoginTest() throws InterruptedException {
        loginPage.login("Admin", "admin1234");
        Thread.sleep(100000);

        WebElement element = Driver.getDriver().findElement(By.className("oxd-alert-content--error"));

        Assert.assertTrue(element.isDisplayed());


    }

}
