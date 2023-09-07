import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class basvur extends BaseDriver {
    @Test
    public void testa1(){
        driver.get("https://techno.study/tr");
        WebElement basvurvarmi= driver.findElement(By.xpath("//*[text()='BAŞVUR']"));
        basvurvarmi.click();
//    1. test gecti    Assert.assertEquals(basvurvarmi.getText(),"BAŞVUR");
        WebElement name= driver.findElement(By.name("name"));
        name.sendKeys("Test_Abuzer_Kadayif");
        WebElement email= driver.findElement(By.name("email"));
        email.sendKeys("Test_Abuzer@gmail.com");
        WebElement type= driver.findElement(By.xpath("//*[@type='tel']"));
        type.sendKeys("9998887777");
        WebElement country= driver.findElement(By.xpath("//option[@value='Andorra']"));
        country.click();
        WebElement course= driver.findElement(By.xpath("//option[@value='SDET Türkçe']"));
        course.click();
        WebElement survey= driver.findElement(By.xpath("//option[@value='Arkadaş vasıtası ile']"));
        survey.click();
        WebElement procode= driver.findElement(By.name("promo code"));
        procode.sendKeys("keske olsa");
        WebElement sart= driver.findElement(By.xpath("//*[@class='t-checkbox__indicator']"));
        sart.click();
        WebElement send= driver.findElement(By.xpath("//*[@class='t-submit']"));
        send.click();
        WebElement sendmsg= driver.findElement(By.id("tildaformsuccesspopuptext"));

        Assert.assertTrue(sendmsg.isDisplayed());


// bitisIslemleri();
    }
}
