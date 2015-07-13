package qa;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
public class TestGame extends BaseTest{
    @Test
    public void testGame(){
        List<WebElement> circles=null;
        WebElement attempts=null;
        try{
            driver.get("http://localhost/index.php");
            circles=getElementsByCss(".circle");
            attempts=getElementByCss("#current_number_of_trys_left");
            while(Integer.parseInt(attempts.getText())>0){
                for(int i=0;i<16;i++){
                    if(circles.get(i).getCssValue("background-color").equals("rgba(0, 128, 0, 1)"))
                        circles.get(i).click();
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
