import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
////input[@name = "verfication_code"]
public class SignUpPage {

    private WebDriver driver;
    private WebDriverWait wait;

// Locator
private By CreatAccountButton = By.xpath("//button[contains(@class , \"css-175oi2r r-sdzlij r-1phboty r-rs99b7 r-lrvibr r-ywje51 r-184id4b r-13qz1uu r-2yi16 r-1qi8awa r-3pj75a r-1loqt21 r-o7ynqc r-6416eg r-1ny4l3l\")]");
private By FullNameFiled = By.xpath("//input[@name = \"name\"]");

private By EmailFiled = By.xpath("//input[@name = \"email\"]");

//private By Month = By.xpath("//select[@id= \"SELECTOR_1\"]/option[@value=\"%d\"]");
private By Month = By.xpath("//select[@id= \"SELECTOR_1\"]");
private By Day = By.xpath("//select[@id= \"SELECTOR_2\"]");
private By Year = By.xpath("//select[@id= \"SELECTOR_3\"]");



private By NextButton= By.xpath("//button[@class =\"css-175oi2r r-sdzlij r-1phboty r-rs99b7 r-lrvibr r-19yznuf r-64el8z r-1fkl15p r-1loqt21 r-o7ynqc r-6416eg r-1ny4l3l\"]");
private By verfication_codeField = By.xpath("//input[@name=\"verfication_code\"]");

private By PasswordField = By.xpath("//input[@type=\"password\"]");

private By SkipButton = By.xpath("//span[@class=\"css-1jxf684 r-dnmrzs r-1udh08x r-1udbk01 r-3s2u2q r-bcqeeo r-1ttztb7 r-qvutc0 r-poiln3 r-1inkyih r-rjixqe\"]");

private By SkipButton2 = By.xpath("//button[@class=\"css-175oi2r r-sdzlij r-1phboty r-rs99b7 r-lrvibr r-1wzrnnt r-19yznuf r-64el8z r-1fkl15p r-1loqt21 r-o7ynqc r-6416eg r-1ny4l3l\"]");

private By SkipButton3 = By.xpath("//button[@class=\"css-175oi2r r-sdzlij r-1phboty r-rs99b7 r-lrvibr r-19yznuf r-64el8z r-1fkl15p r-1loqt21 r-o7ynqc r-6416eg r-1ny4l3l\"]");

private By EnglishLanguageCHECKBOX = By.xpath("//input[@aria-describedby=\"CHECKBOX_2_LABEL\"]");

private By MusicButton = By.xpath("//div[contains(@aria-label , \"Music\")]");
private By SportsButton = By.xpath("//div[contains(@aria-label , \"Sports \")]");
private By FashionButton = By.xpath("//div[contains(@aria-label , \"Fashion \")]");

private By Follow_1Account = By.xpath("//*[@id=\"layers\"]/div[2]/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div/section/div/div/div[3]/div/div/button");

public SignUpPage(WebDriver driver)
{

    this.driver= driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
}

public void CreatAcount()
{
    wait.until(ExpectedConditions.visibilityOfElementLocated(CreatAccountButton));
    driver.findElement(CreatAccountButton).click();

}

public void AddName(String Name)
{

    wait.until(ExpectedConditions.visibilityOfElementLocated(FullNameFiled));
    driver.findElement(FullNameFiled).sendKeys(Name);
}

public void AddEmail(String Email)
{
    driver.findElement(EmailFiled).sendKeys(Email);
}

public void Date_of_birth(int DayOp , int MonthOp , int YearOp)
{
 // Month
    if(MonthOp >=1 && MonthOp <=12){
    Select DropMonth = new Select(driver.findElement(Month));
    DropMonth.selectByIndex(MonthOp);}

    // Day
    if(DayOp >=1 && DayOp <=31)
    {
        Select DropDay = new Select(driver.findElement(Day));
        DropDay.selectByIndex(DayOp);
    }

    if (YearOp>=1905 && YearOp <= 2025)
    {
        Select DropYear = new Select(driver.findElement(Year));
        DropYear.selectByValue(Integer.toString(YearOp));
    }
}

public void Add_Data_Page1(String NAME , String EMAIL , int DAY , int MONTH , int YEAR)
{
    CreatAcount();

    AddName(NAME);

    AddEmail(EMAIL);

    Date_of_birth(DAY,MONTH,YEAR);

    ClickNextButton();



}

public void ClickNextButton()
{
    wait.until(ExpectedConditions.elementToBeClickable(NextButton));
    driver.findElement(NextButton).click();

}

public void Addverfication_codeTo_X_Page(String Number)
{

    driver.findElement(verfication_codeField).sendKeys(Number);

}
public void ClickNextButtonIn_verficationPage()
{
    WebElement Button = wait.until(ExpectedConditions.elementToBeClickable(NextButton));
    Button.click();
}

public void AddNewPassword(String Pass)
{

    driver.findElement(PasswordField).sendKeys(Pass);

    WebElement Button = wait.until(ExpectedConditions.elementToBeClickable(NextButton));
    Button.click();
}

public void SkipForNowButton()
{
    WebElement Button = wait.until(ExpectedConditions.elementToBeClickable(SkipButton));
    Button.click();
}

public void SkipForNowButton2()
{
    WebElement Button = wait.until(ExpectedConditions.elementToBeClickable(SkipButton2));
    Button.click();
}

public void SellectEnglishLanguage()
{
    driver.findElement(EnglishLanguageCHECKBOX).click();
    WebElement Button = wait.until(ExpectedConditions.elementToBeClickable(NextButton));
    Button.click();

}

public void Sellect_you_want_to_see_on_X()
{
    driver.findElement(MusicButton).click();
    driver.findElement(SportsButton).click();
    driver.findElement(FashionButton).click();
    WebElement Button = wait.until(ExpectedConditions.elementToBeClickable(NextButton));
    Button.click();

}

public void SellectToFollow_1Account()
{
    driver.findElement(Follow_1Account).click();
    WebElement Button = wait.until(ExpectedConditions.elementToBeClickable(SkipButton3));
    Button.click();

}

}
