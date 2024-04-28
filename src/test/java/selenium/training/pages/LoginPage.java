package selenium.training.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import selenium.training.utils.Driver;
import selenium.training.utils.GlobalConfigs;
import selenium.training.utils.Wait;

public class LoginPage extends BasePage {

    public static final String INVALID_CREDENTIALS = "Invalid credentials";

    @FindBy(css = "input[name='username']")
    public WebElement usernameWebElement;

    @FindBy(css = "input[name='password']")
    public WebElement passwordWebElement;

    @FindBy(css = "button[type='submit']")
    public WebElement loginButtonWebElement;

    @FindBy(css = ".oxd-text.oxd-text--p.oxd-alert-content-text")
    public WebElement errorMessageWebElement;

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
        // add explicit wait for error message to be displayed
        Wait.getWait().until(ExpectedConditions.visibilityOf(errorMessageWebElement));
        return errorMessageWebElement.getText();
    }
}
