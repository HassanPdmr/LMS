package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Add_DepartmentPageObject {


    @FindBy(xpath = "//*[@id=\"root\"]/div/main/section/div/div[2]/div/img")
    public static WebElement Add_deptCard;

    @FindBy(xpath = "//*[text()='Department Name']")
    public static WebElement deptname;

    @FindBy(xpath = "//*[text()='Sub Department']")
    public static WebElement subdeptment;

    @FindBy(xpath = "//*[text()='Department ID']")
    public static WebElement departId;

    @FindBy(xpath = "//*[text()='Add Sub-Department']")
    public static WebElement add_subdepart_button;

    @FindBy(xpath = "//*[text()='Add']")
    public static WebElement add_dept;

    @FindBy(xpath = "//*[text()='Ok']")
    public static WebElement new_deptCreated;


}

