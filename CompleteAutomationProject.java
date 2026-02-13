
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class CompleteAutomationProject {

    public static void main(String[] args) {

        WebDriver driver = null;

        try {

            // ===============================
            // 1️⃣ ChromeOptions Setup
            // ===============================

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("--disable-notifications");
            options.addArguments("--start-maximized");

            driver = new ChromeDriver(options);

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // ===============================
            // 2️⃣ Real E-commerce Flow
            // ===============================

            driver.get("https://www.saucedemo.com/");

            // Locators (ID, Name, CSS)
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.name("password")).sendKeys("secret_sauce");
            driver.findElement(By.cssSelector("#login-button")).click();

            // Validation
            if (driver.getCurrentUrl().contains("inventory")) {
                System.out.println("Login Successful");
            }

            takeScreenshot(driver, "LoginSuccess");

            // Add to cart (XPath)
            driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();

            // Class locator
            driver.findElement(By.className("shopping_cart_link")).click();

            wait.until(ExpectedConditions.urlContains("cart"));
            takeScreenshot(driver, "CartPage");

            // Checkout
            driver.findElement(By.id("checkout")).click();
            driver.findElement(By.id("first-name")).sendKeys("Sudarshan");
            driver.findElement(By.id("last-name")).sendKeys("QA");
            driver.findElement(By.id("postal-code")).sendKeys("560001");
            driver.findElement(By.id("continue")).click();
            driver.findElement(By.id("finish")).click();

            String confirm = driver.findElement(By.className("complete-header")).getText();

            if (confirm.equals("Thank you for your order!")) {
                System.out.println("Order Completed");
            }

            takeScreenshot(driver, "OrderComplete");

            // ===============================
            // 3️⃣ Actions Class
            // ===============================

            Actions actions = new Actions(driver);
            WebElement menu = driver.findElement(By.id("react-burger-menu-btn"));
            actions.moveToElement(menu).click().perform();

            Thread.sleep(2000);

            // ===============================
            // 4️⃣ Window Handling
            // ===============================

            ((JavascriptExecutor) driver).executeScript("window.open('https://demoqa.com/alerts','_blank');");

            Set<String> windows = driver.getWindowHandles();
            Iterator<String> it = windows.iterator();

            String parent = it.next();
            String child = it.next();

            driver.switchTo().window(child);

            // ===============================
            // 5️⃣ Alert Handling
            // ===============================

            driver.findElement(By.id("alertButton")).click();
            wait.until(ExpectedConditions.alertIsPresent());

            Alert alert = driver.switchTo().alert();
            alert.accept();

            takeScreenshot(driver, "AlertHandled");

            // ===============================
            // 6️⃣ IFrame Handling
            // ===============================

            driver.navigate().to("https://demoqa.com/frames");

            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frame1"));

            String frameText = driver.findElement(By.id("sampleHeading")).getText();
            System.out.println("Frame Text: " + frameText);

            driver.switchTo().defaultContent();
            takeScreenshot(driver, "FramePage");

            // Close child window
            driver.close();
            driver.switchTo().window(parent);

            System.out.println("Execution Completed Successfully");

        } catch (Exception e) {

            System.out.println("Error Occurred: " + e.getMessage());
            e.printStackTrace();

        } finally {

            if (driver != null) {
                driver.quit();
            }
        }
    }

    // ===============================
    // Screenshot Method
    // ===============================

    public static void takeScreenshot(WebDriver driver, String name) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(System.getProperty("user.home")
                + "/Desktop/" + name + "_" + timeStamp + ".png");

        Files.copy(src.toPath(), dest.toPath());
    }
}
