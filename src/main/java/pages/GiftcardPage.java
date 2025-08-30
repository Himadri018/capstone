package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import utils.WaitUtils;

public class GiftcardPage extends BasePage{

	public GiftcardPage(WebDriver d) {
		super(d);
	}
	
	@FindBy(xpath ="//input[@id='dummy']")
    private WebElement citySelec;
    
    @FindBy(xpath ="//div[@class='sc-5d56x9-0 hIDoFD']")
    private WebElement citySelecFinal;
    
    @FindBy(xpath ="(//a[text()='Gift Cards'])[1]")
    private WebElement giftcardSection;
    
    @FindBy(xpath ="(//div[@class='sc-12r1n02-1 ehSquB'])[3]")
    private WebElement checkBalIcon;
    
    @FindBy(xpath ="//input[@id='gift-voucher']")
    private WebElement giftcardEnt;
    
    @FindBy(xpath ="//div[@class='sc-zgl7vj-7 kdBUB']")
    private WebElement giftcardEntContBtn;
    
    @FindBy(xpath ="//p[@class='sc-12r1n02-9 cKoKSF']")
    private WebElement giftcardError;
    
    public void gotoGiftcard() {
        try {
            WaitUtils.waitForClickable(d, giftcardSection, 10).click();
            System.out.println("✅ Navigated to Gift Cards section.");
        } catch (Exception e) {
            System.out.println("❌ Error in gotoGiftcard(): " + e.getMessage());
            Assert.fail("Failed to open Gift Cards tab", e);
        }
    }

    public void checkGiftCard() {
        try {
            WebElement el = WaitUtils.waitForVisible(d, checkBalIcon, 10);
            Assert.assertTrue(el.isDisplayed(), "Check Gift Card Balance icon not visible!");
            System.out.println("✅ Check Gift Card Balance icon is visible.");
        } catch (Exception e) {
            System.out.println("❌ Error in checkGiftCard(): " + e.getMessage());
            Assert.fail("Check Balance icon check failed", e);
        }
    }

    public void checkBalance() {
        try {
            WaitUtils.waitForClickable(d, checkBalIcon, 10).click();
            System.out.println("✅ Clicked on Check Gift Card Balance.");
        } catch (Exception e) {
            System.out.println("❌ Error in checkBalance(): " + e.getMessage());
            Assert.fail("Unable to click Check Gift Card Balance", e);
        }
    }

    public void sendGiftCard(String a) {
        try {
            WebElement box = WaitUtils.waitForVisible(d, giftcardEnt, 10);
            box.clear();
            box.sendKeys(a);
            System.out.println("✅ Entered voucher: " + a);
        } catch (Exception e) {
            System.out.println("❌ Error in sendGiftCard(): " + e.getMessage());
            Assert.fail("Unable to type voucher", e);
        }
    }

    public void sendGiftCardCont() {
        try {
            WaitUtils.waitForClickable(d, giftcardEntContBtn, 10).click();
            System.out.println("✅ Submitted voucher for balance check.");
        } catch (Exception e) {
            System.out.println("❌ Error in sendGiftCardCont(): " + e.getMessage());
            Assert.fail("Unable to submit gift card check", e);
        }
    }

    public void sendGiftCardError() {
        try {
            WebElement err = WaitUtils.waitForVisible(d, giftcardError, 20);
            String msg = err.getText();
            Assert.assertTrue(msg != null && !msg.trim().isEmpty(),
                    "Expected an error message, but none was shown.");
            System.out.println("✅ Error message displayed: " + msg);
        } catch (Exception e) {
            System.out.println("❌ Error in sendGiftCardError(): " + e.getMessage());
            Assert.fail("Invalid voucher error message not found", e);
        }
    }
}
