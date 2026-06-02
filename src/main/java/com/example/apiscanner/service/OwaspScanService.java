package com.example.apiscanner.service;

import org.springframework.stereotype.Service;

import com.example.apiscanner.model.OwaspScanResult;

@Service
public class OwaspScanService {

	public OwaspScanResult scan(String url) {

		OwaspScanResult result = new OwaspScanResult();

		result.setBrokenAccessControl("Needs Manual Verification");

		if (url.startsWith("https")) {
			result.setCryptographicFailures("Low");
		} else {
			result.setCryptographicFailures("High");
		}

		result.setInjectionRisk("Potential");
		result.setSecurityMisconfiguration("Check Headers");
		result.setVulnerableComponents("Unknown");
		result.setIdentificationFailures("Needs Review");
		result.setSoftwareIntegrity("Needs Review");
		result.setSecurityLogging("Unknown");
		result.setSsrfRisk("Unknown");

		result.setOverallRisk("Medium");

		return result;
	}

}
