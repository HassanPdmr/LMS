package TestCases;

import CommonFunctions.CommonFunctions;
import PageObjects.Add_KeyskillsPageObject;
import PageObjects.Add_UserPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.List;

public class AddKeySkillTestcases extends CommonFunctions {


    Add_KeyskillsPageObject addKeySkillTestcases;
    int len_keySkill;
    String keySkillAlert;

    @BeforeClass
    public void setupPage() {
        addKeySkillTestcases = new Add_KeyskillsPageObject(driver);
        PageFactory.initElements(driver, addKeySkillTestcases);

    }

    @Test(priority = 1, description = "LMS-222 : Verify whether user can able to add Key skills")
    public void verifyKeySkillModel() throws AWTException, InterruptedException {

        scrollDown(driver);
        Thread.sleep(5000);
        Add_KeyskillsPageObject.AddKeySkills_model.click();
        Thread.sleep(4000);

        String addKeySkillModel_txt = Add_KeyskillsPageObject.AddKeySkills_modelTxt.getText();
        Assert.assertEquals(addKeySkillModel_txt, "Add Key skills", "Add KeySkills page model was not displayed");
        testCase.info("Add KeySkills model has been displayed");
        System.out.println("KeySkills model displayed");

    }

    @Test(priority = 2, description = "LMS-231 : Verify whether Add KeySkills model is displayed")
    public void verifyAddNewKeySkills() throws AWTException, InterruptedException {

        Add_KeyskillsPageObject.chooseDept_1.click();
        Thread.sleep(3000);

        List<WebElement> key_dep = driver.findElements(By.xpath("//div[@class='MultiSelectInput_multi-select-options-container__i3bVY']/ul/li"));
        len_keySkill = key_dep.size();
        testCase.info("Total number of departments has been listed here");
        Thread.sleep(5000);

        String keySkillDept_v = driver.findElement(By.xpath("//div[@class='MultiSelectInput_multi-select-options-container__i3bVY']/ul[" + len_keySkill + "]/li[1]")).getText();
        System.out.println("Selected Department to add New Skill " + keySkillDept_v);
        Assert.assertEquals(keySkillDept_v, "Software Development", "Wrong department selected");
        testCase.info("Department has been selected to add new skill");

        Add_KeyskillsPageObject.chooseDept_2.click();
        Add_KeyskillsPageObject.chooseDept_1.click();
        Thread.sleep(3000);

        Add_KeyskillsPageObject.addNewKeySills.sendKeys("Node JS");
        Add_KeyskillsPageObject.new_KeySkillAddButton.click();

        Thread.sleep(2000);
        keySkillAlert = Add_KeyskillsPageObject.skillAddedConfirmation.getText();
        Assert.assertEquals(keySkillAlert, "Key skill created successfully", "KeySkill was not created");
        testCase.info("Confirmation of New skill added has been displayed");

        boolean keySkillOk = Add_KeyskillsPageObject.skillOkFinalButton.isEnabled();
        Assert.assertTrue(keySkillOk, "Ok button is not enabled");
        testCase.info("New skill added successfully");


    }

}
