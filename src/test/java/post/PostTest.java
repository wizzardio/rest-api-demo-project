package post;

import base.BaseTest;
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
    }

    @Test
    public void createNewRecordReturns200() {
        requestSpecification.given().log().all();
        Response response = getRouter.createNewRecord();
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }
}
