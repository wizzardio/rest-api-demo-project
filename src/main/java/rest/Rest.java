package rest;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.specification.RequestSpecification;

public class Rest {
    public String baseURI = "http://dummy.restapiexample.com/api/v1";

    public Rest() {
        RestAssured.baseURI = baseURI;
    }

    public RequestSpecification getRequestSpecification() {
        return RestAssured.given();
    }
}
