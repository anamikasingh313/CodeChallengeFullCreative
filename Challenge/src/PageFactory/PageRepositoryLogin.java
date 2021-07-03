package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageRepositoryLogin {
public WebDriver driver;
//Login page

public PageRepositoryLogin(WebDriver driver){
	this.driver=driver;
}
//Username
By username=By.id("user-name");
	//Password
By password=By.id("password");
// Login
By login=By.id("login-button");

By error=By.xpath("//div[@class='error-message-container error']/h3");
	
public WebElement GetUsername() {
	return driver.findElement(username);
}
public WebElement GetPassword() {
	return driver.findElement(password);
}
public WebElement DoLogin() {
	return driver.findElement(login);
}
public WebElement GetError() {
	return driver.findElement(error);
}

}
