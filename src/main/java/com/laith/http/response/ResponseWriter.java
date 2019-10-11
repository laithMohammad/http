package com.laith.http.response;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;

public class ResponseWriter {

	public void writeOutput(Socket client) throws IOException {
		Date today = new Date();
		String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
		if (client.isClosed()) {
			System.out.println("Closed");
			return;
		}
		OutputStream os = client.getOutputStream();

		if (os == null) {
			System.out.println("No Output Stream\n\n\n\n");
		}

		os.write(httpResponse.getBytes());
		os.flush();
		os.close();
	}
}
