import Utility.BaseDriver;
import Utility.BaseDriverBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class anasayfaKurslarDropDownGoruntuleme extends BaseDriverBrowser {
    @Test
    public void anasayfaKurslarDropDownGoruntulemeTest() {


        List<String> expectedMenuList = new ArrayList<>();
        expectedMenuList.add("SDET Yazılım Test Mühendisi");
        expectedMenuList.add("Android uygulama geliştirme");
        expectedMenuList.add("Veri bilimi");
        expectedMenuList.add("Job Center & Arbeitsamt");
        expectedMenuList.add("Master's Program");


        List<WebElement> actualMenuListTextDegil = driver.findElements(By.cssSelector("div[class='t966__menu-item-title t-name']"));

        // JavaScript ile metinleri çekmek için kullanılacak liste
        List<String> actualMenuList = new ArrayList<>();

        // JavascriptExecutor kullanarak elementlerin içeriğini çekin ve Java tarafında saklayın
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (WebElement element : actualMenuListTextDegil) {
            String textWitoutTrim = (String) js.executeScript("return arguments[0].textContent;", element);
            String text = textWitoutTrim.replaceAll("\u00A0", " ").trim(); // Websitesinden çekilen metindeki boşluklar "\u00A0" sayısal değerinde bir boşluk,
            actualMenuList.add(text);                                                      // Bu expectedMenuListdeki boşluklardan farklı, bu yüzden replaceAll yapıldı.
        }


        if (actualMenuList.size() == expectedMenuList.size()) {
            System.out.println("Sizelerı Eşit");
        }

        for (int i = 0; i < expectedMenuList.size(); i++) {

            System.out.println("actualMenuList = " + actualMenuList.get(i));

            if (!expectedMenuList.get(i).equals(actualMenuList.get(i))) {
                System.out.println("Eşleşme Bu menude sağlanamadı");
                System.out.println("resultedMEnuList = " + actualMenuList.get(i));
                System.out.println("expectedMenuList = " + expectedMenuList.get(i));
            }

            Assert.assertTrue(actualMenuList.get(i).equals(expectedMenuList.get(i)), "Hatalı Menu, Tam Eşleşme olmadı");


        }
    }
}
