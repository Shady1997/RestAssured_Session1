package reqres;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetMethodUsingRestAssured {

    public static void main(String[] args) {
        // Step 1: get and store response of get request to list all users
        Response getAllUsers= RestAssured.given().baseUri("https://reqres.in/")
                .basePath("/api/users")
                .queryParam("page","2")
                .when().get();
        // Step 2: print response returned from server
        getAllUsers.prettyPrint();

        // Step 3: count return object
            // 1- convert json to string
        JsonPath jsonPath= new JsonPath(getAllUsers.asString());
            // 2- store data size in int variable
        int dataSize=jsonPath.getInt("data.size()");
            // 3- print data size
        System.out.println(dataSize);
        // print first id in data array
        System.out.println(jsonPath.get("data[1].email").toString());

        // create soft assertion object
    }
}
