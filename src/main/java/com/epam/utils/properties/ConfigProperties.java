package com.epam.utils.properties;

import java.util.Objects;

import static com.epam.utils.properties.PropertySource.getProperty;

public class ConfigProperties {
    public static String getDriverName() {
        return getProperty("driver_name");
    }

    public static String getDriverPath() {
        return getProperty("driver_path");
    }

    public static String getBaseUrl() {
        return getProperty("base_url");
    }

    public static int getTimeWait() {
        return Integer.parseInt(Objects.requireNonNull(getProperty("time_wait")));
    }

    public static int getExplicitWait() {
        return Integer.parseInt(Objects.requireNonNull(getProperty("explicit_wait")));
    }

    public static String getDataSource() {
        return getProperty("data_source");
    }
}
