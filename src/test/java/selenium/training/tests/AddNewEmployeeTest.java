package selenium.training.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.By;
import selenium.training.pages.*;
import selenium.training.utils.Driver;

public class AddNewEmployeeTest {
    private final LoginPage loginPage;
    private final DashboardPage dashboardPage;
    private final AddEmployeePage addEmpPage;
    private final ViewEmployeeListPage viewEmployeeListPage;
    private final PersonalDetailsPage personalDetailsPage;

    public AddNewEmployeeTest() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        addEmpPage = new AddEmployeePage();
        viewEmployeeListPage = new ViewEmployeeListPage();
        personalDetailsPage = new PersonalDetailsPage();
    }

    @AfterMethod
    public void afterEach()  {
        viewEmployeeListPage.logout();
    }

    @Test
    public void addNewEmployee() throws InterruptedException {
        loginPage.login("Admin", "admin123");
        dashboardPage.clickPIMTab();
        viewEmployeeListPage.clickAddEmployeeButton();
        addEmpPage.addEmployee("John", "Doe", "Lee", "0286");
        addEmpPage.clickSaveEmployeeButton();
        personalDetailsPage.clickEmployeeListTab();
        viewEmployeeListPage.searchEmployee("John Lee");
        String firstAndMiddleName = Driver.getDriver().findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[3]")).getText();
        Assert.assertEquals(firstAndMiddleName, "John Lee");
    }
}

