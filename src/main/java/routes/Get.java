package routes;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class Get {
    private RequestSpecification request;
    public String route = "/employee";

    public Get(RequestSpecification requestSpecification) {
        request = requestSpecification;
    }

    public Response getEmployees() {
        return this.request.get(route + "s");
    }

    public Response getEmployee(int id) {
        return this.request.get(route + "/" + id);
    }
}
