package selenium.training.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewEmployeeListPage extends BasePage{

    @FindBy(xpath =("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[1]/button"))
    public WebElement addButtonWebElement;

    @FindBy(css = "button[type=submit]")
    public WebElement searchWebElement;

    @FindBy(css = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[2]")
    public WebElement employeePersonalInfoCardWebElement;

    @FindBy(xpath ="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input")
    public WebElement employeeNameWebElement;

    @FindBy(xpath ="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]")
    public WebElement employeeRecordsTableWebElement;

    @FindBy(xpath ="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input")
    public WebElement employeeIdWebElement;


    public void searchEmployee(String empName) throws InterruptedException {
        Thread.sleep(3000);
        employeeNameWebElement.clear();
        employeeNameWebElement.sendKeys(empName);
        //employeeIdWebElement.sendKeys(employeeId);
        //employeePersonalInfoCardWebElement.click();
    }

    public void clickAddEmployeeButton() {
        addButtonWebElement.click();
    }

    public void clickSearchEmployeeButton() {
        searchWebElement.click();
    }

    public void clickEmployeeRecordsTable(){
        employeeRecordsTableWebElement.click();
    }
}
