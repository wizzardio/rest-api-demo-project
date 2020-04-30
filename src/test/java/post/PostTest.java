package post;

import base.BaseTest;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.filter.log.RequestLoggingFilter;
import com.jayway.restassured.filter.log.ResponseLoggingFilter;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import routes.Post;

public class PostTest extends BaseTest {

    Post getRouter;

    @BeforeTest
    public void beforeTest() {
        getRouter = new Post(this.requestSpecification);
        RestAssured.requestSpecification = requestSpecification.given();
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @Test
    public void createEmployeeRecordReturns201() {
        String postBodyJson = "{\n" +
                "\"name\":\"Doris Wildert\",\n" +
                "\"salary\":\"85600\",\n" +
                "\"age\":\"23\",\n"+
                "}";
        RestAssured.requestSpecification = requestSpecification.given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.given().body(postBodyJson).log().all();
        Response response = getRouter.createResourcePlaceholder();
        int statusCode = response.getStatusCode();
        response.prettyPrint();
        Assert.assertEquals(statusCode, 201);
    }

    @Test
    public void postWithJson() {
        String postBodyJsonplaseholder = "{\n" +
                "\t\"JSON.stringify\":{ \n" +
                "\t\"title\": \"foo\",\n" +
                "\t\"body\": \"bar\",\n" +
                "\t\"userId\": 1}\n" +
                "}";
        RestAssured.requestSpecification = requestSpecification.given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.given().body(postBodyJsonplaseholder).log().all();
        Response response = getRouter.createResourcePlaceholder();
        int statusCode = response.getStatusCode();
        response.prettyPrint();
        Assert.assertEquals(statusCode, 201);
    }

    @Test
    public void checkResponceBodyPostWithJson() {
        String postBodyJsonplaseholder = "{\n" +
                "\t\"JSON.stringify\":{ \n" +
                "\t\"title\": \"foo\",\n" +
                "\t\"body\": \"bar\",\n" +
                "\t\"userId\": 1}\n" +
                "}";
        RestAssured.requestSpecification = requestSpecification.given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.given().body(postBodyJsonplaseholder).log().all();
        Response response = getRouter.createResourcePlaceholder();
        String json = response.body().asString();
        JsonPath jsonPath = new JsonPath(json);
        Assert.assertEquals("101", jsonPath.getString("id"));
    }
}
