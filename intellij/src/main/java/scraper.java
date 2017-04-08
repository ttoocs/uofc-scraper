import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.List;
//import org.

//import io.github.bonigarcia.wdm


//import java.util.concurrent.TimeUnit;

/**
 * Created by fu-fu on 3/10/17.
 */

public class scraper {


    static WebDriver driver = null;

    public static void get_access(){

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

    public static void setup_driver(){
        //ChromeDriverManager.getInstance().setup();
        //InternetExplorerDriverManager.getInstance().setup();
        //OperaDriverManager.getInstance().setup();
        //EdgeDriverManager.getInstance().setup();
        //PhantomJsDriverManager.getInstance().setup();
        FirefoxDriverManager.getInstance().setup();

        driver = new FirefoxDriver();
    }

    public static void main(String[] argv){


        setup_driver();

        //GET SEMESTERS! YAY!
        HashMap<Integer,String> Semesters = GetSemesters();
        HashMap<Integer,semesterData> sdata = new HashMap<Integer,semesterData>();

        for(Integer semester : Semesters.keySet()){
            semesterData data = new semesterData(semester);
        }



       // try_scrape(); //The SeleniumIDE generated one.
        driver.close();
    }

    public static HashMap<Integer,String> GetSemesters(){
        get_access();
        List<WebElement> elems;
        WebElement elem;

        elem = driver.findElement(By.id("CLASS_SRCH_WRK2_STRM$35$"));

        elems = elem.findElements(By.tagName("option"));

        //System.out.println(elem.get);     //FYI: These are useless outputs.
        //System.out.println(elem.toString());
        //System.out.println(elems.toString());

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

}
