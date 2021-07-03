package PageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageRepositoryItems {
	public WebDriver driver;
	WebDriverWait w=new WebDriverWait(driver,5);
	public PageRepositoryItems(WebDriver driver){
		this.driver=driver;
		
	}
	
	// All items
	By items=By.xpath("//div[@class='inventory_item']/div[2]/div[1]/a/div[1]");
// Add to cart Button
	By SelectedItems=By.xpath("//div[@class='inventory_item']/div[2]/div[2]/button");
	
	By ShoppingCart=By.xpath("//a[@class='shopping_cart_link']");
	
	By Checkout=By.id("checkout");
	public <WebElements>List<WebElement> GetItems() {
		return driver.findElements(items);
	}
	
	public  List<WebElement> GetSelectedItems() {
		return driver.findElements(SelectedItems);
				
	}
	public   WebElement GetShopppingCart() {
		return driver.findElement(ShoppingCart);
}
	public   WebElement DoCheckout() {
		return driver.findElement(Checkout);
}
}
