package StepDefinitions;

import BaseClass.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TopStoresValidation extends BaseClass
{
	
	
	@Given("user navigates to the Top Stores URL")
	public void user_navigates_to_the_top_stores_url() throws InterruptedException {
	    
		setup();
		launch_IPriceMalaysiaCouopns();
	}

	@When("tries to find the Top Stores")
	public void tries_to_find_the_top_stores() 
	{
	    
		topStoresLink();
	}

	@Then("Validate url of stores in Top Stores redirected to their proper store url")
	public void top_stores_are_redirected_to_their_proper_store_url()
	{
		urlRedirect();
		close();
	}
	
}
