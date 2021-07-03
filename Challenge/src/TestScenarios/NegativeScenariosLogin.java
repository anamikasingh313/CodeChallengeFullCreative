package TestScenarios;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageFactory.BrowserInitialization;
import PageFactory.PageRepositoryLogin;

public class NegativeScenariosLogin extends BrowserInitialization {
  public WebDriver driver;
	  @Test(timeOut=2000,dataProvider="getData")
	  public void Negative(String Username,String Password) throws IOException {
		  driver=initializeDriver();

		  PageRepositoryLogin Pr=new PageRepositoryLogin(driver);
		  Pr.GetUsername().sendKeys(Username);
		  Pr.GetPassword().sendKeys(Password);
		  
		  Pr.DoLogin().click();
		 
	  }
		  @DataProvider
		  public Object[][] getData(){
			  Object[][] data=new Object[4][2];
			  //First set of data
			  data[0][0]="locked_out_user";
			  data[0][1]="secret_sauce";
			//Second set of data
			  data[1][0]="InvalidUsername";
			  data[1][1]="secret_sauce";
			//Third set of data
			  data[2][0]="problem_user";
			  data[2][1]="InvalidPassword";
			//Fourth set of data
			  data[3][0]="InvalidUsername";
			  data[3][1]="InvalidPassword";
			  return data;
		  }
		  @AfterTest
		  public void close() {
		  	driver.close();
		  }
		  
}

