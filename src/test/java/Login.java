import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    @Test
    public  void LaunchBrowser (){
        WebDriver driver;
        String baseUrl = "https:///kasirdemo.belajarqa.com/";

        WebDriverManager.chromedriver().setup();

        //apply chrome driver setup
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        String url = driver.getCurrentUrl();
        System.out.println(url);

        WebElement logininput = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement passwordinput = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement loginbutton = driver.findElement(By.xpath("//button[normalize-space()='login']"));

        logininput.sendKeys("dixdam16@gmail.com");
        passwordinput.sendKeys("rahasia123");
        loginbutton.click();

        //driver.close();
    }
}
