package stiker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class stiker {
    private WebDriver driver;
    private WebDriverWait wait;
    @Before
    public void start(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,100);
    }
    @Test
    public void myFirstTest(){
        driver.get("http://localhost/litecart/");

        List<WebElement> images = driver.findElements(By.cssSelector("[class ^= product]"));
        if (images.size() == 0)
        {
            System.out.println("Элементы не найдены");
            return;
        }
        else {
            System.out.println("Элементы найдены");
        }
        for (WebElement stikers : images) {
            List<WebElement> sticker = stikers.findElements(By.cssSelector("[class ^= sticker]"));
            if (sticker.size()!= 1) {
                System.out.println("Ошибка со стикерами");
                return;
            }
            System.out.println("Один стикер");
        }
    }
    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
