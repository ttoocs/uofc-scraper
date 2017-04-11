/**
 * Created by fu-fu on 4/9/17.
 */
public class sectionData {

    //DB:

    // int id,  (Special) type,   int number (of what - l01 /ect), String time <mon/tue/wen/thu/fri/sat/sun>,<start-time>,<end-time
    // String Location, int semesterID,    String TA_name (always null :/),     String InstructorName,
    // int CourseNum, String dept_name //Supposed to be dept, but it's really just subjects.

    int id;
    String type; //lec, tut, lab
    String subjectnum; // 01B but just the number.
    String time;    // Time
    String room;    // Room
    String location;
    int semesterID; //Link to semester
    String TAName = null;  //haha. nope.
    String InstructorName;  //Johnathan Joe.
    String prefixNum;          //Course's number ex: 471
    String deptName;     // CPSC/SENG

    String status;          //I WANT DIS.

    public sectionData(int id, int semesterID){
        this.id = id;
        this.semesterID = semesterID;
    }
    public sectionData(int id, String type, String subjectnum, String time, String room, String location, int semesterID, String TAName, String InstructorName, String prefixNum, String deptName,String status){
        this.id = id;
        this.type = type;
        this.subjectnum = subjectnum;
        this.time = time;
        this.room = room;
        this.location = location;
        this.semesterID = semesterID;
        this.TAName = TAName;
        this.InstructorName = InstructorName;
        this.prefixNum = prefixNum;
        this.deptName = deptName;
        this.status = status;
    }

    public String toString(){
        return "SectionData: "+id+":"+type+":"+subjectnum+":"+time+":"+location+":"+semesterID+":"+TAName+":"+InstructorName+":"+prefixNum+":"+deptName+":"+status;
    }
    //Parsable:
    //Title:                                                    :   DERIVED_CLSRCH_DESCR200 (e.getText)

    //Status <Open/closed/..?> (Probably best to be a string)   :   SSR_CLS_DTL_WRK_SSR_DESCRSHORT (e.getText)
    //Class Number (The ID)                                     :   SSR_CLS_DTL_WRK_CLASS_NBR   (e.getText)
    //Session: "Regular Academic" (String)                      :   PSXLATITEM_XLATLONGNAME$31$ (e.getText)
    //Units: 3,6 (Possibly best to handle as string..)          :   SSR_CLS_DTL_WRK_UNITS_RANGE (e.getText)
    //Class Components: "Labratory Required" (String)           :   win0divSSR_CLS_DTL_WRK_SSR_COMPONENT_LONG (Algorithm needed)
    //Career: "Undergraduate Programs" (String)                 :   PSXLATITEM_XLATLONGNAME (e.getText)
    //Dates: "2017/1/9 - 2017/4/12" (two Strings?)              :   SSR_CLS_DTL_WRK_SSR_DATE_LONG (e.getText)
    //Grading: "Graded" (String)                                :   GRADE_BASIS_TBL_DESCRFORMAL (e.getText)
    //Location: "Main campus" (String)                          :   CAMPUS_LOC_VW_DESCR (e.getText)
    //Campus: "University of Calgary" (String)                  :   CAMPUS_TBL_DESCR (e.getText)
    //Meeting Info: //OH GOD A TABLE OF HELL.                   :   win0divSSR_CLSRCH_MTG$0     (ALGOIRTHM)
        //Days & time (String)
        //Room        (String)
        //Instructor  (String)
        //Dates       (String)
    /*
    Enrollment:
        Enrollment Requirments: (STRING):   SSR_CLS_DTL_WRK_SSR_REQUISITE_LONG  (e.getText)
            Restricted:
            Prerequisites:
        Class Attributes:   (STRING):   SSR_CLS_DTL_WRK_SSR_CRSE_ATTR_LONG (e.getText)
            Half-Course (??)
            GFC Hours (3-0) (??)

  Class Restrictions:
    ID:
    Restriction Nbr:
    Start Date:
    End Date:
    Reserved Seats:
    Description:

  Class Availability:
    Class Capacity:                 SSR_CLS_DTL_WRK_ENRL_CAP (e.getText)
    Enrollment Total:               SSR_CLS_DTL_WRK_ENRL_TOT    (e.getText)
    Available Seats:                SSR_CLS_DTL_WRK_AVAILABLE_SEATS (e.getText)
    Wait List Capacity:             SSR_CLS_DTL_WRK_WAIT_CAP
    Wait List Total:                win0divSSR_CLS_DTL_WRK_WAIT_TOT

  Notes:
    Class Notes:

  Description:                      DERIVED_CLSRCH_DESCRLONG (e.getText)
    //Desc:
    //Prerequisites:
    //Antirequisites:
    //Notes:

  Textbooks/Other Materials:        SSR_CLS_DTL_WRK_SSR_CLS_TXB_MSG (e.getText)

    */


}
