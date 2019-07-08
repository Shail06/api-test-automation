package com.zomato;

import java.io.*;
import java.util.Properties;

/**
 * Gets the Configuration such as Base URL, & API key from zomato-config properties
 */
public class ConfigHandler {
    private String host;
    private String key;
    private String environment;
    private Properties config = new Properties();

    public ConfigHandler() throws Exception {
        readConfig();
        this.environment = System.getenv("ENV");
        this.host = config.getProperty("com.zomato." + environment.toLowerCase() + ".host");
        this.key = config.getProperty("com.zomato." + environment.toLowerCase() + ".key");
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Reads the zomato-config file that contains API configuration parameters
     */
    private void readConfig() throws Exception {
        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream inputStream = new FileInputStream(new File(classLoader.
                getResource("zomato-config.properties").getFile()));
        config.load(inputStream);
    }
}
