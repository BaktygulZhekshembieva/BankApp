package UI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class ToolsQA {
    String name = "Baktygul";
    String lastName = "Zhekshembieva";
    String email = "baku@mail.com";
    String mobileNum = "0706615116";
    String dateOfBirth = "30 Dec 1987";
    String address = "prostpect Mira 29";
    String permanent = "Wall street 1";
    @Test
    public void tests() {
        WebDriverManager.chromedriver().setup(); // otkroem cherez chrom
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize(); // otkryvaet stranitsu vo ves' ekran
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // 10 sek ;let

        driver.get("https://demoqa.com/text-box"); // jtkroet etu ssylku

        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys(name);

        WebElement emailinput = driver.findElement(By.id("userEmail"));
        emailinput.sendKeys(email);

        WebElement addressinput = driver.findElement(By.id("currentAddress"));
        addressinput.sendKeys(address);

        WebElement permanentinput = driver.findElement(By.id("permanentAddress"));
        permanentinput.sendKeys(permanent);

        WebElement button = driver.findElement(By.id("submit"));
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform(); // skroll vniz
        button.click();

        WebElement idName = driver.findElement(By.id("name"));
        Assertions.assertEquals(name, idName.getText().substring(5));

        WebElement idEmail = driver.findElement(By.id("email"));
        Assertions.assertEquals(email, idEmail.getText().substring(6));

//        WebElement idAddress = driver.findElement(By.id("(//p[@class=\"mb-1\"])[3]"));
//        Assertions.assertEquals(address,idAddress.getText().substring(17));
//
//        WebElement idpermananet = driver.findElement(By.id("(//p[@class=\"mb-1\"])[4]"));
//        Assertions.assertEquals(permanent, idpermananet.getText().substring(20));
    }

    @Test
    public void xpathTest(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize(); // otkryvaet stranitsu vo ves' ekran
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // 10 sek ;let

        driver.get("https://demoqa.com/text-box"); // jtkroet etu ssylku

        WebElement fullNameInputField = driver.findElement(By.xpath("//input[@placeholder='Full Name']"));
        fullNameInputField.sendKeys("Baha");

        WebElement emailInputField = driver.findElement(By.xpath("//input[@id='userEmail']"));
        emailInputField.sendKeys("baha@mail.com");

        WebElement currentAddressInputField = driver.findElement(By.xpath("(//textarea[@class=\"form-control\"])[1]"));
        currentAddressInputField.sendKeys("Wall Street 123");

        WebElement permanentAddressInputField = driver.findElement(By.xpath("(//textarea[@rows=\"5\"])[2]"));
        permanentAddressInputField.sendKeys("Boston 456");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
        submitButton.click();
    }

    @Test
    public void studentRegistrationForm() throws AWTException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize(); // otkryvaet stranitsu vo ves' ekran
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // 10 sek ;let

        driver.get("https://demoqa.com/automation-practice-form");

        WebElement nameInputSRF = driver.findElement(By.id("firstName"));
        nameInputSRF.sendKeys(name);

        WebElement lastNameInputSRF = driver.findElement(By.id("lastName"));
        lastNameInputSRF.sendKeys(lastName);

        WebElement emailInputSTF = driver.findElement(By.id("userEmail"));
        emailInputSTF.sendKeys(email);

        WebElement gender = driver.findElement(By.xpath("(//label[@class=\"custom-control-label\"])[2]"));
        gender.click();

        WebElement mobileNumberSTF = driver.findElement(By.id("userNumber"));
        mobileNumberSTF.sendKeys(mobileNum);

//        WebElement dateOfBirthInputSTF = driver.findElement(By.id("dateOfBirthInput"));
//        for (int i = 0; i < 10; i++){
//        dateOfBirthInputSTF.sendKeys(Keys.BACK_SPACE);
//        }
//        dateOfBirthInputSTF.sendKeys(dateOfBirth);

        WebElement dateOfBirth = driver.findElement(By.xpath("//input[@id=\"dateOfBirthInput\"]"));
        dateOfBirth.click();
        Select months = new Select(driver.findElement(By.xpath("//select[@class=\"react-datepicker__month-select\"]")));
        months.selectByVisibleText("October");
        Select years = new Select(driver.findElement(By.xpath("//select[@class=\"react-datepicker__year-select\"]")));
        years.selectByVisibleText("2000");
        WebElement date = driver.findElement(By.xpath("//div[@class=\"react-datepicker__day react-datepicker__day--031\"]"));
        date.click();

        WebElement subjectsInputSTF = driver.findElement(By.xpath("//input[@id=\"subjectsInput\"]"));
        subjectsInputSTF.click();
        subjectsInputSTF.sendKeys("Ma");
        subjectsInputSTF.sendKeys(Keys.ENTER);
        subjectsInputSTF.sendKeys("Ph");
        subjectsInputSTF.sendKeys(Keys.ENTER);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        WebElement sportButton = driver.findElement(By.xpath("(//label[@class='custom-control-label'])[4]"));
        sportButton.click();
        WebElement readButton = driver.findElement(By.xpath("(//label[@class='custom-control-label'])[5]"));
        readButton.click();
        WebElement musicButton = driver.findElement(By.xpath("(//label[@class='custom-control-label'])[6]"));
        musicButton.click();

        WebElement pictureInput = driver.findElement(By.xpath("//input[@id='uploadPicture']"));
        pictureInput.sendKeys("C:\\Users\\User\\Downloads\\кужа.png");

        Robot robot = new Robot();
        for (int i = 0; i < 4; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }

        WebElement addressInput = driver.findElement(By.xpath("//textarea[@id=\"currentAddress\"]"));
        addressInput.sendKeys("Kerben");

        WebElement cityInput = driver.findElement(By.xpath("//input[@id='react-select-3-input']"));
        cityInput.sendKeys("Haryana");
        cityInput.sendKeys(Keys.ENTER);

        WebElement cityButton = driver.findElement(By.xpath("//input[@id='react-select-4-input']"));
        cityButton.sendKeys("Karnal");
        cityButton.sendKeys(Keys.ENTER);

        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
        submitButton.click();



    }
}
