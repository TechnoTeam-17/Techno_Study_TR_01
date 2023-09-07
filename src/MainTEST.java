import Utility.BaseDriverBrowser;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainTEST extends BaseDriverBrowser {
    @Test
    public void US_01() {


        List<String> expectedMenuList = new ArrayList<>();
        expectedMenuList.add("SDET Yazılım Test Mühendisi");
        expectedMenuList.add("Android uygulama geliştirme");
        expectedMenuList.add("Veri bilimi");
        expectedMenuList.add("Job Center & Arbeitsamt");
        expectedMenuList.add("Master's Program");


        WebElement courses = driver.findElement(By.xpath("//a[@data-tooltip-menu-id='516093139']")); //
        new Actions(driver).moveToElement(courses).build().perform();
        Assert.assertTrue(courses.isDisplayed());


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

            //  System.out.println("actualMenuList = " + actualMenuList.get(i));

            if (!expectedMenuList.get(i).equals(actualMenuList.get(i))) {
                System.out.println("Eşleşme Bu menude sağlanamadı");
                System.out.println("resultedMEnuList = " + actualMenuList.get(i));
                System.out.println("expectedMenuList = " + expectedMenuList.get(i));
            }

            Assert.assertTrue(actualMenuList.get(i).equals(expectedMenuList.get(i)), "Hatalı Menu, Tam Eşleşme olmadı");

        }

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


    @Test
    public void US_02_Test(){

        WebElement campusLogin= driver.findElement(By.xpath("//*[text()='Campus Login']"));
        campusLogin.click();

        wait.until(ExpectedConditions.urlToBe("https://campus.techno.study/"));


        Assert.assertTrue(driver.getCurrentUrl().contains("campus.techno.study"));
    }




    @Test
    public void US_04() {

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

    @Test
    public void E_BookPaymentProcessTest(){


        WebElement addToCartButton = driver.findElement(By.xpath("//a[text()='Add to Cart']"));
        addToCartButton.click();

        driver.switchTo().frame(0);
        WebElement debitCardOption = driver.findElement(By.xpath("//span[text()='Visa, AMEX, MasterCard, Maestro, Discover']"));
        debitCardOption.click();

        MyFunc.Bekle(2);
        WebElement payButton = driver.findElement(By.xpath("//button[@class='Pay-Button']"));
        payButton.click();

        List<String> errorMessages = Arrays.asList("Invalid Email", "Invalid Billing Name", "Invalid Billing Address 1", "Invalid Billing City", "Invalid Billing PostCode");

        for (String error : errorMessages) {
            WebElement errorMessage = driver.findElement(By.xpath("//div[@id='SnackBar']/span"));
            Assert.assertTrue( errorMessage.isDisplayed());
            System.out.println("errorMessage = " + error);
        }
    }
}
