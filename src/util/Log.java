package util;

import org.apache.log4j.Logger;

public class Log {

	// Initialize Log4j logs

	private static Logger Log = Logger.getLogger(Log.class.getName());//

	// This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite

	public static void startTestCase(String sTestCaseName){

		Log.info("****************************************************************************************");
		Log.info("****************************************************************************************");
		Log.info("                   "+sTestCaseName);
		Log.info("****************************************************************************************");
		Log.info("****************************************************************************************");
	}

	//This is to print log for the ending of the test case

	public static void endTestCase(String sTestCaseName){

		Log.info("XXXXXXXXXXXXXXXXXXXXXXX                "+"-E---N---D-"+"                XXXXXXXXXXXXXXXXXXXXXX");
		Log.info("X");
		Log.info("X");
		Log.info("X");
		Log.info("X");
	}
	
	public static void testDescription(String testName, String summary, String precondition, String steps, String expectedResults){
		
		Log.info("XXXXXXXXXXXXXXXXXXXXXXX             "+ testName +"             XXXXXXXXXXXXXXXXXXXXXX");
		
		Log.info("Summary: ");
		String[] summaryArray = summary.split("\n");
		for(String s1 : summaryArray){
			Log.info(s1);
		}
		
		Log.info("__________________________________________________________________________________________");
		
		Log.info("Pre-Condition: ");
		String[] preconditionArray = precondition.split("\n");
		for(String s2 : preconditionArray){
			Log.info(s2);
		}
		
		Log.info("__________________________________________________________________________________________");
		
		Log.info("Steps: ");
		String[] stepsArray = steps.split("\n");
		for(int i = 0 ; i < stepsArray.length ; i++){
			Log.info(i+1 + ". " + stepsArray[i]);
		}
		
		Log.info("__________________________________________________________________________________________");
		
		Log.info("Expected Results: ");
		String[] expecArray = expectedResults.split("\n");
		for(int j = 0 ; j < expecArray.length ; j++){
			Log.info(j+1 + ". " + expecArray[j]);
		}
		
		Log.info("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		
	}
	

	public static void logTestDescription(String testName, int iTestCaseRow) throws Exception{

		String summary = ExcelUtils.getCellData(iTestCaseRow, Constants.Col_Summary);
		String precondition = ExcelUtils.getCellData(iTestCaseRow, Constants.Col_Pre_Condition);
		String steps = ExcelUtils.getCellData(iTestCaseRow, Constants.Col_Steps);
		String expectedResults = ExcelUtils.getCellData(iTestCaseRow, Constants.Col_Expected_Results);
		testDescription(testName, summary, precondition, steps, expectedResults);
	}

	// Need to create these methods, so that they can be called  

	public static void info(String message) {

		Log.info(message);
	}

	public static void warn(String message) {

		Log.warn(message);
	}

	public static void error(String message) {

		Log.error(message);
	}

	public static void fatal(String message) {

		Log.fatal(message);
	}

	public static void debug(String message) {

		Log.debug(message);
	}

}