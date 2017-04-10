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
    HashMap<Integer,sectionData> sections= new HashMap<Integer,sectionData>();
    HashMap<Integer,classData> classes= new HashMap<Integer,classData>();

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

                try {
                    String err = drv.findElement(By.id(scraper.search_msg_id)).getText();
                    if (err.toLowerCase().contains("no results"))
                        continue;
                }catch(NoSuchElementException e){
                    //Oh good, there was no error, this is something we actually want!
                    System.out.println("Found course: "+scraper.Semesters.get(semester.semester_id)+" "+subject+" "+i);
                }

                parseSearch(drv,semester,subject);
            }
        }
    }

    public static void parseSearch(WebDriver drv,semesterData semester, String subject){

        try {
            String err = drv.findElement(By.id(scraper.search_msg_id)).getText();
            if (err.toLowerCase().contains("no results"))
                return;
        }catch(NoSuchElementException e){
            //Oh good, there was no error, this is something we actually want!
            //System.out.println("Found course: "+scraper.Semesters.get(semester.semester_id)+" "+subject);
        }

        //TODO: Parse the data.

        //Big table ID: ACE_DERIVED_CLSRCH_GROUP6
        //Row1 of first element:    trSSR_CLSRCH_MTG1$0_row1
        //Row1 of second element:   trSSR_CLSRCH_MTG1$1_row1
        //Row2 of second element:   trSSR_CLSRCH_MTG1$2_row1

        //Seems like they iterate over the thing, only ever with row1.
        //So-far seems to do that.

        //Geting num-rows:
        //win0divSSR_CLSRSLT_WRK_GROUPBOX1 has a SSSGROUPBOX,
        //Porbably eaiser to get it via findByVisableText(class section(s) found);


        //Note: Some of these may not exists! Need to try-catch each attmept.
        //Note: The numbers following the $ are very based on the row being probed.


        //Class ID: MTG_CLASS_NBR$8
        //Javascript run when clicked: javascript:submitAction_win0(document.win0,'MTG_CLASS_NBR$8');
        //Class Num/Lab ID: MTG_CLASSNAME$29
        //Date/time: MTG_DAYTIME$29
        //Location: UCSS_E010_WRK_DESCR$1   (MainCampus)
        //Room: MTG_ROOM$0
        //Instructor: MTG_INSTR$0
        //Section Group: UCSS_E010_WRK_ASSOCIATED_CLASS$81 //This is the "Lec 01 needs lab1-3, etc.
        //Status:   win0divDERIVED_CLSRCH_SSR_STATUS_LONG$0     //This is a parent of a picture, the child's alt is the value.
        //Restrictions: UCSS_E010_WRK_HTMLAREA$1

        scraper.wait(drv);  //Wait for anything.

        WebElement e = drv.findElement(By.id("win0divSSR_CLSRSLT_WRK_GROUPBOX1")).findElement(By.className("SSSGROUPBOX"));
        int numrows = Integer.parseInt(e.getText().split(" ")[0]);
        System.out.println("Found "+ numrows+ " rows.");

        for(int i=0; i< numrows; i++){
            //TODO: Handle when any of these don't exists. (Lots of try catch?)
            int cid = Integer.parseInt(drv.findElement(By.id("MTG_CLASS_NBR$"+i)).getText());
            String type = drv.findElement(By.id("MTG_CLASSNAME$"+i)).getText(); //TODO: Parse this into Lab/Tut/Lec and the corrisponding number.
            String time = drv.findElement(By.id("MTG_DAYTIME$"+i)).getText();   //TODO: Parse this into Mon/Tue/Wen/Thur/Fri/Sat/Sun with startime and endtime.
            String location = drv.findElement(By.id("UCSS_E010_WRK_DESCR$"+i)).getText();
            String room = drv.findElement(By.id("MTG_ROOM$"+i)).getText();
            String instructor = drv.findElement(By.id("MTG_INSTR$"+i)).getText();
            int secgrp = Integer.parseInt(drv.findElement(By.id("UCSS_E010_WRK_ASSOCIATED_CLASS$"+i)).getText());
            String status = drv.findElement(By.id("win0divDERIVED_CLSRCH_SSR_STATUS_LONG$"+i)).findElement(By.tagName("img")).getAttribute("alt");
            try{String restrictions = drv.findElement(By.id("UCSS_E010_WRK_HTMLAREA$"+i)).getText();}catch(Exception e2){}

            String type_str = null;
            String nullstr = null;
            int type_num = 0;
            if(! semester.sections.containsKey(cid)) {
                sectionData tmp = new sectionData(cid, type_str, type_num, time, location, semester.semester_id, nullstr, instructor, -1, nullstr,status);
                semester.sections.put(cid,tmp);
                System.out.println(tmp);
            }


        }
    }

}
