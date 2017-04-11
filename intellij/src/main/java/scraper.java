import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.PhantomJsDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.sql.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
//import org.

//import io.github.bonigarcia.wdm


//import java.util.concurrent.TimeUnit;

/**
 * Created/home/fu-fu by fu-fu on 3/10/17.
 */

public class scraper {


    static WebDriver driver = null;

    //Static ID's
    static String wait_id = "WAIT_win0";

    //Search ID's
    static String Term_Selection_id="CLASS_SRCH_WRK2_STRM$35$";
    static String Subject_Selection_id="SSR_CLSRCH_WRK_SUBJECT_SRCH$0";

    static String course_number_selector_id="SSR_CLSRCH_WRK_SSR_EXACT_MATCH1$1";
    static String show_open_classes_only_id="SSR_CLSRCH_WRK_SSR_OPEN_ONLY$3";
    static String contains_number_box_id="SSR_CLSRCH_WRK_CATALOG_NBR$1";
    static String search_button_id="CLASS_SRCH_WRK2_SSR_PB_CLASS_SRCH";
    static String search_msg_id="DERIVED_CLSMSG_ERROR_TEXT";

    static int delay= 1000; //100 too small


    public static void get_access(WebDriver driver){

        //Uses the public link
        driver.get("https://csprd.ucalgary.ca/psauthent/class-search/public");

        //Gets the internal iframe.
        driver.get(driver.findElement(By.id("ptifrmtgtframe")).getAttribute("src"));


    }

    public static void try_scrape() {
        String baseUrl = "https://csprd.ucalgary.ca/";
        //This was the one generated from SeleniumIDE.
        driver.get(baseUrl + "/psp/csprd/EMPLOYEE/CAMPUS/c/COMMUNITY_ACCESS.CLASS_SEARCH.GBL?AUTH=Vm02V2M0RTAxTm1aRG5jelg0Y3NNZz09");
        try {            Thread.sleep(1000);        } catch (InterruptedException e) {}
        new Select(driver.findElement(By.id("CLASS_SRCH_WRK2_STRM$35$"))).selectByVisibleText("2177 - Fall 2017");
        try {            Thread.sleep(1000);        } catch (InterruptedException e) {}
        driver.findElement(By.id("SSR_CLSRCH_WRK_SUBJECT_SRCH$0")).click();
        try {            Thread.sleep(1000);        } catch (InterruptedException e) {}
        new Select(driver.findElement(By.id("SSR_CLSRCH_WRK_SUBJECT_SRCH$0"))).selectByVisibleText("ACCT-Accounting");
        try {            Thread.sleep(1000);        } catch (InterruptedException e) {}
        driver.findElement(By.cssSelector("option[value=\"ACCT\"]")).click();
        try {            Thread.sleep(1000);        } catch (InterruptedException e) {}
        driver.findElement(By.id("SSR_CLSRCH_WRK_SSR_EXACT_MATCH1$1")).click();
        try {            Thread.sleep(1000);        } catch (InterruptedException e) {}
        new Select(driver.findElement(By.id("SSR_CLSRCH_WRK_SSR_EXACT_MATCH1$1"))).selectByVisibleText("greater than or equal to");
        try {            Thread.sleep(1000);        } catch (InterruptedException e) {}
        driver.findElement(By.cssSelector("option[value=\"G\"]")).click();
        try {            Thread.sleep(1000);        } catch (InterruptedException e) {}
        driver.findElement(By.id("SSR_CLSRCH_WRK_CATALOG_NBR$1")).click();
        try {            Thread.sleep(1000);        } catch (InterruptedException e) {}
        driver.findElement(By.id("SSR_CLSRCH_WRK_CATALOG_NBR$1")).clear();
        try {            Thread.sleep(1000);        } catch (InterruptedException e) {}
        driver.findElement(By.id("SSR_CLSRCH_WRK_CATALOG_NBR$1")).sendKeys("0");
        try {            Thread.sleep(1000);        } catch (InterruptedException e) {}
        driver.findElement(By.id("SSR_CLSRCH_WRK_ACAD_CAREER$2")).click();
        try {            Thread.sleep(1000);        } catch (InterruptedException e) {}
        new Select(driver.findElement(By.id("SSR_CLSRCH_WRK_ACAD_CAREER$2"))).selectByVisibleText("Undergraduate Programs");
        try {            Thread.sleep(1000);        } catch (InterruptedException e) {}
        driver.findElement(By.cssSelector("option[value=\"UGRD\"]")).click();
        try {            Thread.sleep(1000);        } catch (InterruptedException e) {}
        driver.findElement(By.id("SSR_CLSRCH_WRK_SSR_OPEN_ONLY$3")).click();
        try {            Thread.sleep(1000);        } catch (InterruptedException e) {}
        driver.findElement(By.id("SSR_CLSRCH_WRK_OEE_IND$4")).click();
        try {            Thread.sleep(1000);        } catch (InterruptedException e) {}
        driver.findElement(By.name("DERIVED_CLSRCH_SSR_EXPAND_COLLAPS$149$$IMG$1")).click();
        try {            Thread.sleep(1000);        } catch (InterruptedException e) {}
        driver.findElement(By.id("SSR_CLSRCH_WRK_SSR_START_TIME_OPR$5")).click();
        try {            Thread.sleep(1000);        } catch (InterruptedException e) {}
        driver.findElement(By.id("SSR_CLSRCH_WRK_SSR_START_TIME_OPR$5")).click();
        try {            Thread.sleep(1000);        } catch (InterruptedException e) {}
        driver.findElement(By.id("CLASS_SRCH_WRK2_SSR_PB_CLASS_SRCH")).click();
        try {            Thread.sleep(1000);        } catch (InterruptedException e) {}
        driver.findElement(By.id("SSR_CLSRCH_WRK_OEE_IND_LBL$4")).click();
        try {            Thread.sleep(1000);        } catch (InterruptedException e) {}
        driver.findElement(By.id("SSR_CLSRCH_WRK_OEE_IND$4")).click();
        try {            Thread.sleep(1000);        } catch (InterruptedException e) {}
        driver.findElement(By.id("SSR_CLSRCH_WRK_OEE_IND$4")).click();
        try {            Thread.sleep(1000);        } catch (InterruptedException e) {}
        driver.findElement(By.name("DERIVED_CLSRCH_SSR_EXPAND_COLLAPS$149$$IMG$1")).click();
        driver.findElement(By.id("SSR_CLSRCH_WRK_OEE_IND$4")).click();
        driver.findElement(By.id("CLASS_SRCH_WRK2_SSR_PB_CLASS_SRCH")).click();
        driver.findElement(By.id("#ICSave")).click();
        driver.findElement(By.id("MTG_CLASS_NBR$0")).click();
        driver.findElement(By.id("MTG_CLASS_NBR$0")).click();
    }

    static boolean run_setup = false;
    public static WebDriver setup_driver(){
        //ChromeDriverManager.getInstance().setup();
        //InternetExplorerDriverManager.getInstance().setup();
        //OperaDriverManager.getInstance().setup();
        //EdgeDriverManager.getInstance().setup();
        //PhantomJsDriverManager.getInstance().setup();
        if(!run_setup) {
            //PhantomJsDriverManager.getInstance().setup();
            ChromeDriverManager.getInstance().setup();
            //FirefoxDriverManager.getInstance().setup();
            run_setup = true;
        }

       // driver = new FirefoxDriver();
        //driver = new PhantomJSDriver();
        driver = new ChromeDriver();
        return driver;
    }

    static HashMap<Integer,String> Semesters;

    public static void main(String[] argv){

        boolean SQLFUN = false;
        if(SQLFUN) {
            setup_sql();

            //semesterData testdata = semesterData.loadSemester(2161);
            //System.out.println(q.toString());
            semesterData testdata = new semesterData(1337);//semesterData.loadSemester(1337);
            //int id, String type, int subjectnum, String time, String location, int semesterID, String TAName, String InstructorName, String prefixNum, String deptName,String status){

            testdata.sections.put(42, new sectionData(42, "tut", 01, "lATER", "Somewhere-else", 1337, "some bloke", "some better bloke.", "123", "AWE", "NOT OPEN FOR ANYONE"));

            if (testdata != null) {

                System.out.println(testdata.toString());

                put_semester(testdata);

                System.exit(0);
            }
        }

        driver = setup_driver();

        //GET SEMESTERS! YAY!
        Semesters = GetSemesters();

        //Get ready for data!
        HashMap<Integer,semesterData> sdata = new HashMap<Integer,semesterData>();

        //Get da https://en.wikipedia.org/wiki/File:DataTNG.jpg
        for(Integer semester : Semesters.keySet()){
            semesterData s = new semesterData(semester);
            semesterData r = semesterData.loadSemester(semester);

            if(r != null && r.complete){    //Try to load if available.
                s=r;
            }else {
                s.run(driver);
            }
            sdata.put(semester,s);
        }

        try {
            driver.close();
            driver.quit();
        }catch(Exception e42){
            //It's shutting down, w.e
        }
        System.out.println("Goodbye.");

    }


    public static List<WebElement> getOptions(WebDriver drv, String id){
        WebElement elem = drv.findElement(By.id(id));
        return elem.findElements(By.tagName("option"));
    }

    public static HashMap<Integer,String> GetSemesters(){
        get_access(driver);

        List<WebElement> elems = getOptions(driver,Term_Selection_id);

        HashMap<Integer,String> ret = new HashMap<Integer,String>();

        for (WebElement e : elems){

                //By default the webpage has a empty option first.
            if(e.getAttribute("value") == null || e.getAttribute("value").equals(""))
                continue;
            //Print out the found value and the string:
            //System.out.println(e.getAttribute("value") +" : "+ e.getText());

            int val = Integer.parseInt(e.getAttribute("value"));
            String txt = e.getText().split("-")[1].trim();

            ret.put(val,txt);

            //Print what we just stored.
            //System.out.println(val +" : "+ txt);

        }
        return ret;

    }


    public static void SearchFor(WebDriver drv, semesterData semester, String subject, int contains){
        SearchFor(drv,semester,subject,contains,"E");
    }
    //Types:
    //E - Exactly
    //C - Contains
    //G - Greater than or equal to
    //T - Less than or equal to
    public static void SearchFor(WebDriver drv, semesterData semester, String subject, int contains, String type){

        subject = subject.toUpperCase();

        //Checks the subject string
        boolean found = false;
        for(String str : semester.subjects.keySet()) {
            if(str.equals(subject)){
                found=true;
                break;
            }
        }

        if(!found){
            System.out.println("Invalid subject string: "+subject+" for semester: " +semester.semester_id);
            System.exit(42);
        }


        get_access(drv);
        semesterData.selectSemester(drv,semester.semester_id);

        //Click the Open_Only (To show all classes)
        drv.findElement(By.id(show_open_classes_only_id)).click();

        //Select Subject
        Select select = new Select(drv.findElement(By.id(Subject_Selection_id)));
        select.selectByValue(subject);

        //Select "Is exactly."
        new Select(drv.findElement(By.id(course_number_selector_id))).selectByValue(type);

        //Put in contains
        WebElement cont =drv.findElement(By.id(contains_number_box_id));
        cont.sendKeys(String.valueOf(contains));

        drv.findElement(By.id(search_button_id)).click();

        wait(drv);

    }

    public static void hitOK(WebDriver drv){
        try{
            drv.findElement(By.id("#ICSave")).click();
        }catch(Exception idc){
            //NOTHING
        }
    }

    public static void wait(WebDriver drv){

        //Old:
        /*
        try {
            Thread.sleep(scraper.delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }   //*/

        //New-ver
        while(true) {

            hitOK(drv); //OKAY IS OKAY HIT OKAY OKAY?

            try {
                if (!drv.findElement(By.id(wait_id)).isDisplayed())
                    break;
            }catch(Exception e){
                //Well it's obviously not displayed then.
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    //SQL BITS:

    static Connection sqlCon;
    static Statement sqlState;
    static ResultSet sqlResults;

    static String sqlUrl = "jdbc:postgresql://localhost/ddn_db";
    static String sqlUser = "postgres";
    static String sqlPassword = "carrots";
    static int sqlPort = 5432;

    public static void setup_sql(){
        try {
        sqlCon = DriverManager.getConnection(sqlUrl, sqlUser, sqlPassword);
        sqlState = sqlCon.createStatement();
        sqlResults = sqlState.executeQuery("SELECT VERSION()");

            if (sqlResults.next()) {
                System.out.println(sqlResults.getString(1));
            }
        }catch(Exception e10){
            e10.printStackTrace();
            System.out.println("SQL FAILED, ABORTING!");
            System.exit(1);
        }
    }
    public static void put_semester(semesterData semester){

        //Nuke the database!
        try {
            sqlState.execute(new Scanner(new File("database.sql")).useDelimiter("\\Z").next()); //Use the database.sql file to nuke it.
        }catch(Exception e11){
            e11.printStackTrace();
        }

        try {
            sqlResults = sqlState.executeQuery("Select id FROM course_section WHERE id = " + semester.semester_id);
            //Somehow check if it has the data and if not add it?

        }catch(Exception e11){
            e11.printStackTrace();
        }

        for(int sectID : semester.sections.keySet()) {
            sectionData sect = semester.sections.get(sectID);
            try {

                //Update Course-Sections
                //I THINK THE ORDER OF THIS IS WRONG.

                //("INSERT INTO course_section VALUES(%L,%s,%s,%s,%L,%s,NULL,%L,%L,%L) ON CONFLICT DO NOTHING",
                //   type, semester_id, section.$.name, time, section.room[0], sectionId++, section.instructor, courseNum, dept);
                PreparedStatement qs = sqlCon.prepareStatement("INSERT INTO course_section VALUES(?,?,?,?,?,?,?,?,?,?) ON CONFLICT DO NOTHING");
                qs.setString(1, sect.type.toUpperCase());
                qs.setString(2, String.valueOf(sect.semesterID));
                qs.setString(3, String.valueOf(sect.subjectnum));
                qs.setString(4, sect.time);
                qs.setString(5, sect.room);
                qs.setString(6, String.valueOf(sect.semesterID));
                qs.setString(7, sect.TAName );
                qs.setString(8, sect.InstructorName );
                qs.setString(9, sect.subjectnum );
                qs.setString(10,sect.deptName);

                //Update Semesters
                //INSERT INTO semester VALUES(%s,%L) ON CONFLICT DO NOTHING , semester.name, semester.desc);

                //Update Teaching Assistants... (sigh)


                //Update Instructors
                //"INSERT INTO instructor VALUES(%L) ON CONFLICT DO NOTHING", name

                //Update Course.
                //("INSERT INTO course VALUES(%L,%L,%L,%L) ON CONFLICT DO NOTHING", name, name, num, dept);

                //Update Departments.
                //INSERT INTO department VALUES(%L,%L) ON CONFLICT DO NOTHING,  dept, dept)
                //"INSERT INTO faculty_contains VALUES(%L,%L) ON CONFLICT DO NOTHING", faculty, dept);

                //Faculty
                //INSERT INTO faculty VALUES(%L) ON CONFLICT DO NOTHING, faculty

            } catch (Exception e12) {
                e12.printStackTrace();
            }
        }
    }

}
