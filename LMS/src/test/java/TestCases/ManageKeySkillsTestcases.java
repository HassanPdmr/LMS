package TestCases;

import CommonFunctions.CommonFunctions;
import PageObjects.ManageKeySkillsPageObject;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;

public class ManageKeySkillsTestcases extends CommonFunctions {

    ManageKeySkillsPageObject manageKeySkillsPageObject;

    @BeforeClass
    public void setupPage() {

        manageKeySkillsPageObject = new ManageKeySkillsPageObject(driver);
        PageFactory.initElements(driver,manageKeySkillsPageObject);



    }
















}
