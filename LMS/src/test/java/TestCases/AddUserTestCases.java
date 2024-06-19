package TestCases;


import PageObjects.Add_UserPageObject;
import CommonFunctions.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import static Utilities.ExcelDataProvider.readExcel;


public class AddUserTestCases extends CommonFunctions {

    Add_UserPageObject addUserPageObject;
    int len_sb, len_key, len_rep,len_empType, expected_subDept, expected_keySkills, expectedEmpType;
    String subDeptText, keySkillText, reportingText, empTypeText;


    @BeforeClass
    public void setupPage() {
        addUserPageObject = new Add_UserPageObject(driver);
        PageFactory.initElements(driver, addUserPageObject);


    }

    @DataProvider(name = "Employee Names")
    public static Object[][] getAddUSerData() throws IOException {
        return readExcel("D:\\uploadtest\\Readnewdata.xlsx", 0);
    }

    @DataProvider(name = "Employee Id")
    public static Object[][] getEmplyId() throws IOException {
        return readExcel("D:\\uploadtest\\Readnewdata.xlsx", 1);
    }

    @DataProvider(name = "Mobile number")
    public static Object[][] getMobileNum() throws IOException {
        return readExcel("D:\\uploadtest\\Readnewdata.xlsx", 2);
    }

    @DataProvider(name = "Email ID")
    public static Object[][] getEmailID() throws IOException {
        return readExcel("D:\\uploadtest\\Readnewdata.xlsx", 3);
    }


    @Test(priority = 2, description = "LMS-204 : Verify and Validate whether sub departments are displayed based on departments ")
    public void verifyAddUserModel() throws AWTException, InterruptedException {

//       driver.manage().window().setSize(new Dimension(1950, 1070));

        Thread.sleep(3000);
        Add_UserPageObject.adduser.click();
        String adduserModel = Add_UserPageObject.AdduserModelText.getText();
        Assert.assertEquals(adduserModel, "Add User", "Add user page model was not displayed");
        testCase.info("Add user model has been displayed");
        System.out.println("Add user displayed");

    }

    @Test(enabled = false, groups = "group A2", dataProvider = "Employee Names", description = "LMS-205 : Verify and Validate the emp name can be added unique ")
    public void verifyUserEmpName(String empNames, boolean expValue, String expectedErrorMessage) throws AWTException, InterruptedException {

        Thread.sleep(4000);
        Add_UserPageObject.empName.sendKeys(empNames);
        System.out.println("This is emp name " + empNames);
        Thread.sleep(3000);
        Add_UserPageObject.add_submitbutton.click();
        Thread.sleep(3000);
        Add_UserPageObject.empName.clear();

        boolean actualResult = Add_UserPageObject.isErrorMessageDisplayedInEmpName(expectedErrorMessage);
        if (!actualResult) {
            System.out.println("Error message not displayed for employee: " + empNames);
            testCase.info("Only Alphabetical values has been accepted");
        }
        Assert.assertEquals(actualResult, expValue, "Error message validation failed for employee: " + empNames);
        testCase.pass("Employee name has been successfully passed");

    }

    @Test(enabled = false, groups = "group A2", dataProvider = "Employee Id", description = "LMS-197 : Verify and Validate the employee ID can be added unique ")
    public void verifyEmpId(String empId, boolean expValue, String expectedErrorMessageEmpId) throws AWTException, InterruptedException {

        Thread.sleep(3000);
        Add_UserPageObject.emplyId.sendKeys(empId);
        System.out.println("This is emp Id " + empId);
        Thread.sleep(3000);
        Add_UserPageObject.add_submitbutton.click();
        Thread.sleep(3000);
        Add_UserPageObject.emplyId.clear();

        boolean actualResult = Add_UserPageObject.isErrorMessageDisplayedInEmplyID(expectedErrorMessageEmpId);
        if (!actualResult) {
            System.out.println("Error message not displayed for Emp Id: " + empId);
            testCase.info("Only numerical value has been accepted here");
        }
        Assert.assertEquals(actualResult, expValue, "Error message validation failed for Emp Id: " + empId);
        System.out.println("Error is displayed for " + empId);
        testCase.pass("Employee ID has been successfully passed");


    }

    @Test(enabled = false, groups = "group A2", dataProvider = "Mobile number", description = "LMS-199 : Verify and Validate the mobile number can be added unique ")
    public void verifyUserMobileNum(String mobNumber, boolean expValue, String expectedErrorMessageMN) throws AWTException, InterruptedException {

        Thread.sleep(2000);
        Add_UserPageObject.mobilenumber.sendKeys(mobNumber);
        System.out.println("User's Mobile number: " + mobNumber);
        Thread.sleep(3000);
        Add_UserPageObject.add_submitbutton.click();
        Thread.sleep(2000);
        Add_UserPageObject.mobilenumber.clear();

        boolean actualResult = Add_UserPageObject.isErrorMessageDisplayedInMobileNo(expectedErrorMessageMN);
        if (!actualResult) {
            System.out.println("Error message not displayed for Mobile No: " + mobNumber);
            testCase.info("Only numerical value has been accepted here");
        }
        Assert.assertEquals(actualResult, expValue, "Error message validation failed for Mobile Number: " + mobNumber);
        System.out.println("Error is displayed for " + mobNumber);
        testCase.pass("Mobile Number has been successfully passed");

    }

    @Test(enabled = false, groups = "group A3", dataProvider = "Email ID", description = "LMS-203 : Verify the email id is valid ")
    public void verifyEmailId(String emailId, boolean expValue, String expectedErrorMessageEMI) throws AWTException, InterruptedException {

        Thread.sleep(2000);
        Add_UserPageObject.emailId.sendKeys(emailId);
        System.out.println("User's Email id: " + emailId);
        Add_UserPageObject.add_submitbutton.click();
        Thread.sleep(2000);
        Add_UserPageObject.emailId.clear();

        boolean actualResult = Add_UserPageObject.isErrorMessageDisplayedInEmailId(expectedErrorMessageEMI);
        if (!actualResult) {
            System.out.println("Error message not displayed for Mobile No: " + emailId);
            testCase.info("Only numerical value has been accepted here");
        }
        Assert.assertEquals(actualResult, expValue, "Error message validation failed for Mobile Number: " + emailId);
        System.out.println("Error is displayed for " + emailId);
        testCase.pass("Mobile Number has been successfully passed");
    }

    @Test(enabled = false, description = "LMS-230 : Verify the Employee type listed for add user ")
    public void verifyEmpType() throws AWTException, InterruptedException {

        Thread.sleep(5000);
        Add_UserPageObject.emptype1.click();
        Thread.sleep(5000);
        List<WebElement> empType = driver.findElements(By.xpath("//div[@class='InputItem_options-container__4ssVB']/ul/li"));
        Thread.sleep(2000);
        len_empType = empType.size();
        System.out.println("Count of Emp Type: "+len_empType);
        expectedEmpType = 2;

//        String EmpType_v = driver.findElement(By.xpath("//div[@class='InputItem_options-container__4ssVB']/ul[" + len_empType + "]/li[2]")).getText();
//        System.out.println("Reporting Name listed: " + EmpType_v);
//        Assert.assertEquals(EmpType_v, "Manager", "EmpType not selected");
//        Thread.sleep(6000);


        Assert.assertEquals(len_empType, expectedEmpType, "Types of employees are not listed");
        testCase.info("Here Employee types are been listed");
        for (WebElement empTypeElement : empType) {
            empTypeText = empTypeElement.getText();
            System.out.println("Employee Types: " + empTypeText);
            Assert.assertFalse(empTypeText.isEmpty(), "Employee type is empty");
        }
        Thread.sleep(3000);
        Add_UserPageObject.emptype2.click();
        Thread.sleep(3000);



    }

    @Test(enabled = false, groups = "group A3", description = "LMS-204 : Verify and Validate whether sub departments are displayed based on departments ")
    public void verifySubDepartment() throws AWTException, InterruptedException {

        Robot robot_2 = new Robot();
        robot_2.keyPress(KeyEvent.VK_CONTROL);
        robot_2.keyPress(KeyEvent.VK_MINUS);
        robot_2.keyRelease(KeyEvent.VK_CONTROL);
        robot_2.keyRelease(KeyEvent.VK_MINUS);

        Thread.sleep(5000);
        WebDriverWait wait_2 = new WebDriverWait(driver, 40);
        wait_2.until(ExpectedConditions.elementToBeClickable(Add_UserPageObject.designation)).sendKeys("Software Tester");
        wait_2.until(ExpectedConditions.elementToBeClickable(Add_UserPageObject.division)).sendKeys("First");
        wait_2.until(ExpectedConditions.elementToBeClickable(Add_UserPageObject.educationadetails)).sendKeys("BE");
        wait_2.until(ExpectedConditions.elementToBeClickable(Add_UserPageObject.department_1)).click();
        wait_2.until(ExpectedConditions.elementToBeClickable(Add_UserPageObject.department_2)).click();
        Thread.sleep(4000);
//        wait_2.until(ExpectedConditions.elementToBeClickable(Add_UserPageObject.subdepartment_1)).click();
        Add_UserPageObject.subdepartment_1.click();
        Thread.sleep(9000);
        List<WebElement> subDept = driver.findElements(By.xpath("//div[@class='MultiSelectInput_multi-select-options-container__i3bVY']/ul/li"));
        len_sb = subDept.size();
        System.out.println("Count of sub dept: "+len_sb);

        expected_subDept = 3;
        Assert.assertEquals(len_sb, expected_subDept, "Number of sub-departments does not match the expected count.");
        testCase.info("Here 3 sub departments has been listed based on department");
        for (WebElement subDeptElement : subDept) {
            subDeptText = subDeptElement.getText();
            System.out.println("Sub-department text: " + subDeptText);
            Assert.assertFalse(subDeptText.isEmpty(), "Sub-department is empty");
        }
        Thread.sleep(3000);
        Add_UserPageObject.subdepartment_2.click();
        Thread.sleep(3000);

    }

    @Test(enabled = false, description = "LMS-201 : Verify and Validate whether keyskills are displayed based on department ")
    public void verifyKeySkills() throws AWTException, InterruptedException {

        Robot robot_1 = new Robot();
        robot_1.keyPress(KeyEvent.VK_CONTROL);
        robot_1.keyPress(KeyEvent.VK_MINUS);
        robot_1.keyRelease(KeyEvent.VK_CONTROL);
        robot_1.keyRelease(KeyEvent.VK_MINUS);

        Thread.sleep(4000);
        Add_UserPageObject.selectkeyskills_1.click();
        Thread.sleep(6000);
        List<WebElement> keySkill = driver.findElements(By.xpath("//div[@class='MultiSelectInput_multi-select-options-container__i3bVY']/ul/li"));
        len_key = keySkill.size();
        System.out.println("No of Keyskills: "+len_key);

        expected_keySkills = 3;
        Assert.assertEquals(len_key, expected_keySkills, "Number of keyskills does not match the expected count.");
        testCase.info("Here keyskills has been listed ");

        for (WebElement keySillsElement : keySkill) {
            keySkillText = keySillsElement.getText();
            System.out.println("KeySkills text: " + keySkillText);
            Assert.assertFalse(keySkillText.isEmpty(), "KeySkills is empty");
        }
        Thread.sleep(3000);
        Add_UserPageObject.selectkeyskills_2.click();

    }

    @Test(enabled = false, description = "LMS-200 : Verify and Validate whether reporting is displayed based on emp type ")
    public void verifyReporting() throws AWTException, InterruptedException {

        Thread.sleep(6000);
        Add_UserPageObject.reporting_1.click();
        List<WebElement> reporting = driver.findElements(By.xpath("//div[@class='InputItem_options-container__4ssVB']/ul/li"));
        len_rep = reporting.size();

        System.out.println("Count of Reporting: "+len_rep);
        testCase.info("Employee name with id has been listed for reporting");
        Thread.sleep(6000);

        String Report_v = driver.findElement(By.xpath("//div[@class='InputItem_options-container__4ssVB']/ul[" + len_rep + "]/li[1]")).getText();
        System.out.println("Reporting Name listed: " + Report_v);
        Assert.assertEquals(Report_v, "1234-Admin-Admin", "Reporting not selected");

        for (WebElement reportingEmployee : reporting) {
            reportingText = reportingEmployee.getText();
            Assert.assertFalse(reportingText.isEmpty(), "Reporting is empty");
        }
        Thread.sleep(6000);
        Add_UserPageObject.reporting_2.click();


    }


//    @Test(priority = 9, description = "LMS-202 : Verify the add button is accessible ")
//    public void verifyAddButton() throws AWTException, InterruptedException {
//
//
//    }







}


//        boolean actualResult = Add_UserPageObject.isErrorMessageDisplayedInEmailId(expectedErrorMessageEMI);
//        if (!actualResult) {
//            System.out.println("Error message not displayed for Mobile No: " + emailId);
//            testCase.info("Only numerical value has been accepted here");
//        }
//        Assert.assertEquals(actualResult, expValue, "Error message validation failed for Email Id: " + emailId);
//        System.out.println("Error is displayed for " + emailId);
//        testCase.pass("Email Id has been successfully passed");
//
//    }
//

//
//
//

//    @Test(priority = 9, description = "LMS-202 : Verify the add button is accessible ")
//    public void verifyAddButton() throws AWTException, InterruptedException {
//    }


//
//        WebElement keyskll_1 = wait.until(ExpectedConditions.elementToBeClickable(Add_UserPageObject.selectkeyskills_1));
//        keyskll_1.click();
//        WebElement keyskll_2 = wait.until(ExpectedConditions.elementToBeClickable(Add_UserPageObject.selectkeyskills_2));
//        keyskll_2.click();
//
//        Thread.sleep(3000);
//        WebElement EmpType_rep = wait.until(ExpectedConditions.elementToBeClickable(Add_UserPageObject.emptype1));
//        EmpType_rep.click();
//        Add_UserPageObject.emptype2.click();
//
//
//        WebElement reprt_1 = wait.until(ExpectedConditions.elementToBeClickable(Add_UserPageObject.reporting_1));
//        reprt_1.click();
//        WebElement reprt_2 = wait.until(ExpectedConditions.elementToBeClickable(Add_UserPageObject.reporting_2));
//        reprt_2.click();






