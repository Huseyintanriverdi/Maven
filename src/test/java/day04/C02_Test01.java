package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C02_Test01 {
//    1-Test01 isimli bir class olusturun
//2- https://www.walmart.com/ adresine gidin
//            3- Browseri tam sayfa yapin
//4-Sayfayi “refresh” yapin
//5- Sayfa basliginin “Save” ifadesi icerdigini control edin
//6-Sayfa basliginin “Walmart.com | Save Money.Live Better” a esit oldugunu control ediniz
//7- URL in walmart.com icerdigini control edin
//8-”Nutella” icin arama yapiniz
//9- Kac sonuc bulundugunu yaziniz
//10-Sayfayi kapatin

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.walmart.com/");
        driver.manage().window().maximize();
        driver.navigate().refresh();
        String actuelTitle = driver.getTitle();
        String arananKelime="save";
        if (actuelTitle.contains(arananKelime)){
            System.out.println("title " + arananKelime+" kelimesini iceriyor, Test PASS");
        }else
            System.out.println("title " + arananKelime+" kelimesini icermiyor, Test FAILED");
        String expectedTitle="Walmart.com | Save Money.Live Better";

        if (expectedTitle.equals(actuelTitle)){
            System.out.println("Sayfa title beklenen ile ayni, test PASS");
        }else
            System.out.println("Sayfa title beklenen ile farkli, test FAILED");
        System.out.println("actuel title : " +actuelTitle);

        String actuelURL=driver.getCurrentUrl();
        String urlArananKelime="walmart.com";
        if (actuelURL.contains(urlArananKelime)){
            System.out.println("URL "+ urlArananKelime + " kelimesini iceriyor, test PASS");
        }else
            System.out.println("URL "+ urlArananKelime + " kelimesini icermiyor, test PASS");
        WebElement aramaKutusu= driver.findElement(By.xpath("//input[@name='q']"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        WebElement sonucYazisiElementi=driver.findElement(By.xpath("//div[@class='inline-flex mv3-xl mt3 ml3 ml4-xl mr1 db']")); //div[@class='inline-flex mv3-xl mt3 ml3 ml4-xl mr1 db'
        System.out.println(sonucYazisiElementi.getText());
        driver.close();

    }

}
