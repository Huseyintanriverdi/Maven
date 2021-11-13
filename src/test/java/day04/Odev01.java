package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Odev01 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");
//        2. Username kutusuna “standard_user” yazdirin
//        3. Password kutusuna “secret_sauce” yazdirin
//        4. Login tusuna basin
        driver.findElement(By.xpath("//input[@class='input_error form_input']")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@class='submit-button btn_action']")).click();
//        5.Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        driver.findElement(By.xpath("//div[@class='inventory_item_name']")).click();
//        6. Add to Cart butonuna basin
        driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']")).click();
//        7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

//        8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
       WebElement cantaEklendimi= driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
       if (cantaEklendimi.isDisplayed()){
           System.out.println("sectiginiz urun basari ile eklendi, test PASS");
       }else
           System.out.println("sectiginiz urun eklenemedi, test FAILED");

       driver.close();
    }

}
