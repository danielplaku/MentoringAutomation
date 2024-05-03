package selenium.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.training.utils.Driver;

import java.util.List;

public class ViewJobVacancyPage extends BasePage {

    @FindBy(css = ".oxd-form-row > div > div:nth-child(2) .oxd-select-text--after")
    public WebElement vacancyDropDownPickerElement;

    @FindBy(xpath = "//div[@role='listbox']//*[text()='Senior QA Lead']")
    public WebElement seniorQALeadElement;

    @FindBy(css = "button[type='submit']")
    public WebElement searchButtonWebElement;

    @FindBy(css = ".oxd-table-body div[role='row']")
    public List<WebElement> tableRowsElements;

    public void filterByVacancy(String position) {
        vacancyDropDownPickerElement.click();
        Driver.getDriver().findElement(By.xpath("//div[@role='listbox']//*[text()='"+position+"']")).click();
    }

    public void applyFilters() {
        searchButtonWebElement.click();
    }

    public int getNumberOfRows() {
        return tableRowsElements.size();
    }

    public String getFirstTableCellText() {
        By firstTableCellBy = By.cssSelector(".oxd-table-body > div:nth-child(1) div[role='row'] > div:nth-child(2)");
       return Driver.getDriver().findElement(firstTableCellBy).getText();
    }
}
