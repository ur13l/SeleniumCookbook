package com.seleniumcookbook.examples.chapter01;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

/**
 * Created by Uriel on 09/06/2017.
 */
public class GoogleSearchTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        //Launch a new Firefox instance
        System.setProperty("webdriver.gecko.driver","src\\test\\resources\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();

        //Maximize the browser window
        driver.manage().window().maximize();

        //Navigate to Google
        driver.get("http://www.google.com");
    }

    @Test
    public void testGoogleSearch() {
        //Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        //Clear the existing text value
        element.clear();

        //Enter something to search for
        element.sendKeys(("Selenium testing tools cookbook"));

        //Now submit the form
        element.submit();

        //Google's search is rendered dynamically with Javascript.
        //Wait for the page to load, timeout after 10 seconds.
        new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
           public Boolean apply(WebDriver d) {
               return d.getTitle().toLowerCase()
                       .startsWith("selenium testing tools cookbook");
           }
        });

        assertEquals("Selenium testing tools cookbook - Buscar con Google", driver.getTitle());
    }

    @After
    public void tearDown() throws Exception {
        //Close the browser
        driver.quit();
    }
}
