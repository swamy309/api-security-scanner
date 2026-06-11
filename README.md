# 🛡️ CyberRadar - API Security Scanner

## Overview

CyberRadar is a web-based API Security Scanner developed using Java Spring Boot, HTML, CSS, and JavaScript. The tool helps security engineers, developers, and testers analyze API security posture by scanning security headers, Swagger/OpenAPI documentation, JWT tokens, and OWASP Top 10 vulnerabilities.

The application generates detailed security reports and downloadable PDF reports with security scores, risk levels, recommendations, and vulnerability analysis.

---

## Features

### 1. Security Header Scanner

Scans websites and APIs for important HTTP security headers:

* HTTPS
* X-Frame-Options
* Content-Security-Policy (CSP)
* Strict-Transport-Security (HSTS)
* X-Content-Type-Options
* X-XSS-Protection
* Referrer-Policy
* Permissions-Policy
* Access-Control-Allow-Origin
* Cache-Control
* Server Header

### 2. Swagger/OpenAPI Scanner

Analyzes Swagger/OpenAPI specifications and validates:

* HTTPS Usage
* Bearer Authentication
* Global Security Configuration
* Total API Count

### 3. JWT Token Analyzer

Analyzes JWT tokens and extracts:

* Algorithm
* Audience
* Issuer
* Expiration Details
* Token Type
* Risk Score

### 4. OWASP Top 10 Scanner

Performs basic security analysis against OWASP Top 10 risks:

* Broken Access Control
* Cryptographic Failures
* Injection Vulnerabilities
* Security Misconfiguration
* Overall Risk Assessment

---

## PDF Reporting

CyberRadar generates professional PDF reports containing:

* Security Score
* Risk Level
* Scan Results
* Recommendations
* Generated Time
* Target URL
* Executive Summary

Each scanner generates its own dedicated PDF report.

---

## Technology Stack

### Backend

* Java 17
* Spring Boot
* Maven
* REST APIs

### Frontend

* HTML5
* CSS3
* JavaScript

### PDF Generation

* OpenPDF

### JSON Processing

* Jackson
* org.json

---

## Project Architecture

Controller Layer

* ScanController

Service Layer

* ScanService
* SwaggerScanService
* JwtScanService
* OwaspScanService
* PdfService

Model Layer

* ScanResult
* SwaggerScanResult
* JwtScanResult
* OwaspScanResult

---

## Available APIs

| Endpoint      | Description                     |
| ------------- | ------------------------------- |
| /scan         | Security Header Scan            |
| /swagger-scan | Swagger Security Scan           |
| /jwt-scan     | JWT Token Analysis              |
| /owasp-scan   | OWASP Vulnerability Scan        |
| /download-pdf | Download Security Header Report |

---

## Future Enhancements

* SQL Injection Detection
* XSS Detection
* Security Dashboard
* Historical Scan Reports
* User Authentication
* Cloud Deployment
* Advanced Vulnerability Assessment

---

## Author

Swamy Dandu

CyberRadar – Scan • Detect • Secure
