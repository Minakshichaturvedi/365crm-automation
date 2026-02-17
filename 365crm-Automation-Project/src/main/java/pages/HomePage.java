package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//nav[@class='navbar navbar-expand-lg center-nav transparent navbar-light navbar-clone fixed navbar-stick']//div[@class='navbar-brand w-100']//img[@title='365 CRM']")
    private WebElement logo;

    @FindBy(xpath = "//nav[@class='navbar navbar-expand-lg center-nav transparent navbar-light navbar-clone fixed navbar-stick']//a[@aria-label='Features'][normalize-space()='Features']")
    private WebElement featuresLink;

    @FindBy(xpath = "//nav[@class='navbar navbar-expand-lg center-nav transparent navbar-light']//a[@aria-label='Pricing'][normalize-space()='Pricing']")
    private WebElement pricingLink;

    @FindBy(xpath = "//nav[@class='navbar navbar-expand-lg center-nav transparent navbar-light']//a[@aria-label='Contact Us'][normalize-space()='Contact Us']")
    private WebElement contactLink;

    @FindBy(xpath = "//span[@class='a-link fw-bold']")
    private WebElement signUpButton;

    @FindBy(xpath = "//nav[@class='navbar navbar-expand-lg center-nav transparent navbar-light']//div[@class='navbar-other w-100 d-flex ms-auto']//a[@aria-label='Login'][normalize-space()='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//h1 | //div[@class='hero-section']//h1")
    private WebElement heroTitle;

    @FindBy(xpath = "//a[contains(text(),'Free')]")
    private WebElement freeTrialButton;

    @FindBy(xpath = "//nav[@class='navbar navbar-expand-lg center-nav transparent navbar-light']//div[@class='navbar-other w-100 d-flex ms-auto']//a[@aria-label='Schedule Demo'][normalize-space()='Schedule Demo']")
    private WebElement requestDemoButton;

    @FindBy(xpath = "//a[@aria-expanded='false']")
    private List<WebElement> featureCards;

    @FindBy(xpath = "//a[@aria-label='Privacy Policy']")
    private WebElement privacyPolicyLink;

    @FindBy(xpath = "//a[@aria-label='Terms & Conditions']")
    private WebElement termsLink;

    @FindBy(xpath = "//a[@aria-label='Terms & Conditions']")
    private WebElement facebookLink;

    @FindBy(xpath = "//nav[@class='nav social mb-0 text-md-end justify-content-center']//i[@class='fab fa-twitter']")
    private WebElement twitterLink;

    @FindBy(xpath = "//footer//a[@href='https://www.linkedin.com']")
    private WebElement linkedinLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void closePopup() {
        try {
            Thread.sleep(3000);
            List<WebElement> closeButtons = driver.findElements(By.xpath(
                "//button[@class='close'] | //button[@aria-label='Close'] | " +
                "//button[contains(@class,'btn-close')] | //span[text()='×'] | " +
                "//div[contains(@class,'modal')]//button | //button[@data-bs-dismiss='modal'] | " +
                "//button[@data-dismiss='modal']"
            ));
            
            for (WebElement btn : closeButtons) {
                try {
                    if (btn.isDisplayed()) {
                        btn.click();
                        System.out.println("Popup closed");
                        Thread.sleep(1000);
                        break;
                    }
                } catch (Exception e) {
                    continue;
                }
            }
        } catch (Exception e) {
            System.out.println("No popup found");
        }
    }

    public boolean isLogoDisplayed() {
        return isDisplayed(logo);
    }

    public boolean isHeroTitleDisplayed() {
        return isDisplayed(heroTitle);
    }

    public String getHeroTitle() {
        return getText(heroTitle);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentPageUrl() {
        return getCurrentUrl();
    }

    public FeaturesPage navigateToFeatures() {
        closePopup();
        click(featuresLink);
        return new FeaturesPage(driver);
    }

    public PricingPage navigateToPricing() {
        closePopup();
        click(pricingLink);
        return new PricingPage(driver);
    }

    public ContactUsPage navigateToContact() {
        closePopup();
        click(contactLink);
        return new ContactUsPage(driver);
    }

    public SignUpPage clickSignUp() {
        closePopup();
        click(signUpButton);
        return new SignUpPage(driver);
    }

    public LoginPage clickLogin() {
        closePopup();
        click(loginButton);
        return new LoginPage(driver);
    }

    public void clickFreeTrialButton() {
        closePopup();
        scrollToElement(freeTrialButton);
        click(freeTrialButton);
    }

    public DemoRequestPage clickRequestDemo() {
        closePopup();
        click(requestDemoButton);
        return new DemoRequestPage(driver);
    }

    public int getFeatureCardsCount() {
        return featureCards.size();
    }

    public boolean areFeatureCardsDisplayed() {
        return featureCards.size() > 0 && featureCards.get(0).isDisplayed();
    }

    public void clickPrivacyPolicy() {
        scrollToElement(privacyPolicyLink);
        click(privacyPolicyLink);
    }

    public void clickTermsAndConditions() {
        scrollToElement(termsLink);
        click(termsLink);
    }

    public void clickFacebookLink() {
        scrollToElement(facebookLink);
        click(facebookLink);
    }

    public void clickLinkedInLink() {
        scrollToElement(linkedinLink);
        click(linkedinLink);
    }

    public boolean isFeaturesLinkDisplayed() {
        return isDisplayed(featuresLink);
    }

    public boolean isPricingLinkDisplayed() {
        return isDisplayed(pricingLink);
    }

    public boolean isContactLinkDisplayed() {
        return isDisplayed(contactLink);
    }

    public boolean isSignUpButtonDisplayed() {
        return isDisplayed(signUpButton);
    }

    public boolean isLoginButtonDisplayed() {
        return isDisplayed(loginButton);
    }
}