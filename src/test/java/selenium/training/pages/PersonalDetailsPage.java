package selenium.training.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalDetailsPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]")
    private WebElement EmployeeListTabWebElement;

    public void clickEmployeeListTab() {
        EmployeeListTabWebElement.click();
    }
}
