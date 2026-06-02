package com.example.apiscanner.service;

import org.springframework.stereotype.Service;
import com.example.apiscanner.model.ScanResult;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ScanService {

	public ScanResult scanApi(String url) {

		ScanResult result = new ScanResult();

		try {

			HttpClient client = HttpClient.newHttpClient();

			HttpRequest request = HttpRequest.newBuilder().uri(new URI(url)).GET().build();

			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

			result.setUrl(url);

			// HTTPS Check
			if (url.startsWith("https")) {
				result.setHttps("Enabled");
			} else {
				result.setHttps("Not Enabled");
			}

			// Headers Check
			var headers = response.headers();

			result.setxFrameOptions(checkHeader(response, "X-Frame-Options"));

			result.setContentSecurityPolicy(checkHeader(response, "Content-Security-Policy"));

			result.setStrictTransportSecurity(checkHeader(response, "Strict-Transport-Security"));

			result.setxContentTypeOptions(checkHeader(response, "X-Content-Type-Options"));

			result.setxXssProtection(checkHeader(response, "X-XSS-Protection"));

			result.setReferrerPolicy(checkHeader(response, "Referrer-Policy"));

			result.setPermissionsPolicy(checkHeader(response, "Permissions-Policy"));

			result.setAccessControlAllowOrigin(checkHeader(response, "Access-Control-Allow-Origin"));

			result.setCacheControl(checkHeader(response, "Cache-Control"));

			result.setServer(checkHeader(response, "Server"));

		} catch (Exception e) {

			e.printStackTrace();
		}

		return result;
	}

	private String checkHeader(HttpResponse<String> response, String headerName) {

		return response.headers().firstValue(headerName).isPresent() ? "Present" : "Missing";
	}

}
