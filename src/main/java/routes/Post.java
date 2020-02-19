package routes;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class Post {
        private RequestSpecification request;
        public String routePost = "/create";


        public Post(RequestSpecification requestSpecification) {
            request = requestSpecification;
        }



        public Response createNewRecord() {
            return this.request.post(routePost);
        }
    }

