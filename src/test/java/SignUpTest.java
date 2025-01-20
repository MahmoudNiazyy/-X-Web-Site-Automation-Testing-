import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;



public class SignUpTest extends TestBase{

    String EmailAddress;
    String CreateMailWindow;
    Set<String> AllWindow;

    @Test (priority = 1)
    public void code() throws InterruptedException {

        driver.get("https://moakt.com/en/inbox");
        CreateMailWindow= driver.getWindowHandle();
        Verfication_code = new verfication_code(driver);

        EmailAddress =  Verfication_code.Create_FackAccount("MahmoudN551");
        Thread.sleep(Duration.ofSeconds(3));
        System.out.println(EmailAddress);

        ((JavascriptExecutor) driver).executeScript("window.open('https://x.com/i/flow/signup', '_blank');");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        AllWindow= driver.getWindowHandles();
        for (String s : AllWindow)
        {
            if(!s.equals(CreateMailWindow))
            {
                driver.switchTo().window(s);
            }
        }
        signUpPage = new SignUpPage(driver);
        signUpPage.Add_Data_Page1("Naser",EmailAddress,8,3,1997);
        Thread.sleep(Duration.ofSeconds(3));
        driver.switchTo().window(CreateMailWindow);

        System.out.println(driver.getCurrentUrl());

        Thread.sleep(Duration.ofSeconds(20));
        driver.navigate().refresh();
        Thread.sleep(Duration.ofSeconds(3));




       String VerficationNumber= Verfication_code.verficationCode();

       System.out.println(VerficationNumber);

        for (String s : AllWindow)
        {
            if(!s.equals(CreateMailWindow))
            {
                driver.switchTo().window(s);
            }
        }

        Thread.sleep(Duration.ofSeconds(10));
        signUpPage.Addverfication_codeTo_X_Page(VerficationNumber);
        Thread.sleep(Duration.ofSeconds(5));
        signUpPage.ClickNextButtonIn_verficationPage();
        Thread.sleep(Duration.ofSeconds(5));
        signUpPage.AddNewPassword("Mi123987@@");
        Thread.sleep(Duration.ofSeconds(3));
        signUpPage.SkipForNowButton();//photo
        Thread.sleep(Duration.ofSeconds(3));
        signUpPage.SkipForNowButton();// call you
        Thread.sleep(Duration.ofSeconds(3));
        signUpPage.SkipForNowButton2(); // noyification
        Thread.sleep(Duration.ofSeconds(3));
        signUpPage.SellectEnglishLanguage();
        Thread.sleep(Duration.ofSeconds(3));
        signUpPage.Sellect_you_want_to_see_on_X();// edit
        Thread.sleep(Duration.ofSeconds(3));
        signUpPage.SkipForNowButton();
        Thread.sleep(Duration.ofSeconds(3));
        signUpPage.SellectToFollow_1Account();//EDIT
        Thread.sleep(Duration.ofSeconds(5));

    }

}
