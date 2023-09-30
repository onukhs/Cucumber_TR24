package steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static steps.BrowserSetup.getDriver;

public class StepDefinitions {
    private final WebDriver driver = getDriver();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver.get("https://www.saucedemo.com/");
        System.out.println("STEP 1 - I ON THE LOGIN PAGE");
    }
    @When("I enter valid username and password")
    public void i_enter_valid_username_and_password() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        System.out.println("STEP 2 - I ENTERED VALID USERNAME AND PASSWORD");
    }

    @When("I enter invalid {string} and {string}")
    public void i_enter_invalid_username_and_password(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);

        System.out.println("STEP 2 - I ENTERED INVALID USERNAME AND PASSWORD: " + username + " " + password);
    }
    @When("I click on Login button")
    public void i_click_on_login_button(){
        driver.findElement(By.id("login-button")).click();
        System.out.println("STEP 3 - I CLICKED ON LOGIN BUTTON");

    }
    @Then("I should be logged in")
    public void i_should_be_logged_in() {
        driver.findElement(By.id("shopping_cart_container"));
        System.out.println("STEP 4 - I AM LOGGED IN");

    }

    @Then("I should see an {string}")
    public void i_should_see_an_error(String errorMessage) {
        String errorActual = driver.findElement(By.xpath("//*[@data-test='error']")).getText();

        if(errorActual.equals(errorMessage)){
            System.out.println("INFO - ERROR MESSAGES ARE SIMILAR");
        } else{
            System.out.println("ERROR - MESSAGES ARE DIFFERENT");
        }
    }

    @Then("I should not be logged in")
    public void i_should_not_be_logged_in() {
        driver.findElement(By.id("login-button"));
        System.out.println("INFO - USER IS NOT LOGGED IN");
    }

}
