package TestCases;


import PageObjects.ManageUsersPageObject;
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

public class ManageUsersTestcases extends CommonFunctions {
    int len;

    @Test
    public void verifyManageusers() throws AWTException, InterruptedException {


        PageFactory.initElements(driver, ManageUsersPageObject.class);
        Thread.sleep(5000);


        ManageUsersPageObject.sidedashboard_m.click();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement KB = wait.until(ExpectedConditions.elementToBeClickable(ManageUsersPageObject.peoplcenterpage));
        KB.click();

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_MINUS);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_MINUS);

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();


        Thread.sleep(6000);
        ManageUsersPageObject.manageusers.click();
        Thread.sleep(5000);

        ManageUsersPageObject.sampletext.isDisplayed();

        /*
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");*/

        Thread.sleep(3500);


        List<WebElement> manageusers_list = driver.findElements(By.xpath("//div[@class='ManageUserTable_user-list-container__m+r4g']/ul"));
        len = manageusers_list.size();

        Thread.sleep(3500);
        System.out.println("Newly added Emp Id: " + driver.findElement(By.xpath("//div[@class='ManageUserTable_user-list-container__m+r4g']/ul[" + len + "]/li[2]")).getText());
        System.out.println("Newly added Emp Name: " + driver.findElement(By.xpath("//div[@class='ManageUserTable_user-list-container__m+r4g']/ul[" + len + "]/li[3]")).getText());


    }


}
