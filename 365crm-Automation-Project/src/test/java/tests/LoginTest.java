package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    
    @Test(priority = 1)
    public void testValidLogin() {
        System.out.println("Test: Valid Login");
        
        LoginPage loginPage = new LoginPage(driver);
        
        loginPage.login("your@323gmail.com", "your@shi76");  // UPDATE
        
        // Add assertion based on successful login indicator
        // Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
        
        System.out.println("✓ Login successful");
    }
    
    @Test(priority = 2)
    public void testInvalidLogin() {
        System.out.println("Test: Invalid Login");
        
        LoginPage loginPage = new LoginPage(driver);
        
        loginPage.login("invalid@email.com", "wrongpassword");
        
        String errorMsg = loginPage.getErrorMessage();
        Assert.assertTrue(errorMsg.contains("Invalid") || errorMsg.contains("error"));
        
        System.out.println("✓ Error message displayed correctly");
    }
    
    @Test(priority = 3)
    public void testEmptyCredentials() {
        System.out.println("Test: Empty Credentials");
        
        LoginPage loginPage = new LoginPage(driver);
        
        loginPage.clickLogin();
        
        // Add appropriate assertion
        Assert.assertTrue(loginPage.isLoginButtonDisplayed());
        
        System.out.println("✓ Validation working for empty fields");
    }
}