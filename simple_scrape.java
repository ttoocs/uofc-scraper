package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SimpleScrape {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://csprd.ucalgary.ca/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSimpleScrape() throws Exception {
    driver.get(baseUrl + "/psp/csprd/EMPLOYEE/CAMPUS/c/COMMUNITY_ACCESS.CLASS_SEARCH.GBL?AUTH=Vm02V2M0RTAxTm1aRG5jelg0Y3NNZz09");
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | TargetContent | ]]
    new Select(driver.findElement(By.id("CLASS_SRCH_WRK2_STRM$35$"))).selectByVisibleText("2177 - Fall 2017");
    driver.findElement(By.id("SSR_CLSRCH_WRK_SUBJECT_SRCH$0")).click();
    new Select(driver.findElement(By.id("SSR_CLSRCH_WRK_SUBJECT_SRCH$0"))).selectByVisibleText("ACCT-Accounting");
    driver.findElement(By.cssSelector("option[value=\"ACCT\"]")).click();
    driver.findElement(By.id("SSR_CLSRCH_WRK_SSR_EXACT_MATCH1$1")).click();
    new Select(driver.findElement(By.id("SSR_CLSRCH_WRK_SSR_EXACT_MATCH1$1"))).selectByVisibleText("greater than or equal to");
    driver.findElement(By.cssSelector("option[value=\"G\"]")).click();
    driver.findElement(By.id("SSR_CLSRCH_WRK_CATALOG_NBR$1")).click();
    driver.findElement(By.id("SSR_CLSRCH_WRK_CATALOG_NBR$1")).clear();
    driver.findElement(By.id("SSR_CLSRCH_WRK_CATALOG_NBR$1")).sendKeys("0");
    driver.findElement(By.id("SSR_CLSRCH_WRK_ACAD_CAREER$2")).click();
    new Select(driver.findElement(By.id("SSR_CLSRCH_WRK_ACAD_CAREER$2"))).selectByVisibleText("Undergraduate Programs");
    driver.findElement(By.cssSelector("option[value=\"UGRD\"]")).click();
    driver.findElement(By.id("SSR_CLSRCH_WRK_SSR_OPEN_ONLY$3")).click();
    driver.findElement(By.id("SSR_CLSRCH_WRK_OEE_IND$4")).click();
    Thread.slee(100); //IS TOO FAST.
    driver.findElement(By.name("DERIVED_CLSRCH_SSR_EXPAND_COLLAPS$149$$IMG$1")).click();
    driver.findElement(By.id("SSR_CLSRCH_WRK_SSR_START_TIME_OPR$5")).click();
    driver.findElement(By.id("SSR_CLSRCH_WRK_SSR_START_TIME_OPR$5")).click();
    driver.findElement(By.id("CLASS_SRCH_WRK2_SSR_PB_CLASS_SRCH")).click();
    driver.findElement(By.id("SSR_CLSRCH_WRK_OEE_IND_LBL$4")).click();
    driver.findElement(By.id("SSR_CLSRCH_WRK_OEE_IND$4")).click();
    driver.findElement(By.id("SSR_CLSRCH_WRK_OEE_IND$4")).click();
    driver.findElement(By.name("DERIVED_CLSRCH_SSR_EXPAND_COLLAPS$149$$IMG$1")).click();
    driver.findElement(By.id("SSR_CLSRCH_WRK_OEE_IND$4")).click();
    driver.findElement(By.id("CLASS_SRCH_WRK2_SSR_PB_CLASS_SRCH")).click();
    driver.findElement(By.id("#ICSave")).click();
    driver.findElement(By.id("MTG_CLASS_NBR$0")).click();
    driver.findElement(By.id("MTG_CLASS_NBR$0")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
