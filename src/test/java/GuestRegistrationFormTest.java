import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GuestRegistrationFormTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeAll
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
    }

    @Test
    @DisplayName("Automate Guest Registration Form with Specific XPaths")
    public void GuestRegistrationFormTest() {
        driver.get("https://demo.wpeverest.com/user-registration/guest-registration-form/");

        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Sanjida");
        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Afrin");
        driver.findElement(By.xpath("//*[@id='user_email']")).sendKeys("afrinsanjida997@gmail.com");

        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//input[@id='user_pass']")));
        passwordField.sendKeys("Hello3963@");

        driver.findElement(By.xpath("//input[@id='radio_1665627729_Female']")).click();
        driver.findElement(By.xpath("//input[@id='input_box_1665629217']")).sendKeys("Bangladeshi");
        driver.findElement(By.xpath("//input[@id='phone_1665627880']")).sendKeys("01712345678");

        WebElement countryDropdown = driver.findElement(By.xpath("//select[@id='country_1665629257']"));
        Select selectCountry = new Select(countryDropdown);
        selectCountry.selectByVisibleText("Bangladesh");

        driver.findElement(By.xpath("//input[@id='number_box_1665629930']")).sendKeys("7");
        driver.findElement(By.xpath("//input[@id='radio_1665627931_Yes']")).click();
        driver.findElement(By.xpath("//input[@id='radio_1665627997_Single Room']")).click();

        WebElement dietaryRestriction = driver.findElement(By.xpath("//input[@id='radio_1665628131_None']"));
        dietaryRestriction.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", dietaryRestriction);

        WebElement activitiesDropdown = driver.findElement(By.xpath("//select[@id='select_1665628361']"));
        Select selectActivities = new Select(activitiesDropdown);
        selectActivities.selectByVisibleText("Luncheon");

        WebElement checkbox = driver.findElement(By.xpath("//input[@id='privacy_policy_1665633140']"));
        js.executeScript("arguments[0].scrollIntoView(true);", checkbox);

        wait.until(ExpectedConditions.elementToBeClickable(checkbox));
        if (!checkbox.isSelected()) {
            try {
                checkbox.click();
            } catch (ElementClickInterceptedException e) {
                js.executeScript("arguments[0].click();", checkbox);
            }
        }


        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/main/article/div/div/div/form/div[4]/button")).click();


        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div[1]/div[2]/div/div/main/article/div/div/div/form/div[6]")));


        String expectedMessage = "User successfully registered.";
        String actualMessage = successMessage.getText();
        System.out.println("Actual message: " + actualMessage);
        Assertions.assertEquals(expectedMessage, actualMessage, "The success message does not match.");
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }
}
