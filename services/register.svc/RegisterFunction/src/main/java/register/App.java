package register;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import register.models.UrlCreation;

/**
 * Handler for requests to Lambda function.
 */
public class App implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    public APIGatewayProxyResponseEvent handleRequest(final APIGatewayProxyRequestEvent input, final Context context) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("X-Custom-Header", "application/json");

        // create response builder
        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent()
                .withHeaders(headers);
        
        //Map<String, String> pathParams = input.getPathParameters();
        String body = input.getBody();

        try {
            UrlCreation req = new ObjectMapper().readValue(body, UrlCreation.class);

            // Memory
            

            return response
                    .withBody(
                              "{"
                            + String.format("url: {%s}", req.getUrl())
                            + "}"
                    )
                    .withStatusCode(201);

        } catch (Exception e) {
            return response
                .withBody(String.format("Error whilst parsing body! err=[%s]", e.getMessage()))
                .withStatusCode(500);
        }

        // String url = pathParams != null ? pathParams.get("url") : null;

        // if (url == null) {
        //     return response
        //         .withBody("Url is missing!")
        //         .withStatusCode(400);
        // }

        // return response
        //             .withBody("{}")
        //             .withStatusCode(500);
    }
}
