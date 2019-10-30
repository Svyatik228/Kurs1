package ua.com.kurs;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class FirstTest {
    /*WebDriver driver = new ChromeDriver();
    @Before
    public void before() {
        System.out.println("Test  start");
    }*/


    @Test
    public void TestFirst() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://kurs.com.ua/?gclid=CjwKCAjwusrtBRBmEiwAGBPgEykQWUHf8iCg0rA7u21PGm596a7_gLKm9rdhu7vSgzSxMWeqN2MgIxoC0igQAvD_BwE");
        WebElement button_USD = driver.findElement(By.xpath(".//*[@id='elMainFormMenu']/../..//a[contains(text(),'USD')]"));
        button_USD.click();
        Thread.sleep(2000);
        String l= driver.findElement(By.xpath(".//td[contains(@data-rate-type,'commercial')]/span[@class='ipsKurs_rate ipsResponsive_hidePhone']")).getText();
        System.out.println(l);
        driver.findElement(By.cssSelector("#elAmountFrom")).sendKeys("125");
     //   String result= driver.findElement(By.cssSelector("#elAmountTo")).getText();
       // String elementId;
        Thread.sleep(2000);
        driver.findElement(By.id("elSourcesMenu")).click();
        driver.findElement(By.xpath(".//li[@class='ipsMenu_item']//span[contains(text(),'Коммерческий')]/..")).click();
        Thread.sleep(2000);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        String jsStatement = "return document.getElementById('" + "elAmountTo" + "')." + "value" + ";";
        String res= (String) executor.executeScript(jsStatement);
        Assert.assertEquals(res,String.valueOf(getMultiply(l,"125")));
    }
private double getMultiply(String k,String chyslo){
        return Double.parseDouble(k)*Double.parseDouble(chyslo);
}
   /* @After
    public void after() {
        System.out.println("Test  end");
        driver.quit();
    }*/
}
