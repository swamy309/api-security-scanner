package com.example.apiscanner.service;

import org.springframework.stereotype.Service;
import java.net.HttpURLConnection;
import java.net.URL;
import com.example.apiscanner.model.OwaspScanResult;

@Service
public class OwaspScanService {

	public OwaspScanResult scan(String targetUrl) {

		OwaspScanResult result = new OwaspScanResult();

		int score = 100;

		try {

			URL url = new URL(targetUrl);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod("GET");

			String hsts = conn.getHeaderField("Strict-Transport-Security");

			String csp = conn.getHeaderField("Content-Security-Policy");

			String server = conn.getHeaderField("Server");

			// A01 Broken Access Control

			result.setBrokenAccessControl("Manual Verification Required");

			// A02 Cryptographic Failures

			if (targetUrl.startsWith("https")) {

				result.setCryptographicFailures("Low Risk");

			} else {

				result.setCryptographicFailures("High Risk");

				score -= 15;
			}

			// A03 Injection

			result.setInjectionRisk("Manual Validation Required");

			// A04 Insecure Design

			result.setInsecureDesign("Needs Architecture Review");

			// A05 Security Misconfiguration

			if (csp == null) {

				result.setSecurityMisconfiguration("CSP Missing");

				score -= 15;

			} else {

				result.setSecurityMisconfiguration("Low Risk");
			}

			// A06 Vulnerable Components

			if (server != null) {

				result.setVulnerableComponents("Server Header Exposed");

				score -= 10;

			} else {

				result.setVulnerableComponents("Low Risk");
			}

			// A07 Identification Failures

			result.setIdentificationFailures("Manual Review Required");

			// A08 Software Integrity Failures

			result.setSoftwareIntegrityFailures("Manual Review Required");

			// A09 Logging Failures

			result.setLoggingFailures("Cannot Verify Remotely");

			// A10 SSRF

			result.setSsrfRisk("Manual Testing Required");

			result.setRiskScore(score);

			if (score >= 80) {

				result.setOverallRisk("LOW");

			} else if (score >= 50) {

				result.setOverallRisk("MEDIUM");

			} else {

				result.setOverallRisk("HIGH");
			}

		} catch (Exception e) {

			result.setOverallRisk("SCAN FAILED");
		}

		return result;
	}

}
