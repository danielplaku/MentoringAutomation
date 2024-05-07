package selenium.training.tests;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import selenium.training.pages.DashboardPage;
import selenium.training.pages.LoginPage;
import selenium.training.pages.ViewCandidatesPage;
import selenium.training.pages.ViewJobVacancyPage;
import selenium.training.utils.Driver;

public class RecruitmentTest {

    public LoginPage loginPage;
    public DashboardPage dashboardPage;
    public ViewCandidatesPage viewCandidatesPage;
    public ViewJobVacancyPage viewJobVacancyPage;

    public RecruitmentTest() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        viewCandidatesPage = new ViewCandidatesPage();
        viewJobVacancyPage = new ViewJobVacancyPage();
    }

//    @AfterMethod
//    public void afterEach() {
//        Driver.getDriver().close();
//    }

    @Test
    public void filterVacanciesByVacancyFilterTest() throws InterruptedException {

        loginPage.login("Admin", "admin123");

        dashboardPage.clickRecruitmentTab();

        viewCandidatesPage.clickButton("Vacancies");


        viewJobVacancyPage.filterByVacancy("Senior QA Lead");

        Thread.sleep(3000);

        viewJobVacancyPage.applyFilters();

        Thread.sleep(3000);

        //Verify that following item is filtered out
        int actualRows = viewJobVacancyPage.getNumberOfRows();
        Assertions.assertEquals(1, actualRows);
        Assertions.assertEquals("Senior QA Lead", viewJobVacancyPage.getFirstTableCellText());
    }

}
