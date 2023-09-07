import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class US_05_SosialMediaErisim extends BaseDriver {
    @Test
    public void test() {

      //  MyFunc.Bekle(2);
      //  List<WebElement> cookiesAccept = driver.findElements(By.xpath("//button[text()='Allow all cookies']"));
      //  if (cookiesAccept.size() > 0)
      //      cookiesAccept.get(0).click();
//

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollTo(0, 7000);");

        WebElement facebook = driver.findElement(By.linkText("https://www.facebook.com/technostudybootcamps"));
                facebook.click();
        MyFunc.Bekle(3);

        WebElement instagram = driver.findElement(By.linkText("https://www.instagram.com/techno.study"));
                instagram.click();
        MyFunc.Bekle(1);


        WebElement youtube = driver.findElement(By.linkText("https://www.youtube.com/c/TechnoStudyInc"));
                youtube.click();
        MyFunc.Bekle(1);

        WebElement linkedin = driver.findElement(By.linkText("https://www.linkedin.com/company/techno-study-inc"));
                linkedin.click();
        MyFunc.Bekle(1);


    }
}