package NavigateObj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Navigation_Keys {


    private WebDriver driver;

    public Navigation_Keys(WebDriver driver) {


        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//p[@class='Dashboard_headerTitle__hGo7r']")
    public WebElement homepage;

    @FindBy(xpath = "//img[@alt='LMS logo']")
    public WebElement sideDashboard;

    @FindBy(xpath = "//*[text()='People Center']")
    public WebElement peopleCenterPage;

}
