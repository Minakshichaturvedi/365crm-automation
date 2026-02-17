package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.*;
import utils.TestDataGenerator;

public class E2EWorkflowTests extends BaseTest {

    @Test(priority = 1, description = "End-to-end workflow: Browse -> Features -> Pricing -> Sign Up")
    public void testCompleteUserJourney() {
        test = extent.createTest("Complete User Journey Test");
        
        // Step 1: Start on home page
        HomePage homePage = new HomePage(driver);
        test.info("Step 1: Landed on home page");
        
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        
        // Step 2: Navigate to Features
        FeaturesPage featuresPage = homePage.navigateToFeatures();
        test.info("Step 2: Navigated to Features page");
        
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        
        // Step 3: Go back and check pricing
        driver.navigate().back();
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        
        homePage = new HomePage(driver);
        PricingPage pricingPage = homePage.navigateToPricing();
        test.info("Step 3: Navigated to Pricing page");
        
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        
        // Step 4: Navigate back to home
        driver.navigate().back();
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        
        // Step 5: Attempt sign up
        homePage = new HomePage(driver);
        SignUpPage signUpPage = homePage.clickSignUp();
        test.info("Step 4: Navigated to Sign Up page");
        
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        
        // Step 6: Fill sign up form
        String name = TestDataGenerator.getRandomFirstName() + " " + TestDataGenerator.getRandomLastName();
        String email = TestDataGenerator.getRandomEmail();
        String company = TestDataGenerator.getRandomCompany();
        String phone = TestDataGenerator.getRandomPhoneNumber();
        
        signUpPage.completeSignUp(name, email, "Test@123456", company, phone, email);
        test.info("Step 5: Completed sign up form with email: " + email);
        
        try { Thread.sleep(3000); } catch (InterruptedException e) {}
        
        test.pass("Complete user journey executed successfully");
    }

    @Test(priority = 2, description = "End-to-end workflow: Browse -> Contact -> Submit Inquiry")
    public void testContactInquiryJourney() {
        test = extent.createTest("Contact Inquiry Journey Test");
        
        // Step 1: Start on home page
        HomePage homePage = new HomePage(driver);
        test.info("Step 1: Landed on home page");
        
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        
        // Step 2: Navigate to Contact
        ContactUsPage contactPage = homePage.navigateToContact();
        test.info("Step 2: Navigated to Contact page");
        
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        
        // Step 3: Submit contact form
        String name = TestDataGenerator.getRandomFirstName() + " " + TestDataGenerator.getRandomLastName();
        String email = TestDataGenerator.getRandomEmail();
        String phone = TestDataGenerator.getRandomPhoneNumber();
        
        contactPage.submitContactForm(name, email, phone,
            "I would like to know more about your CRM features");
        test.info("Step 3: Submitted contact form with email: " + email);
        
        try { Thread.sleep(3000); } catch (InterruptedException e) {}
        
        test.pass("Contact inquiry journey completed successfully");
    }
}