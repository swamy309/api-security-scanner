package com.example.apiscanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiscanner.model.JwtScanResult;
import com.example.apiscanner.model.OwaspScanResult;
import com.example.apiscanner.model.ScanResult;
import com.example.apiscanner.model.SwaggerScanResult;
import com.example.apiscanner.service.JwtScanService;
import com.example.apiscanner.service.OwaspScanService;
import com.example.apiscanner.service.PdfService;
import com.example.apiscanner.service.ScanService;
import com.example.apiscanner.service.SwaggerScanService;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RestController
public class ScanController {

	@Autowired
	private ScanService scanService;

	@GetMapping("/scan")
	public ScanResult scan(@RequestParam String url) {

		return scanService.scanApi(url);
	}

	@Autowired
	private SwaggerScanService swaggerScanService;

	@GetMapping("/swagger-scan")
	public SwaggerScanResult scanSwagger(@RequestParam String url) {

		return swaggerScanService.scanSwagger(url);
	}

	@Autowired
	private PdfService pdfService;

	@GetMapping("/download-pdf")
	public ResponseEntity<byte[]> downloadPdf(@RequestParam String url) {

		ScanResult result = scanService.scanApi(url);

		byte[] pdf = pdfService.generatePdf(result);

		return ResponseEntity.ok().header("Content-Disposition", "attachment; filename=security-report.pdf")
				.contentType(MediaType.APPLICATION_PDF).body(pdf);
	}

	@Autowired
	private JwtScanService jwtScanService;

	@GetMapping("/jwt-scan")
	public JwtScanResult scanJwt(@RequestParam String token) {

		return jwtScanService.scanJwt(token);
	}

	@Autowired
	private OwaspScanService service;

	@GetMapping("/owasp-scan")
	public OwaspScanResult scanOwasp(@RequestParam String url) {

		return service.scan(url);
	}

}
