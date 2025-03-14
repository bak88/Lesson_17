package org.example;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostmanEchoTest {

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void testGetRequest() {
        given()
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo("close"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/17.0.13)"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.cache-control", nullValue())
                .body("headers.postman-token", nullValue())
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.cookie", nullValue())
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }

    @Test
    public void testPostRawText() {
        given()
                .body("This is expected to be sent back as part of response body.")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("args", equalTo(Collections.emptyMap()))
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("files", equalTo(Collections.emptyMap()))
                .body("form", equalTo(Collections.emptyMap()))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.content-length", equalTo("58"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("content-type", nullValue())
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/17.0.13)"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.cache-control", nullValue())
                .body("headers.postman-token", nullValue())
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.cookie", nullValue())
                .body("json", nullValue())
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    public void testPostFromData() {
        given()
                .contentType("application/json")
                .body("")
                .when()
                .post("/post")
                .then()
                .body("args", equalTo(Collections.emptyMap()))
                .body("data", equalTo(Collections.emptyMap()))
                .body("files", equalTo(Collections.emptyMap()))
                .body("form.foo1", nullValue())
                .body("form.foo2", nullValue())
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo("close"))
                .body("headers.content-length", equalTo("0"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/17.0.13)"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.cache-control", nullValue())
                .body("headers.postman-token", nullValue())
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.cookie", nullValue())
                .body("headers.content-type", equalTo("application/json"))
                .body("json.foo1", nullValue())
                .body("json.foo2", nullValue())
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    public void testPutRequest() {
        given()
                .contentType("application/json")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .put("/put")
                .then()
                .body("args", equalTo(Collections.emptyMap()))
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("files", equalTo(Collections.emptyMap()))
                .body("form", equalTo(Collections.emptyMap()))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo("close"))
                .body("headers.content-length", equalTo("58"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.content-type", equalTo("application/json"))
                .body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/17.0.13)"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.cache-control", nullValue())
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("json", nullValue())
                .body("url", equalTo("https://postman-echo.com/put"));
    }

    @Test
    public void testPatchRequest() {
        given()
                .body("This is expected to be sent back as part of response body.")
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("args", equalTo(Collections.emptyMap()))
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("files", equalTo(Collections.emptyMap()))
                .body("form", equalTo(Collections.emptyMap()))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.'x-request-start'", notNullValue())
                .body("headers.connection", equalTo("close"))
                .body("headers.'content-length'", equalTo("58"))
                .body("headers.'x-forwarded-proto'", equalTo("https"))
                .body("headers.'x-forwarded-port'", equalTo("443"))
                .body("headers.'x-amzn-trace-id'", notNullValue())
                .body("headers.'content-type'", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers.'user-agent'", equalTo("Apache-HttpClient/4.5.13 (Java/17.0.13)"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.'cache-control'", nullValue())
                .body("headers.'postman-token'", nullValue())
                .body("headers.'accept-encoding'", equalTo("gzip,deflate"))
                .body("headers.cookie", nullValue())
                .body("json", nullValue())
                .body("url", equalTo("https://postman-echo.com/patch"));
    }

    @Test
    public void testDeleteRequest() {
        given()
                .body("This is expected to be sent back as part of response body.")
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("args", equalTo(Collections.emptyMap()))
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("files", equalTo(Collections.emptyMap()))
                .body("form", equalTo(Collections.emptyMap()))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.'x-request-start'", notNullValue())
                .body("headers.connection", equalTo("close"))
                .body("headers.'content-length'", equalTo("58"))
                .body("headers.'x-forwarded-proto'", equalTo("https"))
                .body("headers.'x-forwarded-port'", equalTo("443"))
                .body("headers.'x-amzn-trace-id'", notNullValue())
                .body("headers.'content-type'", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers.'user-agent'", equalTo("Apache-HttpClient/4.5.13 (Java/17.0.13)"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.'cache-control'", nullValue())
                .body("headers.'postman-token'", nullValue())
                .body("headers.'accept-encoding'", equalTo("gzip,deflate"))
                .body("headers.cookie", nullValue())
                .body("json", nullValue())
                .body("url", equalTo("https://postman-echo.com/delete"));
    }
}
