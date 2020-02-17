package get;

import base.BaseTest;
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
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void getSingleEmployeeReturns200() {
        requestSpecification.given().log().all();
        Response response = getRouter.getEmployee(1);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }
}
