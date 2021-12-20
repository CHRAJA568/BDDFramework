	package stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import pageobjects.ShoppingCartPage;
import utilities.TestContext;


public class ShoppingCartSteps {

    TestContext testContext;
    ShoppingCartPage shoppingCartPage;

    public ShoppingCartSteps(TestContext context) {
        testContext = context;
        shoppingCartPage = testContext.getPageObjectManager().geShoppingCartPage();
    }

 

    @Given("^user opens the Shopping cart$")
    public void user_opens_the_Shopping_cart() throws Throwable {
    	 //opening he URL is already handled in hooks, so in future for any custom auth creds this method can be used
    }

    @When("^the user is on Homepage$")
    public void the_user_is_on_Homepage() throws Throwable {
    	//Assert for Correct URL Loaded
    	Assert.assertEquals(FileReaderManager.getInstance().getConfigFileReader().getUrl(), shoppingCartPage.getCurrentUrl());
  
    }

    @Then("^the user is able to see all  the '(\\d+)' products$")
    public void the_user_is_able_to_see_all_the_products(int expectedProductsCount) throws Throwable {
    	//Assert condition whether all the products got loaded or not,for this demo application it is 16 products
    	Assert.assertEquals(expectedProductsCount,shoppingCartPage.numberOfProductLoaded());
    }

    @When("^the user selects the partiular \"([^\"]*)\"$")
    public void the_user_selects_the_partiular(String size) throws Throwable {
    	//Passing the size filter as an input parameter from feature file doing so the same method can be reused for all the sizes
    	shoppingCartPage.selectSize(size);
    }

    @Then("^the user sees only the products of relevant size selected and verifies the  '(\\d+)'$")
    public void the_user_sees_only_the_products_of_relevant_size_selected_and_verifies_the(int relevantSizeProductCount) throws Throwable {
        //Passing the relevant size product count as an input parameter from feature file
    	Assert.assertTrue(shoppingCartPage.numberOfRelevantProductsLoaded(relevantSizeProductCount));
    }

    @When("^the user selects the order by filter lowest to highest$")
    public void the_user_selects_the_order_by_filter_lowest_to_highest() throws Throwable {
    	//Selecting the order by filter Lowest to Highest,can also done by passing as an input parameter but for now implemented only for lowesttohoghest value 
    	shoppingCartPage.selectDropdownLowestToHigest();
    }

    @Then("^the user verifies the lowest price product is displayed on top$")
    public void the_user_verifies_the_lowest_price_product_is_displayed_on_top() throws Throwable {
        //verifying the products are sorted in ascending order or not,thanks to collections
    	Assert.assertTrue(shoppingCartPage.verifytheProductsAreSortedInAscending());
    }

    @When("^the user adds one product to cart$")
    public void the_adds_one_product_to_cart() throws Throwable {
    	//Adding one product to cart
    	Assert.assertTrue(shoppingCartPage.clickAddToCart());
    	
    }

    @Then("^the user verifies the count in the cart is displayed as one\\.$")
    public void the_user_verifies_the_count_in_the_cart_is_displayed_as_one() throws Throwable {
       //Verifying one product is added in cart or not
      Assert.assertTrue(shoppingCartPage.verifyOneProductInCart());
    }

    @When("^the user clicks on the cart$")
    public void the_user_clicks_on_the_cart() throws Throwable {
    	//Clicking on cart
    	shoppingCartPage.clickCart();
    }

    @Then("^the user views the checkout button$")
    public void the_user_views_the_checkout_button() throws Throwable {
    	//verifying the checkout button
    	 Assert.assertTrue(shoppingCartPage.verifyCheckOutButton());
    	
    }
}
