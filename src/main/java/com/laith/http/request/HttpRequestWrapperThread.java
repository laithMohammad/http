package com.laith.http.request;

import com.laith.http.response.ResponseWriter;
import com.laith.http.service.Service;
import com.laith.http.service.ServiceLocator;

import javax.management.ServiceNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

public class HttpRequestWrapperThread implements Runnable {
	private Socket client;
	private static AtomicInteger integer;

	static {
		integer = new AtomicInteger(0);
	}

	public HttpRequestWrapperThread(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		try {
			System.out.println(integer.getAndIncrement());
			InputStream inputStream = client.getInputStream();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			HttpRequest request = new HttpRequestParser().readAndParseRequest(bufferedReader);
			Service service = ServiceLocator.getService(request);
			service.serve(request);
			new ResponseWriter().writeOutput(client);
		} catch (IOException | ServiceNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}