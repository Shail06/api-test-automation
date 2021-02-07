package stepdefs;

import com.employee.Utils.EmployeeUtils;
import com.employee.config.ConfigHandler;
import com.employee.endpoint.EmployeeEndpoint;
import com.employee.model.Employee;
import com.utility.ApiClient;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

public class Employee_Step_Definitions {

    private ConfigHandler configHandler = new ConfigHandler();
    private ApiClient apiClient = new ApiClient();
    private EmployeeEndpoint employeeEndpoint = new EmployeeEndpoint();
    private EmployeeUtils utils = new EmployeeUtils();

    public Employee_Step_Definitions() throws Exception {
        apiClient.setHostname(configHandler.getHost()+":"+configHandler.getPort());
    }

    @Given("^I want to get all Employees$")
    public void iWantToGetAllEmployees() {
        employeeEndpoint.setMethod("/api/employees");
        employeeEndpoint.setMethodType("GET");
        employeeEndpoint.setRequestType("REST");
        apiClient.setEndpoint(employeeEndpoint);
    }

    @When("^I send the request$")
    public void iSendTheRequest() {
        apiClient.sendRequest();
    }

    @Then("^I get response (\\d+)$")
    public void iGetResponse(int expectedResponse) {
        int actualResponse = apiClient.getResponseStatusCode();
        MatcherAssert.assertThat("Status Code Mismatch!", actualResponse, Matchers.equalTo(expectedResponse));
    }

    @Given("^I want to add one Employee$")
    public void iWantToAddOneEmployee() {
        employeeEndpoint.setMethod("/api/employees");
        employeeEndpoint.setMethodType("POST");
        employeeEndpoint.setRequestType("REST");
        apiClient.setEndpoint(employeeEndpoint);
    }

    @And("^I setup the new Employee data$")
    public void iSetupTheNewEmployee() {
        Employee employee = new Employee();
        employee.setFirst_name(utils.randomString());
        employee.setLast_name(utils.randomString());
        employee.setEmail(utils.randomEmail());
        employee.setHire_date(utils.randomDateISO8601());
        employee.setJob_title("Engineer");
        employee.setManager_id(1);
        employee.setPhone(utils.randomPhoneNumber());
        apiClient.setRequestBody(employee);
    }
}
