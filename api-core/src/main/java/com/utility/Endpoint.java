package com.utility;

public interface Endpoint {
    /**
     * @param method: the endpoint method
     */
    void setMethod(String method);

    String getMethod();

    /**
     * @param requestType: like REST, SOAP etc
     */
    void setRequestType(String requestType);

    String getRequestType();

    /**
     * @param methodType: like GET, POST, PUT etc
     */
    void setMethodType(String methodType);

    String getMethodType();

}
