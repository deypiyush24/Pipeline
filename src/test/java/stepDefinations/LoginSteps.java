package stepDefinations;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.DashBoardPage;
import pages.LoginPage;
import utils.web.DriverFactory;
import utils.web.DriverManager;

import java.net.MalformedURLException;
import java.util.logging.Logger;
public class LoginSteps {

    private static final Logger log = Logger.getLogger(LoginSteps.class.getName());

    private LoginPage loginPage;
    private DashBoardPage dashBoardPage;
    WebDriver driver;
    @Given("I open the browser")
    public void i_open_the_browser() throws MalformedURLException {
        DriverFactory.initDriver("chrome");
        driver = DriverManager.getDriver();
        loginPage = new LoginPage(driver);
    }

    @When("I navigate to the OrangeHRM login page")
    public void i_navigate_to_the_orangehrm_login_page() {
        String title = "OrangeHRM";
        loginPage.navigateToTheURL(title);
    }

    @Then("the login page should be displayed")
    public void the_login_page_should_be_displayed() {
        loginPage.loginToTheOrangeHRMWithCredential();
    }

    @And("Validate we are on DashBoard Page {string}")
    public void validateWeAreOnDashBoardPage(String heading) {
        DashBoardPage dashBoardPage = new DashBoardPage(driver);
        dashBoardPage.validateTheHeading(heading);
    }






}
