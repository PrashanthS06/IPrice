package StepDefinitions;

import BaseClass.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TopTrendingProducts extends BaseClass
{

	@Given("user navigates to the Trending Products URL")
	public void user_navigates_to_the_Trending_Products_url() throws InterruptedException 
	{
		
		setup();
		launch_IPriceMalaysia();
	}

	
	@When("tries to find the Top Trending Products")
	public void find_the_top_trending_products() 
	{
		// method for calling the element by locating without  “data-vars-cgt” attribute
		
		topTrendingProduct1();
		
		// method for calling the element by Locating with “data-vars-cgt” attribute
		
		topTrendingProduct2();
		
	}
	
	@Then ("display the count of the Top Trending Products")
	public void count_the_each_item_in_top_trending_products()
	{
		System.out.println("The Count of Top Trending Products is:" + count1);
	}
	
	@And("Validate the Top Trending Products")
	public void validate_top_trending_products()
	{
		if(TrendingProduct.equals(TrendingProduct2))
		{
			System.out.println("All the Top Trending Products contains “data-vars-cgt”");
		}
		else
		{
			System.out.println("All the Top Trending Products does not contains “data-vars-cgt”");
		}
		
		
		close();
	}
	
	
	
	
}
