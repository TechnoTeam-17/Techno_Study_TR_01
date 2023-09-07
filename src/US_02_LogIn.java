import Utility.BaseDriver;
import Utility.BaseDriverBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_02_LogIn extends BaseDriver {
    @Test
    public void US_02(){

        WebElement campusLogin= driver.findElement(By.xpath("//*[text()='Campus Login']"));
        campusLogin.click();

        wait.until(ExpectedConditions.urlToBe("https://campus.techno.study/"));


        Assert.assertTrue(driver.getCurrentUrl().contains("campus.techno.study"));



    }
}
