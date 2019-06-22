package lesson3.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileUtils {

    public static String readUserFromFile(String filePath) {
        Properties prop = new Properties();

        try (InputStream input = FileUtils.class.getClass().getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
            }
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop.toString();
    }
}