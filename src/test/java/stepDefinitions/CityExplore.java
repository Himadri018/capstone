package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CityPage;

public class CityExplore {
	private WebDriver driver() {
        return Hooks.getDriver();
    }

    // Create the page object lazily with the live driver
    private CityPage cp() {
        return new CityPage(driver());
    }
	@Given("I am on the BookMyShow home page")
	public void i_am_on_the_book_my_show_home_page() {
	    //Achived with hooks
	}

	@When("I open the city selector")
	public void i_open_the_city_selector() {
	    //city sected
	}

	@When("I search city {string}")
	public void i_search_city(String string) {
		cp().cityExploreValid(string);
	}

	@Then("I should see {string} in the city results")
	public void i_should_see_in_the_city_results(String string) {
	    cp().cityResult(string);
	}
	
	@When("I give invalid city name")
	public void i_give_invalid_city_name() {
		cp().openCity();
	}

	@Then("I select the city {string}")
	public void i_select_the_city(String string) {
	    cp().cityExploreInvalid(string);
	}

	@Then("I should see a no-results message")
	public void i_should_see_a_no_results_message() {
	    cp().noCity();
	}

	@When("I click the popular city {string} with icon")
	public void i_click_the_popular_city_with_icon(String string) {
	    cp().citySelecIcon(string);
	}
	
	@Then("the site context should change to {string}")
	public void the_site_context_should_change_to(String string) {
	    cp().cityResult(string);
	}

	@When("I click View All Cities")
	public void i_click_view_all_cities() {
	    cp().allCityBtn();
	}

	@Then("I should see the cities {string} in All Cities")
	public void i_should_see_the_cities_in_all_cities(String string) {
		Assert.assertTrue(cp().isCityPresent(string),"City not found in All Cities: " + string);
	}
}
