package util;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class sendToTestLink {

    @BeforeMethod
    public void beforeMethod() throws Exception {
    }

    @Test
    public static void f() throws Exception {

        assert(true);
    }

    @AfterMethod
    public void afterMethod() throws Exception {
        TestLinkResultsManager.getInstance().closeFile();
        TestLinkResultsManager.getInstance().saveAllResults();
    }
}
