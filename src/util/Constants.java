package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Constants {

    /** Selenium test configuration */
    public static final String URL = getProps().getProperty("ApplicationURL");

    public static final String Path_TestData = "./res/testData/";
    public static final String File_TestData_US001 = "US001.xlsx";

    /** TestLink configuration */
//	public static final int TestLink_ProjectID = 2315;
//	public static final int TestLink_Cycle01ID = 4696;
//	public static final int TestLink_Cycle02ID = 5299;
    public static final String TestLinkUserKey = getProps().getProperty("TestLinkUserKey");
    public static final String TestLinkUrl = getProps().getProperty("TestLinkURL");
    public static final String TestLinkProjectName = getProps().getProperty("TestLinkProjectName");
    public static final String TestLinkPlanName = getProps().getProperty("TestLinkPlanName");
    public static final boolean saveTestLink = Boolean.valueOf(getProps().getProperty("SaveToTestLink"));
    public static final String Path_ExecutionResults = "./res/ExecutionResults/";

    /** Sheet columns fields*/
    public static final int Col_TestCaseName = 0;
    public static final int Col_UserName =1 ;
    public static final int Col_Password = 2;
    public static final int Col_Browser = 3;
    public static final int Col_Summary = 4;
    public static final int Col_Pre_Condition = 5;
    public static final int Col_Steps = 6;
    public static final int Col_Expected_Results = 7;
    public static final int Col_Generic_1 = 8;
    public static final int Col_Generic_2 = 9;
    public static final int Col_Generic_3 = 10;
    public static final int Col_Generic_4 = 11;
    public static final int Col_Generic_5 = 12;

    /** Columns List Page Table*/
    public static final int LIST_checkbox = 0;
    public static final int LIST_statusName = 1;
    public static final int LIST_createdIn = 2;
    public static final int LIST_createdBy = 3;
    public static final int LIST_lastUpdate = 4;
    public static final int LIST_updatedBy = 5;

    /** Screenshot path */
    public static final String Path_ScreenShot = "./res/Screenshots/";

    /** Operations in Create Update and Delete Entity */
    public static final int NORMAL = 0;
    public static final int DUPLICATED = 1;
    public static final int NULLNAME = 2;

    private static Properties _prop = null;

    public static Properties getProps() {
        if (_prop == null) {
            _prop = new Properties();

            String propertiesFileName = "application.properties";
            FileInputStream is = null;
            try {
                is = new FileInputStream("./res/" + propertiesFileName);
            } catch (FileNotFoundException e) {
                Log.error("File ./res/" + propertiesFileName + " not found!");
            }

            if (is != null) {
                try {
                    _prop.load(is);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                Log.error("File " + propertiesFileName + "' not found in the classpath");
                throw new RuntimeException("Property file not found");
            }
        }
        Log.info("Properties file loaded successfully");
        return _prop;
    }
}