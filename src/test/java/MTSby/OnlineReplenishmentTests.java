package MTSby;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.*;

 class OnlineReplenishmentTests {
    static WebDriver driver;

    @BeforeAll
    public static void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://mts.by");
        WebElement cookieAgreeButton = driver.findElement(By.id("cookie-agree"));
        cookieAgreeButton.click();
    }

    @Test
    @DisplayName("id_1. Проверка наличия и названия блока «Онлайн пополнение без комиссии»")
    public void testOnlineReplenishmentTitle() {
        WebElement titleElement = driver.findElement(By.xpath("//*[@class='pay__wrapper']"));
        String actualTitle = titleElement.getText();
        String expectedTitle = "Онлайн пополнение\nбез комиссии";
        assertTrue(actualTitle.contains(expectedTitle),"id_1. Ошибка: блок «Онлайн пополнение без комиссии» не найден на странице.");
    }

    @Test
    @DisplayName("id_2.1. Проверка наличия логотипа платежной системы: Visa")
    public void testAvailabilityLogoPaymentSystemVisa() {
        WebElement visaLogo = driver.findElement(By.xpath("//div[@class='pay__partners']//*[@alt=\"Visa\"]"));
        assertTrue(visaLogo.isDisplayed(), "id_2.1. Ошибка: логотип платежной системы Visa не отображается");
    }

    @Test
    @DisplayName("id_2.2. Проверка наличия логотипа платежной системы: Verified By Visa")
    public void testAvailabilityLogoPaymentSystemVerifiedByVisa(){
        WebElement verifiedByVisaLogo = driver.findElement(By.xpath("//div[@class='pay__partners']//*[@alt=\"Verified By Visa\"]"));
        assertTrue(verifiedByVisaLogo.isDisplayed(), "id_2.2. Ошибка: логотип платежной системы Verified By Visa не отображается");
    }

    @Test
    @DisplayName("id_2.3. Проверка наличия логотипа платежной системы: MasterCard")
    public void  testAvailabilityLogoPaymentSystemMasterCard(){
        WebElement masterCardLogo = driver.findElement(By.xpath("//div[@class='pay__partners']//*[@alt=\"MasterCard\"]"));
        assertTrue(masterCardLogo.isDisplayed(), "id_2.3. Ошибка: логотип платежной системы MasterCard не отображается");
    }

    @Test
    @DisplayName("id_2.4. Проверка наличия логотипа платежной системы: MasterCard Secure Code")
    public void testAvailabilityLogoPaymentSystemMasterCardSecureCode() {
        WebElement masterCardSecureCodeLogo = driver.findElement(By.xpath("//div[@class='pay__partners']//*[@alt=\"MasterCard Secure Code\"]"));
        assertTrue(masterCardSecureCodeLogo.isDisplayed(), "id_2.4. Ошибка: логотип платежной системы MasterCard Secure Code не отображается");
    }

    @Test
    @DisplayName("id_2.5. Проверка наличия логотипа платежной системы: Белкарт")
    public void testAvailabilityLogoPaymentSystemBelkart(){
        WebElement belkartLogo = driver.findElement(By.xpath("//div[@class='pay__partners']//*[@alt=\"Белкарт\"]"));
        assertTrue(belkartLogo.isDisplayed(), "id_2.5. Ошибка: логотип платежной системы Белкарт не отображается");
    }

    @Test
    @DisplayName("id_3. Проверка работы ссылки «Подробнее о сервисе»")
    public void testMoreAboutServiceLink(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement linkMoreAboutService = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Подробнее о сервисе")));
        linkMoreAboutService.click();
        boolean urlIsCorrect = wait.until(ExpectedConditions.urlContains("help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
        assertTrue(urlIsCorrect, "id_3. Ошибка: URL страницы не соответствует ожидаемому.");
    }

    @Test
    @DisplayName("id_4. Проверка кнопки «Продолжить», вариант оплаты «Услуги связи»")
    public void testButtonContinueOptionCommunicationServices(){
        WebElement phoneNumber = driver.findElement(By.id("connection-phone"));
        phoneNumber.sendKeys("297777777");
        WebElement connectionSum = driver.findElement(By.id("connection-sum"));
        connectionSum.sendKeys("100");
        WebElement buttonContinue = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        buttonContinue.click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("bepaid-iframe")));
        WebElement paymentContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"payment-page__container\"]")));
        assertTrue(paymentContainer.isDisplayed(), "id_4. Ошибка: Окно оплаты не отображается после нажатия на кнопку «Продолжить»");
    }

    @AfterEach
    public void returnToStart(){
        driver.get("http://mts.by");
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }


}