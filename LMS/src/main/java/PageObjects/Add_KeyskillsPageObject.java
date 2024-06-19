package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Add_KeyskillsPageObject {


    static WebDriver driver;
    public Add_KeyskillsPageObject(WebDriver driver) {


        Add_KeyskillsPageObject.driver = driver;
//        this.driver = driver;

        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "(//img[@alt='Add Key Skills'])[1]")
    public static WebElement AddKeySkills_model;

    @FindBy(xpath = "(//h2[normalize-space()='Add Key skills'])[1]")
    public static WebElement AddKeySkills_modelTxt;

    @FindBy(xpath = "//input[@class='MultiSelectInput_multi-select-input-box__1GSG8']")
    public static WebElement chooseDept_1;

    @FindBy(xpath = "(//input[@type='checkbox'])[1]")
    public static WebElement chooseDept_2;

    @FindBy(xpath = "//*[text()='Enter New Key skill']")
    public static WebElement addNewKeySills;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    public static WebElement new_KeySkillAddButton;

    @FindBy(xpath = "//*[text()='Key skill created successfully']")
    public static WebElement skillAddedConfirmation;

    @FindBy(xpath = "//button[normalize-space()='Ok']")
    public static WebElement skillOkFinalButton;








}
