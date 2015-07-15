package qa;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
public class TestGame extends BaseTest{
    @Test
    public void clickGreenCircles(){


        JavascriptExecutor js = (JavascriptExecutor)driver;
        List<WebElement> circles = null;
        List<WebElement> timers   = null;
        WebElement attempts      = null;
        try{
            driver.get("http://localhost/index.php");
            circles=getElementsByCss(".circle");
            timers = getElementsByCss(".time_bar");
            attempts=getElementByCss("#current_number_of_trys_left");
            while(Integer.parseInt(attempts.getText())>0){
                for(int i=0;i<16;i++){
                    if(circles.get(i).getCssValue("background-color").equals("rgba(0, 128, 0, 1)"))
                        circles.get(i).click();
                    else {

                        if( Float.parseFloat(timers.get(i).getAttribute("value")) > 0 || Float.parseFloat(timers.get(i).getAttribute("value")) < 0 )
                        js.executeScript("Game.Driver.pauseGame()");
                    }
          
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
