package com.example.apiscanner.model;

public class OwaspScanResult {

	private String brokenAccessControl;
	private String cryptographicFailures;
	private String injectionRisk;
	private String insecureDesign;
	private String securityMisconfiguration;
	private String vulnerableComponents;
	private String identificationFailures;
	private String softwareIntegrityFailures;
	private String loggingFailures;
	private String ssrfRisk;
	private String overallRisk;
	private int riskScore;

	public String getBrokenAccessControl() {
		return brokenAccessControl;
	}

	public void setBrokenAccessControl(String brokenAccessControl) {
		this.brokenAccessControl = brokenAccessControl;
	}

	public String getCryptographicFailures() {
		return cryptographicFailures;
	}

	public void setCryptographicFailures(String cryptographicFailures) {
		this.cryptographicFailures = cryptographicFailures;
	}

	public String getInjectionRisk() {
		return injectionRisk;
	}

	public void setInjectionRisk(String injectionRisk) {
		this.injectionRisk = injectionRisk;
	}

	public String getInsecureDesign() {
		return insecureDesign;
	}

	public void setInsecureDesign(String insecureDesign) {
		this.insecureDesign = insecureDesign;
	}

	public String getSecurityMisconfiguration() {
		return securityMisconfiguration;
	}

	public void setSecurityMisconfiguration(String securityMisconfiguration) {
		this.securityMisconfiguration = securityMisconfiguration;
	}

	public String getVulnerableComponents() {
		return vulnerableComponents;
	}

	public void setVulnerableComponents(String vulnerableComponents) {
		this.vulnerableComponents = vulnerableComponents;
	}

	public String getIdentificationFailures() {
		return identificationFailures;
	}

	public void setIdentificationFailures(String identificationFailures) {
		this.identificationFailures = identificationFailures;
	}

	public String getSoftwareIntegrityFailures() {
		return softwareIntegrityFailures;
	}

	public void setSoftwareIntegrityFailures(String softwareIntegrityFailures) {
		this.softwareIntegrityFailures = softwareIntegrityFailures;
	}

	public String getLoggingFailures() {
		return loggingFailures;
	}

	public void setLoggingFailures(String loggingFailures) {
		this.loggingFailures = loggingFailures;
	}

	public String getSsrfRisk() {
		return ssrfRisk;
	}

	public void setSsrfRisk(String ssrfRisk) {
		this.ssrfRisk = ssrfRisk;
	}

	public String getOverallRisk() {
		return overallRisk;
	}

	public void setOverallRisk(String overallRisk) {
		this.overallRisk = overallRisk;
	}

	public int getRiskScore() {
		return riskScore;
	}

	public void setRiskScore(int riskScore) {
		this.riskScore = riskScore;
	}

}
