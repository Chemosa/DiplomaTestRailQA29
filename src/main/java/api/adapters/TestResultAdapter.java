package api.adapters;

import api.objects.TestResult;
import api.objects.TestResultResponse;
import com.google.gson.Gson;

public class TestResultAdapter extends BaseAdapter {

    /**
     * This method send POST request to add new test result for test case and transfer obtained response to json.
     * @param testResult
     * @param testRunId
     * @param testCaseId
     * @return
     */
    public TestResultResponse addTestCaseResult(TestResult testResult, int testRunId, int testCaseId) {
        return new Gson().fromJson(post(String.format(ADD_TESTCASE_RESULT_ENDPOINT, testRunId, testCaseId), gson.toJson(testResult)), TestResultResponse.class);
    }
}