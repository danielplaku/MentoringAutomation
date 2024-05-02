package selenium.training.tests;

import org.junit.Test;
import org.testng.Assert;

import selenium.training.pages.DashboardPage;
import selenium.training.pages.LoginPage;
import selenium.training.pages.RecruitmentPage;

public class RecruitmentTest {
    private LoginPage login;
    private DashboardPage dashboard;
    private RecruitmentPage recruitment;

    public RecruitmentTest(){
        login = new LoginPage();
        dashboard = new DashboardPage();
        recruitment = new RecruitmentPage();
    }

    @Test
    public void recruitmentTest(){
        login.login("Admin", "admin123");
        dashboard.clickRecruitmentTab();
        recruitment.clickVacanciesTab();
        recruitment.selectVacancy("Senior QA Lead");
        recruitment.clickSearchButton();
        Assert.assertNotEquals(0, recruitment.getFilteredItems());
    }
}

