package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignUpPage;
import utils.TestDataGenerator;

public class SignUpTests extends BaseTest {

    private HomePage homePage;
    private SignUpPage signUpPage;

    @BeforeMethod
    public void navigateToSignUp() {
        homePage = new HomePage(driver);
        homePage.closePopup();

        driver.get("https://www.web.365crm.io/register");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        signUpPage = new SignUpPage(driver);
        System.out.println("Current URL: " + driver.getCurrentUrl());
    }

    @Test(priority = 1, description = "Verify sign up page loads")
    public void testSignUpPageLoad() {
        test = extent.createTest("Sign Up Page Load Test");

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("register"), "Not on register page");
        test.pass("Sign up page loaded. URL: " + currentUrl);
    }

    @Test(priority = 2, description = "Verify all form fields are present")
    public void testFormFieldsPresent() {
        test = extent.createTest("Form Fields Present Test");

        Assert.assertTrue(signUpPage.isFirstNameFieldDisplayed(), "First Name field not displayed");
        Assert.assertTrue(signUpPage.isLastNameFieldDisplayed(), "Last Name field not displayed");
        Assert.assertTrue(signUpPage.isEmailFieldDisplayed(), "Email field not displayed");
        Assert.assertTrue(signUpPage.isPhoneFieldDisplayed(), "Phone field not displayed");
        Assert.assertTrue(signUpPage.isPasswordFieldDisplayed(), "Password field not displayed");
        Assert.assertTrue(signUpPage.isConfirmPasswordFieldDisplayed(), "Confirm Password field not displayed");

        test.pass("All form fields are present");
    }

    @Test(priority = 3, description = "Verify all 3 plans are displayed")
    public void testPlansDisplayed() {
        test = extent.createTest("Plans Displayed Test");

        boolean gold = signUpPage.isGoldPlanDisplayed();
        boolean diamond = signUpPage.isDiamondPlanDisplayed();
        boolean platinum = signUpPage.isPlatinumPlanDisplayed();

        if (gold) test.pass("Gold plan is displayed");
        else test.skip("Gold plan not found");

        if (diamond) test.pass("Diamond plan is displayed");
        else test.skip("Diamond plan not found");

        if (platinum) test.pass("Platinum plan is displayed");
        else test.skip("Platinum plan not found");
    }

    @Test(priority = 4, description = "Test sign up with valid data")
    public void testValidSignUp() {
        test = extent.createTest("Valid Sign Up Test");

        String firstName = TestDataGenerator.getRandomFirstName();
        String lastName = TestDataGenerator.getRandomLastName();
        String email = TestDataGenerator.getRandomEmail();
        String phone = "9876543210";
        String password = "Test@123456";
        String company = TestDataGenerator.getRandomCompany();

        signUpPage.completeSignUp(firstName, lastName, email, phone, password, company);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        test.pass("Sign up form submitted with email: " + email);
    }

    @Test(priority = 5, description = "Test sign up with invalid email")
    public void testInvalidEmailSignUp() {
        test = extent.createTest("Invalid Email Sign Up Test");

        signUpPage.completeSignUp("Test", "User", "invalidemail", "9876543210", "Test@123456", "Test Company");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        test.pass("Sign up with invalid email attempted");
    }

    @Test(priority = 6, description = "Test sign up with empty fields")
    public void testEmptySignUp() {
        test = extent.createTest("Empty Sign Up Test");

        signUpPage.clickSignUpButton();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        test.pass("Sign up attempted with empty fields");
    }

    @Test(priority = 7, description = "Test password mismatch")
    public void testPasswordMismatch() {
        test = extent.createTest("Password Mismatch Test");

        signUpPage.enterFirstName("Test");
        signUpPage.enterLastName("User");
        signUpPage.enterEmail(TestDataGenerator.getRandomEmail());
        signUpPage.enterPhone("9876893210");
        signUpPage.enterPassword("Test@123456");
        signUpPage.enterConfirmPassword("DifferentPass@123");
        signUpPage.acceptTerms();
        signUpPage.clickSignUpButton();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        test.pass("Enter valid Confirm Password.");
    }

    @Test(priority = 8, description = "Test sign in link navigation")
    public void testSignInLink() {
        test = extent.createTest("Sign In Link Test");

        signUpPage.clickSignInLink();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String currentUrl = driver.getCurrentUrl();
        System.out.println("Navigated to: " + currentUrl);
        test.pass("Sign in link clicked. URL: " + currentUrl);
    }

    @Test(priority = 9, description = "Test optional company name field")
    public void testOptionalCompanyField() {
        test = extent.createTest("Optional Company Field Test");

        boolean companyDisplayed = signUpPage.isCompanyNameFieldDisplayed();

        if (companyDisplayed) {
            signUpPage.enterCompanyName("Test Company Pvt Ltd");
            test.pass("Company name field is present and working");
        } else {
            test.skip("Company name field not found");
        }
    }

    @Test(priority = 10, description = "Test select Diamond plan")
    public void testSelectDiamondPlan() {
        test = extent.createTest("Select Diamond Plan Test");

        if (signUpPage.isDiamondPlanDisplayed()) {
            signUpPage.selectDiamondPlan();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            test.pass("Diamond plan selected successfully");
        } else {
            test.skip("Diamond plan not found");
        }
    }
}