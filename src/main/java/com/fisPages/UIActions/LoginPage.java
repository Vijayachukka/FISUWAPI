package com.fisPages.UIActions;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import java.util.ArrayList;

public class LoginPage {
    public static WebDriver driver;
    public static Scenario scenario;
    static final String mottoUrl = "https://www.ebay.com/";
    static final Logger log = LoggerFactory.getLogger(LoginPage.class);

    public void OpenBrowser() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        ChromeOptions options = new ChromeOptions();
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
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public Scenario getScenario() {
        return scenario;
    }

    public void launchMottoWebsite() {
        OpenBrowser();
        driver.get(mottoUrl);
//        WebElement homepage = driver.findElement(By.xpath("//div[@class='logo-div']"));
//        waitTime().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='logo-div']")));

    }

    public void clickHomePage() {
        WebElement homepage = driver.findElement(By.xpath("//div[@class='logo-div']"));
        waitTime().until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='logo-div']")));
        homepage.click();
    }

    public void selectdpdn() {
        Select obj = new Select(driver.findElement(By.xpath("")));
        obj.selectByIndex(1);
    }

    public void verifyTitleOfHomePage() {
        Assert.assertEquals("Title of the home page is: ", "Electronics, Cars, Fashion, Collectibles & More | eBay", driver.getTitle());
        writeScenarioEvidence("Title of Home Page is :" + driver.getTitle());

    }

    public void writeScenarioEvidence(String message) {
        try {
            getScenario().log(message);
        } catch (NullPointerException e) {
            log.info(message);
        }
    }

    public WebDriverWait waitTime() {
        Duration timeout = Duration.ofSeconds(100);
        long time= Long.parseLong("30");
        WebDriverWait wait = new WebDriverWait(driver, time);
        return wait;
    }

    public void selectLanguage() {
        WebElement language = driver.findElement(By.xpath("//a[text()='Global (English)']"));
        try {
            waitTime().until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Global (English)']")));
            language.click();
        } catch (Exception e) {
            System.out.println("Default language is already selected");
        }

    }

    public void closeBrowser() {
        driver.quit();
    }

    public void inputSearchTextbox(String text) {
        waitTime().until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@role='combobox']"))));
        driver.findElement(By.xpath("//input[@role='combobox']")).click();
        driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys(text, Keys.ENTER);
    }

    public void selectProduct(String productNum) {
        waitTime().until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[contains(@class,'srp-results srp-list')]//a/div[@class='s-item__title'])[" + productNum + "]")));
        driver.findElement(By.xpath("(//ul[contains(@class,'srp-results srp-list')]//a/div[@class='s-item__title'])[" + productNum + "]")).click();
    }

    public void clickButton(String buttonName) {
        waitTime().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a//span[text()='" + buttonName + "']")));
        driver.findElement(By.xpath("//a//span[text()='" + buttonName + "']")).click();
    }

    public void verifyShoppingCart() {
        waitTime().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@aria-label='Account']//a[contains(@aria-label,'Your shopping cart')]")));
        String pro = driver.findElement(By.xpath("//div[@aria-label='Account']//a[contains(@aria-label,'Your shopping cart')]")).getAttribute("aria-label");
        String noOfProducts = pro.split("contains")[1].split(" ")[1].replaceAll(" ","");
        Assert.assertEquals("1", noOfProducts);
        writeScenarioEvidence("Expected no.of products displayed is:1");
        writeScenarioEvidence("Actual no.of products displayed is:"+noOfProducts);
    }
    public void switchToTab()
    {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }
}
