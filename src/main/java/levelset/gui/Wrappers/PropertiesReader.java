package levelset.gui.Wrappers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    static String filePath = "WebConfigurations.properties";
    public static Properties properties = new Properties();
    static {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
        }catch (FileNotFoundException fileNotFoundException){
            fileNotFoundException.printStackTrace();
        }
        try{
            properties.load(fileInputStream); //convert into key and value
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static String getProperty(String key){
        try{
            return properties.getProperty(key);
        }catch (Exception e){
            return "Property not found";
        }
    }

}
