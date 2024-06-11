package MTSby;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;


public class TestMTS {
    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://mts.by");
        WebElement cookieAgreeButton = driver.findElement(By.id("cookie-agree")); // Клик по кнопке согласия на использование cookies
        cookieAgreeButton.click();
    }

    @Test
    @DisplayName("1. Проверка наличия и названия блока «Онлайн пополнение без комиссии»")
    public void testOnlineReplenishmentTitle() {
        WebElement titleElement = driver.findElement(By.xpath("//*[@class='pay__wrapper']"));
        String actualTitle = titleElement.getText();
        String expectedTitle = "Онлайн пополнение\nбез комиссии";
        Assertions.assertTrue(actualTitle.contains(expectedTitle),"Блок «Онлайн пополнение без комиссии» не найден на странице.");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }



}
