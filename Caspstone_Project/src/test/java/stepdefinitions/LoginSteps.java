package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.LoginPage;
import page.HomePage;
import java.time.Duration;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @When("I login with username {string} and password {string}")
    public void i_login_with_username_and_password(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("I should be redirected to the products page")
    public void i_should_be_redirected_to_the_products_page() {
        assert homePage.isProductsPageDisplayed();
        driver.quit();
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        assert loginPage.getErrorMessage().contains("Epic sadface");
        driver.quit();
    }
}
