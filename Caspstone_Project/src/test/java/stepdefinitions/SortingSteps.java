package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.LoginPage;
import page.HomePage;
import java.time.Duration;

public class SortingSteps {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;

    @Given("I am logged in with {string} and {string}")
    public void i_am_logged_in_with(String username, String password) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginPage.login(username, password);
    }

    @When("I sort products by {string}")
    public void i_sort_products_by(String sortValue) {
        homePage.sortProducts(sortValue);
    }

    @Then("products should be sorted by name ascending")
    public void products_should_be_sorted_by_name_ascending() {
        assert homePage.isSortedByNameAscending();
        driver.quit();
    }

    @Then("products should be sorted by price high to low")
    public void products_should_be_sorted_by_price_high_to_low() {
        assert homePage.isSortedByPriceHighToLow();
        driver.quit();
    }
}
