package kasiraja.login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginScenarios {
    @Test
    public void SelVentureLogin(){
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Duration timeout = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        driver.manage().window().maximize();

        String baseUrl = "https://kasirdemo.belajarqa.com/";
        driver.get(baseUrl);
        String Url = driver.getCurrentUrl();
        System.out.println(Url);
        Assert.assertEquals("https://kasirdemo.belajarqa.com/login",Url);

        WebElement logininput = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement passwordinput = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement loginbutton = driver.findElement(By.xpath("//button[normalize-space()='login']"));

        logininput.sendKeys("admin@sel.com");
        passwordinput.sendKeys("test321");
        loginbutton.click();

        WebElement userfullname = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//dt[normalize-space()='Sel Ventures']")));
        String loginname = userfullname.getText();
        System.out.println(loginname);
        Assert.assertEquals("Sel Ventures",loginname);

        driver.quit();
    }

    @Test
    public void SelVentureWrongPassword(){
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Duration timeout = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        driver.manage().window().maximize();

        String baseUrl = "https://kasirdemo.belajarqa.com/";
        driver.get(baseUrl);
        String Url = driver.getCurrentUrl();
        System.out.println(Url);
        Assert.assertEquals("https://kasirdemo.belajarqa.com/login",Url);

        WebElement logininput = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement passwordinput = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement loginbutton = driver.findElement(By.xpath("//button[normalize-space()='login']"));

        logininput.sendKeys("admin@sel.com");
        passwordinput.sendKeys("321");
        loginbutton.click();

        WebElement AlertKredensial = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='alert']")));
        String AlertText = AlertKredensial.getText();
        Assert.assertEquals("Kredensial yang Anda berikan salah", AlertText);

        driver.quit();
    }
}
