package base;

import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;
import rest.Rest;

public class BaseTest {
    protected RequestSpecification requestSpecification;

    @BeforeSuite
    public void beforeSuite() {
        Rest rest = new Rest();
        requestSpecification = rest.getRequestSpecification();
    }
}
