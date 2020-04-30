package routes;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class Put {
        private RequestSpecification request;
        private String route = "https://jsonplaceholder.typicode.com/posts/1";

        public Put(RequestSpecification requestSpecification) {
            request = requestSpecification;
        }

        public Response updateResourse() {
            return this.request.put(route);
        }
    }

