package put;

import base.BaseTest;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.filter.log.RequestLoggingFilter;
import com.jayway.restassured.filter.log.ResponseLoggingFilter;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import routes.Post;
import routes.Put;

public class PutTest extends BaseTest {

    Put getRouter;

    @BeforeTest
    public void beforeTest() {
        getRouter = new Put(this.requestSpecification);
        RestAssured.requestSpecification = requestSpecification.given();
    }

    @Test
    public void updateResourceReturns200() {
        String putBodyJson = "{\n" +
                "\t\"JSON.stringify\":{ \n" +
                "\t\"title\": \"foo\",\n" +
                "}";
        RestAssured.requestSpecification = requestSpecification.given();
        requestSpecification.given().body(putBodyJson).log().all();
        Response response = getRouter.updateResourse();
        int statusCode = response.getStatusCode();
        requestSpecification.accept(ContentType.JSON);
        response.prettyPrint();
        Assert.assertEquals(statusCode, 200);
    }
}
