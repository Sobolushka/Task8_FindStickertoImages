package stiker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
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

        List<WebElement> images = driver.findElements(By.className("image-wrapper"));
        if (images == null)
        {
            System.out.println("Элементы не найдены");
            return;
        }
        for (int i = 0; i < images.size(); i++) {
            List<WebElement> sticker = images.get(i).findElements(By.className("sticker"));
            if (sticker.size()!= 1) {
                System.out.println("Ошибка со стикерами");
                return;
            }
        }
        System.out.println("Все имеют только по одному стикеру");
    }
    @After
    public void stop(){

        driver.quit();
        driver = null;
    }
}
