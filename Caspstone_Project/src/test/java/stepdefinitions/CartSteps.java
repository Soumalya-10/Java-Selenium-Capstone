package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.LoginPage;
import page.HomePage;
import page.ProductsPage;
import page.CartPage;
import java.time.Duration;

public class CartSteps {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    ProductsPage productsPage;
    CartPage cartPage;

    @Given("I am logged in with {string} and {string}")
    public void i_am_logged_in_with(String username, String password) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        loginPage.login(username, password);
    }

    @When("I add {string} to the cart")
    public void i_add_to_the_cart(String productName) {
        homePage.addItemToCart(productName);
    }

    @Then("the cart count should be {int}")
    public void the_cart_count_should_be(Integer count) {
        assert homePage.getCartCount() == count;
        driver.quit();
    }

    @Given("I have {string} in my cart")
    public void i_have_in_my_cart(String productName) {
        i_am_logged_in_with("standard_user", "secret_sauce");
        homePage.addItemToCart(productName);
        homePage.getCartCount();
    }

    @When("I remove it from the cart")
    public void i_remove_it_from_the_cart() {
        productsPage.removeBackpackFromCart();
    }

    @Then("the cart should be empty")
    public void the_cart_should_be_empty() {
        assert homePage.getCartCount() == 0;
        driver.quit();
    }
}
