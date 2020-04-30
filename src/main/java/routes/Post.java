package routes;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class Post {
        private RequestSpecification request;
        private String route = "/create";
        private String placeholderRoute = "https://jsonplaceholder.typicode.com/posts";

        public Post(RequestSpecification requestSpecification) {
            request = requestSpecification;
        }

        public Response createNewRecord() {
            return this.request.post(route);
        }

        public Response createResourcePlaceholder() {
        return this.request.post(placeholderRoute);
        }
    }

