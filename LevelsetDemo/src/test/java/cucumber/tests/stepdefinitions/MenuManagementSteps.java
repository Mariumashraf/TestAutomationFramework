package cucumber.tests.stepdefinitions;

import cucumber.pages.RestaurantMenu;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import cucumber.pages.RestaurantMenuItem;

public class MenuManagementSteps {
    RestaurantMenuItem restaurantMenuItem ;
    RestaurantMenu restaurantMenu = new RestaurantMenu();
    @Given("I have a menu item with name {string} and price {int}")
    public void i_have_a_menu_item_with_name_and_price(String menuItemName, Integer price) {
        restaurantMenuItem = new RestaurantMenuItem(menuItemName,menuItemName,price);
        System.out.println("Step 1");

    }
    @When("I add that menu item")
    public void i_add_that_menu_item() {
        restaurantMenu.addMenuItem(restaurantMenuItem);
        System.out.println("Step 2");

    }
    @Then("Menu item with name {string} should be added")
    public void menu_item_with_name_should_be_added(String string) {
        boolean Exists = restaurantMenu.doesItemExist(restaurantMenuItem);
        System.out.println("Step 3" + Exists);

    }

/*    @Given("I have a menu item with name {string} and price {int}")
    public void i_have_a_menu_item_with_name_and_price(String menuItemName, Integer price) {
        restaurantMenuItem = new RestaurantMenuItem(menuItemName,menuItemName,price);
        System.out.println("Step 1");

    }
    @When("I add that menu item")
    public void i_add_that_menu_item() {
        restaurantMenu.addMenuItem(restaurantMenuItem);
        System.out.println("Step 2");
    }

    @Then("Menu item with name {string} should be added")
    public void menu_item_with_name_should_be_added(String string) {
        boolean Exists = restaurantMenu.doesItemExist(restaurantMenuItem);
        System.out.println("Step 3" + Exists);

    }*/
}
