import Utility.BaseDriver;
import org.testng.annotations.Test;

public class US_08_kullanimSartlari extends BaseDriver {

        @Test
        public <JavascriptExecutor> void kullanimSartlariTest(){
            loginTesti();

            JavascriptExecutor js= (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, 6000);");
            MyFunc.Bekle(1);

            WebElement kulsart = driver.findElement(By.xpath(" //a[@href='https://techno.study/tr/terms'] "));
            kulsart.click();
            MyFunc.Bekle(2);

            WebElement bize=driver.findElement(By.xpath(" //*[@class='tn-atom'and @field='tn_text_1661174897949']" ));
            if (bize.getText().equals("Bize ulaşın!"));
            System.out.println("bize ulasin sayfasi dogru acilmistir");

            WebElement formKullSart= driver.findElement(By.xpath("//span[@class='t-checkbox__labeltext']"));
            formKullSart.click();
            String formKullSartSonrasiUrl=driver.getCurrentUrl();


            Assert.assertEquals(formKullSartSonrasiUrl, "GEREKLİ SAYFA LİNKİ", "Kullanici sartlari sayfasina erisilemedi");

        }

    }

}
