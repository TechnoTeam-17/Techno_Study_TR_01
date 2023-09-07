import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_06_anaSayfaKontrol extends BaseDriver {

    @Test
    public void test() {


        WebElement homePg = driver.findElement(By.xpath("//a[@href='/home']"));
        homePg.click();


        Assert.assertFalse(driver.getCurrentUrl().equals("https://techno.study/tr"));

                //Web sayfasi yonlenmiyor buraya uyari kismi eklenmeli
                //kod calisti


                //Ana sayfaya gelen url ilk acilisdaki url ile ayni degil


                //  Assert.assertTrue("mail ayni olamaz",text.getText().equals("The specified email already exists"));
                // Assert.assertTrue("https://techno.study/tr== https://techno.study/home%22,%22techno studyTR url-si bulunamadi");
                //  Assert.assertTrue(elements.msg.getText().equals("Your order has been placed!"));

    }


}