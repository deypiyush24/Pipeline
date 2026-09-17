package Utills;

import org.jspecify.annotations.NonNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import stepDefinations.LoginSteps;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

public class DriverFactory {

    private static final Logger log = Logger.getLogger(DriverFactory.class.getName());

    public static void initDriver(String browser) throws MalformedURLException {

        WebDriver driver =null;
        String systemValue = System.getProperty("runMode");// The Tag Name in Surefire plugin
        System.out.println("---------------------------------");
        System.out.println("Current Run Mode: " + systemValue);
        System.out.println("---------------------------------");
        log.info("Driver Mode: " + systemValue);

        if (systemValue.equals("docker")) {
            // ChromeOptions is passed as Method Back there
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--headless", "--window-size=1920,1080");
            try {
                // "selenium-hub" is the name of the service in your Docker Compose file
                driver = new RemoteWebDriver(new URL("http://selenium-hub:4444/wd/hub"), getChromeOptionsForSeleniumGridWithDocker());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        else {
            switch (browser.toLowerCase())
            {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    chromeOptions.addArguments("--incognito");
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new RuntimeException("Invalid browser: " + browser);
            }
        }

        if( driver != null)
        {
            DriverManager.setDriver(driver);
        }
        else {
            System.out.println("Driver is null can't intinalise driver");
        }

    }

    private static @NonNull ChromeOptions getChromeOptionsForSeleniumGridWithDocker() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage"); // Overcomes limited resource problems
        options.addArguments("--disable-gpu");          // Crucial for Docker container rendering
        options.addArguments("--remote-allow-origins=*");

       // Add this if running on Apple Silicon / Mac M-series or experiencing crash on start
        options.addArguments("--disable-software-rasterizer");
        return options;
    }


}

