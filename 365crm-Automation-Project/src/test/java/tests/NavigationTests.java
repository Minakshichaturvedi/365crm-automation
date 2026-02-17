package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class NavigationTests extends BaseTest {

    private HomePage homePage;

    @BeforeMethod
    public void initializePage() {
        homePage = new HomePage(driver);
    }

    @Test(priority = 1, description = "Test navigation from home to features")
    public void testNavigationToFeatures() {
        test = extent.createTest("Navigation to Features Test");
        
        homePage.navigateToFeatures();
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        String currentUrl = driver.getCurrentUrl();
        test.pass("Navigated successfully. Current URL: " + currentUrl);
    }

    @Test(priority = 2, description = "Test navigation from home to pricing")
    public void testNavigationToPricing() {
        test = extent.createTest("Navigation to Pricing Test");
        
        homePage.navigateToPricing();
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        String currentUrl = driver.getCurrentUrl();
        test.pass("Navigated successfully. Current URL: " + currentUrl);
    }

    @Test(priority = 3, description = "Test navigation from home to contact")
    public void testNavigationToContact() {
        test = extent.createTest("Navigation to Contact Test");
        
        homePage.navigateToContact();
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        String currentUrl = driver.getCurrentUrl();
        test.pass("Navigated successfully. Current URL: " + currentUrl);
    }

    @Test(priority = 4, description = "Test complete navigation flow")
    public void testCompleteNavigationFlow() {
        test = extent.createTest("Complete Navigation Flow Test");
        
        // Navigate through all main pages
        homePage.navigateToFeatures();
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        
        driver.navigate().back();
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        
        homePage.navigateToPricing();
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        
        driver.navigate().back();
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        
        homePage.navigateToContact();
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        
        test.pass("Complete navigation flow executed successfully");
    }

    @Test(priority = 5, description = "Test browser back button functionality")
    public void testBackButtonNavigation() {
        test = extent.createTest("Back Button Navigation Test");
        
        String homeUrl = driver.getCurrentUrl();
        homePage.navigateToFeatures();
        
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        
        driver.navigate().back();
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        
        String returnedUrl = driver.getCurrentUrl();
        Assert.assertEquals(returnedUrl, homeUrl, "Back button didn't return to home page");
        
        test.pass("Back button navigation working correctly");
    }
}