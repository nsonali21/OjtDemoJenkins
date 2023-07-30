package com.utilites;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
public static String readProperties(String key) throws IOException {
String path=System.getProperty("user.dir")+"/src/test/resources/config.properties";
FileInputStream fis=new FileInputStream(path);
Properties prop=new Properties();
prop.load(fis);
return prop.getProperty(key);
}
}
