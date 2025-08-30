package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitUtils;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver d) { super(d); }

    @FindBy(xpath ="//input[@id='dummy']")
    private WebElement citySelec;
    
    @FindBy(xpath ="//div[@class='sc-5d56x9-0 hIDoFD']")
    private WebElement citySelecFinal;
    
    @FindBy(xpath ="//div[text()='Sign in']")
    private WebElement loginTrigger;

    @FindBy(xpath = "//input[@id='userMobileNumber']")
    private WebElement mobileInput;

    @FindBy(xpath ="//div[text()='Continue']")
    private WebElement continueBtn;

    @FindBy(xpath = "//div[@class='sc-2vmyj1-17 hcvbMz']")
    private WebElement otpInput;

    @FindBy(xpath = "//div[@class='sc-z1ldnh-12 Qsrzn']")
    private WebElement invalidMobileError;

    @FindBy(xpath = "//div[@class='sc-1ydq0aj-0 bIaakI']")
    private WebElement signBack;
    
    @FindBy(xpath = "//div[@class='sc-1ydq0aj-6 gnsbYm']")
    private WebElement signBackCross;
    
    @FindBy(xpath = "")
    private WebElement anyDismiss;
    

    //Actions
    public void citySelection(String s) {
    	citySelec.sendKeys(s);
    	citySelecFinal.click();
    }
    
    public void openLogin() {
        try { WaitUtils.waitForClickable(d, loginTrigger, 8).click(); } 
        catch (Exception ignored) {}
        try { anyDismiss.click(); } 
        catch (Exception ignored) {}
    }

    public void enterMobile(String mobile) {
        WaitUtils.waitForVisible(d, mobileInput, 8).clear();
        mobileInput.sendKeys(mobile);
    }

    public void clickContinue() {
        WaitUtils.waitForClickable(d, continueBtn, 8).click();
    }
    
    public void clickBack() {
    	WaitUtils.waitForClickable(d, signBack, 8).click();
    	WaitUtils.waitForClickable(d, signBackCross, 8).click();
    }

    // ── Checks ────────────────────────────────────────────────────────────────
    public boolean isOtpVisible() {
        try { System.out.println(otpInput.getText());
        	return WaitUtils.waitForVisible(d, otpInput, 8).isDisplayed(); }
        catch (Exception e) { return false; }
    }

    public boolean isInvalidMobileErrorVisible() {
    	try {
            // primary: wait for the mapped error element to become visible
            return WaitUtils.waitForVisible(d, invalidMobileError, 8).isDisplayed();
        } catch (Exception ignore) {
            // fallback by text (handles dynamic classes)
            try {
                WebElement byText = d.findElement(org.openqa.selenium.By.xpath(
                    "//*[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'invalid mobile')]"
                ));
                return WaitUtils.waitForVisible(d, byText, 5).isDisplayed();
            } catch (Exception e2) {
                return false;
            }
        }
    }

    public boolean isLoginButtonVisible() {
        try { 
        	System.out.println(loginTrigger.getText());
        	return loginTrigger.isDisplayed(); }
        catch (Exception e) { return false; }
    }

    public boolean isMobileInputVisible() {
        try { System.out.println(mobileInput.getText());
        	return mobileInput.isDisplayed(); }
        catch (Exception e) { return false; }
    }
}
