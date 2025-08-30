package stepDefinitions;

import org.openqa.selenium.WebDriver;

import hooks.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GiftcardPage;


public class GiftcardSteps {
	private WebDriver d() {
        return Hooks.getDriver();
    }

    // Create the page object lazily with the live driver
    private GiftcardPage gp() {
        return new GiftcardPage(d());
    }
	
    @When("I go to the Gift Cards tab")
    public void i_go_to_the_gift_cards_tab() {
        gp().gotoGiftcard();
    }

	@Then("the Check Gift Card Balance icon should be visible")
	public void the_check_gift_card_balance_icon_should_be_visible() {
	    gp().checkGiftCard();
	}

	@When("I click on Check Gift Card Balance")
	public void i_click_on_check_gift_card_balance() {
	    gp().checkBalance();
	}

	@When("I enter invalid voucher number {string}")
	public void i_enter_invalid_voucher_number(String string) {
		gp().sendGiftCard(string);
	}

	@When("I submit gift card balance check")
	public void i_submit_gift_card_balance_check() {
	    gp().sendGiftCardCont();
	}

	@Then("an error message should be shown for invalid voucher")
	public void an_error_message_should_be_shown_for_invalid_voucher() {
	    gp().sendGiftCardError();
	}
}
