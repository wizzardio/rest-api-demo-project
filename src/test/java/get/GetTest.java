package get;

import base.BaseTest;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import routes.Get;

public class GetTest extends BaseTest {

    Get getRouter;

    @BeforeTest
    public void beforeTest() {
        getRouter = new Get(this.requestSpecification);
    }

    @Test
    public void getAllEmployeesReturns200() {
        requestSpecification.given().log().all();
        Response response = getRouter.getEmployees();
        int statusCode = response.getStatusCode();
        response.prettyPrint();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void getSingleEmployeeReturns200() {
        requestSpecification.given().log().all();
        Response response = getRouter.getEmployee(1);
        int statusCode = response.getStatusCode();
        response.prettyPrint();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void getSwapReturns200() {
        requestSpecification.given().log().all();
        Response response = getRouter.getSwap(1);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void getSwapResponseContainsName() {
        requestSpecification.given().log().all();
        Response response = getRouter.getSwap(1);
        String jsonResponseAsString = response.asString();
        System.out.println(jsonResponseAsString);
        String json = response.body().asString();
        JsonPath jsonPath = new JsonPath(json);
        Assert.assertEquals("Luke Skywalker", jsonPath.getString("name"));
    }
}
