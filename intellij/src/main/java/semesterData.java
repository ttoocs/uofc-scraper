import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.List;

/**
 * Created by scott.saunders on 4/8/17.
 */
public class semesterData {
    int semester_id;
    HashMap<String,String> subjects;

    public static void selectSemester(int semester_id){
        //Get accesses
        WebDriver drv = scraper.driver;
        scraper.get_access(drv);

        new Select(drv.findElement(By.id(scraper.Term_Selection_id))).selectByValue(String.valueOf(semester_id));


    }

    public void selectSemester(){
        selectSemester(semester_id);
    }

    public semesterData(int semester_id){
        this.semester_id = semester_id;
    }


    public void ParseSubjects(){
        WebDriver drv = scraper.driver;
        selectSemester(semester_id);
        //


        try {
            Thread.sleep(1000);     ///For some reason the page refreshes or something!?
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> elems = scraper.getOptions(drv, scraper.Subject_Selection_id );


        for (WebElement e : elems){

            //By default the webpage has a empty option first.
            if(e.getAttribute("value") == null || e.getAttribute("value").equals(""))
                continue;
            //Print out the found value and the string:
            System.out.println(e.getAttribute("value") +" : "+ e.getText());

            //int val = Integer.parseInt(e.getAttribute("value"));
            //String txt = e.getText().split("-")[1].trim();

            //Print what we just stored.
            //System.out.println(val +" : "+ txt);

        }



    }


    public void getData(){

    }
}
