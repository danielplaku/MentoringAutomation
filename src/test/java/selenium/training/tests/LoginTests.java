package selenium.training.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import selenium.training.pages.DashboardPage;
import selenium.training.pages.LoginPage;
import selenium.training.utils.Driver;

import java.time.Duration;

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
    public void unsuccessfulLoginTest() {
        loginPage.login("WrongUsername", "WrongPassword");
        String expectedErrorMessage = "Invalid credentials";
        WebDriverWait explicitWait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        By by = By.cssSelector("p[class='oxd-text oxd-text--p oxd-alert-content-text']");
        explicitWait.until(ExpectedConditions.textToBe(by, expectedErrorMessage));

        String invalidText = Driver.getDriver().findElement(by).getText();
        Assert.assertEquals(invalidText, expectedErrorMessage);
    }
}
