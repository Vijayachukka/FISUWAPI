package MottamcPages;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class LoginPage
{
    public static WebDriver driver;
    public static Scenario scenario;
    static final String  mottoUrl="https://www.ebay.com/";
    static final Logger log = LoggerFactory.getLogger(LoginPage.class);

    public void OpenBrowser()
    {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-setuid-sandbox");
        options.addArguments("--disable-gpu");
        options.addArguments("--lang=az-AZ");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-popup-blocking");
       // options.addArguments("--headless=new");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("disable-extensions");
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().clearDriverCache().setup();
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }
    public Scenario getScenario()
    {
        return scenario;
    }
    public void launchMottoWebsite()
    {
        OpenBrowser();
        driver.get(mottoUrl);
        WebElement homepage = driver.findElement(By.xpath("//div[@class='logo-div']"));
        waitTime().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='logo-div']")));

    }
    public void clickHomePage()
    {
        WebElement homepage = driver.findElement(By.xpath("//div[@class='logo-div']"));
        waitTime().until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='logo-div']")));
        homepage.click();
    }
    public void selectdpdn()
    {
        Select obj=new Select(driver.findElement(By.xpath("")));
        obj.selectByIndex(1);
    }
    public void verifyTitleOfHomePage()
    {
        Assert.assertEquals("Title of the home page is: ","Global engineering, management and development consultants - Mott MacDonald",driver.getTitle());
        writeScenarioEvidence("Title of Home Page is :"+driver.getTitle());

    }
    public  void writeScenarioEvidence(String message)
    {
        try
        {
            getScenario().log(message);
        }
        catch (NullPointerException e)
        {
            log.info(message);
        }
    }
    public WebDriverWait waitTime()
    {
        Duration timeout= Duration.ofSeconds(100);
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        return wait;
    }
    public void selectLanguage()
    {
        WebElement language = driver.findElement(By.xpath("//a[text()='Global (English)']"));
        try
        {
            waitTime().until( ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Global (English)']")) );
            language.click();
        }
        catch(Exception e)
        {
            System.out.println("Default language is already selected");
        }

    }
    public void closeBrowser()
    {
        driver.quit();
    }

    public void selectquery()
    {
        String txt="Select top 1 max(salary) from employee where salary not in (Select max(salary) from employee)";
        Select selectdpdn=new Select(driver.findElement(By.xpath("fgfg")));
        selectdpdn.getAllSelectedOptions();
        driver.getWindowHandle();
        driver.switchTo().window(String.valueOf(1));
    }
}
