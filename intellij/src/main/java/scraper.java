import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.PhantomJsDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.List;
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
        if(!run_setup)
            //PhantomJsDriverManager.getInstance().setup();
            FirefoxDriverManager.getInstance().setup();

        driver = new FirefoxDriver();
        return driver;
    }

    static HashMap<Integer,String> Semesters;

    public static void main(String[] argv){


        driver = setup_driver();

        //GET SEMESTERS! YAY!
        Semesters = GetSemesters();

        //Get ready for data!
        HashMap<Integer,semesterData> sdata = new HashMap<Integer,semesterData>();

        //Get da https://en.wikipedia.org/wiki/File:DataTNG.jpg
        for(Integer semester : Semesters.keySet()){
            semesterData data = new semesterData(semester);
            //data.ParseSubjects(driver);
            sdata.put(semester,data);
        }

        sdata.get(2161).ParseSubjects(driver);

        //SearchFor(driver,sdata.get(2161),"CPSC",42);

        sdata.get(2161).getDataIterative(driver);

        //try {
        //    Thread.sleep(100000);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}

        driver.close();
        driver.quit();

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
        new Select(drv.findElement(By.id(course_number_selector_id))).selectByValue("E");

        //Put in contains
        WebElement cont =drv.findElement(By.id(contains_number_box_id));
        cont.sendKeys(String.valueOf(contains));

        drv.findElement(By.id(search_button_id)).click();

        wait(drv);

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
            try {
                if (!drv.findElement(By.id(wait_id)).isDisplayed())
                    break;
            }catch(Exception e){
                //If it fails, the element doesn't exist! (The true java way, try something and see if it broke).
            }



            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
