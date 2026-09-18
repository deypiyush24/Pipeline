package stepDefinations.hooks;

import utils.web.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;


public class Hooks {
    private static final Logger log = LoggerFactory.getLogger(Hooks.class);
    private final WebDriver driver;
    public Hooks ()
    {
        this.driver = DriverManager.getDriver();
    }

    @Before
    public void startOfTheAutomation()
    {
       System.out.println("-".repeat(20)+ "Automation is starting" + "-".repeat(20));
    }


    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed() && driver != null) {
            scenario.attach(getTheScreenShotInBytes(), "image/png", "Failed_Screenshot");// In the cucumber Report
            saveTheScreenShot(scenario);
            DriverManager.quitDriver();
        }
        else
        {
            DriverManager.quitDriver();
        }
    }


    private byte[] getTheScreenShotInBytes()
    {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        return screenshot.getScreenshotAs(OutputType.BYTES);

    }

    private File getTheScreenShotInFiles()
    {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        return screenshot.getScreenshotAs(OutputType.FILE);

    }

    private void saveTheScreenShot(Scenario scenario)  {
        try {
            // 1. Sanitize scenario name to avoid illegal file characters (spaces, colons, etc.)
            String sanitizedName = scenario.getName().replaceAll("[^a-zA-Z0-9-_]", "_");

            // 2. Define your target path
            Path absolutePath = Path.of("screenShots", sanitizedName + ".png").toAbsolutePath();

            // 3. Ensure the 'screenShots' folder exists
            Files.createDirectories(absolutePath.getParent());

            // 4. Get the temporary file from Selenium
            File sourceFile = getTheScreenShotInFiles();

            // 5. Copy the temporary file to your final destination
            Files.copy(sourceFile.toPath(), absolutePath, StandardCopyOption.REPLACE_EXISTING);

            log.info("Screenshot saved successfully at: {}", absolutePath);

        } catch (Exception e) {
            log.error("Failed to save screenshot for scenario: {}", scenario.getName(), e);
        }
    }
}
