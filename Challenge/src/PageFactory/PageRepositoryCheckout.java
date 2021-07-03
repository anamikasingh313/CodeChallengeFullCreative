package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageRepositoryCheckout {
public WebDriver driver;
public PageRepositoryCheckout(WebDriver driver){
	this.driver=driver;
}
	By firstname=By.id("first-name");
	By lastname=By.id("last-name");
	By PostalCode=By.id("postal-code");
    By Continue=By.id("continue");
  
    public   WebElement GetFirstName() {
		return driver.findElement(firstname);
}
    public   WebElement GetLastName() {
		return driver.findElement(lastname);
}
    public   WebElement GetpostalCode() {
		return driver.findElement(PostalCode);
    }
    
    public   WebElement DoContiue() {
		return driver.findElement(Continue);
    }
}