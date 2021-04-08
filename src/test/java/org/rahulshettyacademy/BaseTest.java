package org.rahulshettyacademy;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class BaseTest {
    //important test cases...

    public WebDriver initializeDriver() {
        System.setProperty("webdriver.chrome.driver", "F:\\design patterns\\88\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;

    }

    public List<HashMap<String, String>> getJsonPath(String jsonFilePath) throws IOException {
        //it will convert any file to JSON string
        String jsonContent = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);
        //this will help to map the json with hashmap==ObjectMapper Class
        ObjectMapper mapper = new ObjectMapper();
        //readvalue required the type String.
        //So, we have to convert the json to string

        List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
        });
        return data;

    }
}