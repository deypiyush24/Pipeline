package utils.api;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

public class APITesting {

    public static void main(String[] args) throws JsonProcessingException {
        System.out.println("API Testing");

        Map<String,String> formParameters = new HashMap<>();
        formParameters.put("grant_type","cilent-credentials");
        formParameters.put("client_id","6790cjvcoup87");
        formParameters.put("client_scerets","6790cjvcoup87");
        String tokenURL ="PiyushURL";



      Response responseFromTokenURL =
              RestAssured.given().formParams(formParameters).when().post(tokenURL)
                      .then().statusCode(200).log().all()
                      .extract().response();



        String token = responseFromTokenURL.jsonPath().getString("AccessToken");

        String combineUrl = "BASEURL" + "EndpointURL";

        Response finalResponseFromEndpoint = RestAssured.given().header ("Authorisation", "Bearer " + token).when().get(combineUrl).then().log().all().
                statusCode(200).extract().response();

        finalResponseFromEndpoint.jsonPath().getString("access_token");


        String bearerToken = String.format("Bearer %s",token);

         Response value = RestAssured.given().header("Authorisation", " Bearer Token").when().get(combineUrl).then().log().all().statusCode(200).extract().response();
         value.jsonPath().getString("token");
         Response ResponSeFromAPI = RestAssured.given().header("Authorisation", "Token").when().get(combineUrl).then().log().all().statusCode(200).extract().response();



    }
}
