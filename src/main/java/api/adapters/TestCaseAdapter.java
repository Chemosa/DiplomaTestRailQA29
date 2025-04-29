package api.adapters;

import api.objects.TestCase;
import api.objects.TestCaseResponse;
import com.google.gson.Gson;

public class TestCaseAdapter extends BaseAdapter {

    /**
     * This method send POST request to add new test case and transfer obtained response to json.
     * @param testCase
     * @param sectionId
     * @return
     */
    public TestCaseResponse addTestCase(TestCase testCase, int sectionId) {
        return new Gson().fromJson(post(String.format(ADD_TESTCASE_ENDPOINT, sectionId), gson.toJson(testCase)), TestCaseResponse.class);
    }
}