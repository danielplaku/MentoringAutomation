package selenium.training.tests;

import org.openqa.selenium.Keys;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import selenium.training.pages.DashboardPage;
import selenium.training.pages.LoginPage;
import selenium.training.pages.Recruitment;

public class LoginTests {

    private final LoginPage loginPage;
    private final DashboardPage dashboardPage;
    private final Recruitment recruitmentTab;
    private final String wrongUsername;
    private final String wrongPassword;
    private final String username;
    private final String password;

    public LoginTests() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        recruitmentTab = new Recruitment();
        wrongUsername = "WrongUsername";
        wrongPassword = "WrongPassword";
        username = "Admin";
        password = "admin123";
    }

    @AfterMethod
    public void afterEach(ITestResult result) {
        if (!result.getMethod().getMethodName().equals("unsuccessfulLoginTest")) {
            dashboardPage.logout();
        }
    }

    @Test
    public void successfulLoginTest() {
        loginPage.login(username, password);
        //dashboardPage.logout();
    }

    @Test
    public void successfulLoginTest2() {
        loginPage.login(username, password);
        Assert.fail();
        //loginPage.tearDown();
    }

    @Test
    public void successfulLoginTest3() {
        loginPage.login(username, password);
    }

    /**
     * ▪Implement below test by following POM architecture:
     * 1.Go to https://opensource-demo.orangehrmlive.com/
     * 2.In the field 'Username' enter: WrongUsername
     * 3.In the 'Password' field enter: WrongPassword
     * 4.Click the Login button
     * 5.Make sure that user is not logged in successfully and an error message
     * with text “Invalid credentials” is displayed
     */
    @Test
    public void unsuccessfulLoginTest() throws InterruptedException {
        loginPage.login(wrongUsername, wrongPassword);
        Assert.assertEquals(loginPage.getErrorMessage(), LoginPage.INVALID_CREDENTIALS);
    }

    /**
     * ▪Implement below test by following POM architecture:
     * 1.Go to https://opensource-demo.orangehrmlive.com/
     * 2.In the field 'Username' enter: Admin
     * 3.In the 'Password' field enter: admin123
     * 4.Click the Login button
     * 5.From the sidebar menu navigate to Recruitment item
     * 6.Click on Vacancies tab
     * 7.From Vacancy drop-down choose option 'Senior QA Lead’
     * 8.Click on Search button
     */
    @Test
    public void searchVacancyTest() throws InterruptedException {
        loginPage.login(username, password);
        dashboardPage.clickRecruitmentTab();
        recruitmentTab.clickVacancySelect();
        recruitmentTab.selectVacancy("Senior QA Lead");
        recruitmentTab.clickSearchButton();
        Assert.assertNotEquals(0, recruitmentTab.getRecordsFound());
    }

}
