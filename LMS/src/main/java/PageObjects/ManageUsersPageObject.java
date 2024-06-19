package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageUsersPageObject {


    @FindBy(xpath = "//*[@id=\"root\"]/div/header/div/div[1]")
    public static WebElement sidedashboard_m;

    @FindBy(xpath = "//*[text()='People Center']")
    public static WebElement peoplcenterpage;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/section/div/div[3]/div/img")
    public static WebElement manageusers;


    @FindBy(xpath = "//h2[text()='Users']")
    public static WebElement sampletext;


}
