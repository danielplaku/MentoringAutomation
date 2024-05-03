package selenium.training.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import selenium.training.utils.Driver;
import selenium.training.utils.GlobalConfigs;
import selenium.training.utils.Wait;

public class LoginPage extends BasePage {

    @FindBy(css = "input[name='username']")
    private WebElement usernameWebElement;

    @FindBy(css = "input[name='password']")
    private WebElement passwordWebElement;

    @FindBy(css = "button[type='submit']")
    private WebElement loginButtonWebElement;

    @FindBy(css = ".oxd-alert-content-text")
    private WebElement errorMessageWebElement;

    public void login(String username, String password) {
        navigateToHomePage();
        usernameWebElement.clear();
        usernameWebElement.sendKeys(username);
        //password -> admin123
        passwordWebElement.clear();
        passwordWebElement.sendKeys(password);
        //click login
        loginButtonWebElement.click();
    }

    public void navigateToHomePage() {
        Driver.getDriver().get(GlobalConfigs.URL);
    }

    public String getErrorMessage() {
        Wait.getWait().until(ExpectedConditions.visibilityOf(errorMessageWebElement));
        return errorMessageWebElement.getText();
    }
}
