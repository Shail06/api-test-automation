import com.utility.ApiClient;

import java.util.HashMap;

/**
 * Class to test proper functionality of ApiClient class
 */
public class ApiClientTest {

    private String host = "https://developers.zomato.com";
    private TestEndpoint endpoint = new TestEndpoint();

    //@Test
    public void testZomatoCities() {
        endpoint.setMethod("/api/v2.1/cities");
        endpoint.setMethodType("GET");
        endpoint.setRequestType("REST");

        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("q", "London");

        HashMap<String, String> headers = new HashMap<>();
        headers.put("user-key", "<PASTE_THE_KEY_HERE>");

        ApiClient apiClient = new ApiClient();

        apiClient.setHostname(host);
        apiClient.setEndpoint(endpoint);
        apiClient.setRequestParameters(parameters);
        apiClient.setHeaders(headers);

        apiClient.sendRequest();

        System.out.println(apiClient.getResponseStatusCode());
        apiClient.getResponseBody();

    }

}
