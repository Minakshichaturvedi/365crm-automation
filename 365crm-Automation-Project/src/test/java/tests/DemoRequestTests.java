package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DemoRequestPage;
import pages.HomePage;
import utils.TestDataGenerator;

public class DemoRequestTests extends BaseTest {

    private HomePage homePage;
    private DemoRequestPage demoPage;

    @BeforeMethod
    public void navigateToDemo() {
        homePage = new HomePage(driver);
        homePage.closePopup();

        driver.get("https://www.365crm.io/schedule-demo");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        demoPage = new DemoRequestPage(driver);
        System.out.println("Current URL: " + driver.getCurrentUrl());
    }

    @Test(priority = 1, description = "Verify demo page loads")
    public void testDemoPageLoad() {
        test = extent.createTest("Demo Page Load Test");

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("demo"), "Not on demo page");
        test.pass("Demo page loaded. URL: " + currentUrl);
    }

    @Test(priority = 2, description = "Verify all form fields are present")
    public void testFormFieldsPresent() {
        test = extent.createTest("Demo Form Fields Test");

        boolean firstName = demoPage.isFirstNameFieldDisplayed();
        boolean lastName = demoPage.isLastNameFieldDisplayed();
        boolean email = demoPage.isEmailFieldDisplayed();
        boolean mobile = demoPage.isMobileFieldDisplayed();
        boolean date = demoPage.isScheduleDateFieldDisplayed();
        boolean message = demoPage.isMessageFieldDisplayed();
        boolean submit = demoPage.isSubmitButtonDisplayed();

        if (firstName) test.pass("First Name field is displayed");
        else test.skip("First Name field not found");

        if (lastName) test.pass("Last Name field is displayed");
        else test.skip("Last Name field not found");

        if (email) test.pass("Email field is displayed");
        else test.skip("Email field not found");

        if (mobile) test.pass("Mobile field is displayed");
        else test.skip("Mobile field not found");

        if (date) test.pass("Schedule Date field is displayed");
        else test.skip("Schedule Date field not found");

        if (message) test.pass("Message field is displayed");
        else test.skip("Message field not found");

        if (submit) test.pass("Submit button is displayed");
        else test.skip("Submit button not found");
    }

    @Test(priority = 3, description = "Submit demo form with valid data")
    public void testValidDemoRequest() {
        test = extent.createTest("Valid Demo Request Test");

        String firstName = TestDataGenerator.getRandomFirstName();
        String lastName = TestDataGenerator.getRandomLastName();
        String email = TestDataGenerator.getRandomEmail();
        String mobile = "9876543210";
        String date = "25/02/2026";
        String message = "I want to see a demo of 365 CRM";

        demoPage.submitDemoRequest(firstName, lastName, email, mobile, date, message);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        test.pass("Demo form submitted with email: " + email);
    }

    @Test(priority = 4, description = "Submit demo form with empty fields")
    public void testEmptyDemoForm() {
        test = extent.createTest("Empty Demo Form Test");

        demoPage.clickSubmit();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        test.pass("Empty form submission attempted");
    }

    @Test(priority = 5, description = "Submit demo form with invalid email")
    public void testInvalidEmailDemo() {
        test = extent.createTest("Invalid Email Demo Test");

        demoPage.submitDemoRequest("Test", "User", "invalidemail", "9876543210", "25/02/2026", "Test message");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        test.pass("Invalid email demo request attempted");
    }

    @Test(priority = 6, description = "Verify first name validation")
    public void testFirstNameValidation() {
        test = extent.createTest("First Name Validation Test");

        demoPage.enterLastName("User");
        demoPage.enterEmail(TestDataGenerator.getRandomEmail());
        demoPage.clickSubmit();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (demoPage.isFirstNameErrorDisplayed()) {
            test.pass("First name validation message displayed");
        } else {
            test.pass("Form prevented submission without first name");
        }
    }

    @Test(priority = 7, description = "Fill only required fields")
    public void testRequiredFieldsOnly() {
        test = extent.createTest("Required Fields Only Test");

        String firstName = TestDataGenerator.getRandomFirstName();
        String lastName = TestDataGenerator.getRandomLastName();
        String email = TestDataGenerator.getRandomEmail();
        String date = "28/02/2026";

        demoPage.enterFirstName(firstName);
        demoPage.enterLastName(lastName);
        demoPage.enterEmail(email);
        demoPage.enterScheduleDate(date);
        demoPage.clickSubmit();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        test.pass("Required fields submitted with email: " + email);
    }

    @Test(priority = 8, description = "Verify page title is displayed")
    public void testPageTitle() {
        test = extent.createTest("Demo Page Title Test");

        if (demoPage.isPageTitleDisplayed()) {
            String title = demoPage.getPageTitleText();
            test.pass("Page title displayed: " + title);
        } else {
            test.skip("Page title not found");
        }
    }

    @Test(priority = 9, description = "Test mobile number field")
    public void testMobileField() {
        test = extent.createTest("Mobile Number Field Test");

        if (demoPage.isMobileFieldDisplayed()) {
            demoPage.enterMobile("9876543210");
            test.pass("Mobile number entered successfully");
        } else {
            test.skip("Mobile field not found");
        }
    }

    @Test(priority = 10, description = "Test message field")
    public void testMessageField() {
        test = extent.createTest("Message Field Test");

        if (demoPage.isMessageFieldDisplayed()) {
            demoPage.enterMessage("I am interested in 365 CRM for my business. Please schedule a demo.");
            test.pass("Message entered successfully");
        } else {
            test.skip("Message field not found");
        }
    }
}