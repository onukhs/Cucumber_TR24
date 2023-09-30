package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BrowserSetup {

    private static WebDriver driver;

    @Before
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\SDA\\TEE25\\CucumberDEMO\\src\\main\\resources\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.manage().window().maximize();

        System.out.println("INFO : BROWSER IS SETUP");
    }

    @After
    public static void shutDown(){
        driver.close();
        driver.quit();

        System.out.println("INFO : BROWSER IS DOWN");
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
