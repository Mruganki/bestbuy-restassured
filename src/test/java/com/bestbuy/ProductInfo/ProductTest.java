package com.bestbuy.ProductInfo;

import com.bestbuy.ProductPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;

public class ProductTest extends TestBase {
    @Test
    public void getAllProductInfo() {
        Response response =
                given()
                        .when()
                       .get("/products");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void searchProductWithParameter() {


        Response response =
                given()
                       .queryParam("manufacturer","Duracell")
                      // .queryParam("limit",2)
                        .when()
                        .get("/products");
        response.prettyPrint();

    }

    @Test
    public void getSingleProductInfo() {
        Response response =

                given()
                        .pathParam("id",43900)
                        .when()
                        .get("/{id}");
        response.prettyPrint();

    }


    @Test
    public void createProduct(){

        ProductPojo productpojo= new ProductPojo();
        productpojo.setName("SoloerCell");
        productpojo.setType("Motor");
        productpojo.setPrice(80);
        productpojo.setUpc("700099");
        productpojo.setShipping(90);
        productpojo.setDescription("Powercekk90");
        productpojo.setManufacturer("UKPowerltd");
        productpojo.setModel("new8980");
        productpojo.setUrl("fkju200@gmail.com");
        productpojo.setImage("Newmakerinmarket");

        Response response =
                given()
                       .header("Content-Type","application/json")
                        .body(productpojo)
                        .when()
                        .post();
        response.then().statusCode(201);
        response.prettyPrint();

    }
    @Test
    public void updateProductWithPatch(){

        ProductPojo productPojo = new ProductPojo();
        productPojo.setModel("surya");

        Response response =
                given()
                        .header("Content-Type","application/json")
                        .body(productPojo)
                        .when()
                        .put("/127687");
        response.then().statusCode(200);
        response.prettyPrint();

    }
@Test
    public void deleteProductInfo() {
        Response response =
                given()
                        .pathParam("id", "150115")
                        .when()
                        .delete("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
