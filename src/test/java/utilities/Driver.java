package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {
    public static WebDriver driver;

    private Driver() {
    }//new keyword'ü ile başka class'lardan bu class'ın bir objesinin oluşturulmasının önüne geçer.

    public static WebDriver getDriver() {

        if (driver == null) {//Eğer driver null(oluşturulmamış)  ise yeni driver oluştur.

            String browser = ConfigReader.getProperty("browser");//configuration.properties dosyasında yazılı browser değerini  String olarak döner

            switch (browser) {//configuration.properties dosyasından gelen değere göre ilgili browser'ı açar.

                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "headless":
                    driver = new ChromeDriver(new ChromeOptions().addArguments("--headless=new"));
                    break;
                default:
                    driver = new ChromeDriver();

            }

        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }


    public static void closeDriver() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (driver != null) {//Eğer driver null değil(oluşturulmuş) ise quit() metodunu kullan.
            driver.quit();
            driver = null;//quit() işlemi sonrası getDriver() methodunun tekrar çalışabilmsi için gerekli.
        }

    }
}