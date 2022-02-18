package BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	// Declaration of driver and file properties
	
	public WebDriver driver;
	File propfile, datafile;
	FileInputStream fip,fis;
	public Properties prop;
	
	// Declaration of Variables to find the List of Stores in the "Find the Best Deals Online"
	
	public int StoreCount;
	public List<WebElement> storesList =new ArrayList<WebElement>();
	public List<String> FullStoreList=new ArrayList<String>();
	
	// Declaration of Variables to find the count and list of "Top Trending Products"
	
	public int count1,count2;
	public List<WebElement> TrendingProduct=new ArrayList<WebElement>();
	public List<WebElement> TrendingProduct2=new ArrayList<WebElement>();
	
	// Declaration of Variables to find the active Count and list of URL in the "Top Stores"
	
	public int TopStoreslinkcount;
	public List<WebElement> TopStoresLink=new ArrayList<WebElement>();
	public List<String> TopStoreLinkNameList= new ArrayList<String>();
	public String TopStoreLinkList=null;
	public int Activecount=0;
	public List<String> URLName= new ArrayList<String>();
	public String TopStoresURL=null;
	
	// Method to initial configuration of Property File
	
	public void initialconfig()
	{
	propfile = new File(System.getProperty("user.dir")+"//src//test//resources//config//config.properties");
	
	try 
	{
		fip=new FileInputStream(propfile);
		prop= new Properties();
		prop.load(fip);
	} catch (FileNotFoundException e) {

		System.out.println("FileNotException caught in the initialconfig:"+e.getMessage());
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
	// Method to read the config property file
	
	public String ReadPropertyFile(String key)
	{
		return prop.getProperty(key);
				
	}
	
	// Method to launch the chrome driver
	
	public void setup() throws InterruptedException
	{
		initialconfig();
		System.setProperty("webdriver.chrome.driver", ReadPropertyFile("chromedriverpath"));
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		
	}
	
	// Method to launch the IPriceMalaysiaurl
	
	public void launch_IPriceMalaysia()
	{
		driver.get(ReadPropertyFile("IPriceMalaysiaurl"));
	}
	
	// Method to launch the IPriceMalaysiacouponurl
	
	public void launch_IPriceMalaysiaCouopns()
	{
		driver.get(ReadPropertyFile("IPriceMalaysiacouponurl"));
	}
	
	// Method to find the List of Stores in the "Find the Best Deals Online"
	
	public void bestDeals()
	{
		storesList = driver.findElements(By.xpath(ReadPropertyFile("ListofStoresPath")));
		
		 StoreCount= storesList.size();
		
		for(WebElement Name :storesList)
		{
			String StoreName=Name.getText();
			FullStoreList.add(StoreName);
		}
		
	    
	}
	
	// Method to get the list of Top Stores by index
	
	 public  WebElement getElementWithIndex(By by, int index)
		{
			 List<WebElement> TopStores=driver.findElements(By.xpath("//section[@data-uat='top-stores']//following-sibling::p//a"));
			 
			 return TopStores.get(index);
			
		}
	 
	 // Method to find the list of Top Trending Product without  “data-vars-cgt” attribute
	 
	 public void topTrendingProduct1()
	 {
		// Locating xpath without  “data-vars-cgt” attribute
			
			TrendingProduct=driver.findElements(By.xpath(ReadPropertyFile("TopTrendingProduct1")));
			count1=TrendingProduct.size();
	 }
	 
	// Method to find the list of Top Trending Product with  “data-vars-cgt” attribute
	 
	 public void topTrendingProduct2()
	 {
		// Locating with  “data-vars-cgt” attribute
			
			TrendingProduct2=driver.findElements(By.xpath(ReadPropertyFile("TopTrendingProduct2")));
			count2=TrendingProduct2.size();
	 }
	 
	 // Method to find the Count of URL in the Top Stores
	 
	 public void topStoresLink()
	 {
		 TopStoresLink=driver.findElements(By.xpath(ReadPropertyFile("TopStoresCouponsPath")));
		 TopStoreslinkcount=TopStoresLink.size();
		 System.out.println("The Count of URL in the web Page:" +TopStoreslinkcount);
	 }
	 
	// Method to find the List and count of active URL in the Top Stores
	 
	 public void activeURL()
	 {
		 for(int i=0;i<TopStoreslinkcount;i++)
			{	
							
				if(TopStoresLink.get(i).isEnabled())
				{
					TopStoreLinkList=TopStoresLink.get(i).getAttribute("href");
					TopStoreLinkNameList.add(TopStoreLinkList);
					Activecount++;
					System.out.println("The List of Active URL:" +TopStoreLinkList);
					 
				}
				else
				{
					String notActiveLinks =TopStoresLink.get(i).getAttribute("href");
					System.out.println("The Link is not Active:" +notActiveLinks);
				}
						
							
			}	
			
			System.out.println("The Count of URL Which is Active:" +Activecount);
			
	 }
	 
	 
	 // Method to find the URL in Top Stores are redirected to their proper store url
	 
	 public void urlRedirect()
	 {
		 
		 for(int i=0;i<TopStoreslinkcount;i++)
			{	
							
					TopStoreLinkList=TopStoresLink.get(i).getAttribute("href");
					TopStoreLinkNameList.add(TopStoreLinkList);
					 
			}
				
		 for(int index=0;index<TopStoreslinkcount;index++)
			{
				
			getElementWithIndex(By.tagName("a"), index).click();
			String currentURL=driver.getCurrentUrl();
			URLName.add(currentURL);
			TopStoresURL=URLName.get(index);
			System.out.println(TopStoresURL);
			driver.navigate().back();
			}
		
		 if(TopStoreLinkNameList.equals(URLName))
			{
		System.out.println("List of stores in Top Stores is redirected to their proper store url");
			}
		 else
		 	{
		System.out.println("List of stores in Top Stores is not redirected to their proper store url");
		 	}
		 
	 }
	 
	 // Method to Close the browser session
	 
	public void close()
	{
		driver.quit();
	}
	
	
}
