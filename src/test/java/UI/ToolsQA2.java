package UI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.time.Duration;

public class ToolsQA2 {
    @Test
    public void buttons() throws AWTException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize(); // otkryvaet stranitsu vo ves' ekran
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // 10 sek ждет. явная ожидание

        driver.get("https://demoqa.com/automation-practice-form");

    }
}
