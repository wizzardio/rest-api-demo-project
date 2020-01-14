package routes;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class Get {
    private RequestSpecification request;
    public String route = "/employees";

    public Get(RequestSpecification requestSpecification) {
        request = requestSpecification;
    }

    public Response getEmployees() {
        return this.request.get(route);
    }
}
