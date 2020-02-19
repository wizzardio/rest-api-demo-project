package routes;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class Get {
    private RequestSpecification request;
    public String routeGet = "/employee";
    //public String routePost = "/create";


    public Get(RequestSpecification requestSpecification) {
        request = requestSpecification;
    }

    public Response getEmployees() {
        return this.request.get(routeGet + "s");
    }

    public Response getEmployee (int id) {
        return this.request.get(routeGet + "/" + id);
    }
}
