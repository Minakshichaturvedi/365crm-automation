package pages;

import base.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage extends BasePage {

    @FindBy(xpath = "//input[@placeholder='Enter First Name']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@placeholder='Enter Last Name']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@placeholder='Enter Email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@value='+91']")
    private WebElement phoneField;

    @FindBy(xpath = "//input[@placeholder='Enter Password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@placeholder='Enter Confirm Password']")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//input[@placeholder='Enter Company Name']")
    private WebElement companyNameField;

    @FindBy(xpath = "//input[@placeholder='Enter GST Number']")
    private WebElement gstNumberField;

    @FindBy(xpath = "//label[@class='fw-bolder cursor-pointer fs-6 text-primary form-label']")
    private WebElement couponCodeField;

    @FindBy(xpath = "//div[@class='select__value-container select__value-container--has-value css-1hwfws3']")
    private WebElement timezoneDropdown;

    @FindBy(xpath = "//div[@class='d-flex justify-content-center align-items-center cursor-pointer card_pack_active card']//p[1]")
    private WebElement goldPlan;

    @FindBy(xpath = "//div[@class='d-flex justify-content-center align-items-center cursor-pointer card_pack_active card']")
    private WebElement diamondPlan;

    @FindBy(xpath = "//div[@class='d-flex justify-content-center align-items-center cursor-pointer card_pack_active card']")
    private WebElement platinumPlan;

    @FindBy(xpath = "//input[@name='terms']")
    private WebElement termsCheckbox;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement signUpButton;

    @FindBy(xpath = "//span[normalize-space()='Sign in instead']")
    private WebElement signInLink;

    @FindBy(xpath = "//div[contains(@class,'error')] | //span[contains(@class,'error')] | //div[contains(@class,'alert')]")
    private WebElement errorMessage;

    @FindBy(xpath = "//div[contains(@class,'success')]")
    private WebElement successMessage;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void enterFirstName(String firstName) {
        sendKeys(firstNameField, firstName);
    }

    public void enterLastName(String lastName) {
        sendKeys(lastNameField, lastName);
    }

    public void enterEmail(String email) {
        sendKeys(emailField, email);
    }

    public void enterPhone(String phone) {
        sendKeys(phoneField, phone);
    }

    public void enterPassword(String password) {
        sendKeys(passwordField, password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        sendKeys(confirmPasswordField, confirmPassword);
    }

    public void enterCompanyName(String companyName) {
        sendKeys(companyNameField, companyName);
    }

    public void enterGSTNumber(String gstNumber) {
        sendKeys(gstNumberField, gstNumber);
    }

    public void enterCouponCode(String couponCode) {
        sendKeys(couponCodeField, couponCode);
    }

    public void selectGoldPlan() {
        scrollToElement(goldPlan);
        click(goldPlan);
    }

    public void selectDiamondPlan() {
        scrollToElement(diamondPlan);
        click(diamondPlan);
    }

    public void selectPlatinumPlan() {
        scrollToElement(platinumPlan);
        click(platinumPlan);
    }

    public boolean isGoldPlanDisplayed() {
        return isDisplayed(goldPlan);
    }

    public boolean isDiamondPlanDisplayed() {
        return isDisplayed(diamondPlan);
    }

    public boolean isPlatinumPlanDisplayed() {
        return isDisplayed(platinumPlan);
    }

    // FIXED - acceptTerms using JavaScript click
    public void acceptTerms() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", termsCheckbox);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!termsCheckbox.isSelected()) {
            js.executeScript("arguments[0].click();", termsCheckbox);
        }
    }

    // FIXED - clickSignUpButton using JavaScript click
    public void clickSignUpButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", signUpButton);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        js.executeScript("arguments[0].click();", signUpButton);
    }

    public LoginPage clickSignInLink() {
        scrollToElement(signInLink);
        click(signInLink);
        return new LoginPage(driver);
    }

    public void completeSignUp(String firstName, String lastName, String email,
                               String phone, String password, String companyName) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        enterPhone(phone);
        enterPassword(password);
        enterConfirmPassword(password);
        enterCompanyName(companyName);
        acceptTerms();
        clickSignUpButton();
    }

    public boolean isFirstNameFieldDisplayed() {
        return isDisplayed(firstNameField);
    }

    public boolean isLastNameFieldDisplayed() {
        return isDisplayed(lastNameField);
    }

    public boolean isEmailFieldDisplayed() {
        return isDisplayed(emailField);
    }

    public boolean isPhoneFieldDisplayed() {
        return isDisplayed(phoneField);
    }

    public boolean isPasswordFieldDisplayed() {
        return isDisplayed(passwordField);
    }

    public boolean isConfirmPasswordFieldDisplayed() {
        return isDisplayed(confirmPasswordField);
    }

    public boolean isCompanyNameFieldDisplayed() {
        return isDisplayed(companyNameField);
    }

    public boolean isSignUpButtonDisplayed() {
        return isDisplayed(signUpButton);
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

    public boolean isSuccessMessageDisplayed() {
        return isDisplayed(successMessage);
    }
}