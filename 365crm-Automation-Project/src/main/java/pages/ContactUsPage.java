package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends BasePage {

    @FindBy(xpath = "//div[@class='col-md-6']//input[@id='name']")
    private WebElement nameField;

    @FindBy(xpath = "//div[@class='col-12']//input[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = "//div[@class='col-md-6']//input[@id='mobile']")
    private WebElement phoneField;

    

    @FindBy(xpath = "//div[@class='col-12']//textarea[@id='message']")
    private WebElement messageField;

    @FindBy(xpath = "//input[@id='getintouchbtn']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[contains(@class,'success')]")
    private WebElement successMessage;

    @FindBy(xpath = "//div[contains(@class,'error')]")
    private WebElement errorMessage;

    @FindBy(xpath = "//h1[contains(text(),'Contact')]")
    private WebElement pageTitle;

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isContactPageDisplayed() {
        return isDisplayed(pageTitle);
    }

    public void fillContactForm(String name, String email, String phone,  String message) {
        if (isDisplayed(nameField)) sendKeys(nameField, name);
        if (isDisplayed(emailField)) sendKeys(emailField, email);
        if (isDisplayed(phoneField)) sendKeys(phoneField, phone);
        if (isDisplayed(messageField)) sendKeys(messageField, message);
    }

    public void clickSubmit() {
        click(submitButton);
    }

    public void submitContactForm(String name, String email, String phone, String message) {
        fillContactForm(name, email, phone,  message);
        clickSubmit();
    }

    public boolean isSuccessMessageDisplayed() {
        return isDisplayed(successMessage);
    }

    public boolean isErrorMessageDisplayed() {
        return isDisplayed(errorMessage);
    }

    public String getSuccessMessage() {
        if (isDisplayed(successMessage)) {
            return getText(successMessage);
        }
        return "";
    }
}