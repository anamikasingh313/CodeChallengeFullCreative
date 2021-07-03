package TestScenarios;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import PageFactory.PageRepositoryConfirmation;

public class Confirmation {
	public WebDriver driver;
  @Test
  public void confimation() {
	  PageRepositoryConfirmation c=new PageRepositoryConfirmation(driver);
	 System.out.println(c.GetConfirmation().getText());
	  
  }
  @AfterTest
  public void close() {
  	driver.close();
  }
  }

