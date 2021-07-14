package com.bestbuy.ProductInfo;

import com.bestbuy.ProductPojo;
import com.bestbuy.ServicesPojo;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ServiceTest {


        @Test
        //Get
        public void getAllServices(){
          io.restassured.response.Response response =
                  given()
                          .when()
                          .get("http://localhost:3030/services");
            response.then().statusCode(200);
            response.prettyPrint();

        }
        @Test
        //Post-id 22 is automatically generated and i delete that 22 id
        public void createNewService(){
            ServicesPojo servicesPojo = new ServicesPojo();
          servicesPojo.setName("fff");

            Response response =
                    given()
                            .header("Content-Type","application/json")
                            .body(servicesPojo)
                            .when()
                            .post("http://localhost:3030/services");
            response.then().statusCode(201);
            response.prettyPrint();
        }
        @Test
        //Patch
        public void updateServiceData(){
            ServicesPojo servicesPojo = new ServicesPojo();
            servicesPojo.setName("Water Colour enterprise");

            io.restassured.response.Response response =
                    given()
                            .header("Content-Type","application/json")
                            .body(servicesPojo)
                            .when()
                            .put("780");
            response.then().statusCode(200);
            response.prettyPrint();
        }
        @Test
        //Delete
        public void deleteServices(){
            io.restassured.response.Response response =
                    given()
                            .pathParam("id", "22")
                            .when()
                            .delete("/{id}");
            response.then().statusCode(404);
            response.prettyPrint();


        }
    }

