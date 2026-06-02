package com.example.apiscanner.model;

public class OwaspScanResult {
	
	private String brokenAccessControl;
    private String cryptographicFailures;
    private String injectionRisk;
    private String securityMisconfiguration;
    private String vulnerableComponents;
    private String identificationFailures;
    private String softwareIntegrity;
    private String securityLogging;
    private String ssrfRisk;
    private String overallRisk;

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

    public String getSoftwareIntegrity() {
        return softwareIntegrity;
    }

    public void setSoftwareIntegrity(String softwareIntegrity) {
        this.softwareIntegrity = softwareIntegrity;
    }

    public String getSecurityLogging() {
        return securityLogging;
    }

    public void setSecurityLogging(String securityLogging) {
        this.securityLogging = securityLogging;
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

}
