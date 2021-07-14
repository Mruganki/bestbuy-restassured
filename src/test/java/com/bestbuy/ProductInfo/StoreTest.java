package com.bestbuy.ProductInfo;

import com.bestbuy.CategoriesPojo;
import com.bestbuy.ProductPojo;
import com.bestbuy.StoresPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;



public class StoreTest  {

    @Test
    //GET
    public void getAllStoreInfo() {
        Response response =
                given()
                        .when()
                        .get("http://localhost:3030/stores");
        response.then().statusCode(200);
        response.prettyPrint();

    }
    @Test
    //POST this newly generated id and delete id would be same so always run with newly
    public void createStores(){
        StoresPojo storesPojo = new StoresPojo();
        storesPojo.setName("UK N INDIA Urrban Development");
        storesPojo.setType("Rural");
        storesPojo.setAddress("Britney");
        storesPojo.setAddress2("Seacroft");
        storesPojo.setCity("Morley");
        storesPojo.setState("Vaalri");
        storesPojo.setZip("4520236");
        storesPojo.setLat(5);
//        storesPojo.setLng(30);
//        storesPojo.setHours("3.2");
//        storesPojo.setServices("");


        Response response =
                given()
                        .header("Content-Type","application/json")
                        .body(storesPojo)
                        .when()
                        .post("http://localhost:3030/stores");
        response.then().statusCode(201);
        response.prettyPrint();

    }
    @Test
    //put
    public void updateStoreWithPatch(){

        StoresPojo storesPojo = new StoresPojo();

        storesPojo.setName("Urban and county Development");


        Response response =
                given()
                        .header("Content-Type", "application/json")
                        .body(storesPojo)
                        .when()
                        .patch("http://localhost:3030/stores/8925");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    //Delete
    public void deleteProductInfo() {
        Response response =
                given()
                        .pathParam("id", "8924")//you needto give diffrent id when you run the test
                        .when()
                        .delete("http://localhost:3030/stores/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}





