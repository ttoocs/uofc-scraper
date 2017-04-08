import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;

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
        selectSemester(this.semester_id);
    }


    public void ParseSubjects(){
        selectSemester(semester_id);
        //
        ///scraper.Subject_Selection_id;
    }


    public void getData(){

    }
}
