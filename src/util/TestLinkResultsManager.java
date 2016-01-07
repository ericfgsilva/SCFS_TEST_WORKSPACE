package util;

import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIConst;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

import java.io.*;
import java.util.Date;

public class TestLinkResultsManager {

    private File file;
    private String filePath;
    private FileWriter fw;
    private BufferedWriter bw;
    private String buildName;

    private static TestLinkResultsManager instance;

    public static TestLinkResultsManager getInstance() {
        if(instance == null) {
            instance = new TestLinkResultsManager();
        }

        return instance;
    }

    // private actor
    private TestLinkResultsManager() {

        if(Constants.saveTestLink){
            TestLinkAPIClient api = new TestLinkAPIClient(Constants.TestLinkUserKey, Constants.TestLinkUrl);

            try {
                buildName = getActualTestLinkBuild(api);
                filePath = Constants.TestLinkProjectName + "-" + Constants.TestLinkPlanName + "-" + buildName + "-" + new Date();
                filePath = Constants.Path_ExecutionResults + filePath + ".txt";

                // creating file
                file = new File(filePath);

                if (!file.exists()) {
                    file.createNewFile();
                }

                fw = new FileWriter(file.getAbsoluteFile());
                bw = new BufferedWriter(fw);

            }catch (Exception ex) {
                // do anything?
            }
        }
    }

    public void writeToFile(String testName, boolean result, String msg) throws Exception{

        if(Constants.saveTestLink){
            String data = testName + "#" + result + "#" + msg + "\n";
            bw.append(data);
        }
    }

    public void closeFile() throws IOException {

        if(Constants.saveTestLink){
            bw.close();
        }
    }

    public void saveAllResults() throws Exception{

        if(Constants.saveTestLink){

            Log.info("Starting to save all results...\n\n");

            TestLinkAPIClient api = new TestLinkAPIClient(Constants.TestLinkUserKey, Constants.TestLinkUrl);

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();

            int testCount = 1;

            while (line != null){
                System.out.println("Saving test " + testCount);
                Log.info("Saving test " + testCount);

                String[] lineValues = line.split("#");

                /**
                 * lineValues[0] = Test Case Name
                 * lineValues[1] = Test Case Result
                 * lineValues[2] = Result message
                 */

                String resultString;
                if(Boolean.parseBoolean(lineValues[1])) {
                    resultString = TestLinkAPIConst.TEST_PASSED;
                }else {
                    resultString = TestLinkAPIConst.TEST_FAILED;
                }

                String testExternalID = testExternalIDExtract(lineValues[0]);

                api.reportTestCaseResult(Constants.TestLinkProjectName, Constants.TestLinkPlanName, testExternalID, buildName, lineValues[2], resultString);

                line = br.readLine();
                testCount++;
            }

            br.close();
        }
    }

    private String getActualTestLinkBuild(TestLinkAPIClient api) throws TestLinkAPIException {

        TestLinkAPIResults projects = api.getProjects();
        int projectID = 0;
        for(int i = 0 ; i < projects.size() ; i++){
            if(projects.getValueByName(i, "name").equals(Constants.TestLinkProjectName)){
                projectID = Integer.parseInt(projects.getValueByName(i, "id").toString());
            }
        }

        TestLinkAPIResults plans = api.getProjectTestPlans(projectID);
        int planID = 0;
        for(int j = 0 ; j < plans.size() ; j++){
            if(plans.getValueByName(j, "name").equals(Constants.TestLinkPlanName)){
                planID = Integer.parseInt(plans.getValueByName(j, "id").toString());
            }
        }

        TestLinkAPIResults build = api.getLatestBuildForTestPlan(planID);
        return build.getValueByName(0, "name").toString();
    }

    private String testExternalIDExtract(String testName) {

        String[] split = testName.split("_");
        String result = split[0] + "-" + split[1];

        return result;
    }
}
