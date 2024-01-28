package com.scooter;

import com.scooter.pageobject.page.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    protected WebDriver driver;
    @Before
    public void setUp() {
        String browser = System.getenv("BROWSER");
        driver = getDriver(browser == null ? "chrome" : browser);
        driver.get(MainPage.URL);
        setCoocie(new Cookie("Cartoshka","true"));
        setCoocie(new Cookie("Cartoshka-legacy","true"));
    }
//метод для закрытия плашки с куками в домашней странице
    private void setCoocie(Cookie coocie) {
        driver.manage().addCookie(coocie);
        driver.navigate().refresh();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    private WebDriver getDriver(String browser){

        switch (browser.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "mozilla":
                System.setProperty("webdriver.gecko.driver","src/test/resources/geckodriver.exe");
                return new FirefoxDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser");


        }
    }
}
