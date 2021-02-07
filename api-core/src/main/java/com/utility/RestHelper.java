package com.utility;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;



class RestHelper {

    static Response sendRestRequest(String methodUri, String methodType, Map<String, String> params, Map<String, String> headers, Object requestBody) {
        if(headers == null || headers.isEmpty()) {
            headers = new HashMap<>();
            headers.put("Content-Type", "application/json");
        }
        RequestSpecification requestSpecification = RestAssured.given().headers(headers);
        Response response = null;
        switch (methodType) {
            case "GET":
                if(params != null)
                    response = requestSpecification
                            .params(params)
                            .get(methodUri);
                else
                    response = requestSpecification
                            .get(methodUri);
                break;
            case "POST":
                response = requestSpecification
                        .body(requestBody)
                        .post(methodUri);
                break;
        }
        return response;
    }
}
