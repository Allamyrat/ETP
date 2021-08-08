package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class dataReader {
    private static Properties properties;
    static {

        try {
            String path= "data.properties";
            FileInputStream input=new FileInputStream(path);
            properties=new Properties();
            properties.load(input);
            input.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String get(String Keyname){
        return properties.getProperty(Keyname);
    }
}
