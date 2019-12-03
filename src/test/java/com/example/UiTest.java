package com.example;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class UiTest {

    @Test
    public void uiTest(){
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        String baseUrl = "http://localhost:9090/developers";
        driver.get(baseUrl);
        driver.close();
        System.out.println("Ui Test passed");
    }
}
