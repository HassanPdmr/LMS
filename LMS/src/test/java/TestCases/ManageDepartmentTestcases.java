package TestCases;

import PageObjects.ManageDepartmentPageObject;
import CommonFunctions.CommonFunctions;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;


public class ManageDepartmentTestcases extends CommonFunctions {

    ManageDepartmentPageObject manageDeptPage;
    int len, len_1, len_del;


    @BeforeClass
    public void setupPage() {
        manageDeptPage = new ManageDepartmentPageObject(driver);
        PageFactory.initElements(driver, manageDeptPage);


    }

    @Test(priority = 1, description = "LMS-225 : Verify and Validate whether new department is added")
    public void verifyNewDeptAdded() throws InterruptedException, AWTException {

//        testCase = extentReport.createTest("LMS-225 : Verify and Validate whether new department is added");

        Thread.sleep(4000);
        ManageDepartmentPageObject.sidedashboard_managedept.click();
        Thread.sleep(6000);
        ManageDepartmentPageObject.peoplcenterpage_managedept.click();

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_MINUS);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_MINUS);

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        Thread.sleep(4000);
        ManageDepartmentPageObject.managedeptTab.click();

        testCase.info("Manage Department TAB was displayed");
        Thread.sleep(2500);

        List<WebElement> manageDept_list = driver.findElements(By.xpath("//div[@class='ManageDepartment_dept-list-container__v+SAN']/ul"));
        len = manageDept_list.size();
        System.out.println("Total number of Departments are " + len);
        Thread.sleep(2500);

        String newDeptName_v = driver.findElement(By.xpath("//div[@class='ManageDepartment_dept-list-container__v+SAN']/ul[last()]/LI[3]")).getText();
        System.out.println("Recently Added department: " + newDeptName_v);
        Assert.assertEquals(newDeptName_v, "Cornelson", "Dept not added");
        testCase.pass("Newly Added Dept was listed");

        String newSubDept_v = driver.findElement(By.xpath("//div[@class='ManageDepartment_dept-list-container__v+SAN']/ul[" + len + "]/li[4]")).getText();
        Assert.assertEquals(newSubDept_v, "Test", "SubDept not added");
        testCase.pass("Newly Added SubDept was listed");

//        if (expected_dept.equals(actual_dept)) {
//            testCase.log(Status.PASS, "Actual Sub Dept and expected are equal");
//        } else {
//            testCase.log(Status.PASS, "Actual Sub Dept and expected are not equal");
//        }
    }

    @Test(priority = 4, description = "LMS-219 : Verify the edit button is accessbile in action column to edit department")
    public void verifyManageDeptEditButton() throws InterruptedException, AWTException {

//        Thread.sleep(2000);
//        List<WebElement> manageDeptId_list = driver.findElements(By.xpath("//div[@class='ManageDepartment_dept-list-container__v+SAN']/ul"));
//        len_1 = manageDeptId_list.size();
//        System.out.println("Total number of Dep Id are " + len_1);
        Thread.sleep(2000);
        ManageDepartmentPageObject.EditButton.click();
        testCase.info("Edit button is enabled");



    }


    @Test(priority = 2, description = "LMS-220 : Verify whether delete button is accessible")
    public void verifyDeleteButton() throws InterruptedException {

//        testCase = extentReport.createTest("LMS-220 : Verify whether delete button is accessible");
        Thread.sleep(5000);
        ManageDepartmentPageObject.deleteButton.click();
        testCase.info("Delete is Enabled");
        Thread.sleep(5000);

        String deleteconf = ManageDepartmentPageObject.deleteconfirmation.getText();
        Assert.assertEquals(deleteconf, "Are you sure want to delete the department name of Sakthi ?", "Confirmation was wrong");
        testCase.info("Delete confirmation has been displayed");

        ManageDepartmentPageObject.deleteNoButton.click();
        testCase.pass("No button has been selected");


    }

    @Test(priority = 3, description = "LMS-221 : Verify and validate whether edited department details updated after using edit option")
    public void verifyEditedDetailsUpdated() throws InterruptedException {
//        testCase = extentReport.createTest("LMS-221 : Verify and validate whether edited department details updated after using edit option");


        testCase.info("All DeptId generated are listed here");
        Thread.sleep(3000);
        String DeptId_v = driver.findElement(By.xpath("//div[@class='ManageDepartment_dept-list-container__v+SAN']/ul[last()]/LI[2]")).getText();
        System.out.println("New Generated Dept ID: " + DeptId_v);
        Assert.assertEquals(DeptId_v, "DEP75149", "DeptID was not valid");
        testCase.pass("Newly Added DepID Verified");


    }


//    @Test
//    public void ab1() {
//        testCase = extentReport.createTest("Verify Manage Dept Edit Button1");
//
//        Assert.assertFalse(true);
//        Assert.assertEquals(true, true);
//    }

//    @Test
//    public void ab2() {
//        testCase = extentReport.createTest("Verify Manage Dept Edit Button2");
//
//        testCase.info("2nd test case");
//        Assert.assertFalse(false);
//        testCase.pass("testcase on 1st line");
//
//        Assert.assertTrue(false, "Going to throw assertion error");
//
//
}




