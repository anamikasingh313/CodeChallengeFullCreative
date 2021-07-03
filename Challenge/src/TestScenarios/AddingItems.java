package TestScenarios;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import PageFactory.PageRepositoryItems;

public class AddingItems {
	public WebDriver driver;
  @Test
  public void Items() {
	  String[] itemsneeded= {"Backpack","Bike","Bolt","Fleece"};
	  PageRepositoryItems pt=new PageRepositoryItems(driver);
	  additems(driver,itemsneeded);
	  pt.GetShopppingCart().click();
	  pt.DoCheckout().click();
	  }
	 public void additems(WebDriver driver, String[] itemsneeded) {
			int j=0;
PageRepositoryItems it=new PageRepositoryItems(driver);
List<WebElement>Products=it.GetItems();
for(int i=0;i<Products.size();i++) {
	String[] name=Products.get(i).getText().split(" ");
	String FormattedName=name[2].trim();
	List Itemsneededlist=Arrays.asList(itemsneeded);
	if(Itemsneededlist.contains(FormattedName)){
		
			j++;
			it.GetSelectedItems().get(i).click();
			if(j==itemsneeded.length)
				
				break;
	}
			
}
	 }
	 @AfterTest
	 public void close() {
	 	driver.close();
	 }
	 }


