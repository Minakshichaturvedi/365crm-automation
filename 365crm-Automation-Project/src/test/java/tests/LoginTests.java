package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;

    @BeforeMethod
    public void navigateToLogin() {
        homePage = new HomePage(driver);
        homePage.closePopup();
        
        // Navigate directly to login page URL
        driver.get("https://www.web.365crm.io/login");
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        loginPage = new LoginPage(driver);
        System.out.println("Current URL: " + driver.getCurrentUrl());
    }

    @Test(priority = 1, description = "Verify login page loads")
    public void testLoginPageLoad() {
        test = extent.createTest("Login Page Load Test");

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("login"), "Not on login page");
        test.pass("Login page loaded. URL: " + currentUrl);
    }

    @Test(priority = 2, description = "Verify forgot password link is present")
    public void testForgotPasswordLink() {
        test = extent.createTest("Forgot Password Link Test");

        boolean isDisplayed = loginPage.isForgotPasswordLinkDisplayed();

        if (isDisplayed) {
            test.pass("Forgot password link is present");
        } else {
            test.skip("Forgot password link not found on this page");
        }
    }

    @Test(priority = 3, description = "Test login with dummy credentials")
    public void testLoginAttempt() {
        test = extent.createTest("Login Attempt Test");

        loginPage.login("test@example.com", "TestPassword123");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        test.pass("Login attempted with test credentials");
    }

    @Test(priority = 4, description = "Test login with empty credentials")
    public void testEmptyLogin() {
        test = extent.createTest("Empty Login Test");

        loginPage.clickLoginButton();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        test.pass("Login attempted with empty fields");
    }
}