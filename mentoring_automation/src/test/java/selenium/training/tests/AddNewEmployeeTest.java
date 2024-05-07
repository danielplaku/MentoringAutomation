package selenium.training.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.By;
import selenium.training.pages.*;
import selenium.training.utils.Driver;

public class AddNewEmployeeTest {
    private LoginPage login;
    private DashboardPage dashboard;
    private AddEmployeePage addEmpPage;
    private ViewEmployeeListPage viewEmployeeListPage;
    private PersonalDetailsPage personalDetailsPage;

    public AddNewEmployeeTest() {
        login = new LoginPage();
        dashboard = new DashboardPage();
        addEmpPage = new AddEmployeePage();
        viewEmployeeListPage = new ViewEmployeeListPage();
        personalDetailsPage = new PersonalDetailsPage();
    }

    /*@AfterMethod
    public void afterEach()  {
        Driver.getDriver().close();}
    Driver.getDriver().quit();
    }*/

    @Test
    public void addNewEmployee() throws InterruptedException {
        login.login("Admin", "admin123");
        dashboard.clickPIMTab();
        viewEmployeeListPage.clickAddEmployeeButton();
        addEmpPage.addEmployee("John", "Harry", "Lee", "0286");
        addEmpPage.clickSaveEmployeeButton();
        personalDetailsPage.clickEmployeeListTab();
        viewEmployeeListPage.searchEmployee("John Doe");
        String firstAndMiddleName = Driver.getDriver().findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[3]")).getText();
        Assert.assertEquals(firstAndMiddleName, "John James");
    }
}

