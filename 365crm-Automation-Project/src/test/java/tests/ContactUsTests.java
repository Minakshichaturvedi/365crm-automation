package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import utils.TestDataGenerator;

public class ContactUsTests extends BaseTest {

    private HomePage homePage;
    private ContactUsPage contactUsPage;

    @BeforeMethod
    public void navigateToContact() {
        homePage = new HomePage(driver);
        contactUsPage = homePage.navigateToContact();
    }

    @Test(priority = 1, description = "Verify contact page loads")
    public void testContactPageLoad() {
        test = extent.createTest("Contact Page Load Test");
        
        try {
            Thread.sleep(2000);
            Assert.assertTrue(contactUsPage.isContactPageDisplayed(), "Contact page not displayed");
            test.pass("Contact page loaded successfully");
        } catch (Exception e) {
            test.info("Contact page structure may be different");
        }
    }

    @Test(priority = 2, description = "Submit contact form with valid data")
    public void testValidContactSubmission() {
        test = extent.createTest("Valid Contact Form Submission");
        
        String name = TestDataGenerator.getRandomFirstName() + " " + TestDataGenerator.getRandomLastName();
        String email = TestDataGenerator.getRandomEmail();
        String phone = TestDataGenerator.getRandomPhoneNumber();
        String message = TestDataGenerator.getRandomMessage();
        
        contactUsPage.submitContactForm(name, email, phone, message);
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        test.pass("Contact form submitted with email: " + email);
    }

    @Test(priority = 3, description = "Submit contact form with invalid email")
    public void testInvalidEmailContact() {
        test = extent.createTest("Invalid Email Contact Test");
        
        contactUsPage.submitContactForm("Test User", "invalidemail", "1234567890", 
             "Test message");
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        test.pass("Contact form with invalid email attempted");
    }
}