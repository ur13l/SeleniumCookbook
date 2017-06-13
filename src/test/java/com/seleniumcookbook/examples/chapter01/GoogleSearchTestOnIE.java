package com.seleniumcookbook.examples.chapter01;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Uriel on 13/06/2017.
 */
public class GoogleSearchTestOnIE {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/IEDriverServer.exe");
        DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
        caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

        //Lanzar Internet explorer
        driver = new InternetExplorerDriver(caps);

        //Maximizar el navegador
        driver.manage().window().maximize();

        //Navegar a Google
        driver.get("http://www.google.com");

    }


    @Test
    public void testGoogleSearch () {
        //Encuentra el input por su nombre
        //WebElement element = dri
    }
}
