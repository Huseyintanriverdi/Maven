package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C03_Before_After {
    // uc test methodu yapin
    //1.metod amazon.com
    //2.metod techproeducationa
    //3.method facebooka gitsin
    //eger her test methodu icin yeni bir sayfa acilsin ve test methodu sonunda kapansin
    //istiyorsak @Before ve @after notasyonlari kullanilmali
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @Test
    public void amazonTesti(){
        driver.get("https://amazon.com/");
        System.out.println(driver.getTitle());
    }
    @Test
    public void techproedTesti(){
        driver.get("https://techproed.com/");
        System.out.println(driver.getTitle());
    }
    @Test
    public void facebookTesti(){
        driver.get("https://facebook.com/");
        System.out.println(driver.getTitle());
    }
    @After
    public void tearDown(){
        driver.close();
    }
}
