package CommonFunctions;

import NavigateObj.Navigation_Keys;
import PageObjects.LoginPageObject;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CommonFunctions {


    public static WebDriver driver = null;
    public static Properties properties;

    public static String username;
    public static String Password;


    public static ExtentReports extentReport;
    public static ExtentSparkReporter sparkReporter;
    public static ExtentTest testCase;

    public Properties loadPropertyFile() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("CommonConfig.properties");

        properties = new Properties();
        properties.load(fileInputStream);
        return properties;

    }

//    @AfterMethod
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

    @BeforeSuite(description = "LMS launch")
    public void launchBrowser() throws IOException, InterruptedException {
        loadPropertyFile();
        Logger.getGlobal().setLevel(Level.OFF);

        extentReport = new ExtentReports();
        sparkReporter = new ExtentSparkReporter("ExtentReport.html");
        extentReport.attachReporter(sparkReporter);
        sparkReporter.config().setTheme(Theme.DARK);

        String browser = properties.getProperty("browser");
        String url = properties.getProperty("url");
        username = properties.getProperty("username");
        Password = properties.getProperty("password");

        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
            driver.get(url);
            driver.manage().window().maximize();
            Thread.sleep(1000);

        } else {

            System.out.println("chrome not displayed");
            return;
        }

        driver.get(url);
        LoginPageObject loginPageObj = new LoginPageObject(driver);

        loginPageObj.enterUsername(username);
        loginPageObj.enterPassword(Password);

        loginPageObj.clickSubmit();

        Thread.sleep(1000);

    }

    public String takeScreenshot(String testName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        String destPath = testName + ".png";
        try {
            Files.createDirectories(Paths.get("screenshots"));
            Files.copy(srcFile.toPath(), Paths.get(destPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destPath;

    }
    public void scrollDown(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scroll down by 1000 pixels vertically
        js.executeScript("window.scrollBy(0, 1000)");
    }

    @BeforeMethod
    public void navigateHomepage() throws AWTException, InterruptedException {

        Navigation_Keys navigationKeys = new Navigation_Keys(driver);

        if (testCase == null) {
            testCase = extentReport.createTest("Default Test Name"); // Provide a default test name or description
        }

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_MINUS);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_MINUS);

        WebDriverWait wait_1 = new WebDriverWait(driver, 60);
        Thread.sleep(5000);
        String homepage_v = navigationKeys.homepage.getText();
        Assert.assertEquals(homepage_v, "Dashboard", "Homepage dashboard was not displayed");

        if (testCase != null) {
            testCase.info("Homepage dashboard has been displayed");
        } else {
            // Handle the case where testCase is unexpectedly null

            System.err.println("testCase is null. Unable to log info message.");
        }


        wait_1.until(ExpectedConditions.elementToBeClickable(navigationKeys.sideDashboard));
        Thread.sleep(5000);
        navigationKeys.peopleCenterPage.click();
        Thread.sleep(2500);
        System.out.println("People center has been selected");

//        driver.manage().window().setSize(new Dimension(0, 50));

    }

    @AfterSuite
    public void End() throws InterruptedException {
        Thread.sleep(900);
//        driver.close();
        extentReport.flush();


    }


}



