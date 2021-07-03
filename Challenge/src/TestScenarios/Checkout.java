package TestScenarios;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageFactory.PageRepositoryCheckout;

public class Checkout {
	public WebDriver driver;

			 @Test(dataProvider="StoreData")
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
  


}