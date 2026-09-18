package model.validation;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.user.User;

import java.io.File;
import java.io.IOException;

public class ValidationOfReponse {


    public static void main(String[] args) throws IOException {

        String pathToTheResponseJson = System.getProperty("user.dir")+"/src/test/resources/apiResponse/response.json";
        File jsonFile = new File(pathToTheResponseJson);
        System.out.println(pathToTheResponseJson);
        ObjectMapper mapper = new ObjectMapper();
        User user= mapper.readValue(jsonFile, User.class);
        System.out.println(user.getCompany_id());
        System.out.println(user.getDepartments().get(0).getHead_count());
    }
}
