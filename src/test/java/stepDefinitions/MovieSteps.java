package stepDefinitions;

import org.openqa.selenium.WebDriver;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MoviePage;

public class MovieSteps {
	private WebDriver d() {
        return Hooks.getDriver();
    }

    // Create the page object lazily with the live driver
    private MoviePage mp() {
        return new MoviePage(d());
    }
	
	@Given("I have selected the city {string}")
	public void i_have_selected_the_city(String string) {
	    mp().citySelection(string);
	}

	@When("I click on the {string} available in the recommended")
	public void i_click_on_the_available_in_the_recommended(String string) {
	    mp().recMovie(string);
	}

	@Then("I should see the {string} and booking details")
	public void i_should_see_the_movie_and_booking_details(String string) {
	    mp().recMovieDetails(string);
	}


	@Then("all {string} should be visible")
	public void all_elements_should_be_visible(String string) {
		mp().elementCheck(string);
	}

	@Then("search bar should be visible")
	public void search_bar_should_be_visible() {
	    mp().searchBarcheck();
	}
	
	@When("I go to the Movies tab")
	public void i_go_to_the_movies_tab() {
	    mp().mvGo();
	}

	@When("I click Explore Upcoming Movies")
	public void i_click_explore_upcoming_movies() {
	    mp().upcomingMovie();
	}

	@Then("{string} link should be visible")
	public void link_should_be_visible(String string) {
	    mp().inMovies();
	}
}
