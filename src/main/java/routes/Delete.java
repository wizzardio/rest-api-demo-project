package routes;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class Delete {
        private RequestSpecification request;
        private String route = "https://jsonplaceholder.typicode.com/posts/1";

        public Delete(RequestSpecification requestSpecification) {
            request = requestSpecification;
        }

        public Response deleteResource() {
            return this.request.delete(route);
        }
    }

