package com.example.comparePrice.service.scneduledJob;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


@Service
public class MonsterScraping {

    private static String _URL = "https://kr.iherb.com/pr/musclepharm-combat-100-whey-protein-chocolate-milk-5-lbs-2269-g/70913";

    private ChromeDriver driver =null;

    private WebElement element = null;

    private String price = "";

    @Scheduled(cron = "0 15 10 ? * *")
    @PostConstruct
    public void getPrice() throws IOException {
        setPage();
        element = driver.findElement(By.xpath("/html/body/div[7]/article/div[1]/div[2]/section[1]/div[2]/div[2]/div/section[1]/section/div[1]/div[2]"));
        price = element.getText();

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println(price);
    }

    public static void setPage() throws IOException {
        Path path = Paths.get(System.getProperty("user.dir"), "src/main/resources/chromedriver.exe");

        System.setProperty("webdriver.chrome.driver", path.toString());

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-popuo-blocking");
        options.addArguments("--disable-default-apps");

        ChromeDriver driver = new ChromeDriver();

        driver.executeScript("window.open('about:blank','_blank');");

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(0));
        driver.get(_URL);

        ////*[@id="price"]
    }
}
