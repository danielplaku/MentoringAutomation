package selenium.training.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.training.utils.Driver;

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
        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/");
    }

}
