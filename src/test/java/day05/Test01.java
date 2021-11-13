package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Test01 {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
//    2- https://www.amazon.com/ adresine gidin
    @Test
    public void test01(){
        driver.get("https://www.amazon.com/");
//        3- Browseri tam sayfa yapin
        driver.manage().window().maximize();
//        4-Sayfayi “refresh” yapin
        driver.navigate().refresh();
//        5- Sayfa basliginin “Amazon” ifadesi icerdigini control edin

        if (driver.getTitle().contains("Amazon")){
            System.out.println("sayfa basligi amazon iceriyor,Test PASS");
        }else
            System.out.println("sayfa basligi amazon icermiyor,Test FAILED");
//        6-Sayfa basliginin “Amazon.com. Spend less. Smile more.” a esit oldugunu control ediniz
        if (driver.getTitle().equals("Amazon.com. Spend less. Smile more.")){
            System.out.println("Sayfa basligi Amazon.com. Spend less. Smile more. Test PASS");
        }else
            System.out.println("Amazon.com. Spend less. Smile more. degil,Test FAILED gercek baslis : "+driver.getTitle());
//        7- URL in amazon.com icerdigini control edin
        if (driver.getCurrentUrl().contains("amazon.com")){
            System.out.println("URL amazon.com iceriyor, Test PASS");
        }else
            System.out.println("URL amazon.com icermiyor, Test FAILED");
//        8-”Nutella” icin arama yapiniz
       driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
//        9- Kac sonuc bulundugunu yaziniz
        System.out.println(driver.findElement(By.xpath("(//span[@dir='auto'])[1]")).getText());

        }
        @After
    public void tearDown(){
        driver.close();
        }
    }

