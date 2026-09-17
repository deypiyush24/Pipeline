package pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

public class DashBoardPage extends BasePage
{
    private static final Logger log = Logger.getLogger(DashBoardPage.class.getName());

    Wait<WebDriver> wait;
    public DashBoardPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy (css = "[class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    WebElement headingWebElement;

    public void validateTheHeading(String heading)
    {
        String headingActual = wait.until(ExpectedConditions.visibilityOf(headingWebElement)).getText();
        Assertions.assertThat(headingActual).isEqualTo(heading);
        log.info(String.format("Into the dashboard has heading : %s",headingActual));
//        SoftAssertions softly = new SoftAssertions();
//        softly.assertThat(successMessage.getText()).isEqualTo("Saved!");
//        softly.assertThat(submitButton.isEnabled()).isFalse();
//        softly.assertAll(); // Reports all failures at the very end

    }



}
