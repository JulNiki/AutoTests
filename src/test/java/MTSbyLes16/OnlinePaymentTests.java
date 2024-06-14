package MTSbyLes16;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OnlinePaymentTests {
    private static WebDriver driver;

    @BeforeAll
    public static void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://mts.by");
        try {
            WebElement cookieAgreeButton = driver.findElement(By.id("cookie-agree"));
            cookieAgreeButton.click();
        } catch (NoSuchElementException e){
        }
    }

    @Test
    @DisplayName("id_5. Проверка плейсхолдера поля ввода телефона для варианта «Услуги связи»")
    public void testPlaceholderPhoneInputFieldCommunicationServices() {
        WebElement phoneInputField = driver.findElement(By.id("connection-phone"));
        assertTrue(phoneInputField.getAttribute("placeholder").contains("Номер телефона"), "id_5. Ошибка: плейсхолдер поля ввода телефона для варианта «Услуги связи» не соответствует ожидаемому");
    }

    @Test
    @DisplayName("id_6. Проверка плейсхолдера поля ввода суммы для варианта «Услуги связи»")
    public void testPlaceholderSumInputFieldCommunicationServices(){
        WebElement sumInputField = driver.findElement(By.id("connection-sum"));
        assertTrue(sumInputField.getAttribute("placeholder").contains("Сумма"), "id_6. Ошибка: плейсхолдер поля ввода суммы для варианта «Услуги связи» не соответствует ожидаемому" );
    }

    @Test
    @DisplayName("id_7. Проверка плейсхолдера поля ввода email для варианта «Услуги связи»")
    public void testPlaceholderEmailInputFieldCommunicationServices(){
        WebElement emailInputField = driver.findElement(By.id("connection-email"));
        assertTrue(emailInputField.getAttribute("placeholder").contains("E-mail для отправки чека"),"id_7. Ошибка: плейсхолдер поля ввода email для варианта «Услуги связи» не соответствует ожидаемому" );
    }


    @Test
    @DisplayName("id_8. Проверка плейсхолдера поля ввода телефона для варианта «Домашний интернет»")
    public void testPlaceholderPhoneInputFieldHomeInternet() {
        WebElement dropdown = driver.findElement(By.cssSelector("[class=select__header]"));
        dropdown.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='select__option' and contains(text(), 'Домашний интернет')]")));
        option.click();
        WebElement phoneInputField = driver.findElement(By.id("internet-phone"));
        assertTrue(phoneInputField.getAttribute("placeholder").contains("Номер абонента"), "id_8. Ошибка: плейсхолдер поля ввода телефона для варианта «Домашний интернет» не соответствует ожидаемому");
    }

    @Test
    @DisplayName("id_9. Проверка плейсхолдера поля ввода суммы для варианта «Домашний интернет»")
    public void testPlaceholderSumInputFieldHomeInternet() {
        WebElement dropdown = driver.findElement(By.cssSelector("[class=select__header]"));
        dropdown.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='select__option' and contains(text(), 'Домашний интернет')]")));
        option.click();
        WebElement sumInputField = driver.findElement(By.id("internet-sum"));
        assertTrue(sumInputField.getAttribute("placeholder").contains("Сумма"), "id_9. Ошибка: плейсхолдер поля ввода суммы для варианта «Домашний интернет» не соответствует ожидаемому");
    }

    @Test
    @DisplayName("id_10. Проверка плейсхолдера поля ввода email для варианта «Домашний интернет»")
    public void testPlaceholderEmailInputFieldHomeInternet() {
        WebElement dropdown = driver.findElement(By.cssSelector("[class=select__header]"));
        dropdown.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='select__option' and contains(text(), 'Домашний интернет')]")));
        option.click();
        WebElement sumInputField = driver.findElement(By.id("internet-email"));
        assertTrue(sumInputField.getAttribute("placeholder").contains("E-mail для отправки чека"), "id_10. Ошибка: плейсхолдер поля ввода email для варианта «Домашний интернет» не соответствует ожидаемому");
    }

    @Test
    @DisplayName("id_11. Проверка плейсхолдера поля ввода номера счета для варианта «Рассрочка»")
    public void testPlaceholderInvoiceNumberInputFieldInstallment() {
        WebElement dropdown = driver.findElement(By.cssSelector("[class=select__header]"));
        dropdown.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='select__option' and contains(text(), 'Рассрочка')]")));
        option.click();
        WebElement invoiceNumber = driver.findElement(By.id("score-instalment"));
        assertTrue(invoiceNumber.getAttribute("placeholder").contains("Номер счета на 44"), "id_11. Ошибка: плейсхолдер поля ввода номера счета для варианта «Рассрочка» не соответствует ожидаемому");
    }

    @Test
    @DisplayName("id_12. Проверка плейсхолдера поля ввода суммы для варианта «Рассрочка»")
    public void testPlaceholderSumInputFieldInstallment() {
        WebElement dropdown = driver.findElement(By.cssSelector("[class=select__header]"));
        dropdown.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='select__option' and contains(text(), 'Рассрочка')]")));
        option.click();
        WebElement sumInputField = driver.findElement(By.id("instalment-sum"));
        assertTrue(sumInputField.getAttribute("placeholder").contains("Сумма"), "id_10. Ошибка: плейсхолдер поля ввода суммы для варианта «Рассрочка» не соответствует ожидаемому");
    }

    @Test
    @DisplayName("id_13. Проверка плейсхолдера поля ввода email для варианта «Рассрочка»")
    public void testPlaceholderEmailInputFieldInstallment() {
        WebElement dropdown = driver.findElement(By.cssSelector("[class=select__header]"));
        dropdown.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='select__option' and contains(text(), 'Рассрочка')]")));
        option.click();
        WebElement sumInputField = driver.findElement(By.id("instalment-email"));
        assertTrue(sumInputField.getAttribute("placeholder").contains("E-mail для отправки чека"), "id_13. Ошибка: плейсхолдер поля ввода email для варианта «Рассрочка» не соответствует ожидаемому");
    }

    @Test
    @DisplayName("id_14. Проверка плейсхолдера поля ввода номера счета для варианта «Задолженность»")
    public void testPlaceholderInvoiceNumberInputFieldArrears() {
        WebElement dropdown = driver.findElement(By.cssSelector("[class=select__header]"));
        dropdown.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='select__option' and contains(text(), 'Задолженность')]")));
        option.click();
        WebElement invoiceNumber = driver.findElement(By.id("score-arrears"));
        assertTrue(invoiceNumber.getAttribute("placeholder").contains("Номер счета на 2073"), "id_14. Ошибка: плейсхолдер поля ввода номера счета для варианта «Задолженность» не соответствует ожидаемому");
    }

    @Test
    @DisplayName("id_15. Проверка плейсхолдера поля ввода суммы для варианта «Задолженность»")
    public void testPlaceholderSumInputFieldArrears() {
        WebElement dropdown = driver.findElement(By.cssSelector("[class=select__header]"));
        dropdown.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='select__option' and contains(text(), 'Задолженность')]")));
        option.click();
        WebElement sumInputField = driver.findElement(By.id("arrears-sum"));
        assertTrue(sumInputField.getAttribute("placeholder").contains("Сумма"), "id_15. Ошибка: плейсхолдер поля ввода суммы для варианта «Задолженность» не соответствует ожидаемому");
    }

    @Test
    @DisplayName("id_16. Проверка плейсхолдера поля ввода email для варианта «Задолженность»")
    public void testPlaceholderEmailInputFieldArrears() {
        WebElement dropdown = driver.findElement(By.cssSelector("[class=select__header]"));
        dropdown.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='select__option' and contains(text(), 'Задолженность')]")));
        option.click();
        WebElement sumInputField = driver.findElement(By.id("arrears-email"));
        assertTrue(sumInputField.getAttribute("placeholder").contains("E-mail для отправки чека"), "id_16. Ошибка: плейсхолдер поля ввода email для варианта «Задолженность» не соответствует ожидаемому");
    }

    @AfterEach
    public void returnToStart(){
        driver.get("http://mts.by");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
