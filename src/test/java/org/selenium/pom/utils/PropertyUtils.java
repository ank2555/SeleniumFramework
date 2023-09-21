package org.selenium.pom.utils;

import java.io.FileInputStream;
import java.io.*;
import java.util.Properties;

public class PropertyUtils {
    private static java.util.Properties properties;


    public static Properties GetProperties(String FIlePath) {
        try {

            FileInputStream fileInputStream = new FileInputStream(FIlePath);
            properties = new java.util.Properties();
            return properties;


        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return properties;


    }
}
