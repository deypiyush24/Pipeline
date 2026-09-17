package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.logging.Logger;

public class LoginPage extends BasePage {
    private static final Logger log = Logger.getLogger(LoginPage.class.getName());
    Wait<WebDriver> wait;

    public LoginPage(WebDriver driver) {
        super(driver); // When used super we passed the Knowledge to Parent constructor
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @FindBy(css = "p[class ='oxd-text oxd-text--p']")
    WebElement adminWebElement;

    @FindBy(xpath = "//p [text() = 'Password : admin123']")
    WebElement passwordWebElement;

    @FindBy(css = "button[type='submit']")
    WebElement clickButton;

    public void loginToTheOrangeHRMWithCredential() {
        //WebElement adminWebElement =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p[class ='oxd-text oxd-text--p']")));
        wait.until(ExpectedConditions.visibilityOf(adminWebElement));
        wait.until(ExpectedConditions.visibilityOf(passwordWebElement));
        String userName = adminWebElement.getText().trim().split(":")[1].trim();
        String passWord = passwordWebElement.getText().trim().split(":")[1].trim();
        log.info(String.format("This is UserName : %s and This is password %s%n", userName, passWord));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains (@name ,'username')]"))).sendKeys(userName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains (@name ,'password')]"))).sendKeys(passWord);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']"))).click();
    }


}
