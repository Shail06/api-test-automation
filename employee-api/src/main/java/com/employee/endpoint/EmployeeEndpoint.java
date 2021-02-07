package com.employee.endpoint;

import com.utility.Endpoint;

public class EmployeeEndpoint implements Endpoint{
    private String methodType;

    private String methodUri;
    private String requestType;

    @Override
    public String getMethodType() {
        return methodType;
    }

    @Override
    public void setMethodType(String methodType) {
        this.methodType = methodType;
    }

    public String getMethodUri() {
        return methodUri;
    }

    public void setMethodUri(String methodUri) {
        this.methodUri = methodUri;
    }

    @Override
    public String getRequestType() {
        return requestType;
    }

    @Override
    public void setMethod(String method) {
        this.methodUri = method;
    }

    @Override
    public String getMethod() {
        return this.methodUri;
    }

    @Override
    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }
}
