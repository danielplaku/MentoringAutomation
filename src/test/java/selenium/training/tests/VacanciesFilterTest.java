package selenium.training.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.training.pages.DashboardPage;
import selenium.training.pages.LoginPage;
import selenium.training.pages.ViewCandidatesPage;
import selenium.training.pages.ViewVacanciesPage;

public class VacanciesFilterTest {

    private final LoginPage loginPage;
    private final DashboardPage dashboardPage;
    private final ViewCandidatesPage viewCandidatesPage;
    private final ViewVacanciesPage viewVacanciesPage;

    public VacanciesFilterTest() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        viewCandidatesPage = new ViewCandidatesPage();
        viewVacanciesPage = new ViewVacanciesPage();
    }

//    @AfterMethod
//    public void afterEach() {
//        Driver.getDriver().close();
//    }

    /*
        2️⃣ Implement below test by following POM architecture:
        1.Go to https://opensource-demo.orangehrmlive.com/
        2.In the field 'Username' enter: Admin
        3.In the 'Password' field enter: admin123
        4.Click the Login button
        5.From the sidebar menu navigate to Recruitment item
        6.Click on Vacancies tab
        7.From Vacancy drop-down choose option 'Senior QA Lead’
        8.Click on Search button
    */

    @Test
    public void filterVacanciesByVacancyFilterTest() throws InterruptedException {

        loginPage.login("Admin", "admin123");

        dashboardPage.clickRecruitmentTab();

        viewCandidatesPage.clickButton("Vacancies");

        //From Vacancy drop-down choose option 'Senior QA Lead’
        viewVacanciesPage.filterByVacancy("Senior QA Lead");

        viewVacanciesPage.applyFilters();

        //Verify that following item is filtered out
        int actualRows = viewVacanciesPage.getNumberOfRows();
        Assert.assertEquals(1, actualRows);
        Assert.assertEquals("Senior QA Lead", viewVacanciesPage.getFirstTableCellText());
    }
}
