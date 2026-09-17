package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage
{
    protected WebDriver driver;
    private final Wait<WebDriver> wait;
    public BasePage(WebDriver driver)
    {
        this.driver =  driver;
        PageFactory.initElements(driver, this); // Here we used Page Factory to Start using the @FindBy
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToTheURL(String title)
    {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        wait.until(ExpectedConditions.titleContains(title));
    }




}
