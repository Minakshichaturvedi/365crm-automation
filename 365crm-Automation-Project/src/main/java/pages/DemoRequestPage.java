package pages;

import base.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoRequestPage extends BasePage {

    // Form Fields
    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@class='form-control phone_validate intl_mobile iti__tel-input']")
    private WebElement mobileField;

    @FindBy(xpath = "//input[@id='schedule_date']")
    private WebElement scheduleDateField;

    @FindBy(xpath = "//span[@class='select2-selection__placeholder']")
    private WebElement timeslotDropdown;

    @FindBy(xpath = "//textarea[@placeholder='Your message']")
    private WebElement messageField;

    // Submit Button
    @FindBy(xpath = "//button[@id='scheduledemobtn']")
    private WebElement submitButton;

    // Page Title
    @FindBy(xpath = "//h2[contains(text(),'Demo')] | //h1[contains(text(),'Demo')]")
    private WebElement pageTitle;

    // Error and Success Messages
    @FindBy(xpath = "//div[contains(@class,'error')] | //span[contains(@class,'error')] | //p[contains(@class,'error')]")
    private WebElement errorMessage;

    @FindBy(xpath = "//div[contains(@class,'success')] | //p[contains(@class,'success')]")
    private WebElement successMessage;

    // Validation Messages
    @FindBy(xpath = "//span[contains(text(),'Please enter first name')] | //div[contains(text(),'Please enter first name')]")
    private WebElement firstNameError;

    public DemoRequestPage(WebDriver driver) {
        super(driver);
    }

    // Input Methods
    public void enterFirstName(String firstName) {
        sendKeys(firstNameField, firstName);
    }

    public void enterLastName(String lastName) {
        sendKeys(lastNameField, lastName);
    }

    public void enterEmail(String email) {
        sendKeys(emailField, email);
    }

    public void enterMobile(String mobile) {
        sendKeys(mobileField, mobile);
    }

    public void enterScheduleDate(String date) {
        sendKeys(scheduleDateField, date);
    }

    public void enterMessage(String message) {
        sendKeys(messageField, message);
    }

    // Submit
    public void clickSubmit() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", submitButton);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        js.executeScript("arguments[0].click();", submitButton);
    }

    // Fill Complete Form
    public void fillDemoForm(String firstName, String lastName, String email,
                             String mobile, String date, String message) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        enterMobile(mobile);
        enterScheduleDate(date);
        enterMessage(message);
    }

    // Submit Complete Form
    public void submitDemoRequest(String firstName, String lastName, String email,
                                  String mobile, String date, String message) {
        fillDemoForm(firstName, lastName, email, mobile, date, message);
        clickSubmit();
    }

    // Field Verification
    public boolean isFirstNameFieldDisplayed() {
        return isDisplayed(firstNameField);
    }

    public boolean isLastNameFieldDisplayed() {
        return isDisplayed(lastNameField);
    }

    public boolean isEmailFieldDisplayed() {
        return isDisplayed(emailField);
    }

    public boolean isMobileFieldDisplayed() {
        return isDisplayed(mobileField);
    }

    public boolean isScheduleDateFieldDisplayed() {
        return isDisplayed(scheduleDateField);
    }

    public boolean isMessageFieldDisplayed() {
        return isDisplayed(messageField);
    }

    public boolean isSubmitButtonDisplayed() {
        return isDisplayed(submitButton);
    }

    public boolean isPageTitleDisplayed() {
        return isDisplayed(pageTitle);
    }

    public String getPageTitleText() {
        if (isDisplayed(pageTitle)) {
            return getText(pageTitle);
        }
        return "";
    }

    // Error and Success
    public boolean isErrorMessageDisplayed() {
        return isDisplayed(errorMessage);
    }

    public boolean isSuccessMessageDisplayed() {
        return isDisplayed(successMessage);
    }

    public boolean isFirstNameErrorDisplayed() {
        return isDisplayed(firstNameError);
    }
}