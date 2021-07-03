package TestScenarios;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageFactory.BrowserInitialization;
import PageFactory.PageRepositoryCheckout;
import PageFactory.PageRepositoryConfirmation;
import PageFactory.PageRepositoryFinish;
import PageFactory.PageRepositoryItems;
import PageFactory.PageRepositoryLogin;


public class MainTest extends BrowserInitialization{
	public WebDriver driver;
	@Test(priority=1,dataProvider="getData")
	  public void Login(String Username,String Password)throws IOException  {
		driver=initializeDriver();
		  PageRepositoryLogin Pr=new PageRepositoryLogin(driver);
		  Pr.GetUsername().sendKeys(Username);
		  Pr.GetPassword().sendKeys(Password);
		  
		  Pr.DoLogin().click();
		 
	  }
		  @DataProvider
		  public Object[][] getData(){
			  Object[][] data=new Object[3][2];
			  
			  //first set of data
			  data[0][0]="standard_user";
			  data[0][1]="secret_sauce";
			  //Second set of data
			  data[1][0]="problem_user";
			  data[1][1]="secret_sauce";
			//Third set of data
			  data[2][0]="performance_glitch_user";
			  data[2][1]="secret_sauce";
			  
			  return data;
		  }
		  
		  
	  
	 // Adding Items
	  @Test
	  public void items() {
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
	 @Test(dependsOnMethods= {"items"},dataProvider="StoreData") 
	  public void checkout(String Firstname,String Lastname, String Postalcode) {
		  PageRepositoryCheckout pc=new PageRepositoryCheckout(driver);
		  pc.GetFirstName().sendKeys(Firstname);
		  pc.GetLastName().sendKeys(Lastname);
		  pc.GetpostalCode().sendKeys(Postalcode);
		  pc.DoContiue().click();
	  }
	  @DataProvider
	  
		  public Object[][] StoreData(){
		  Object[][] datas=new Object[1][3];
		  datas[0][0]="Anamika";
		  datas[0][1]="Singh";
		  datas[0][2]="441404";
		  return datas;
	  }
	  @Test(dependsOnMethods= {"checkout"})
	  public void finish() {
		  
		  JavascriptExecutor js=(JavascriptExecutor)driver;
		  js.executeScript("window.scrollBy(0,500)");
		  PageRepositoryFinish f=new PageRepositoryFinish(driver);
		  f.ClickFinish().click();
	  }
	  @Test(dependsOnMethods= {"finish"})
	  public void confirmation() {
		  PageRepositoryConfirmation c=new PageRepositoryConfirmation(driver);
		 System.out.println(c.GetConfirmation().getText());
		  driver.close();
	  }
	}

