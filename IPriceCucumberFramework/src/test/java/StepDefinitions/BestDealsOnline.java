package StepDefinitions;

import BaseClass.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BestDealsOnline extends BaseClass
{
	
	
	@Given("user navigates to the URL")
	public void user_navigates_to_the_url() throws InterruptedException 
	{
		
		setup();
		launch_IPriceMalaysia();
	}

	@When("tries to find the Best Deals Online")
	public void tries_to_find_the_best_deals_online() 
	{
		
		bestDeals();
	}

	@Then("display the list of the stores")
	
	public void list_of_the_stores() 
	{
		
		for(String List:FullStoreList)
		{
			System.out.println("The List of Stores are:" + List);
		}
		
		
	    
	}

	@And("count of the stores")
	public void display_the_count_of_the_stores()
	{
		
		System.out.println("The Count of the Store is:" + StoreCount);
		close();
		
	}
}
