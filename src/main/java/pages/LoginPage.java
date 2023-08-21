package pages;

import base.PredefinedActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PredefinedActions {

    private static LoginPage loginPage;

    @FindBy(xpath = "//div[@class='panel wrapper']//a[contains(text(),'Sign In')]")
    private WebElement signInElement;

    @FindBy(id = "email")
    private WebElement emailElement;

    @FindBy(css = "div[class='page-wrapper'] input[type='Password']")
    private WebElement passwordElement;

    @FindBy(xpath = "//div[@class='login-container']//span[text()='Sign In']")
    private WebElement loginButtonElement;

    @FindBy(xpath = "//div[@role='alert']/div/div")
    private WebElement errorMessageElement;

    private LoginPage() {

    }

    public static LoginPage getObject(){
        if(loginPage==null)
            loginPage= new LoginPage();
        PageFactory.initElements(driver, loginPage);
        return loginPage;
    }


    public void clickOnSign() {
        clickOnElement(signInElement, true);
    }

    public void enterUserNamePassword(String userName, String password) {
        enterText(emailElement, userName);
        enterText(passwordElement, password);
    }

    public void clickOnLoginButton() {
        clickOnLoginButton(loginButtonElement, false);
    }

    public String getErrorMessageText() {
        return getElementText(errorMessageElement, true);
    }

    public boolean isLoginErrorMessageDisplays() {
        return isElementDisplayed(errorMessageElement, true);
    }

}
