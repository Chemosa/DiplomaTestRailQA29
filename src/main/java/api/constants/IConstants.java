package api.constants;

public interface IConstants {
    String CONTENT_TYPE_VALUE = "application/json";
    String CONTENT_TYPE = "content-type";
    String ADD_PROJECT_ENDPOINT = "/index.php?/api/v2/add_project";
    String ADD_SECTION_ENDPOINT = "/index.php?/api/v2/add_section/%s";
    String ADD_TESTCASE_ENDPOINT = "/index.php?/api/v2/add_case/%s";
    String ADD_TEST_RUN_ENDPOINT = "/index.php?/api/v2/add_run/%s";
    String ADD_TESTCASE_RESULT_ENDPOINT = "/index.php?/api/v2/add_result_for_case/%s/%s";
    String DELETE_PROJECT_ENDPOINT = "/index.php?/api/v2/delete_project/";
    String GET_PROJECT_ENDPOINT = "/index.php?/api/v2/get_project/%s";
}