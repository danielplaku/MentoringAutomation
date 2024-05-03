package selenium.training.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

    @FindBy(css = "a[href='/web/index.php/pim/viewPimModule']")
    private WebElement pimTabWebElement;

    @FindBy(xpath = "//*[@id='app']/div[1]/div[1]/aside/nav/div[2]/ul/li[5]")
    private WebElement recruitmentTabWebElement;

    public void clickPIMTab() {
        pimTabWebElement.click();
    }

    public void clickRecruitmentTab() {
        recruitmentTabWebElement.click();
    }
}
