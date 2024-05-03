package selenium.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import selenium.training.utils.Driver;
import selenium.training.utils.Wait;

import java.util.List;

public class ViewVacanciesPage extends BasePage {

    @FindBy(css = ".oxd-form-row > div > div:nth-child(2) .oxd-select-text--after")
    private WebElement vacancyDropDownPickerElement;

    @FindBy(css = "button[type='submit']")
    private WebElement searchButtonWebElement;

    @FindBy(css = ".oxd-table-body div[role='row']")
    private List<WebElement> tableRowsElements;

    public void filterByVacancy(String position) {
        vacancyDropDownPickerElement.click();
        Driver.getDriver().findElement(By.xpath("//div[@role='listbox']//*[text()='" + position + "']")).click();
    }

    public void applyFilters() {
        searchButtonWebElement.click();
    }

    public int getNumberOfRows() {
        Wait.getWait().until(ExpectedConditions.visibilityOfAllElements(tableRowsElements));
        return tableRowsElements.size();
    }

    public String getFirstTableCellText() {
        By firstTableCellBy = By.cssSelector(".oxd-table-body > div:nth-child(1) div[role='row'] > div:nth-child(2)");
        return Driver.getDriver().findElement(firstTableCellBy).getText();
    }
}
