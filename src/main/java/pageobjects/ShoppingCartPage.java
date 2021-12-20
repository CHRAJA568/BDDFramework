package pageobjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCartPage {

    private final WebDriver webDriver;

    public ShoppingCartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//div[@class='shelf-container']/div[@class='shelf-item']")
    private List<WebElement> allProducts;

   

    @FindBy(xpath = "//img[@src='/static/media/10686354557628304_1.0d941b4c.jpg']")
    private WebElement lowestPriceProduct;

    @FindBy(xpath = "//div[@class='val']")
    private List<WebElement> productsPrice;

    @FindBy(xpath = "//label[contains(text(),'Harga')]//following-sibling::div//h4")
    private WebElement hargaProductDetail;

    @FindBy(xpath = "//div[@class='shelf-item__buy-btn']")
    private WebElement addToCart;

    @FindBy(xpath = "//span[@class='bag bag--float-cart-closed']")
    private WebElement cart;

    @FindBy(xpath = "//div[@class='buy-btn']")
    private WebElement checkoutButton;


	public String getCurrentUrl() {
		//returning the current Url of the Application 
		return webDriver.getCurrentUrl();
	}


	public int numberOfProductLoaded() {
		//Total products loaded on screen
		return allProducts.size();
	}

	public void selectSize(String size) {
		//Clicking on the Size filter,used the size parameter and had written dynamic XPATH,to make as an common method for all sizes across applications
		webDriver.findElement(By.xpath("//div[@class='filters-available-size']//span[text()='\"+size+\"']")).click();
	}

	public boolean numberOfRelevantProductsLoaded(int relevantSizeProductCount) {
		//checking the count of the relevant products loaded
		return webDriver.findElement(By.xpath("//span[text()='\"+relevantSizeProductCount+\"'][contains(.,'Product(s) found')]")).isDisplayed();
	}

	public void selectDropdownLowestToHigest() {
         //Selecting the order by to Lowest to Highest 
		Select orderByDropdown = new Select(webDriver.findElement(By.cssSelector("select")));
		orderByDropdown.selectByVisibleText("Lowest to highest");
	}

	public boolean verifytheProductsAreSortedInAscending() {
 		
		//Verifying the products are sorted in Ascending order

		// extracting the Productprices from the price elements and store in a List
		List<String> prices = new ArrayList<String>();
		for (WebElement e : productsPrice)
		{
		    prices.add(e.getText());
		}

		// copying into a new list for comparing
		List<String> sortedPrices = new ArrayList<String>(prices);

		// soringt the list,thanx to collections
		Collections.sort(sortedPrices);

		// retuns true if the prices are sorted
		return sortedPrices.equals(prices);


	}

	public boolean clickAddToCart() {
		
		//Verifyig the Add to cart is displayed and clicking the same
        if(addToCart.isDisplayed()) {
		addToCart.click();
		return true;
        }
        return false;   
	}

	public boolean verifyOneProductInCart() {
		//verifying One product is added into cart
         clickCart();
		return webDriver.findElement(By.xpath("//span[@class='bag']/span[text()='1']")).isDisplayed();
	}
	
	
     public void clickCart() {
		//clicking on cart
		cart.click();
	}

	public boolean verifyCheckOutButton() {
		//verifying the checkout button is displayed
		return checkoutButton.isDisplayed();
	}
}
