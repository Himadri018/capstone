package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps {
	// Always fetch driver from Hooks when needed; avoid early initialization
    private WebDriver driver() {
        return Hooks.getDriver();
    }

    // Create the page object lazily with the live driver
    private LoginPage lp() {
        return new LoginPage(driver());
    }
	
	@Given("I go to BMS Page")
	public void i_go_to_bms_page() {
		//automated
	}

	@When("I select my city")
	public void i_select_my_city() {
	    lp().citySelection("kolkata");
	}

	@When("I Login with valid mobile and got to otp page")
	public void i_login_with_valid_mobile_and_got_to_otp_page() {
	    lp().openLogin();
	    lp().enterMobile("8999807667");
	    lp().clickContinue();
	}

	@Then("otp page must be shown")
	public void otp_page_must_be_shown() {
	    lp().isOtpVisible();
	    lp().clickBack();
	}

	@When("I Login with invalid mobile number")
	public void i_login_with_invalid_mobile_number() {
		lp().citySelection("kolkata");
		lp().openLogin();
	    lp().enterMobile("0099807667");
	    lp().clickContinue();
	}

	@Then("Error should appear")
	public void error_should_appear() {
		Assert.assertTrue(lp().isInvalidMobileErrorVisible(),
	            "Expected invalid mobile error to be visible.");
	}

	@Then("login button should be visible")
	public void login_button_should_be_visible() {
		lp().citySelection("kolkata");
	    lp().isLoginButtonVisible();
	    lp().openLogin();
	}

	@Then("mobile input field should be visible")
	public void mobile_input_field_should_be_visible() {
	    lp().isMobileInputVisible();
	}

}
