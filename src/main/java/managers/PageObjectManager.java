package managers;


import org.openqa.selenium.WebDriver;
import pageobjects.ShoppingCartPage;

public class PageObjectManager {

    private final WebDriver webDriver;
    private ShoppingCartPage shoppingCartPage;

    public PageObjectManager(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public ShoppingCartPage geShoppingCartPage() {
        return (shoppingCartPage == null) ? shoppingCartPage = new ShoppingCartPage(webDriver) : shoppingCartPage;
    }
    
    

   
}
