package com.laith.http;

import com.laith.http.service.ServiceLocator;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServiceLocator.loadEndPoints();
        WebServer.start();
	}
}