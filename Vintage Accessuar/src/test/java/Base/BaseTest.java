package Base;

import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class BaseTest {

    public WebDriver driver;

    @BeforeAll
    public void setUp() {

        //PropertyConfigurator.configure("log4j.properties");

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.vintageaksesuar.com");
    }
}
