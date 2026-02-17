package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTests extends BaseTest {

    private HomePage homePage;

    @BeforeMethod
    public void initializePage() {
        homePage = new HomePage(driver);
        homePage.closePopup();
    }

    @Test(priority = 1, description = "Verify home page loads successfully")
    public void testHomePageLoad() {
        test = extent.createTest("Home Page Load Test");

        Assert.assertTrue(homePage.getPageTitle().contains("365"), "Page title doesn't contain '365'");
        test.pass("Home page loaded successfully");
    }

    @Test(priority = 2, description = "Verify all navigation links are present")
    public void testNavigationLinks() {
        test = extent.createTest("Navigation Links Test");

        Assert.assertTrue(homePage.isLoginButtonDisplayed(), "Login button not displayed");
        test.pass("Navigation links are present");
    }

    @Test(priority = 3, description = "Verify hero section is displayed")
    public void testHeroSection() {
        test = extent.createTest("Hero Section Test");

        Assert.assertTrue(homePage.isHeroTitleDisplayed(), "Hero title not displayed");
        String heroTitle = homePage.getHeroTitle();
        Assert.assertFalse(heroTitle.isEmpty(), "Hero title is empty");
        test.pass("Hero section displayed with title: " + heroTitle);
    }

    @Test(priority = 4, description = "Verify URL structure")
    public void testUrlStructure() {
        test = extent.createTest("URL Structure Test");

        String currentUrl = homePage.getCurrentPageUrl();
        Assert.assertTrue(currentUrl.contains("365crm.io"), "URL doesn't contain 365crm.io");
        test.pass("URL structure is correct: " + currentUrl);
    }
}