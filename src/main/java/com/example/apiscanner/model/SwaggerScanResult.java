package com.example.apiscanner.model;

public class SwaggerScanResult {

	private String swaggerUrl;
	private String https;
	private String bearerAuth;
	private String globalSecurity;
	private String oauth2;
	private int totalApis;

	public String getSwaggerUrl() {
		return swaggerUrl;
	}

	public void setSwaggerUrl(String swaggerUrl) {
		this.swaggerUrl = swaggerUrl;
	}

	public String getHttps() {
		return https;
	}

	public void setHttps(String https) {
		this.https = https;
	}

	public String getBearerAuth() {
		return bearerAuth;
	}

	public void setBearerAuth(String bearerAuth) {
		this.bearerAuth = bearerAuth;
	}

	public String getGlobalSecurity() {
		return globalSecurity;
	}

	public void setGlobalSecurity(String globalSecurity) {
		this.globalSecurity = globalSecurity;
	}

	public String getOauth2() {
		return oauth2;
	}

	public void setOauth2(String oauth2) {
		this.oauth2 = oauth2;
	}

	public int getTotalApis() {
		return totalApis;
	}

	public void setTotalApis(int totalApis) {
		this.totalApis = totalApis;
	}

}
