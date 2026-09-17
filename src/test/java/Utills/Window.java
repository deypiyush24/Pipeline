package Utills;

import org.openqa.selenium.WebDriver;

public class Window {

    private final WebDriver driver;
    String mainWindow;
    public Window(WebDriver driver)
    {
       this.mainWindow =  driver.getWindowHandle();
       this.driver = driver;
    }

    public void switchToDefaultWindow()
    {
        driver.switchTo().window(mainWindow);
    }


}
