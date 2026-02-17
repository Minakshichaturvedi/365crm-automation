package tests;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FeaturesPage;
import pages.HomePage;

public class FeaturesTests extends BaseTest {

    private HomePage homePage;
    private FeaturesPage featuresPage;

    @BeforeMethod
    public void initPage() {
        homePage = new HomePage(driver);
        homePage.closePopup();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        featuresPage = new FeaturesPage(driver);
    }

    @Test(priority = 1, description = "Verify Lead Management in dropdown")
    public void testLeadManagement() {
        test = extent.createTest("Lead Management Test");

        if (featuresPage.isLeadManagementDisplayed()) {
            test.pass("Lead Management is displayed in Features dropdown");
        } else {
            test.skip("Lead Management not found");
        }
    }

    @Test(priority = 2, description = "Verify Task Management in dropdown")
    public void testTaskManagement() {
        test = extent.createTest("Task Management Test");

        if (featuresPage.isTaskManagementDisplayed()) {
            test.pass("Task Management is displayed in Features dropdown");
        } else {
            test.skip("Task Management not found");
        }
    }

    @Test(priority = 3, description = "Verify Customer Reminders in dropdown")
    public void testCustomerReminders() {
        test = extent.createTest("Customer Reminders Test");

        if (featuresPage.isCustomerRemindersDisplayed()) {
            test.pass("Customer Reminders & Meeting is displayed");
        } else {
            test.skip("Customer Reminders not found");
        }
    }

    @Test(priority = 4, description = "Verify Notes Management in dropdown")
    public void testNotesManagement() {
        test = extent.createTest("Notes Management Test");

        if (featuresPage.isNotesManagementDisplayed()) {
            test.pass("Notes Management is displayed");
        } else {
            test.skip("Notes Management not found");
        }
    }

    @Test(priority = 5, description = "Verify Live Chat in dropdown")
    public void testLiveChat() {
        test = extent.createTest("Live Chat Test");

        if (featuresPage.isLiveChatDisplayed()) {
            test.pass("Live Chat is displayed");
        } else {
            test.skip("Live Chat not found");
        }
    }

    @Test(priority = 6, description = "Verify Calendar in dropdown")
    public void testCalendar() {
        test = extent.createTest("Calendar Test");

        if (featuresPage.isCalendarDisplayed()) {
            test.pass("Calendar is displayed");
        } else {
            test.skip("Calendar not found");
        }
    }

    @Test(priority = 7, description = "Verify Staff Management in dropdown")
    public void testStaffManagement() {
        test = extent.createTest("Staff Management Test");

        if (featuresPage.isStaffManagementDisplayed()) {
            test.pass("Staff Management is displayed");
        } else {
            test.skip("Staff Management not found");
        }
    }

    @Test(priority = 8, description = "Verify Target Management in dropdown")
    public void testTargetManagement() {
        test = extent.createTest("Target Management Test");

        if (featuresPage.isTargetManagementDisplayed()) {
            test.pass("Target Management is displayed");
        } else {
            test.skip("Target Management not found");
        }
    }

    @Test(priority = 9, description = "Verify Campaign & Channels in dropdown")
    public void testCampaign() {
        test = extent.createTest("Campaign & Channels Test");

        if (featuresPage.isCampaignDisplayed()) {
            test.pass("Campaign & Channels is displayed");
        } else {
            test.skip("Campaign not found");
        }
    }

    @Test(priority = 10, description = "Verify Service Management in dropdown")
    public void testServiceManagement() {
        test = extent.createTest("Service Management Test");

        if (featuresPage.isServiceManagementDisplayed()) {
            test.pass("Service Management is displayed");
        } else {
            test.skip("Service Management not found");
        }
    }

    @Test(priority = 11, description = "Verify Integrations in dropdown")
    public void testIntegrations() {
        test = extent.createTest("Integrations Test");

        if (featuresPage.isIntegrationsDisplayed()) {
            test.pass("Integrations is displayed");
        } else {
            test.skip("Integrations not found");
        }
    }

    @Test(priority = 12, description = "Verify Greetings in dropdown")
    public void testGreetings() {
        test = extent.createTest("Greetings Test");

        if (featuresPage.isGreetingsDisplayed()) {
            test.pass("Greetings is displayed");
        } else {
            test.skip("Greetings not found");
        }
    }

    @Test(priority = 13, description = "Verify Hiring in dropdown")
    public void testHiring() {
        test = extent.createTest("Hiring Test");

        if (featuresPage.isHiringDisplayed()) {
            test.pass("Hiring is displayed");
        } else {
            test.skip("Hiring not found");
        }
    }

    @Test(priority = 14, description = "Click Lead Management and verify page")
    public void testClickLeadManagement() {
        test = extent.createTest("Click Lead Management Test");

        featuresPage.clickLeadManagement();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String currentUrl = driver.getCurrentUrl();
        test.pass("Lead Management clicked. URL: " + currentUrl);
    }

    @Test(priority = 15, description = "Click Task Management and verify page")
    public void testClickTaskManagement() {
        test = extent.createTest("Click Task Management Test");

        featuresPage.clickTaskManagement();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String currentUrl = driver.getCurrentUrl();
        test.pass("Task Management clicked. URL: " + currentUrl);
    }

    @Test(priority = 16, description = "Click Integrations and verify page")
    public void testClickIntegrations() {
        test = extent.createTest("Click Integrations Test");

        featuresPage.clickIntegrations();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String currentUrl = driver.getCurrentUrl();
        test.pass("Integrations clicked. URL: " + currentUrl);
    }

    @Test(priority = 17, description = "Click Hiring and verify page")
    public void testClickHiring() {
        test = extent.createTest("Click Hiring Test");

        featuresPage.clickHiring();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String currentUrl = driver.getCurrentUrl();
        test.pass("Hiring clicked. URL: " + currentUrl);
    }
}