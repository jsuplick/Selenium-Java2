package com.orasi;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hp.lft.sdk.*;
import com.hp.lft.report.*;
import com.hpe.leanft.selenium.*;
import com.hpe.leanft.selenium.By;
import com.hpe.leanft.selenium.ByEach;

import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import java.net.URI;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.pagefactory.ByChained;

public class Selenium_Java_Test {

    public static WebDriver driver = null;
    public static WebDriverWait waitVar = null;

    public static String baseURL = "http://advantageonlineshopping.com/#/";

    public Selenium_Java_Test() {
    //Change this constructor to private if you supply your own public constructor
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

//        //Initialize the LeanFT SDK and the LeanFT Reporter
//        ModifiableSDKConfiguration config = new ModifiableSDKConfiguration();
//        config.setServerAddress(new URI("ws://localhost:5095"));
//        SDK.init(config);
//        ModifiableReportConfiguration rconfig = new ModifiableReportConfiguration();
//        Reporter.init (rconfig);

        //Get WebDriver going
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Orasi_SA\\Desktop\\WebDriver\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {

        driver.quit();
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void test() throws Exception {

        driver.manage().window().maximize();
        driver.get(baseURL);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //Click the Speakers link
        WebElement element = driver.findElements(new ByEach(
                org.openqa.selenium.By.cssSelector("div#SpeakersImg > div > span"),
                org.openqa.selenium.By.xpath("//*[@id='SpeakersImg']/div/span")
        )).get(0);
        element.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //Number of items
        element = driver.findElements(new ByEach(
                org.openqa.selenium.By.cssSelector("html > body > div:nth-child(8) > section > article > div:nth-child(4) > div > div > div:nth-child(1) > p > a"),
                org.openqa.selenium.By.xpath("/html/body/div[4]/section/article/div[3]/div/div/div[1]/p/a")
        )).get(0);

        if (element.getText().contains("Links")) {
            System.out.println("Speakers not available");
        } else {
            System.out.println("Speakers available");
        }

        //Select the item
        element = driver.findElements(new ByEach(
                org.openqa.selenium.By.cssSelector("body > div.uiview.ng-scope > section > article > div.categoryData > a > button"),
                org.openqa.selenium.By.xpath("/html/body/div[4]/section/article/div[1]/a/button")
        )).get(0);
        element.click();

        // back to home
        element = driver.findElements(new ByEach(
                org.openqa.selenium.By.xpath("/html/body/header/nav/div/a/span[1]")
        )).get(0);
        element.click();


        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
}