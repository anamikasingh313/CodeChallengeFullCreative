package TestScenarios;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageFactory.BrowserInitialization ;

import PageFactory.PageRepositoryLogin;

public class Login extends BrowserInitialization  {
	
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
	  
	  
 
@AfterTest
public void close() {
	driver.close();
}
}


