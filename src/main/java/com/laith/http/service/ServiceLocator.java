package com.laith.http.service;

import org.reflections.Reflections;
import com.laith.http.request.HttpRequest;

import javax.management.ServiceNotFoundException;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ServiceLocator {

	public static final String servicePrefixPath = "";


	private static Map<String, Service> endPoints;

	static {
		loadEndPoints();
	}

	public static void loadEndPoints() {
		if(endPoints == null) {
			endPoints = new HashMap<>();
		}
		Set<Class<?>> classes = getAllEndPointServices();
		for (Class clazz : classes) {
			Annotation[] annotations = clazz.getAnnotations();
			for (Annotation annotation : annotations) {
				if(annotation instanceof EndPoint) {
					EndPoint endPoint = (EndPoint) annotation;
					System.out.println("URI: " + endPoint.uri() + " - Associated With: " + clazz.getName() + "- Is Loaded Successfully!!!");
					try {
						endPoints.put(endPoint.uri(), (Service) clazz.newInstance());
					} catch (InstantiationException | IllegalAccessException e) {
						System.out.println(e.getCause() + " - " + e.getMessage());
					}
				}
			}
		}
	}

	private static Set<Class<?>> getAllEndPointServices() {
		Reflections reflections = new Reflections(servicePrefixPath);
		return reflections.getTypesAnnotatedWith(EndPoint.class);
	}

	public static Service getService(HttpRequest request) throws ServiceNotFoundException {
		String uri = request.getUri().trim();
		if(endPoints == null) {
			loadEndPoints();
		}
		Service service = endPoints.get(uri);
		if(service != null) {
			return service;
		}
		throw new ServiceNotFoundException(uri);
	}
}