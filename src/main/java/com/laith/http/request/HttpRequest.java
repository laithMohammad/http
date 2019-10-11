package com.laith.http.request;

import java.util.Map;

public class HttpRequest {
	private String method;
	private String uri;
	private String protocol;
	private String host;
	private String connection;
	private String userAgent;
	private String acceptEncoding;
	private String accept;
	private Map<String, String> unmodifiableParams;

	public Map<String, String> getUnmodifiableParams() {
		return unmodifiableParams;
	}

	public void setUnmodifiableParams(Map<String, String> unmodifiableParams) {
		this.unmodifiableParams = unmodifiableParams;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getAcceptEncoding() {
		return acceptEncoding;
	}

	public void setAcceptEncoding(String acceptEncoding) {
		this.acceptEncoding = acceptEncoding;
	}

	public String getAccept() {
		return accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getConnection() {
		return connection;
	}

	public void setConnection(String connection) {
		this.connection = connection;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
}
