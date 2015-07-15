package qa; /**
 * Created by ben on 5/26/2015.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.List;

public class BaseTest  {

    WebDriver driver = null;

    @Parameters({"browser"})
    @BeforeClass
    public void SetUp(String browser) throws Exception{

        System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\ChromeDriver\\chromedriver.exe");
        if(browser.equals("chrome"))
            this.driver = new ChromeDriver();
        else if(browser.equals("firefox"))
            this.driver = new FirefoxDriver();
        else if(browser.equals("ie"))
            this.driver = new InternetExplorerDriver();
        else
            throw new Exception("");

        this.driver.manage().window().maximize();
    }

    public WebElement getElementByCss(String css_selector){

        WebElement element = null;
        try {
            element = driver.findElement(By.cssSelector(css_selector));
            return element;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return element;
    }
    public List<WebElement> getElementsByCss(String css_selector){

        List<WebElement> elements = null;
        try {
            elements = driver.findElements(By.cssSelector(css_selector));

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return elements;
    }

    public void waitUntil(int seconds_to_wait){

        WebDriverWait wait = null;
        try{
            wait = new WebDriverWait(this.driver , seconds_to_wait);
            wait.wait();
        }catch(Exception ex){

        }
    }


}
