async function scanApi() {

    const url =
        document.getElementById("url").value;

    const resultDiv =
        document.getElementById("result");

    const errorDiv =
        document.getElementById("urlError");

    errorDiv.innerHTML = "";

    if (!url) {

        errorDiv.innerHTML =
            "Please enter Website URL";

        document.getElementById("url").style.border =
            "2px solid #ef4444";

        return;
    }

    // Validation passed
    document.getElementById("url").style.border =
        "1px solid #334155";
    const loader =
        document.getElementById("loader");


    // SHOW LOADER

    loader.style.display =
        "block";

    resultDiv.innerHTML = "";

    try {

        const response =
            await fetch(
                `http://localhost:9090/scan?url=${url}`
            );

        const data =
            await response.json();

        // HIDE LOADER

        loader.style.display =
            "none";

        function getStatusColor(value) {

            if (value === "Missing" ||
                value === "Not Enabled") {

                return "red";
            }

            return "green";
        }

        resultDiv.innerHTML = `
        
<h2>Scan Results</h2>

<div class="result-card">
<b>URL:</b> ${data.url}
</div>

<div class="result-card" style="color:${getStatusColor(data.https)}">
<b>HTTPS:</b> ${data.https}
</div>

<div class="result-card" style="color:${getStatusColor(data.xFrameOptions)}">
<b>X-Frame-Options:</b> ${data.xFrameOptions}
</div>

<div class="result-card" style="color:${getStatusColor(data.contentSecurityPolicy)}">
<b>Content Security Policy:</b> ${data.contentSecurityPolicy}
</div>

<div class="result-card" style="color:${getStatusColor(data.strictTransportSecurity)}">
<b>Strict Transport Security:</b> ${data.strictTransportSecurity}
</div>

<div class="result-card" style="color:${getStatusColor(data.xContentTypeOptions)}">
<b>X-Content-Type-Options:</b> ${data.xContentTypeOptions}
</div>

<div class="result-card" style="color:${getStatusColor(data.xXssProtection)}">
<b>X-XSS-Protection:</b> ${data.xXssProtection}
</div>

<div class="result-card" style="color:${getStatusColor(data.referrerPolicy)}">
<b>Referrer Policy:</b> ${data.referrerPolicy}
</div>

<div class="result-card" style="color:${getStatusColor(data.permissionsPolicy)}">
<b>Permissions Policy:</b> ${data.permissionsPolicy}
</div>

<div class="result-card" style="color:${getStatusColor(data.accessControlAllowOrigin)}">
<b>Access-Control-Allow-Origin:</b> ${data.accessControlAllowOrigin}
</div>

<div class="result-card" style="color:${getStatusColor(data.cacheControl)}">
<b>Cache-Control:</b> ${data.cacheControl}
</div>

<div class="result-card" style="color:${getStatusColor(data.server)}">
<b>Server:</b> ${data.server}
</div>

`;
        document.getElementById("apiPdfBtn")
            .style.display = "inline-block";

    } catch (error) {

        loader.style.display = "none";

        document.getElementById("apiPdfBtn")
            .style.display = "none";

        resultDiv.innerHTML =
            "Error: " + error;
    }
}

async function scanSwagger() {

    const url =
        document.getElementById("swaggerUrl").value;

    const resultDiv =
        document.getElementById("result");

    const errorDiv =
        document.getElementById("swaggerError");

    errorDiv.innerHTML = "";

    if (!url) {
        errorDiv.innerHTML =
            "Please enter Swagger/OpenAPI URL";
        document.getElementById("url").style.border =
            "2px solid #ef4444";
        return;
    }

    // Validation passed
    document.getElementById("url").style.border =
        "1px solid #334155";

    document.getElementById("swaggerUrl")
        .style.border =
        "1px solid #334155";
    const loader =
        document.getElementById("loader");

    loader.style.display = "block";

    resultDiv.innerHTML = "";

    try {

        const response =
            await fetch(
                `http://localhost:9090/swagger-scan?url=${url}`
            );

        const data =
            await response.json();

        loader.style.display = "none";

        function getStatusColor(value) {

            if (value === "Missing" ||
                value === "Not Enabled") {

                return "red";
            }

            return "green";
        }

        resultDiv.innerHTML = `

<h2>Swagger Scan Results</h2>

<div class="result-card">
<b>Swagger URL:</b>
${data.swaggerUrl}
</div>

<div class="result-card"
style="color:${getStatusColor(data.https)}">

<b>HTTPS:</b>
${data.https}

</div>

<div class="result-card"
style="color:${getStatusColor(data.bearerAuth)}">

<b>Bearer Authentication:</b>
${data.bearerAuth}

</div>

<div class="result-card"
style="color:${getStatusColor(data.globalSecurity)}">

<b>Global Security:</b>
${data.globalSecurity}

</div>

<div class="result-card">

<b>Total APIs:</b>
${data.totalApis}

</div>

`;
        document.getElementById("swaggerPdfBtn")
            .style.display = "inline-block";

    } catch (error) {

        loader.style.display = "none";

        document.getElementById("swaggerPdfBtn")
            .style.display = "none";

        resultDiv.innerHTML =
            "Error: " + error;
    }
}

//JWT Token scanner function
async function scanJwt() {

    const token = document.getElementById("jwtToken").value.trim();
    const resultDiv = document.getElementById("result");

    const errorDiv =
        document.getElementById("jwtError");

    errorDiv.innerHTML = "";


    if (!token) {

        errorDiv.innerHTML =
            "Please enter JWT Token";

        document.getElementById("jwtToken").style.border =
            "2px solid #ef4444";

        return;
    }

    // Validation passed
    document.getElementById("jwtToken").style.border =
        "1px solid #334155";

    document.getElementById("jwtToken")
        .style.border =
        "1px solid #334155";

    document.getElementById("loader").style.display = "block";

    try {

        const response = await fetch(
            `http://localhost:9090/jwt-scan?token=${encodeURIComponent(token)}`
        );

        if (!response.ok) {
            throw new Error("Server Error: " + response.status);
        }

        const data = await response.json();

        console.log("JWT RESPONSE:", data);

        resultDiv.innerHTML = `
            <div class="result-card">
                <h2>JWT Analysis Result</h2>

                <p><b>Algorithm:</b> ${data.algorithm ?? "N/A"}</p>
                <p><b>Audience:</b> ${data.audience ?? "N/A"}</p>
                <p><b>Expiration:</b> ${data.expiration ?? "N/A"}</p>
                <p><b>Issuer:</b> ${data.issuer ?? "N/A"}</p>
                <p><b>Risk Score:</b> ${data.riskScore ?? "N/A"}</p>
                <p><b>Token Type:</b> ${data.tokenType ?? "N/A"}</p>
            </div>
        `;

    } catch (error) {
        console.error(error);
        resultDiv.innerHTML = "<p style='color:red;'>" + error.message + "</p>";
    } finally {
        document.getElementById("loader").style.display = "none";
    }
}
// funtion method for scanOwasp
async function scanOwasp() {

    const url =
        document.getElementById("owaspUrl").value;

    const resultDiv =
        document.getElementById("result");
    const errorDiv =
        document.getElementById("owaspError");

    errorDiv.innerHTML = "";


    if (!url) {

        errorDiv.innerHTML =
            "Please enter Website URL";

        document.getElementById("url").style.border =
            "2px solid #ef4444";

        return;
    }

    // Validation passed
    document.getElementById("url").style.border =
        "1px solid #334155";

    document.getElementById("owaspUrl")
        .style.border =
        "1px solid #334155";
    try {

        const response =
            await fetch(
                `http://localhost:9090/owasp-scan?url=${encodeURIComponent(url)}`
            );

        const data =
            await response.json();

        resultDiv.innerHTML = `

        <h2>OWASP Top 10 Report</h2>

        <div class="result-card">
        <b>Broken Access Control:</b>
        ${data.brokenAccessControl}
        </div>

        <div class="result-card">
        <b>Cryptographic Failures:</b>
        ${data.cryptographicFailures}
        </div>

        <div class="result-card">
        <b>Injection Risk:</b>
        ${data.injectionRisk}
        </div>

        <div class="result-card">
        <b>Security Misconfiguration:</b>
        ${data.securityMisconfiguration}
        </div>

        <div class="result-card">
        <b>Overall Risk:</b>
        ${data.overallRisk}
        </div>
        <div class="result-card">
<b>Insecure Design:</b>
${data.insecureDesign}
</div>

<div class="result-card">
<b>Vulnerable Components:</b>
${data.vulnerableComponents}
</div>

<div class="result-card">
<b>Identification Failures:</b>
${data.identificationFailures}
</div>

<div class="result-card">
<b>Software Integrity Failures:</b>
${data.softwareIntegrityFailures}
</div>

<div class="result-card">
<b>Logging Failures:</b>
${data.loggingFailures}
</div>

<div class="result-card">
<b>SSRF Risk:</b>
${data.ssrfRisk}
</div>

<div class="result-card">
<b>Risk Score:</b>
${data.riskScore}/100
</div>

        `;
    }
    catch (error) {

        resultDiv.innerHTML =
            "Error: " + error.message;
    }
}

// downloadAPIPDF 
function downloadApiPdf() {

    const url =
        document.getElementById("url").value;

    if (!url) {

        alert("Please enter a website URL");

        return;
    }

    window.open(
        `http://localhost:9090/download-pdf?url=${encodeURIComponent(url)}`,
        "_blank"
    );
}

//  downloadSwaggerPdf
function downloadSwaggerPdf() {

    const url =
        document.getElementById("swaggerUrl").value;

    if (!url) {

        alert("Please enter a Swagger URL");

        return;
    }

    window.open(
        `http://localhost:9090/download-swagger-pdf?url=${encodeURIComponent(url)}`,
        "_blank"
    );
}

//showApiScanner

function showApiScanner() {

    document.getElementById("apiScanner").style.display = "block";
    document.getElementById("swaggerScanner").style.display = "none";
    document.getElementById("jwtScanner").style.display = "none";
    document.getElementById("owaspScanner").style.display = "none";

    document.getElementById("apiTab").classList.add("active");
    document.getElementById("swaggerTab").classList.remove("active");
    document.getElementById("jwtTab").classList.remove("active");
    document.getElementById("owaspTab").classList.remove("active");

    document.getElementById("result").innerHTML = "";
}

//showSwaggerScanner
function showSwaggerScanner() {

    document.getElementById("apiScanner").style.display = "none";
    document.getElementById("swaggerScanner").style.display = "block";
    document.getElementById("jwtScanner").style.display = "none";
    document.getElementById("owaspScanner").style.display = "none";

    document.getElementById("apiTab").classList.remove("active");
    document.getElementById("swaggerTab").classList.add("active");
    document.getElementById("jwtTab").classList.remove("active");
    document.getElementById("owaspTab").classList.remove("active");

    document.getElementById("result").innerHTML = "";
}

//showJwtScanner

function showJwtScanner() {

    document.getElementById("apiScanner").style.display = "none";
    document.getElementById("swaggerScanner").style.display = "none";
    document.getElementById("jwtScanner").style.display = "block";
    document.getElementById("owaspScanner").style.display = "none";

    document.getElementById("apiTab").classList.remove("active");
    document.getElementById("swaggerTab").classList.remove("active");
    document.getElementById("jwtTab").classList.add("active");
    document.getElementById("owaspTab").classList.remove("active");

    document.getElementById("result").innerHTML = "";
}

//showOwaspScanner

function showOwaspScanner() {

    document.getElementById("apiScanner").style.display = "none";
    document.getElementById("swaggerScanner").style.display = "none";
    document.getElementById("jwtScanner").style.display = "none";
    document.getElementById("owaspScanner").style.display = "block";

    document.getElementById("apiTab").classList.remove("active");
    document.getElementById("swaggerTab").classList.remove("active");
    document.getElementById("jwtTab").classList.remove("active");
    document.getElementById("owaspTab").classList.add("active");

    document.getElementById("result").innerHTML = "";
}

// resetScanner

function resetScanner() {

    document.getElementById("url").value = "";
    document.getElementById("swaggerUrl").value = "";
    document.getElementById("jwtToken").value = "";
    document.getElementById("owaspUrl").value = "";

    document.getElementById("result").innerHTML = "";

    document.getElementById("apiPdfBtn").style.display = "none";
    document.getElementById("swaggerPdfBtn").style.display = "none";

    document.getElementById("urlError").innerHTML = "";
    document.getElementById("swaggerError").innerHTML = "";
    document.getElementById("jwtError").innerHTML = "";
    document.getElementById("owaspError").innerHTML = "";

    // Reset Borders
    document.getElementById("url").style.border =
        "1px solid #334155";

    document.getElementById("swaggerUrl").style.border =
        "1px solid #334155";

    document.getElementById("jwtToken").style.border =
        "1px solid #334155";

    document.getElementById("owaspUrl").style.border =
        "1px solid #334155";

    showApiScanner();
}



