package com.laith.http.service.exception;

public class EndPointNotFoundException extends Exception {

	public EndPointNotFoundException(String serviceName) {
		super("Service: " + serviceName + "is Not Found");
	}
}
