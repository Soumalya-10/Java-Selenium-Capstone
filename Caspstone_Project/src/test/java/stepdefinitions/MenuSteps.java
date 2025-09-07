package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.LoginPage;
import page.HomePage;
import java.time.Duration;

public class MenuSteps {
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

    @When("I open the menu")
    public void i_open_the_menu() {
        homePage.clickMenuButton();
    }

    @Then("the menu should be visible")
    public void the_menu_should_be_visible() {
        assert homePage.isMenuVisible();
        driver.quit();
    }

    @When("I logout")
    public void i_logout() {
        homePage.logout();
    }

    @Then("I should be redirected to the login page")
    public void i_should_be_redirected_to_the_login_page() {
        assert homePage.isLoginPageDisplayed();
        driver.quit();
    }
}
