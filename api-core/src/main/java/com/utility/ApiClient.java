package com.utility;

import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;

import java.util.HashMap;

/**
 * Contains all the relevant functions for implementing HTTP Request handling
 */
public class ApiClient {

    private String host;
    private Endpoint endpoint;
    private HashMap<String, String> queryParameters;
    private HashMap<String, String> headers;
    private Response restResponse;

    /**
     * @param headers: Contain the map of header values. e.g. Authentication
     */
    public void setHeaders(HashMap<String, String> headers) {
        this.headers = headers;
    }

    /**
     * @param queryParameters: Contain map of parameter values
     */
    public void setRequestParameters(HashMap<String, String> queryParameters) {
        this.queryParameters = queryParameters;
    }

    /**
     * @param endpoint: Contains all information like Method, MethodType for the request
     */
    public void setEndpoint(Endpoint endpoint) {
        this.endpoint = endpoint;
    }

    public void setHostname(String host) {
        this.host = host;
    }

    /**
     * This method prepares the request by setting all method details and firing the Http request
     * using Rest Assured methods implemented in RestHelper Class
     */
    public void sendRequest() {
        String methodUri = host + this.endpoint.getMethod();
        String requestType = this.endpoint.getRequestType();
        String methodType = this.endpoint.getMethodType();

        if (requestType.equalsIgnoreCase("REST")) {
            switch (methodType) {
                case "GET":
                    restResponse = RestHelper.sendRestRequest(methodUri, this.queryParameters, this.headers);
                    break;
            }
        }
    }

    public int getResponseStatusCode() {
        return this.restResponse.getStatusCode();
    }

    public String getResponseBody() {
        return this.restResponse.getBody().prettyPrint();
    }

    /**
     * @param responseClass: Will have an POJO Representation of the JSON response
     * @return: The response JSON body deserialized into Java Object
     */
    public Object getReponseBodyAsObject(Class responseClass) {
        return this.restResponse.then().extract().as(responseClass, ObjectMapperType.JACKSON_2);
    }

}
