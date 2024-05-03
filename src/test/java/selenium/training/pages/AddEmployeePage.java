package selenium.training.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddEmployeePage extends BasePage{
    @FindBy(css = "input[name='firstName']")
    private WebElement employeeFirstNameWebElement;

    @FindBy(css = "input[name='middleName']")
    private WebElement employeeMiddleNameWebElement;

    @FindBy(css = "input[name='lastName']")
    private WebElement employeeLastNameWebElement;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input")
    private WebElement employeeIdWebElement;

    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[2]/div/label/span")
    private WebElement createLoginDetailsWebElement;

    @FindBy(css = "button[type='submit']")
    private WebElement saveButtonWebElement;

    public void addEmployee(String firstName, String lastName, String middleName, String empId) throws InterruptedException {
        Thread.sleep(2000);
        employeeFirstNameWebElement.clear();
        employeeFirstNameWebElement.sendKeys(firstName);

        employeeMiddleNameWebElement.clear();
        employeeMiddleNameWebElement.sendKeys(middleName);

        employeeLastNameWebElement.clear();
        employeeLastNameWebElement.sendKeys(lastName);

        employeeIdWebElement.clear();
        employeeIdWebElement.sendKeys(empId);
    }

    public void clickSaveEmployeeButton() {
        saveButtonWebElement.click();
    }
}
