package StepDefinitions;

import BaseClass.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TopStoresActive extends BaseClass

{
	
	
	@Given("user navigates to the Top Stores")
	public void user_navigates_to_the_top_stores() throws InterruptedException {
	    
		setup();
		launch_IPriceMalaysiaCouopns();
	}

	@When("tries to find the Active Top Stores")
	public void tries_to_find_the_active_top_stores() 
	{
	    
		topStoresLink();
		
		activeURL();
		
	}

	@Then("Validate url of stores in Top Stores are all active")
	public void validate_url_of_stores_in_top_stores_are_all_active()
	{
		if(Activecount==TopStoreslinkcount)
		{
			System.out.println("All the URL in Top Stores are active");
		}
		else
		{
			System.out.println("The Active URL in Top Store is:"+Activecount);
		}
			
		close();
	}
}
