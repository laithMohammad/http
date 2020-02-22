package com.laith.http.common;

import java.io.*;
import java.util.Properties;

public class Config {
	private static final Properties properties;


	static {
		properties = new Properties();
		try {
			InputStream is = Config.class.getClassLoader().getResourceAsStream("config.properties");
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getString(String propertyName) {
		return properties.getProperty(propertyName);
	}

	public static int getPort() {
		return Integer.parseInt(getString("server.port"));
	}

	public static int serverThreads() {
		return Integer.parseInt(getString("server.threads"));
	}
}
