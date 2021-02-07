package com.employee.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * Gets the Configuration such as Base URL, & API key from zomato-config properties
 */
public class ConfigHandler {
    private String host;
    private String port;
    private String environment;
    private Properties config = new Properties();

    public ConfigHandler() throws Exception {
        readConfig();
        this.environment = System.getProperty("ENV");
        System.out.println("Test Environment = " + this.environment);
        this.host = config.getProperty("com.employee." + environment.toLowerCase() + ".host");
        this.port = config.getProperty("com.employee." + environment.toLowerCase() + ".port");
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    /**
     * Reads the zomato-config file that contains API configuration parameters
     */
    private void readConfig() throws Exception {
        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream inputStream = new FileInputStream(new File(classLoader.
                getResource("employee-api.properties").getFile()));
        config.load(inputStream);
    }
}
