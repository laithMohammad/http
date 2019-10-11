package com.laith.http.service;

import com.laith.http.request.HttpRequest;
import java.util.Map;

public interface Service {
	Map serve(HttpRequest request);
}
