package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.LoginPage;
import page.HomePage;
import page.CartPage;
import java.time.Duration;

public class CheckoutSteps {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    CartPage cartPage;

    @Given("I have an item in my cart")
    public void i_have_an_item_in_my_cart() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        homePage.addItemToCart("Sauce Labs Backpack");
        cartPage.openCart();
    }

    @When("I proceed to checkout with first name {string}, last name {string}, and postal code {string}")
    public void i_proceed_to_checkout_with_details(String firstName, String lastName, String postalCode) {
        cartPage.clickCheckout();
        cartPage.fillCheckoutDetails(firstName, lastName, postalCode);
    }

    @When("I finish the order")
    public void i_finish_the_order() {
        cartPage.finishCheckout();
    }

    @Then("I should see the order confirmation message")
    public void i_should_see_the_order_confirmation_message() {
        assert cartPage.isOrderComplete();
        driver.quit();
    }
}
