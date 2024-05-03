package selenium.training.pages;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewCandidatesPage extends BasePage {

    @FindBy(css = "nav[aria-label='Topbar Menu'] > ul > li:nth-child(2) a")
    public WebElement vacanciesButton;

    @FindBy(css = "nav[aria-label='Topbar Menu'] > ul > li:nth-child(1) a")
    public WebElement candidatesButton;

    public void clickButton(String buttonName) {

        switch (buttonName) {
            case "Vacancies":
                vacanciesButton.click();
                break;
            case "Candidates":
                candidatesButton.click();
                break;
            default:
                throw new InvalidArgumentException("Button with name " + buttonName + " does not exist on this page.");
        }
    }
}
