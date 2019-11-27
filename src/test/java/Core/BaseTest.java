package Core;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Gilvan Reis on 27/11/2019.
 */
public class BaseTest {
    protected static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\WebDrivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://vfcli.varejofacil.com/");
    }
}
