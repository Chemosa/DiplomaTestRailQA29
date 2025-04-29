package api.adapters;

import api.objects.TestRun;
import api.objects.TestRunResponse;
import com.google.gson.Gson;

public class TestRunAdapter extends BaseAdapter {

    /**
     * This method send POST request to add new test run and transfer obtained response to json.
     * @param testRun
     * @param projectId
     * @return
     */
    public TestRunResponse addTestRun(TestRun testRun, int projectId) {
        return new Gson().fromJson(post(String.format(ADD_TEST_RUN_ENDPOINT, projectId), gson.toJson(testRun)), TestRunResponse.class);
    }
}