package delete;

import base.BaseTest;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import routes.Delete;
import routes.Put;

public class DeleteTest extends BaseTest {

    Delete getRouter;

    @BeforeTest
    public void beforeTest() {
        getRouter = new Delete(this.requestSpecification);
        RestAssured.requestSpecification = requestSpecification.given();
    }

    @Test
    public void deleteResourceReturns200() {
        RestAssured.requestSpecification = requestSpecification.given();
        Response response = getRouter.deleteResource();
        int statusCode = response.getStatusCode();
        requestSpecification.accept(ContentType.JSON);
        response.prettyPrint();
        Assert.assertEquals(statusCode, 200);
    }
}
