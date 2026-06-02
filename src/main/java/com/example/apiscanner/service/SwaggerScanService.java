package com.example.apiscanner.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Iterator;
import org.springframework.stereotype.Service;
import com.example.apiscanner.model.SwaggerScanResult;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SwaggerScanService {
	
	public SwaggerScanResult scanSwagger(String swaggerUrl) {

        SwaggerScanResult result = new SwaggerScanResult();

        try {

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(swaggerUrl))
                    .GET()
                    .build();

            HttpResponse<String> response =
                    client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();

            JsonNode root =
                    mapper.readTree(response.body());

            result.setSwaggerUrl(swaggerUrl);

            // HTTPS Check
            result.setHttps(
                    swaggerUrl.startsWith("https")
                            ? "Enabled"
                            : "Not Enabled");

            // Security Schemes
            JsonNode securitySchemes =
                    root.path("components")
                            .path("securitySchemes");

            if (!securitySchemes.isMissingNode()
                    && securitySchemes.has("bearerAuth")) {

                result.setBearerAuth("Present");

            } else {

                result.setBearerAuth("Missing");
            }

            // OAuth2
            boolean oauthFound = false;

            Iterator<String> names =
                    securitySchemes.fieldNames();

            while (names.hasNext()) {

                String schemeName = names.next();

                JsonNode scheme =
                        securitySchemes.get(schemeName);

                if ("oauth2".equalsIgnoreCase(
                        scheme.path("type").asText())) {

                    oauthFound = true;
                    break;
                }
            }

            result.setOauth2(
                    oauthFound ? "Present" : "Missing");

            // Global Security
            JsonNode security =
                    root.path("security");

            result.setGlobalSecurity(
                    security.isArray()
                            && security.size() > 0
                            ? "Present"
                            : "Missing");

            // Total APIs
            JsonNode paths =
                    root.path("paths");

            result.setTotalApis(paths.size());

        } catch (Exception e) {

            e.printStackTrace();
        }

        return result;
    }

}
