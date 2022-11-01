package com.talentlms.UI.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ChromeWebDriver {

    public static WebDriver loadChromeDriver(){ // ретурн метод который возвращает драйвер
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions(); // опции
        options.addArguments("--start-maximized"); // во весь экран
        options.addArguments("--disable-extensions"); // удаляет все расширения в браузере
        options.addArguments("--window-size=1920,1080"); // формат экрана


        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        return driver;

    }
}
