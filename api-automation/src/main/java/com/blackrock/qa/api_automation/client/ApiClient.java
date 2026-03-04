package com.blackrock.qa.api_automation.client;

import com.blackrock.qa.api_automation.config.Config;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.time.Duration;

public class ApiClient {

    static {
        String base = Config.getBaseUrl();
        if (base != null && !base.isEmpty()) {
            RestAssured.baseURI = base;
        }
        RestAssured.useRelaxedHTTPSValidation();
        // default timeouts can be configured via RestAssured config if desired
    }

    public static Response post(String path, Object body) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(path)
                .andReturn();
    }
}
