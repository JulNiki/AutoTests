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

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
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



    @Test
    @DisplayName("id_17. Описание платежа: проверка корректности отображения суммы, вариант оплаты «Услуги связи»")
    public void testCostDisplayedInPayDescriptionCommunicationServices(){
        WebElement phoneInputField = driver.findElement(By.id("connection-phone"));
        phoneInputField.sendKeys("297777777");
        WebElement sumInputField = driver.findElement(By.id("connection-sum"));
        double testInputSum = 499.99;
        sumInputField.sendKeys(String.valueOf(testInputSum));
        WebElement buttonContinue = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        buttonContinue.click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("bepaid-iframe")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"payment-page__container\"]")));
        WebElement payDescriptionCost = driver.findElement(By.xpath("//div[@class=\"pay-description__cost\"]/span[1]"));
        String expectedSumResult = String.format(Locale.US, "%.2f BYN", testInputSum);
        assertEquals(expectedSumResult, payDescriptionCost.getText(), "id_17. Ошибка: сумма в описании платежа не соответствует введённым данным для варианта «Услуги связи»");
    }

    @Test
    @DisplayName("id_18. Кнопка «Оплатить»: проверка корректности отображения суммы, вариант оплаты «Услуги связи»")
    public void testPayButtonSumIsDisplayedCorrectlyCommunicationServices(){
        WebElement phoneInputField = driver.findElement(By.id("connection-phone"));
        phoneInputField.sendKeys("297777777");
        WebElement sumInputField = driver.findElement(By.id("connection-sum"));
        double testInputSum = 1;
        sumInputField.sendKeys(String.valueOf(testInputSum));
        WebElement buttonContinue = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        buttonContinue.click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("bepaid-iframe")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"payment-page__container\"]")));
        WebElement payButton = driver.findElement(By.xpath("//app-card-page[@class=\"ng-star-inserted\"]//button[@type=\"submit\"]"));
        String expectedSumResult = String.format(Locale.US, "Оплатить %.2f BYN", testInputSum);
        assertEquals(expectedSumResult, payButton.getText(), "id_18. Ошибка. Кнопка оплатить: сумма не соответствует введённым данным для варианта «Услуги связи»");

    }

    @Test
    @DisplayName("id_19. Описание платежа: проверка корректности отображения номера телефона, вариант оплаты «Услуги связи»")
    public void testPhoneNumberDisplayedInPayDescriptionCommunicationServices(){
        String phoneInput = "297777777";
        WebElement phoneInputField = driver.findElement(By.id("connection-phone"));
        phoneInputField.sendKeys(phoneInput);
        WebElement sumInputField = driver.findElement(By.id("connection-sum"));
        sumInputField.sendKeys("2");
        WebElement buttonContinue = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        buttonContinue.click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("bepaid-iframe")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"payment-page__container\"]")));
        WebElement payDescriptionPhoneNumber = driver.findElement(By.xpath("//div[@class=\"payment-page__container\"]//span[@class=\"pay-description__text\"]"));
        String expectedPhoneResult = ("Оплата: Услуги связи Номер:375" + phoneInput);
        assertEquals(expectedPhoneResult, payDescriptionPhoneNumber.getText(), "id_19. Ошибка. Описание платежа: номер телефона не соответствует введённым данным для варианта «Услуги связи»" );

    }

    @Test
    @DisplayName("id_20. Поле ввода номера карты: проверка плейсхолдера для варианта оплаты «Услуги связи»")
    public void testCardNumberInputFieldCommunicationServices(){
        WebElement phoneInputField = driver.findElement(By.id("connection-phone"));
        phoneInputField.sendKeys("297777777");
        WebElement sumInputField = driver.findElement(By.id("connection-sum"));
        sumInputField.sendKeys("0.1");
        WebElement buttonContinue = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        buttonContinue.click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("bepaid-iframe")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"payment-page__container\"]")));
        WebElement cardNumberInputField = driver.findElement(By.xpath("//div[@class=\"content-container ng-tns-c46-1\"]//label"));
        assertEquals("Номер карты", cardNumberInputField.getText(), "id_20. Ошибка: плейсхолдер поля ввода номера карты для варианта «Услуги связи» не соответствует ожидаемому");
    }

    @Test
    @DisplayName("id_21. Поле срок действия карты: проверка плейсхолдера для варианта оплаты «Услуги связи»")
    public void testCardExpirationDateInputFieldCommunicationServices(){
        WebElement phoneInputField = driver.findElement(By.id("connection-phone"));
        phoneInputField.sendKeys("297777777");
        WebElement sumInputField = driver.findElement(By.id("connection-sum"));
        sumInputField.sendKeys("0.1");
        WebElement buttonContinue = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        buttonContinue.click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("bepaid-iframe")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"payment-page__container\"]")));
        WebElement cardExpirationDateField = driver.findElement(By.xpath("//div[@class=\"content ng-tns-c46-4\"]//label"));
        assertEquals("Срок действия", cardExpirationDateField.getText(), "id_21. Ошибка: плейсхолдер поля ввода срока действия карты для варианта «Услуги связи» не соответствует ожидаемому");
    }

    @Test
    @DisplayName("id_22. Поле CVC: проверка плейсхолдера для варианта оплаты «Услуги связи»")
    public void testCardCVCInputFieldCommunicationServices(){
        WebElement phoneInputField = driver.findElement(By.id("connection-phone"));
        phoneInputField.sendKeys("297777777");
        WebElement sumInputField = driver.findElement(By.id("connection-sum"));
        sumInputField.sendKeys("0.1");
        WebElement buttonContinue = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        buttonContinue.click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("bepaid-iframe")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"payment-page__container\"]")));
        WebElement cardCVCField = driver.findElement(By.xpath("//div[@class=\"content ng-tns-c46-5\"]//label"));
        assertEquals("CVC", cardCVCField.getText(), "id_22. Ошибка: плейсхолдер поля CVC карты для варианта «Услуги связи» не соответствует ожидаемому");
    }

    @Test
    @DisplayName("id_23. Поле Имя держателя: проверка плейсхолдера для варианта оплаты «Услуги связи»")
    public void testCardholderNameFieldCInputFieldCommunicationServices(){
        WebElement phoneInputField = driver.findElement(By.id("connection-phone"));
        phoneInputField.sendKeys("297777777");
        WebElement sumInputField = driver.findElement(By.id("connection-sum"));
        sumInputField.sendKeys("0.1");
        WebElement buttonContinue = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        buttonContinue.click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("bepaid-iframe")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"payment-page__container\"]")));
        WebElement cardholderNameField = driver.findElement(By.xpath("//div[@class=\"content ng-tns-c46-3\"]//label"));
        assertEquals("Имя держателя (как на карте)", cardholderNameField.getText(), "id_23. Ошибка: плейсхолдер поля Имя держателя карты для варианта «Услуги связи» не соответствует ожидаемому");
    }

    @Test
    @DisplayName("id_24. Поле номер карты: проверка наличия иконки платежной системы MasterCard для варианта оплаты «Услуги связи»")
    public void testMasterCardIconCardNumberFieldCommunicationServices(){
        WebElement phoneInputField = driver.findElement(By.id("connection-phone"));
        phoneInputField.sendKeys("297777777");
        WebElement sumInputField = driver.findElement(By.id("connection-sum"));
        sumInputField.sendKeys("2");
        WebElement buttonContinue = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        buttonContinue.click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("bepaid-iframe")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"payment-page__container\"]")));
        WebElement masterCardIcon = driver.findElement(By.xpath("//div[@class=\"cards-brands cards-brands__container ng-tns-c61-0 ng-trigger ng-trigger-brandsState ng-star-inserted\"]//img[@src=\"assets/images/payment-icons/card-types/mastercard-system.svg\"]"));
        assertTrue(masterCardIcon.isDisplayed(),"id_24. Ошибка. Поле номер карты: иконка платежной системы MasterCard не отображается");
    }

    @Test
    @DisplayName("id_25. Поле номер карты: проверка наличия иконки платежной системы Visa для варианта оплаты «Услуги связи»")
    public void testVisaIconCardNumberFieldCommunicationServices(){
        WebElement phoneInputField = driver.findElement(By.id("connection-phone"));
        phoneInputField.sendKeys("297777777");
        WebElement sumInputField = driver.findElement(By.id("connection-sum"));
        sumInputField.sendKeys("247");
        WebElement buttonContinue = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        buttonContinue.click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("bepaid-iframe")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"payment-page__container\"]")));
        WebElement visaIcon = driver.findElement(By.xpath("//div[@class=\"cards-brands cards-brands__container ng-tns-c61-0 ng-trigger ng-trigger-brandsState ng-star-inserted\"]//img[@src=\"assets/images/payment-icons/card-types/visa-system.svg\"]"));
        assertTrue(visaIcon.isDisplayed(),"id_25. Ошибка. Поле номер карты: иконка платежной системы Visa не отображается");
    }

    @Test
    @DisplayName("id_26. Поле номер карты: проверка наличия иконки платежной системы Белкарт для варианта оплаты «Услуги связи»")
    public void testBelkartIconCardNumberFieldCommunicationServices(){
        WebElement phoneInputField = driver.findElement(By.id("connection-phone"));
        phoneInputField.sendKeys("297777777");
        WebElement sumInputField = driver.findElement(By.id("connection-sum"));
        sumInputField.sendKeys("247");
        WebElement buttonContinue = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        buttonContinue.click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("bepaid-iframe")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"payment-page__container\"]")));
        WebElement belkartIcon = driver.findElement(By.xpath("//div[@class=\"cards-brands cards-brands__container ng-tns-c61-0 ng-trigger ng-trigger-brandsState ng-star-inserted\"]//img[@src=\"assets/images/payment-icons/card-types/belkart-system.svg\"]"));
        assertTrue(belkartIcon.isDisplayed(),"id_26. Ошибка. Поле номер карты: иконка платежной системы Белкарт не отображается");
    }

    @Test
    @DisplayName("id_27. Поле номер карты: проверка наличия иконки платежной системы Мир для варианта оплаты «Услуги связи»")
    public void testMirIconCardNumberField(){
        WebElement phoneInputField = driver.findElement(By.id("connection-phone"));
        phoneInputField.sendKeys("297777777");
        WebElement sumInputField = driver.findElement(By.id("connection-sum"));
        sumInputField.sendKeys("364");
        WebElement buttonContinue = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        buttonContinue.click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("bepaid-iframe")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"payment-page__container\"]")));
        WebElement mirIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"cards-brands cards-brands__container ng-tns-c61-0 ng-trigger ng-trigger-brandsState ng-star-inserted\"]//img[@src=\"assets/images/payment-icons/card-types/mir-system-ru.svg\"]")));
        assertTrue(mirIcon.isDisplayed(),"id_27. Ошибка. Поле номер карты: иконка платежной системы Мир не отображается");
    }

    @Test
    @DisplayName("id_28. Поле номер карты: проверка наличия иконки платежной системы Maestro для варианта оплаты «Услуги связи»")
    public void testMaestroIconCardNumberField(){
        WebElement phoneInputField = driver.findElement(By.id("connection-phone"));
        phoneInputField.sendKeys("297777777");
        WebElement sumInputField = driver.findElement(By.id("connection-sum"));
        sumInputField.sendKeys("400");
        WebElement buttonContinue = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        buttonContinue.click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("bepaid-iframe")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"payment-page__container\"]")));
        WebElement maestroIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"cards-brands cards-brands__container ng-tns-c61-0 ng-trigger ng-trigger-brandsState ng-star-inserted\"]//img[@src=\"assets/images/payment-icons/card-types/maestro-system.svg\"]")));
        assertTrue(maestroIcon.isDisplayed(),"id_28. Ошибка. Поле номер карты: иконка платежной системы Maestro не отображается");
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
