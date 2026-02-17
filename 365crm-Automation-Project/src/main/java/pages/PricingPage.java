package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PricingPage extends BasePage {

    // Page Title
    @FindBy(xpath = "//h2[contains(text(),'Our Pricing')] | //h2[contains(text(),'Pricing')]")
    private WebElement pageTitle;

    // Pricing Tabs
    @FindBy(xpath = "//a[@class='nav-link active'][normalize-space()='Popular Pricing Plans']")
    private WebElement popularPricingTab;

    @FindBy(xpath = "//div[@class='card-body']//a[@aria-label='Add-on Services'][normalize-space()='Add-on Services']")
    private WebElement addOnServicesTab;

    // Currency Toggle
    @FindBy(xpath = "//div[@id='tabt3-1']//div[@class='pricing-switcher pricing-switcher-active']")
    private WebElement inrToggle;

    @FindBy(xpath = "//div[@id='tabt3-1']//div[@class='pricing-switcher']")
    private WebElement usdToggle;

    // Plan Names
    @FindBy(xpath = "//div[normalize-space()='Gold']")
    private WebElement goldPlan;

    @FindBy(xpath = "//div[normalize-space()='Diamond']")
    private WebElement diamondPlan;

    @FindBy(xpath = "//div[normalize-space()='Platinum']")
    private WebElement platinumPlan;

    // Prices
    @FindBy(xpath = "//div[@class='price original-price-top price-show']//span[@class='price-value'][normalize-space()='40']")
    private WebElement goldPrice;

    @FindBy(xpath = "//div[@class='price original-price-top price-show']//span[@class='price-value'][normalize-space()='60']")
    private WebElement diamondPrice;

    @FindBy(xpath = "//div[@class='price original-price-top price-show']//span[@class='price-value'][normalize-space()='100']")
    private WebElement platinumPrice;

    // WhatsApp Button
    @FindBy(xpath = "//td[normalize-space()='Click To WhatsApp']")
    private List<WebElement> whatsappButtons;

    // Plan Feature Rows
    @FindBy(xpath = "//td[contains(text(),'Number of Staff')] | //th[contains(text(),'Number of Staff')]")
    private WebElement staffRow;

    @FindBy(xpath = "//td[contains(text(),'Lead')] | //th[contains(text(),'Lead')]")
    private WebElement leadFeature;

    @FindBy(xpath = "//td[contains(text(),'Storage')] | //th[contains(text(),'Storage')]")
    private WebElement storageRow;

    @FindBy(xpath = "//td[contains(text(),'WhatsApp Message Credits')] | //th[contains(text(),'WhatsApp Message Credits')]")
    private WebElement whatsappCreditsRow;

    // All pricing cards
    @FindBy(xpath = "//div[contains(@class,'pricing') or contains(@class,'card')]//h3[normalize-space()='Gold' or normalize-space()='Diamond' or normalize-space()='Platinum']")
    private List<WebElement> allPlans;

    public PricingPage(WebDriver driver) {
        super(driver);
    }

    // Page Verification
    public boolean isPricingPageDisplayed() {
        return isDisplayed(pageTitle);
    }

    public String getPageTitleText() {
        return getText(pageTitle);
    }

    // Tab Methods
    public boolean isPopularPricingTabDisplayed() {
        return isDisplayed(popularPricingTab);
    }

    public boolean isAddOnServicesTabDisplayed() {
        return isDisplayed(addOnServicesTab);
    }

    public void clickPopularPricingTab() {
        click(popularPricingTab);
    }

    public void clickAddOnServicesTab() {
        click(addOnServicesTab);
    }

    // Currency Toggle Methods
    public void clickINR() {
        click(inrToggle);
    }

    public void clickUSD() {
        click(usdToggle);
    }

    public boolean isINRToggleDisplayed() {
        return isDisplayed(inrToggle);
    }

    public boolean isUSDToggleDisplayed() {
        return isDisplayed(usdToggle);
    }

    // Plan Verification
    public boolean isGoldPlanDisplayed() {
        return isDisplayed(goldPlan);
    }

    public boolean isDiamondPlanDisplayed() {
        return isDisplayed(diamondPlan);
    }

    public boolean isPlatinumPlanDisplayed() {
        return isDisplayed(platinumPlan);
    }

    public int getAllPlansCount() {
        return allPlans.size();
    }

    // Feature Verification
    public boolean isStaffRowDisplayed() {
        scrollToElement(staffRow);
        return isDisplayed(staffRow);
    }

    public boolean isLeadFeatureDisplayed() {
        return isDisplayed(leadFeature);
    }

    public boolean isStorageRowDisplayed() {
        scrollToElement(storageRow);
        return isDisplayed(storageRow);
    }

    public boolean isWhatsappCreditsDisplayed() {
        scrollToElement(whatsappCreditsRow);
        return isDisplayed(whatsappCreditsRow);
    }

    // WhatsApp Button
    public boolean areWhatsappButtonsDisplayed() {
        return whatsappButtons.size() > 0;
    }

    public void clickFirstWhatsappButton() {
        if (!whatsappButtons.isEmpty()) {
            scrollToElement(whatsappButtons.get(0));
            click(whatsappButtons.get(0));
        }
    }
}