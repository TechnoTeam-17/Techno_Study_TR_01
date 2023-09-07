import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_08_kullanimSartlari extends BaseDriver {

    @Test
    public void kullanimSartlariTest() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 6000);");
        MyFunc.Bekle(3);

        WebElement bize = driver.findElement(By.xpath("//*[@class='tn-atom'and @field='tn_text_1661174897949']"));
        if (bize.getText().equals("Bize ulaşın!")) {
            System.out.println("bize ulasin sayfasi dogru acilmistir");
        }

        WebElement kulsart = driver.findElement(By.xpath("//span[@class='t-checkbox__labeltext']"));
        kulsart.click();
        String kulsartSonrasiUrl = driver.getCurrentUrl();
        Assert.assertEquals(kulsartSonrasiUrl, "https://techno.study/tr/terms", "Kullanici sartlari sayfasina erisilemedi");

        WebElement formKullSart = driver.findElement(By.xpath("//a[@href='https://techno.study/tr/terms']"));
        formKullSart.click();
        String formKullSartSonrasiUrl = driver.getCurrentUrl();
        Assert.assertEquals(formKullSartSonrasiUrl, "https://techno.study/tr/terms", "Kullanici sartlari sayfasina erisilemedi");




    }

}


