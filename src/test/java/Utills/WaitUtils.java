package Utills;

import frameWork.expections.ElementIssueExceptions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;


public class WaitUtils {

    private final static int DefaultValue = 10;
    private final Wait<WebDriver> webDriverWait;
    private final int defaultPolling = 2;
    private Wait<WebDriver> fluentWait;

    private static final Logger log = LoggerFactory.getLogger(WaitUtils.class);

    public Wait<WebDriver> getTheWait()
    {
      return webDriverWait;
    }

    public WaitUtils(WebDriver driver) {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(DefaultValue));
        fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(DefaultValue)).pollingEvery(Duration.ofSeconds(defaultPolling)).ignoring(NoSuchElementException.class);
    }


    public WaitUtils(WebDriver driver, int timeOut) {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeOut)).pollingEvery(Duration.ofSeconds(defaultPolling)).ignoring(NoSuchElementException.class);
    }

    public WaitUtils(WebDriver driver, int timeOut, int pollingTime) {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeOut)).pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class);
    }


    public WebElement waitForTheElementToVisible(WebElement element) {
        return webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForTheElementToVisible(By locator) {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement constPollToTheWebElement(WebElement element)
    {
        WebElement elementReturn;
        try {
            elementReturn = fluentWait.until(ExpectedConditions.visibilityOf(element));
            log.info("The Element Successfully Located: {}", element);
            return elementReturn;
        }
        catch (Exception e)
        {
            // Here we have Exceptions
            log.debug("There is error {}",e.getMessage());
            throw new ElementIssueExceptions(e.getMessage());
        }

    }




}
