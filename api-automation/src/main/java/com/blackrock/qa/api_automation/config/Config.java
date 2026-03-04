package com.blackrock.qa.api_automation.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final Properties props = new Properties();

    static {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (in != null) {
                props.load(in);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    private static String get(String key) {
        String env = System.getenv(key.toUpperCase());
        if (env != null && !env.isEmpty()) return env;
        String sys = System.getProperty(key);
        if (sys != null && !sys.isEmpty()) return sys;
        return props.getProperty(key);
    }

    public static String getBaseUrl() {
        return get("baseUrl");
    }

    public static String getUsername() {
        return get("username");
    }

    public static String getEmail() {
        return get("email");
    }

    public static String getPassword() {
        return get("password");
    }
}
