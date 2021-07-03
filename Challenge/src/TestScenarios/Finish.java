package TestScenarios;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import PageFactory.PageRepositoryFinish;

public class Finish {
public WebDriver driver;
  @Test
  public void finish() {
	  
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("window.scrollBy(0,500)");
	  PageRepositoryFinish f=new PageRepositoryFinish(driver);
	  f.ClickFinish().click();
  }
  
  
}
