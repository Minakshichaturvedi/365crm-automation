package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@placeholder='Email OR Mobile']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@placeholder='············']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//small[@class='float-end my-75 fw-bold ']")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//span[@class='a-link fw-bold']")
    private WebElement signUpLink;

    @FindBy(xpath = "//div[contains(@class,'error')]")
    private WebElement errorMessage;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement rememberMeCheckbox;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        sendKeys(emailField, email);
    }

    public void enterPassword(String password) {
        sendKeys(passwordField, password);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    public void clickRememberMe() {
        if (isDisplayed(rememberMeCheckbox)) {
            click(rememberMeCheckbox);
        }
    }

    public void clickForgotPassword() {
        click(forgotPasswordLink);
    }

    public SignUpPage clickSignUpLink() {
        click(signUpLink);
        return new SignUpPage(driver);
    }

    public boolean isErrorMessageDisplayed() {
        return isDisplayed(errorMessage);
    }

    public String getErrorMessage() {
        if (isDisplayed(errorMessage)) {
            return getText(errorMessage);
        }
        return "";
    }

    public boolean isForgotPasswordLinkDisplayed() {
        return isDisplayed(forgotPasswordLink);
    }

    public boolean isLoginButtonDisplayed() {
        return isDisplayed(loginButton);
    }
}