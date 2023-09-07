import Utility.BaseDriver;
import Utility.BaseDriverBrowser;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class herKursIcinDetayBilgi extends BaseDriver{
    @Test

    public void detayliBilgiTest(){

        driver.get("https://techno.study/tr");
        List<WebElement> detayliBilgi=driver.findElements(By.linkText("Detaylı bilgi"));

        for (int i = 0; i <detayliBilgi.size() ; i++) {
            System.out.println("Detayli bilgi butonu gorunur mu?  " + detayliBilgi.get(i).isDisplayed());
            System.out.println("3 Kurs icin Detayli Bilgi linkleri = " + detayliBilgi.get(i).getAttribute("href"));
            Assert.assertEquals(detayliBilgi.get(0).getAttribute("href"),"https://techno.study/tr/data");
            Assert.assertEquals(detayliBilgi.get(1).getAttribute("href"),"https://techno.study/tr/sdet");
            Assert.assertEquals(detayliBilgi.get(2).getAttribute("href"),"https://techno.study/tr/androidapp");

        }

    //    WebElement sdet=driver.findElement(By.xpath("//*[contains(@href,'https://techno.study/tr/sdet')]"));
     //   sdet.click();
     //   WebElement android=driver.findElement(By.xpath("//*[contains(@href,'https://techno.study/tr/androidapp')]"));
    //    android.click();
     //  WebElement data=driver.findElement(By.xpath("//*[contains(@href,'https://techno.study/tr/data')]"));
     //   data.click();

    }

    }


