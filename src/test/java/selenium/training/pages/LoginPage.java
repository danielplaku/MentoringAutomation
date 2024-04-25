package selenium.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.training.utils.Driver;
import selenium.training.utils.GlobalConfigs;

public class LoginPage extends BasePage {

    @FindBy(css = "input[name='username']")
    public WebElement usernameWebElement;

    @FindBy(css = "input[name='password']")
    public WebElement passwordWebElement;

    @FindBy(css = "button[type='submit']")
    public WebElement loginButtonWebElement;

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

}
