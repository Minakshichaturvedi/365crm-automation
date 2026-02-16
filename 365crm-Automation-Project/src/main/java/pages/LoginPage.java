package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    
    WebDriver driver;
    
    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    // Page Elements - UPDATE LOCATORS BASED ON 365CRM
    @FindBy(xpath = "//input[@placeholder='Email OR Mobile']")  // UPDATE THIS
    WebElement usernameField;
    
    @FindBy(xpath = "//input[@placeholder='············']")  // UPDATE THIS
    WebElement passwordField;
    
    @FindBy(xpath = "//button[@type='submit']")  // UPDATE THIS
    WebElement loginButton;
    
    @FindBy(xpath = "//div[@class='error-message']")  // UPDATE THIS
    WebElement errorMessage;
    
    // Action Methods
    public void enterUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }
    
    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    
    public void clickLogin() {
        loginButton.click();
    }
    
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
    
    public String getErrorMessage() {
        return errorMessage.getText();
    }
    
    public boolean isLoginButtonDisplayed() {
        return loginButton.isDisplayed();
    }
}