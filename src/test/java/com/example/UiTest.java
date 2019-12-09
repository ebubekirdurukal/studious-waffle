package com.example;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.thoughtworks.gauge.Step;
import java.util.logging.Logger;

public class UiTest {

    private final static Logger logger = Logger.getLogger(UiTest.class.getName());


    @Test
    public void uiTest(){
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        String baseUrl = "http://localhost:9090/films";
        driver.get(baseUrl);
        driver.close();
        logger.info("Test Passed");
    }
}
