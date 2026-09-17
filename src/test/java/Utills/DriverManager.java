package Utills;

import org.openqa.selenium.WebDriver;

public class DriverManager {


    // Thread Safety
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Set driver
    public static void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance);
    }

    // Get driver
    public static WebDriver getDriver() {
        return driver.get();
    }

    // Quit driver
    public static void quitDriver() {
        driver.get().quit();
        driver.remove(); // very important to avoid memory leaks
    }
}