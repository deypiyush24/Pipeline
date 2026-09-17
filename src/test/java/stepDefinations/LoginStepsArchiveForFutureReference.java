package stepDefinations;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.logging.Logger;

public class LoginStepsArchiveForFutureReference {

    private static final Logger log = Logger.getLogger(LoginStepsArchiveForFutureReference.class.getName());
    ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    /* future Reference only
//    private WebDriver driver;

//    @Given("I open the browser")
//    public void i_open_the_browser() {
//        String systemValue = System.getProperty("runMode");
//
//        String runMode = System.getProperty("runMode"); // The Tag Name in Surefire plugin
//
//        System.out.println("---------------------------------");
//        System.out.println("Current Run Mode: " + runMode);
//        System.out.println("---------------------------------");
//
//
//
//
//        log.info("System value: " + systemValue);
//        if (systemValue.equals("docker")) {
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--headless", "--window-size=1920,1080");
//            try {
//                // "selenium-hub" is the name of the service in your Docker Compose file
//                driver = new RemoteWebDriver(new URL("http://selenium-hub:4444/wd/hub"), options);
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            }
//        } else {
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
//        }
//
//        // Here We added Conncept of ThreadLocal Driver which controls Single driver
//        driverThreadLocal.set(driver);
//        driver =  driverThreadLocal.get();
//    }
//
//    @When("I navigate to the OrangeHRM login page")
//    public void i_navigate_to_the_orangehrm_login_page() {
//
//        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//    }
//
//    @Then("the login page should be displayed")
//    public void the_login_page_should_be_displayed() {
//        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.titleContains("OrangeHRM"));
//        WebElement adminWebElement =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p[class ='oxd-text oxd-text--p']")));
//        WebElement passwordWebElement=  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p [text() = 'Password : admin123']")));
//        String userName = adminWebElement.getText().trim().split(":")[1].trim();
//        String passWord = passwordWebElement.getText().trim().split(":")[1].trim();
//        System.out.printf("This is UserName : %s and This is password %s%n", userName,passWord );
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains (@name ,'username')]"))).sendKeys(userName);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains (@name ,'password')]"))).sendKeys(passWord);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']"))).click();
////        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text() ='Jane Doe']")));
//
//    }
//
//    @After
//    public void tearDown() {
//        System.out.println("Driver shut down");
//        if (driver != null) {
//            driver.quit();
//        }
//    }


     */

}
