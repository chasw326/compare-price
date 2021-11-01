package com.example.comparePrice.selenium;

import org.aspectj.lang.annotation.Before;
import org.junit.After;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class selenium_test {

    private WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "study/chromedriver"); // 다운받은 ChromeDriver 위치를 넣어줍니다.
        driver = new ChromeDriver(); // Driver 생성
    }
    @After
    public void tearDown(){
        driver.quit();  // Driver 종료
    }

    @Test
    public void test_title(){ //타이틀 확인하는 테스트 코드
        driver.get("Test URL입력"); // URL로 접속하기
        WebElement coolestWidgetEvah = driver.findElement(By.id("coolestWidgetEvah")); //id로 Element 가져오기
        WebElement cheese = driver.findElements(By.className("cheese")); //클래스이름으로 Element 가져오기
        WebElement iframe = driver.findElement(By.tagName("iframe")); //태그이름으로 Element 가져오기
        Assert.assertThat(driver.getTitle(),is("URL의 Title")); // Title 확인 작업
    }
}