import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.ArrayList;
import java.util.List;

public class K3MebelTest {

    static {
        WebDriverManager.chromedriver().setup();
    }

    private WebDriver driver;
    private final String url = "https://k3-mebel.ru/";

    @Test
    public void testFooterFirstHeaderTitle() throws InterruptedException {
        String titleExpected = "О программе".toUpperCase();

        driver.get(url);
        String titleActual = driver.findElement(By.xpath("//li[@id='menu-item-15217']/a")).getText();
        Assert.assertEquals(titleExpected, titleActual);
    }

    @Test
    public void testFooterFirstHeadersTitles() throws InterruptedException {
        List<String> titlesExpected = new ArrayList<>();
        titlesExpected.add("НОВАЯ ВЕРСИЯ К3-МЕБЕЛЬ");
        titlesExpected.add("Новости");
        titlesExpected.add("Отчеты");
        titlesExpected.add("Системные требования");
        titlesExpected.add("История версий");
        titlesExpected.add("Наши клиенты");
        titlesExpected.add("FAQ");

        driver.get(url);
        List<String> titlesActual = new ArrayList<>();
        for(WebElement title: driver.findElements(By.xpath("//li[@id='menu-item-15217']/ul/li"))) {
            titlesActual.add(title.getText());
        }

        Assert.assertEquals(titlesExpected, titlesActual);
    }

    //li[@id='menu-item-6']/a
//    String telActual = driver.findElement(By.xpath("//li[@id='menu-item-6']/a")).getText();
//body/header/div/div/div/div/div/a[@href=\"tel:88003504248\"]/span

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

