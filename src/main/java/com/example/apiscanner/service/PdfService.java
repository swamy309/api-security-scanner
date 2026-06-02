package com.example.apiscanner.service;

import java.io.ByteArrayOutputStream;
import org.springframework.stereotype.Service;
import com.example.apiscanner.model.ScanResult;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class PdfService {

	public byte[] generatePdf(ScanResult result) {

		try {

			Document document = new Document();

			ByteArrayOutputStream out = new ByteArrayOutputStream();

			PdfWriter.getInstance(document, out);

			document.open();

			document.add(new Paragraph("API Security Scan Report"));
			document.add(new Paragraph(" "));

			document.add(new Paragraph("URL: " + result.getUrl()));
			document.add(new Paragraph("HTTPS: " + result.getHttps()));
			document.add(new Paragraph("X-Frame-Options: " + result.getxFrameOptions()));
			document.add(new Paragraph("Content-Security-Policy: " + result.getContentSecurityPolicy()));
			document.add(new Paragraph("HSTS: " + result.getStrictTransportSecurity()));

			document.close();

			return out.toByteArray();

		} catch (Exception e) {

			throw new RuntimeException(e);
		}
	}

}
