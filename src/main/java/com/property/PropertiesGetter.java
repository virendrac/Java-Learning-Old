package com.property;

import java.util.Properties;
import java.io.*;

public class PropertiesGetter {

    public static String getProperty(String propertyName){

        String retVal="";
        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("config.properties");

            // load a properties file
            prop.load(input);

            retVal=prop.getProperty(propertyName);



        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return retVal;
    }
}
