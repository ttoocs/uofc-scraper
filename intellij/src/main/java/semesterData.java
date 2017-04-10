import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.List;

/**
 * Created by scott.saunders on 4/8/17.
 */
public class semesterData {
    int semester_id;
    HashMap<String,String> subjects = new HashMap<String,String>();

    public static void selectSemester(WebDriver drv, int semester_id){
        //Get accesses
        //scraper.get_access(drv);
        //Select the class.
        new Select(drv.findElement(By.id(scraper.Term_Selection_id))).selectByValue(String.valueOf(semester_id));

        scraper.wait(drv);

    }

    public semesterData(int semester_id){
        this.semester_id = semester_id;

    }


    public void ParseSubjects(WebDriver drv){
        //WebDriver drv = scraper.driver;
        selectSemester(drv, semester_id);
        //

        List<WebElement> elems = scraper.getOptions(drv, scraper.Subject_Selection_id );

        if(subjects != null)
            subjects.clear();   //PURGE THE OLD DATA!

        for (WebElement e : elems){
            //By default the webpage has a empty option first.
            if(e.getAttribute("value") == null || e.getAttribute("value").equals(""))
                continue;
            //Print out the found value and the string:
            //System.out.println(e.getAttribute("value") +" : "+ e.getText());

            String abbr = e.getAttribute("value");
            String full = e.getText().split("-")[1].trim();

            subjects.put(abbr,full);

            //Print what we just stored.
            //System.out.println(val +" : "+ txt);
        }



    }

    public void getDataIterative(WebDriver drv){
        getDataIterative(drv,this);
    }

    public static void getDataIterative(WebDriver drv, semesterData semester){

        for(String subject : semester.subjects.keySet()){
            for(int i=1; i<1000; i++){
                scraper.SearchFor(drv,semester,subject,i);


                String err = drv.findElement(By.id(scraper.search_msg_id)).getText();

                if(err.toLowerCase().contains("no results"))
                    continue;

                //TODO: Parse the data.
                System.exit(0);

            }
        }
    }
}
