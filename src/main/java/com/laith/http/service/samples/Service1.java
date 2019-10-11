package com.laith.http.service.samples;

import com.laith.http.request.HttpRequest;
import com.laith.http.service.EndPoint;
import com.laith.http.service.Service;

import java.util.Map;

@EndPoint(uri = "/welcome")
public class Service1 implements Service {

	@Override
	public Map serve(HttpRequest request) {
		System.out.println(" Service Attached!!!");
		return null;
	}
}
