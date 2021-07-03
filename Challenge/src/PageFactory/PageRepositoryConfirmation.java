package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageRepositoryConfirmation {
public WebDriver driver;
public PageRepositoryConfirmation(WebDriver driver){
	this.driver=driver;
}
By confirmation=By.xpath("//h2[@class='complete-header']");

public   WebElement GetConfirmation() {
	return driver.findElement(confirmation);
}
}
