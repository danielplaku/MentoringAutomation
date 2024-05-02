package selenium.training.pages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RecruitmentPage extends BasePage{
    
    @FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-item' and text()='Vacancies']")
    private WebElement vacanciesTab;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]")
    public WebElement vacancyDropdown;

    @FindBy(css = "button[type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span")
    private WebElement filteredItems;

    public void clickVacanciesTab(){
        vacanciesTab.click();
    }

    public void clickVacancyDropDown() {
        vacancyDropdown.click();
    }

    public void selectVacancy(String vacancy) {
        while (!vacancyDropdown.getText().equals(vacancy)) {
            this.vacancyDropdown.sendKeys(Keys.ARROW_DOWN);
        }
        this.vacancyDropdown.sendKeys(Keys.ENTER);
    }

    public void clickSearchButton(){
        searchButton.click();
    }

    public int getFilteredItems() {
        // Define a pattern to match the number enclosed in parentheses
        String recordsFound = filteredItems.getText();
        Pattern pattern = Pattern.compile("\\((\\d+)\\)");
        Matcher matcher = pattern.matcher(recordsFound);

        // If the pattern is found, extract the number
        if (matcher.find()) {
            String numberStr = matcher.group(1);
            return Integer.parseInt(numberStr);
        } else {
            return 0;
        }
    }
}
