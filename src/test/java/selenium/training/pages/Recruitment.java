package selenium.training.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import selenium.training.utils.Wait;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Recruitment extends BasePage {
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]")
    public WebElement vacancySelectWebElement;

    @FindBy(css = "button[type='submit']")
    public WebElement searchButtonWebElement;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span")
    public WebElement recordsFoundWebElement;

    public void clickVacancySelect() {
        vacancySelectWebElement.click();
    }

    public void clickSearchButton() {
        searchButtonWebElement.click();
    }

    public void selectVacancy(String vacancy) {
        while (!vacancySelectWebElement.getText().equals(vacancy)) {
            this.vacancySelectWebElement.sendKeys(Keys.ARROW_DOWN);
        }
        this.vacancySelectWebElement.sendKeys(Keys.ENTER);
    }

    public int getRecordsFound() {
        // Define a pattern to match the number enclosed in parentheses
        String recordsFound = recordsFoundWebElement.getText();
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
