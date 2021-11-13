package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
////Navigate to "https://react-shopping-cart-67954.firebaseapp.com/"
//// List all the elements on the website
//// Create a String Arraylist and put Product Names into the ArrayList
//// Choose 5 items randomly, add to cart and print the names of items
//// (Each product cannot be added more then 1 time!)
//
//// CHECK THE PRICES!
//// Sum each item's price and compare your result with the website
//// If results are matching print success message
//// Get string price values from Website, convert them to double and add to <Double> ArrayList and print the price list
//// Click Checkout
public class QA7Work {
  WebDriver driver;

  @Before
  public void setup(){
      WebDriverManager.chromedriver().setup();
      driver= new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
      driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
  }
  @Test
    public void test01(){
       List<WebElement> urunListesi=driver.findElements(By.xpath("//div[@class='shelf-item__thumb']"));
      System.out.println(urunListesi);
  }
}
