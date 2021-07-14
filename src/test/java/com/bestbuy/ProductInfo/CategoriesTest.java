package com.bestbuy.ProductInfo;

import com.bestbuy.CategoriesPojo;
import com.bestbuy.ProductPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CategoriesTest {


@Test
    public void getAllCategories(){
        Response response=
                given()
                        .when()
                        .get("http://localhost:3030/categories");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void createCategories(){

        CategoriesPojo categoriesPojo = new CategoriesPojo();
       categoriesPojo.setName("Tree maintanace");
       categoriesPojo.setId("780");

        Response response =
                given()
                        .header("Content-Type","application/json")
                        .body(categoriesPojo)
                        .when()
                        .post("http://localhost:3030/categories");
        response.then().statusCode(201);
        response.prettyPrint();

    }

    @Test
    public void updateCategoriesWithPatch(){

        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setName("Waterloo Maintanance");
        Response response =
                given()
                        .header("Content-Type","application/json")
                        .body(categoriesPojo)
                        .when()
                        .put("http://localhost:3030/categories/780");
        response.then().statusCode(204);
        response.prettyPrint();

    }

@Test
    public void updateProductWithPatch() {
        CategoriesPojo categoriesPojo=new CategoriesPojo();
        categoriesPojo.setName("hhh");

        Response response =
                given()
                        .header("Content-Type", "application/json")
                        .body(categoriesPojo)
                        .when()
                        .patch("http://localhost:3030/categories/780");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void deleteProductInfo() {
        Response response =
                given()
                        .pathParam("id", "780")
                        .when()
                        .delete("http://localhost:3030/categories/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}







