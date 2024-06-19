package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageDepartmentPageObject {


    WebDriver driver;

    public ManageDepartmentPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/header/div/div[1]")
    public static WebElement sidedashboard_managedept;

    @FindBy(xpath = "//*[text()='People Center']")
    public static WebElement peoplcenterpage_managedept;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/section/div/div[4]/div/img")
    public static WebElement managedeptTab;

    @FindBy(xpath = "//h2[text()='Departments']")
    public static WebElement sampletext_departments;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/section/div[3]/div/div/ul[45]/li[5]/div[2]")
    public static WebElement deleteButton;

    @FindBy(xpath = "//div[@class = 'DeletePopUpModal_content__iDOAh']")
    public static WebElement deleteconfirmation;

    @FindBy(xpath = "//button[text()='No']")
    public static WebElement deleteNoButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/section/div[3]/div/div/ul[45]/li[5]/div[1]")
    public static WebElement EditButton;




}
