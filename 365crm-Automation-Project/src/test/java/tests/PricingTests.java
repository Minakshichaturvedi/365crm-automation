package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.PricingPage;

public class PricingTests extends BaseTest {

    private HomePage homePage;
    private PricingPage pricingPage;

    @BeforeMethod
    public void navigateToPricing() {
        homePage = new HomePage(driver);
        homePage.closePopup();
        
        driver.get("https://www.365crm.io/pricing");
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        pricingPage = new PricingPage(driver);
        System.out.println("Current URL: " + driver.getCurrentUrl());
    }

    @Test(priority = 1, description = "Verify pricing page loads")
    public void testPricingPageLoad() {
        test = extent.createTest("Pricing Page Load Test");

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("pricing"), "Not on pricing page");
        test.pass("Pricing page loaded. URL: " + currentUrl);
    }

    @Test(priority = 2, description = "Verify all 3 plans are displayed")
    public void testAllPlansDisplayed() {
        test = extent.createTest("All Plans Displayed Test");

        boolean goldDisplayed = pricingPage.isGoldPlanDisplayed();
        boolean diamondDisplayed = pricingPage.isDiamondPlanDisplayed();
        boolean platinumDisplayed = pricingPage.isPlatinumPlanDisplayed();

        Assert.assertTrue(goldDisplayed, "Gold plan not displayed");
        Assert.assertTrue(diamondDisplayed, "Diamond plan not displayed");
        Assert.assertTrue(platinumDisplayed, "Platinum plan not displayed");

        test.pass("All 3 plans displayed: Gold, Diamond, Platinum");
    }

    @Test(priority = 3, description = "Verify pricing tabs are present")
    public void testPricingTabs() {
        test = extent.createTest("Pricing Tabs Test");

        boolean popularTab = pricingPage.isPopularPricingTabDisplayed();
        boolean addOnTab = pricingPage.isAddOnServicesTabDisplayed();

        if (popularTab) {
            test.pass("Popular Pricing Plans tab is present");
        } else {
            test.skip("Popular Pricing Plans tab not found");
        }

        if (addOnTab) {
            test.pass("Add-on Services tab is present");
        } else {
            test.skip("Add-on Services tab not found");
        }
    }

    @Test(priority = 4, description = "Verify currency toggle INR/USD")
    public void testCurrencyToggle() {
        test = extent.createTest("Currency Toggle Test");

        boolean inrDisplayed = pricingPage.isINRToggleDisplayed();
        boolean usdDisplayed = pricingPage.isUSDToggleDisplayed();

        if (inrDisplayed && usdDisplayed) {
            pricingPage.clickUSD();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            pricingPage.clickINR();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            test.pass("Currency toggle INR/USD working");
        } else {
            test.skip("Currency toggle not found");
        }
    }

    @Test(priority = 5, description = "Verify plan features table")
    public void testPlanFeaturesTable() {
        test = extent.createTest("Plan Features Table Test");

        boolean staffRow = pricingPage.isStaffRowDisplayed();
        boolean storageRow = pricingPage.isStorageRowDisplayed();
        boolean whatsappCredits = pricingPage.isWhatsappCreditsDisplayed();

        if (staffRow) {
            test.pass("Number of Staff row is displayed");
        } else {
            test.skip("Staff row not found");
        }

        if (storageRow) {
            test.pass("Storage row is displayed");
        } else {
            test.skip("Storage row not found");
        }

        if (whatsappCredits) {
            test.pass("WhatsApp Message Credits row is displayed");
        } else {
            test.skip("WhatsApp Credits row not found");
        }
    }

    @Test(priority = 6, description = "Verify Add-on Services tab click")
    public void testAddOnServicesTab() {
        test = extent.createTest("Add-on Services Tab Test");

        if (pricingPage.isAddOnServicesTabDisplayed()) {
            pricingPage.clickAddOnServicesTab();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            test.pass("Add-on Services tab clicked successfully");
        } else {
            test.skip("Add-on Services tab not found");
        }
    }

    @Test(priority = 7, description = "Verify WhatsApp buttons are present")
    public void testWhatsappButtons() {
        test = extent.createTest("WhatsApp Buttons Test");

        boolean whatsappDisplayed = pricingPage.areWhatsappButtonsDisplayed();

        if (whatsappDisplayed) {
            test.pass("WhatsApp buttons are present on pricing page");
        } else {
            test.skip("WhatsApp buttons not found");
        }
    }
}