package Utills;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Alerts {
    private static final Logger log = LoggerFactory.getLogger(Alerts.class);
    WaitUtils waitUtils;
    private final Alert alert;

    public Alerts(WebDriver driver) {
        WaitUtils waitUtils = new WaitUtils(driver);
        log.info(" Driver is Passed in Alert Class : {}", driver);
        this.alert = driver.switchTo().alert();
        waitUtils.getTheWait().until(ExpectedConditions.alertIsPresent());
    }

    public void acceptTheAlert() {
        alert.accept();
        log.info("Accepted {}", Alerts.class.getName());

    }
    public void dismissTheAlert() {
        alert.dismiss();
        log.info("Dismissed {}", Alerts.class.getName());

    }
    public void sendKeysAlert(String inputValue) {
        alert.sendKeys(inputValue);

    }
    public String getTheAlertMessage() {
       return  alert.getText();

    }
}
