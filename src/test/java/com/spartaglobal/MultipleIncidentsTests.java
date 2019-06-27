package com.spartaglobal;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static  org.hamcrest.Matchers.*;

public class MultipleIncidentsTests {

    static JsonPath jsonBody;


    @BeforeClass
    public static void setup()
    {
        baseURI = "https://bikewise.org";
        basePath = "/api/";
        JSONObject incidents = new JSONObject();
        JSONArray multipleIncidentsType = new JSONArray();

        multipleIncidentsType.add("theft");
        multipleIncidentsType.add("crash");



        jsonBody = given()
                .queryParam("proximity_square", 11)
                .contentType(ContentType.JSON)
                .body(incidents)
                .when()
                .post()
                .then()
                .extract()
                .jsonPath();


    }

    @Test
    public void IncidentTests()
    {
            Assert.assertEquals(200,(int) jsonBody.get("description"));

    }

}
