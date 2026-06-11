package com.example.apiscanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.apiscanner.model.APIScanResult;
import com.example.apiscanner.model.JwtScanResult;
import com.example.apiscanner.model.OwaspScanResult;
import com.example.apiscanner.model.SwaggerScanResult;
import com.example.apiscanner.service.ApiScanService;
import com.example.apiscanner.service.JwtScanService;
import com.example.apiscanner.service.OwaspScanService;
import com.example.apiscanner.service.PdfService;
import com.example.apiscanner.service.SwaggerScanService;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RestController
public class ScanController {

	// API scan service
	@Autowired
	private ApiScanService apiScanService;

	@GetMapping("/api-scan")
	public APIScanResult scan(@RequestParam String url) {

		return apiScanService.scanApi(url);
	}

	// swaggerScanService
	@Autowired
	private SwaggerScanService swaggerScanService;

	@GetMapping("/swagger-scan")
	public SwaggerScanResult scanSwagger(@RequestParam String url) {

		return swaggerScanService.scanSwagger(url);
	}

	// jwtScanService
	@Autowired
	private JwtScanService jwtScanService;

	@GetMapping("/jwt-scan")
	public JwtScanResult scanJwt(@RequestParam String token) {

		return jwtScanService.scanJwt(token);
	}

	// owaspScanService
	@Autowired
	private OwaspScanService owaspScanService;

	@GetMapping("/owasp-scan")
	public OwaspScanResult scanOwasp(@RequestParam String url) {

		return owaspScanService.scan(url);
	}

	// PDFService
	@Autowired
	private PdfService pdfService;

	@GetMapping("/download-api-pdf")
	public ResponseEntity<byte[]> downloadHeaderPdf(@RequestParam String url) {

		APIScanResult result = apiScanService.scanApi(url);

		byte[] pdf = pdfService.generateHeaderPdf(result);

		return ResponseEntity.ok().header("Content-Disposition", "attachment; filename=Header-Report.pdf")
				.contentType(MediaType.APPLICATION_PDF).body(pdf);
	}

	@GetMapping("/download-swagger-pdf")
	public ResponseEntity<byte[]> downloadSwaggerPdf(@RequestParam String url) {

		SwaggerScanResult result = swaggerScanService.scanSwagger(url);

		byte[] pdf = pdfService.generateSwaggerPdf(result);

		return ResponseEntity.ok().header("Content-Disposition", "attachment; filename=Swagger-Report.pdf")
				.contentType(MediaType.APPLICATION_PDF).body(pdf);
	}

	@GetMapping("/download-jwt-pdf")
	public ResponseEntity<byte[]> downloadJwtPdf(@RequestParam String token) {

		JwtScanResult result = jwtScanService.scanJwt(token);

		byte[] pdf = pdfService.generateJwtPdf(result);

		return ResponseEntity.ok().header("Content-Disposition", "attachment; filename=JWT-Report.pdf")
				.contentType(MediaType.APPLICATION_PDF).body(pdf);
	}

	@GetMapping("/download-owasp-pdf")
	public ResponseEntity<byte[]> downloadOwaspPdf(@RequestParam String url) {

		OwaspScanResult result = owaspScanService.scan(url);

		byte[] pdf = pdfService.generateOwaspPdf(result);

		return ResponseEntity.ok().header("Content-Disposition", "attachment; filename=OWASP-Report.pdf")
				.contentType(MediaType.APPLICATION_PDF).body(pdf);
	}

}
