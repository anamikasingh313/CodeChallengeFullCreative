package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageRepositoryFinish {
public WebDriver driver;
public PageRepositoryFinish(WebDriver driver){
	this.driver=driver;
}
By finish=By.id("finish");
public   WebElement ClickFinish() {
	return driver.findElement(finish);
}
}
