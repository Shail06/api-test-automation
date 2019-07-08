package com.utility;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;


class RestHelper {

    static Response sendRestRequest(String methodUri, Map<String, String> params, Map<String, String> headers) {
        RequestSpecification specification = new RequestSpecBuilder()
                .addQueryParams(params)
                .addHeaders(headers).build();
        Response response = given(specification).contentType("application/json").get(methodUri);
        return response;
    }
}
