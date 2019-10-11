package com.laith.http.request;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class HttpRequestParser {

	public HttpRequest readAndParseRequest(BufferedReader bufferedReader) throws IOException {
		HttpRequest request = new HttpRequest();
		List<String> requestString = new LinkedList<>();
		String line = bufferedReader.readLine();
		while (line != null && !line.isEmpty()) {
			extractLineData(request, line);
			requestString.add(line);
			line = bufferedReader.readLine();
		}
		return request;
	}

	private void extractLineData(HttpRequest request, String line) {
		if (line == null || line.length() == 0) {
			System.out.println("Empty Line ");
			return;
		}
		String[] lineTokens = line.split(":");
		String attrName = lineTokens[0].toLowerCase();
		if ("host".equals(attrName)) {
			request.setHost(lineTokens[1].trim());
		} else if ("connection".equals(attrName)) {
			request.setConnection(lineTokens[1].trim());
		} else if ("cache-control".equals(attrName)) {
			request.setHost(lineTokens[1].trim());
		} else if ("user-agent".equals(attrName)) {
			request.setUserAgent(lineTokens[1].trim());
		} else if ("accept-encoding".equals(attrName)) {
			request.setAcceptEncoding(lineTokens[1].trim());
		} else if ("accept".equals(attrName)) {
			request.setAccept(lineTokens[1].trim());
		} else if (lineTokens.length == 1) {
			String[] methodLine = lineTokens[0].split(" ");
			if (methodLine.length != 3) {
				System.out.println("Error in method header line: " + line);
			}
			request.setMethod(methodLine[0]);
			prepareUriAndParams(methodLine[1], request);
		}
	}

	private void prepareUriAndParams(String uri, HttpRequest request) {
		String[] uriTokens = uri.split("\\?");
		request.setUri(uriTokens[0]);
		if(uriTokens.length == 1) {
			return;
		}
		Map<String, String> parametersMap = new HashMap<>();
		for (String parameterKeyValue : uriTokens[1].split("&")) {
			String[] keyValuePair = parameterKeyValue.split("=");
			parametersMap.put(keyValuePair[0], keyValuePair[1]);
		}
		request.setUnmodifiableParams(Collections.unmodifiableMap(parametersMap));
	}
}