package selenium.training.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.training.utils.Driver;

public class BasePage {

    protected BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = ".oxd-topbar-header-userarea ul[class='oxd-dropdown-menu'] li:nth-child(4)")
    private WebElement logoutButtonWebElement;

    @FindBy(css = ".oxd-topbar-header-userarea .oxd-userdropdown-icon")
    private WebElement openProfileWebElement;

    public void logout() {
        openProfileWebElement.click();
        logoutButtonWebElement.click();
        Assertions.assertTrue(Driver.getDriver().getCurrentUrl().endsWith("/auth/login"));
    }
}
