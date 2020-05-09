package stepdefs;

import com.utility.ApiClient;
import com.zomato.ConfigHandler;
import com.zomato.endpoint.ZomatoEndpoint;
import com.zomato.response.CitiesResponse;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import java.util.HashMap;

/**
 * The class implements step definitions for TEST01-GET cities information
 */
public class CitiesSteps {

    private ConfigHandler configHandler = new ConfigHandler();
    private ApiClient apiClient = new ApiClient();
    private ZomatoEndpoint endpoint = new ZomatoEndpoint();

    public CitiesSteps() throws Exception {
        apiClient.setHostname(configHandler.getHost());
    }

    @Given("I want to test the details of cities")
    public void iWantToTestTheDetailsOfCities() {
        endpoint.setMethod("/api/v2.1/cities");
        endpoint.setMethodType("GET");
        endpoint.setRequestType("REST");
        apiClient.setEndpoint(endpoint);
    }

    @And("^I have set the query parameters (.*?) with valid data (.*?)$")
    public void iHaveSetTheQueryParametersQueryParamsWithValidDataValues(String qParams, String paramValues) {
        HashMap<String, String> parameters = new HashMap<>();
        String[] paramNames = qParams.split(";");
        String[] paramVals = paramValues.split(";");
        for (int i = 0; i < paramNames.length; i++) {
            parameters.put(paramNames[i], paramVals[i]);
        }
        apiClient.setRequestParameters(parameters);
    }

    @And("^I have set the correct headers for the request$")
    public void iHaveSetTheCorrectHeadersForTheRequest() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("user-key", configHandler.getKey());
        apiClient.setHeaders(headers);
    }

    @When("^I send the request$")
    public void iSendTheRequest() {
        apiClient.sendRequest();
        apiClient.getResponseBody();
    }

    @Then("^I should get the response code (\\d+)$")
    public void iShouldGetTheResponseCode(int responseCode) {
        int actualResponseCode = apiClient.getResponseStatusCode();
        MatcherAssert.assertThat("Status Code Mismatch!",
                actualResponseCode, Matchers.equalTo(responseCode));
    }

    @And("^I should get non empty and correct response structure$")
    public void iShouldGetNonEmptyAndCorrectResponseStructure() {
        Object responseObject = apiClient.getReponseBodyAsObject(CitiesResponse.class);
        MatcherAssert.assertThat("Response Structure Incorrect",
                responseObject, Matchers.instanceOf(CitiesResponse.class));

        CitiesResponse cities = (CitiesResponse) responseObject;

        MatcherAssert.assertThat(
                "City Information is Empty!",
                cities.getLocation_suggestions().length,
                Matchers.greaterThan(0)
        );
    }
}
