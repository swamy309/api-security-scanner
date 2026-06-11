package com.example.apiscanner.model;

public class APIScanResult {

	private String url;
	private String https;
	private String xFrameOptions;
	private String contentSecurityPolicy;
	private String strictTransportSecurity;
	private String xContentTypeOptions;
	private String xXssProtection;
	private String referrerPolicy;
	private String permissionsPolicy;
	private String accessControlAllowOrigin;
	private String cacheControl;
	private String server;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHttps() {
		return https;
	}

	public void setHttps(String https) {
		this.https = https;
	}

	public String getxFrameOptions() {
		return xFrameOptions;
	}

	public void setxFrameOptions(String xFrameOptions) {
		this.xFrameOptions = xFrameOptions;
	}

	public String getContentSecurityPolicy() {
		return contentSecurityPolicy;
	}

	public void setContentSecurityPolicy(String contentSecurityPolicy) {
		this.contentSecurityPolicy = contentSecurityPolicy;
	}

	public String getStrictTransportSecurity() {
		return strictTransportSecurity;
	}

	public void setStrictTransportSecurity(String strictTransportSecurity) {
		this.strictTransportSecurity = strictTransportSecurity;
	}

	public String getxContentTypeOptions() {
		return xContentTypeOptions;
	}

	public void setxContentTypeOptions(String xContentTypeOptions) {
		this.xContentTypeOptions = xContentTypeOptions;
	}

	public String getxXssProtection() {
		return xXssProtection;
	}

	public void setxXssProtection(String xXssProtection) {
		this.xXssProtection = xXssProtection;
	}

	public String getReferrerPolicy() {
		return referrerPolicy;
	}

	public void setReferrerPolicy(String referrerPolicy) {
		this.referrerPolicy = referrerPolicy;
	}

	public String getPermissionsPolicy() {
		return permissionsPolicy;
	}

	public void setPermissionsPolicy(String permissionsPolicy) {
		this.permissionsPolicy = permissionsPolicy;
	}

	public String getAccessControlAllowOrigin() {
		return accessControlAllowOrigin;
	}

	public void setAccessControlAllowOrigin(String accessControlAllowOrigin) {
		this.accessControlAllowOrigin = accessControlAllowOrigin;
	}

	public String getCacheControl() {
		return cacheControl;
	}

	public void setCacheControl(String cacheControl) {
		this.cacheControl = cacheControl;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}
}
