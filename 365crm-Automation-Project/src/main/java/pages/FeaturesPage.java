package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FeaturesPage extends BasePage {

    // Dropdown Feature Links
    @FindBy(xpath = "/html[1]/body[1]/div[2]/header[1]/nav[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]")
    private WebElement leadManagement;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/header[1]/nav[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")
    private WebElement taskManagement;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/header[1]/nav[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")
    private WebElement customerReminders;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/header[1]/nav[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")
    private WebElement notesManagement;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/header[1]/nav[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")
    private WebElement liveChat;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/header[1]/nav[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")
    private WebElement calendar;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/header[1]/nav[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")
    private WebElement staffManagement;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/header[1]/nav[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")
    private WebElement targetManagement;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/header[1]/nav[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")
    private WebElement campaign;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/header[1]/nav[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")
    private WebElement serviceManagement;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/header[1]/nav[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")
    private WebElement integrations;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/header[1]/nav[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")
    private WebElement greetings;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/header[1]/nav[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")
    private WebElement hiring;

    public FeaturesPage(WebDriver driver) {
        super(driver);
    }

    public void hoverOnFeatures() {
        try {
            // Find any visible Features link using driver.findElements
            List<WebElement> featuresLinks = driver.findElements(By.xpath("//a[normalize-space()='Features']"));

            for (WebElement link : featuresLinks) {
                try {
                    if (link.isDisplayed()) {
                        JavascriptExecutor js = (JavascriptExecutor) driver;
                        js.executeScript(
                            "var event = new MouseEvent('mouseover', {bubbles: true}); arguments[0].dispatchEvent(event);",
                            link
                        );
                        Thread.sleep(1500);
                        System.out.println("Hovered on Features link");
                        return;
                    }
                } catch (Exception e) {
                    continue;
                }
            }
        } catch (Exception e) {
            System.out.println("Could not hover on Features: " + e.getMessage());
        }
    }

 // Find and click a feature link by text
    private void clickFeatureLink(String featureName) {
        try {
            hoverOnFeatures();
            List<WebElement> links = driver.findElements(By.xpath("//a[contains(text(),'" + featureName + "')]"));
            for (WebElement link : links) {
                try {
                    if (link.isDisplayed()) {
                        JavascriptExecutor js = (JavascriptExecutor) driver;
                        js.executeScript("arguments[0].click();", link);
                        System.out.println("Clicked: " + featureName);
                        return;
                    }
                } catch (Exception e) {
                    continue;
                }
            }
        } catch (Exception e) {
            System.out.println("Could not click " + featureName + ": " + e.getMessage());
        }
    }

    // Check if a feature link is visible
    private boolean isFeatureDisplayed(String featureName) {
        try {
            hoverOnFeatures();
            List<WebElement> links = driver.findElements(By.xpath("//a[contains(text(),'" + featureName + "')]"));
            for (WebElement link : links) {
                try {
                    if (link.isDisplayed()) {
                        System.out.println(featureName + " is displayed");
                        return true;
                    }
                } catch (Exception e) {
                    continue;
                }
            }
        } catch (Exception e) {
            System.out.println(featureName + " not found");
        }
        return false;
    }

    // Verification Methods
    public boolean isLeadManagementDisplayed() {
        return isFeatureDisplayed("Lead Management");
    }

    public boolean isTaskManagementDisplayed() {
        return isFeatureDisplayed("Task Management");
    }

    public boolean isCustomerRemindersDisplayed() {
        return isFeatureDisplayed("Customer Reminders");
    }

    public boolean isNotesManagementDisplayed() {
        return isFeatureDisplayed("Notes Management");
    }

    public boolean isLiveChatDisplayed() {
        return isFeatureDisplayed("Live Chat");
    }

    public boolean isCalendarDisplayed() {
        return isFeatureDisplayed("Calendar");
    }

    public boolean isStaffManagementDisplayed() {
        return isFeatureDisplayed("Staff Management");
    }

    public boolean isTargetManagementDisplayed() {
        return isFeatureDisplayed("Target Management");
    }

    public boolean isCampaignDisplayed() {
        return isFeatureDisplayed("Campaign");
    }

    public boolean isServiceManagementDisplayed() {
        return isFeatureDisplayed("Service Management");
    }

    public boolean isIntegrationsDisplayed() {
        return isFeatureDisplayed("Integrations");
    }

    public boolean isGreetingsDisplayed() {
        return isFeatureDisplayed("Greetings");
    }

    public boolean isHiringDisplayed() {
        return isFeatureDisplayed("Hiring");
    }

    // Click Methods
    public void clickLeadManagement() {
        clickFeatureLink("Lead Management");
    }

    public void clickTaskManagement() {
        clickFeatureLink("Task Management");
    }

    public void clickCustomerReminders() {
        clickFeatureLink("Customer Reminders");
    }

    public void clickNotesManagement() {
        clickFeatureLink("Notes Management");
    }

    public void clickLiveChat() {
        clickFeatureLink("Live Chat");
    }

    public void clickCalendar() {
        clickFeatureLink("Calendar");
    }

    public void clickStaffManagement() {
        clickFeatureLink("Staff Management");
    }

    public void clickTargetManagement() {
        clickFeatureLink("Target Management");
    }

    public void clickCampaign() {
        clickFeatureLink("Campaign");
    }

    public void clickServiceManagement() {
        clickFeatureLink("Service Management");
    }

    public void clickIntegrations() {
        clickFeatureLink("Integrations");
    }

    public void clickGreetings() {
        clickFeatureLink("Greetings");
    }

    public void clickHiring() {
        clickFeatureLink("Hiring");
    }
}