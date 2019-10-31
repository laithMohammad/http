package com.laith.http;

import com.laith.http.service.ServiceLocator;

import java.io.*;

public class Start {

	public static void run() throws IOException {
        ServiceLocator.loadEndPoints();
        WebServer.start();
	}
}
