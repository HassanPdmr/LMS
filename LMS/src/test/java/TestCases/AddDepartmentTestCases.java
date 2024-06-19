package TestCases;

import PageObjects.Add_DepartmentPageObject;
import PageObjects.Add_UserPageObject;
import CommonFunctions.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class AddDepartmentTestCases extends CommonFunctions {


    @Test
    public void verifyAddDepart() throws InterruptedException, AWTException {

        PageFactory.initElements(driver, Add_DepartmentPageObject.class);
        Thread.sleep(3000);


        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement KB = wait.until(ExpectedConditions.elementToBeClickable(Add_UserPageObject.peoplcenterpage));
        KB.click();

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_MINUS);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_MINUS);

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();


        Thread.sleep(1000);

        Add_DepartmentPageObject.Add_deptCard.click();


        WebElement depID = wait.until(ExpectedConditions.elementToBeClickable(Add_DepartmentPageObject.departId));
        depID.getText();

        Add_DepartmentPageObject.deptname.sendKeys("TestNewOne");
        Add_DepartmentPageObject.subdeptment.sendKeys("SubOne");
        Add_DepartmentPageObject.add_subdepart_button.click();

        Thread.sleep(2000);

        Add_DepartmentPageObject.subdeptment.sendKeys("SubTwo");
        Add_DepartmentPageObject.add_subdepart_button.click();

        Thread.sleep(2000);

        List<WebElement> sub_depart_list = driver.findElements(By.xpath("//div[@class='AddDepartment_sub-department-container__jlzXF']/li"));
        int len = sub_depart_list.size();

        System.out.println("Total Sub department added " + len);


        for (WebElement name : sub_depart_list) {
            System.out.println("Sub department added names " + name);
        }


    }


}
