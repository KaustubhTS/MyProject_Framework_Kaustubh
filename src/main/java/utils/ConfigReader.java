package utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static ConfigReader instance;
    private  Properties prop;

    private ConfigReader() {
        try {
            prop = new Properties();
            // First try to load from classpath (works for src/test/resources or src/main/resources)
            InputStream is = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties");
            if (is != null) {
                prop.load(is);
                is.close();
            } else {
                // Fallback: try to load from working directory (original behavior)
                FileInputStream fis = new FileInputStream("config.properties");
                prop.load(fis);
                fis.close();
            }
        } catch (Exception e) {
            // Print useful message so the cause is clear in test output
            System.err.println("Could not load config.properties from classpath or working dir: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static ConfigReader getInstance() {
        if (instance == null) {
            instance = new ConfigReader();
        }
        return instance;
    }

    public  String getBrowser(String key) {
        return prop.getProperty(key);
    }
    public String getUrl(String key) {
        return prop.getProperty(key);
    }
}