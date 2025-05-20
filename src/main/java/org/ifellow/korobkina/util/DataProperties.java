package org.ifellow.korobkina.util;

import java.io.IOException;
import java.util.Properties;

public class DataProperties {
    private static final Properties properties = new Properties();

    static {
        try {
            properties.load(DataProperties.class.getClassLoader()
                    .getResourceAsStream("properties/data.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Проперти не загрузились", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}