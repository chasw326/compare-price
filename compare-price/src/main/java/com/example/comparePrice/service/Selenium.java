package com.example.comparePrice.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class Selenium {

    private static String _URL = "https:/www.naver.com/";

    public void getPrice() throws IOException {

    }
    @PostConstruct
    public void setChrome() throws IOException {
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

    }
}
