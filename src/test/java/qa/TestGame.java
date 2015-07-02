package qa;

/**
 * Created by ben on 5/26/2015.
 */
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestGame extends BaseTest{

    @Test
    public void testGame(){

        int number_of_trys                = -1;
        List<WebElement> circles          = null;
        WebElement current_number_of_trys = null;
        try {
            driver.get("http://localhost/index.php");
            current_number_of_trys = getElementByCss("#current_number_of_trys_left");
            circles = new ArrayList<WebElement>();
            number_of_trys = Integer.parseInt(current_number_of_trys.getText());


            circles = getElementsByCss(".circle");
            while(Integer.parseInt(current_number_of_trys.getText()) > 0) {
                for (int i = 0; i < circles.size(); i++) {
                    if (circles.get(i).getCssValue("background-color").equals("rgba(0,255,0,1)")) {
                        circles.get(i).click();
                    }

                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }


    }
}
