import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_04 extends BaseDriver {

    @Test
    public void Courses_SubMenu() {

        driver.get("https://techno.study/tr");
        MyFunc.Bekle(2);

        Actions actions = new Actions(driver);

        WebElement sdetBtn = driver.findElement(By.linkText("SDET Yazılım Test Mühendisi"));
        actions.moveToElement(sdetBtn).perform();
        sdetBtn.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("sdet"));

        driver.navigate().back();

        WebElement androidBtn = driver.findElement(By.linkText("Android Uygulama Geliştirme"));
        actions.moveToElement(androidBtn).perform();
        androidBtn.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("androidapp"));

        driver.navigate().back();

        WebElement veriBtn = driver.findElement(By.linkText("Veri bilimi"));
        actions.moveToElement(veriBtn).perform();
        veriBtn.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("data"));

        driver.navigate().back();

        WebElement masterBtn = driver.findElement(By.linkText("Master's Program"));
        actions.moveToElement(masterBtn).perform();
        masterBtn.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("masters"));
    }
}