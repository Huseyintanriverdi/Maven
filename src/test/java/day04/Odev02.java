package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Odev02 {

//// CHECK THE PRICES!
//// Sum each item's price and compare your result with the website
//// If results are matching print success message
//// Get string price values from Website, convert them to double and add to <Double> ArrayList and print the price list
//// Click Checkout
public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
    Random rnd = new Random();
    //Todo Navigate to "https://react-shopping-cart-67954.firebaseapp.com/"

//// Todo Create a String Arraylist and put Product Names into the ArrayList
    List<WebElement> urunIsimleri = driver.findElements(By.className("shelf-item__title"));
    //// Todo Choose 5 items randomly, add to cart and print the names of items
//    for (int i = 0; i <5 ; i++) {
//        System.out.println((int)(Math.random()*16));
//    }
//    WebElement randomElaman = null;
//    for (int i = 0; i < 5; i++) {
//         randomElaman = urunIsimleri.get(rnd.nextInt(i));
//    }
//    System.out.println(randomElaman.getText());
    Collections.shuffle(urunIsimleri);
    for (int i = 0; i < 5; i++) {
        System.out.println(urunIsimleri.get(i).getText());
        urunIsimleri.get(i).click();
//    }
        //Todo CHECK THE PRICES!


    }
}
}