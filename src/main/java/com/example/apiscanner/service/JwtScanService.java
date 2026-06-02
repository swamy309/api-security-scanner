package com.example.apiscanner.service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.example.apiscanner.model.JwtScanResult;

@Service
public class JwtScanService {

	public JwtScanResult scanJwt(String token) {

		JwtScanResult result = new JwtScanResult();

		try {

			String[] parts = token.split("\\.");

			String headerJson = new String(Base64.getUrlDecoder().decode(parts[0]), StandardCharsets.UTF_8);

			String payloadJson = new String(Base64.getUrlDecoder().decode(parts[1]), StandardCharsets.UTF_8);

			JSONObject header = new JSONObject(headerJson);

			JSONObject payload = new JSONObject(payloadJson);

			result.setAlgorithm(header.optString("alg", "Missing"));

			result.setTokenType(header.optString("typ", "Missing"));

			result.setIssuer(payload.has("iss") ? "Present" : "Missing");

			result.setAudience(payload.has("aud") ? "Present" : "Missing");

			if (payload.has("exp")) {

				long exp = payload.getLong("exp");

				long current = System.currentTimeMillis() / 1000;

				result.setExpiration(exp > current ? "Valid" : "Expired");

			} else {

				result.setExpiration("Missing");
			}

			int score = 100;

			if ("Missing".equals(result.getIssuer()))
				score -= 10;

			if ("Missing".equals(result.getAudience()))
				score -= 10;

			if ("Expired".equals(result.getExpiration()))
				score -= 30;

			if ("none".equalsIgnoreCase(result.getAlgorithm()))
				score -= 50;

			result.setRiskScore(score + "/100");

		} catch (Exception e) {

			e.printStackTrace();
		}

		return result;
	}
}
