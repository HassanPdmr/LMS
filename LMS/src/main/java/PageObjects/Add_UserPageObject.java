package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Add_UserPageObject {

    static WebDriver driver;

    public Add_UserPageObject(WebDriver driver) {
        Add_UserPageObject.driver = driver;
//        this.driver = driver;

        PageFactory.initElements(driver, this);
    }


    public static boolean isErrorMessageDisplayedInEmpName(String expectedErrorMessage) {
        try {
            WebElement errorElement = driver.findElement(By.xpath("//p[text()='" + expectedErrorMessage + "']"));
            return errorElement.isDisplayed();

        } catch (NoSuchElementException e) {
            System.out.println("Error element not found");
            return false;
        }
    }

    public static boolean isErrorMessageDisplayedInEmplyID(String expectedErrorMessageEmpId) {
        try {
            WebElement errorElement = driver.findElement(By.xpath("//p[text()='" + expectedErrorMessageEmpId + "']"));
            return errorElement.isDisplayed();

        } catch (NoSuchElementException e) {
            System.out.println("Error element not found");
            return false;
        }

    }

    public static boolean isErrorMessageDisplayedInMobileNo(String expectedErrorMessageMN) {
        try {
            WebElement errorElement = driver.findElement(By.xpath("//p[text()='" + expectedErrorMessageMN + "']"));
            return errorElement.isDisplayed();

        } catch (NoSuchElementException e) {
            System.out.println("Error element not found");
            return false;
        }
    }

    public static boolean isErrorMessageDisplayedInEmailId(String expectedErrorMessageEMI) {
        try {
            WebElement errorElement = driver.findElement(By.xpath("//p[text()='" + expectedErrorMessageEMI + "']"));
            return errorElement.isDisplayed();

        } catch (NoSuchElementException e) {
            System.out.println("Error element not found");
            return false;
        }
    }


    @FindBy(xpath = "//*[@id=\"root\"]/div/main/section/div/div[1]/div/img")
    public static WebElement adduser;

    @FindBy(xpath = "(//*[text()='Add User'])[2]")
    public static WebElement AdduserModelText;


    @FindBy(xpath = "//*[@id=\"root\"]/div/main/section/div[3]/form/div/div[1]/div[3]/div/input")
    public static WebElement emailId;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/section/div[3]/form/div/div[1]/div[1]/div/input")
    public static WebElement emplyId;

    @FindBy(id = "event_venue")
    public static WebElement empName;

    @FindBy(xpath = "//p[text()='Numbers not allowed']")
    public static WebElement empNameErrmsg;

    @FindBy(xpath = "//header[@class='AddUser_header__62xh2']//*[name()='svg']")
    public static WebElement Adduserclosemodel;


    @FindBy(xpath = "//*[@id=\"root\"]/div/main/section/div[3]/form/div/div[1]/div[4]/div/input")
    public static WebElement emptype1;

    @FindBy(xpath = "//*[text()='Manager']")
    public static WebElement emptype2;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/section/div[3]/form/div/div[1]/div[4]/div/input")
    public static WebElement emptype1_re;

    @FindBy(xpath = "//*[text()='Manager']")
    public static WebElement emptype2_re;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/section/div[3]/form/div/div[1]/div[5]/div/input")
    public static WebElement department_1;

    @FindBy(xpath = "//*[text()='Software Development']")
    public static WebElement department_2;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/section/div[3]/form/div/div[1]/div[6]/input")
    public static WebElement subdepartment_1;

    @FindBy(xpath = "//*[text()='Software Testing']")
    public static WebElement subdepartment_2;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/section/div[3]/form/div/div[1]/div[7]/div/input")
    public static WebElement designation;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/section/div[3]/form/div/div[1]/div[8]/div/input")
    public static WebElement mobilenumber;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/section/div[3]/form/div/div[1]/div[9]/div/input")
    public static WebElement educationadetails;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/section/div[3]/form/div/div[1]/div[10]/div/input")
    public static WebElement division;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/section/div[3]/form/div/div[1]/div[11]/div/div/input")
    public static WebElement selectkeyskills_1;

    @FindBy(xpath = "//*[text()='Check All']")
    public static WebElement selectkeyskills_2;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/section/div[3]/form/div/div[1]/div[12]/input")
    public static WebElement reporting_1;

    @FindBy(xpath = "//*[text()='1234-Admin-Admin']")
    public static WebElement reporting_2;

    @FindBy(xpath = "//*[text()='Add']")
    public static WebElement add_submitbutton;


}
