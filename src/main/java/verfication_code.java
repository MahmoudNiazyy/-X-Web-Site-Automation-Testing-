import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.List;

public class verfication_code {
WebDriver driver1;
private WebDriverWait wait;

private By Refresh = By.xpath("//label[@class=\"text-blue\"]");
private By Code = By.xpath("//*[@id=\"email_message_list\"]/div/table/tbody/tr[2]/td[1]/a");
private By Name = By.className("mail_in");

private By  ClickButton = By.className("mail_butt");

private By EmailAddress = By.xpath("//div[@id = \"email-address\"]");


public String Create_FackAccount(String FNAME){
    driver1.findElement(Name).sendKeys(FNAME);
    driver1.findElement(ClickButton).click();
    String x=  driver1.findElement(EmailAddress).getText();



    return x;

}
  public verfication_code(WebDriver driver)
  {
      this.driver1= driver;
      this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

  }

    public  String getFirstSixCharacters(String input) {
        // Check if the input string is shorter than 6 characters
        if (input.length() < 6) {
            return input; // Return the entire string if it's shorter than 6 characters
        }
        // Extract and return the first 6 characters
        return input.substring(0, 6);
    }


  public String verficationCode()
  {


      String x = driver1.findElement(Code).getText();
      String numberString = getFirstSixCharacters(x);



     return numberString;
  }

}
