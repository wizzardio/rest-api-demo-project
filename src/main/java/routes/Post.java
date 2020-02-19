package routes;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class Post {
        private RequestSpecification request;
        private String route = "/create";

        public Post(RequestSpecification requestSpecification) {
            request = requestSpecification;
        }

        public Response createNewRecord() {
            return this.request.post(route);
        }
    }

