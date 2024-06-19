package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {

    private WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void enterUsername(String username) {
       driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(By.xpath(" //input[@type='password']")).sendKeys(password);
    }

    public void clickSubmit() {
        driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
    }


}
