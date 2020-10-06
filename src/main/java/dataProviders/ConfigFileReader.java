package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath= "configs//Configuration.properties";


    public ConfigFileReader(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getAutomationName(){
        String automationName = properties.getProperty("automationName");
        if(automationName!= null) return automationName;
        else throw new RuntimeException("automationName is not specified in the Configuration.properties file.");
    }

    public String getPlatformName(){
        String platformName = properties.getProperty("platformName");
        if(platformName!= null) return platformName;
        else throw new RuntimeException("platformName is not specified in the Configuration.properties file.");
    }

    public String getDeviceName(){
        String deviceName = properties.getProperty("deviceName");
        if(deviceName!= null) return deviceName;
        else throw new RuntimeException("deviceName is not specified in the Configuration.properties file.");
    }

    public String getUDID(){
        String udid = properties.getProperty("udid");
        if(udid!= null) return udid;
        else throw new RuntimeException("udid is not specified in the Configuration.properties file.");
    }

    public String getAppPackage(){
        String appPackage = properties.getProperty("appPackage");
        if(appPackage!= null) return appPackage;
        else throw new RuntimeException("appPackage is not specified in the Configuration.properties file.");
    }

    public String getAppActivity(){
        String appActivity = properties.getProperty("appActivity");
        if(appActivity!= null) return appActivity;
        else throw new RuntimeException("appActivity is not specified in the Configuration.properties file.");
    }

    public String getExtentReportConfigPath() {
        String extentReportConfigPath = properties.getProperty("extentReportConfigPath");
        if(extentReportConfigPath != null) return extentReportConfigPath;
        else throw new RuntimeException("extentReportConfigPath not specified in the Configuration.properties file.");
    }

}