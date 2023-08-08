package com.example.logicstudiotest2;

import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://opencart.abstracta.us/index.php?route=account/login");

        mainPage = new MainPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void testSuccessfulLogin() {
        // Ingresa las credenciales válidas
        WebElement usernameField = driver.findElement(By.id("input-email"));
        WebElement passwordField = driver.findElement(By.id("input-password"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[value='Login']"));

        usernameField.sendKeys("carlos.sorto@easylifehn.com");
        passwordField.sendKeys("Test123");
        loginButton.click();

        // Validation 1: Verify that login is successfull
        WebElement myAccountLink = driver.findElement(By.linkText("My Account"));
        assertTrue(myAccountLink.isDisplayed());
    }

    @Test(priority = 2)
    public void testFailedLogin() {
        // Input invalid credentials
        WebElement usernameField = driver.findElement(By.id("input-email"));
        WebElement passwordField = driver.findElement(By.id("input-password"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[value='Login']"));

        usernameField.sendKeys("correo_invalido@example.com");
        passwordField.sendKeys("contraseña_invalida");
        loginButton.click();

        // Validation 1: Verify the error message is displayed
        WebElement alertMessage = driver.findElement(By.cssSelector(".alert-danger"));
        assertTrue(alertMessage.isDisplayed());

        // Validation 2: Verify that the error message has te expected message
        String expectedErrorMessage = "Warning: No match for E-Mail Address and/or Password.";
        assertTrue(alertMessage.isDisplayed());
        assertEquals(alertMessage.getText(), expectedErrorMessage);
    }
}
