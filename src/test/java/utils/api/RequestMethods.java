package utils.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class RequestMethods {

    private final String baseUrl;

    public RequestMethods(String baseUrl, String endPoint) {
        this.baseUrl = baseUrl;

    }

    private Map<String, String> createTheFormParams(String ClientId, String clientSecret) {
        Map<String, String> formParameters = new HashMap<>();
        formParameters.put("grant_type", "client-credentials");
        formParameters.put("client_id", ClientId);
        formParameters.put("client_scerets", clientSecret);
        return formParameters;
    }

    public String fetchTheOAuthTokenURL(String tokenURL, String ClientId, String clientSecret) {
        Response responseFromTokenURL =
                RestAssured.given().formParams(createTheFormParams(ClientId, clientSecret)).when().post(tokenURL)
                        .then().statusCode(200).log().all()
                        .extract().response();

        return responseFromTokenURL.jsonPath().getString("AccessToken");
    }

    public Response getTheResponse(String endPointURL) {
        String combineURL = baseUrl + endPointURL;
        return RestAssured.given().when().get(combineURL).then().log().all().statusCode(200).extract().response();
    }


}
