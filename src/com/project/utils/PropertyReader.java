package com.project.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	public static FileInputStream inputStream= null;
	public static Properties prop = null;
	public static String ReadProperty(String PropertyName) throws IOException{
		String PropertyValue = null;
		String ProjectPath = System.getProperty("user.dir");
		File file = new File(ProjectPath + "/src/com/project/config/config.properties");
		inputStream = new FileInputStream(file);
		prop = new Properties();
		//for reading a property from the property file, we first need to load the file 
		prop.load(inputStream);
		PropertyValue = prop.getProperty(PropertyName);		
		return PropertyValue;
	}
}