package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageKeySkillsPageObject {

    static WebDriver driver;

    public ManageKeySkillsPageObject(WebDriver driver){

        ManageKeySkillsPageObject.driver = driver;
        PageFactory.initElements(driver, this);

    }


    @FindBy(xpath = "//*[@id=\"root\"]/div/main/section/div/div[6]/div/img")
    public static WebElement manageKeySkillTab;



}
