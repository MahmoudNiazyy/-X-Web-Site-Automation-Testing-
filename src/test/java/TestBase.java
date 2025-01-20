import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {


    private WebDriverWait wait;
    protected   verfication_code Verfication_code;
    protected WebDriver driver;
    protected   SignUpPage signUpPage;
    @BeforeMethod
    public void SetUp()
    {
       // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        driver =  new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void TearDown()
    {
        // driver.quit();
    }




}
