package com.bestbuy.extractingreport;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class SearchJasonPath {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then();
    }

    // 1) Extract limit
    @Test
    public void test001() {
        int limit = response.extract().path("limit");


        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total number of limit is: " + limit);
        System.out.println("------------------End of Test---------------------------");

    }

    // 2) Extract total
    @Test
    public void test002() {
        int total = response.extract().path("total");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The search query is: " + total);
        System.out.println("------------------End of Test---------------------------");
    }

    // 3) Extract  name of 5th store "MapleWood"
    @Test
    public void test003() {

        String name = response.extract().path("data[4].name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of 5th store is: " + name);
        System.out.println("------------------End of Test---------------------------");
    }

    // 4) Get All the Names of all stores
    @Test
    public void test004() {

        List<String> name = response.extract().path("data.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of the store are:: " + name);
        System.out.println("------------------End of Test---------------------------");
    }

    //5. Extract the storeId of all the store
    @Test
    public void test005() {

        List<String> storeId = response.extract().path("data.services.storeservices.storeId");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The storeId of store are:: " + storeId);
        System.out.println("------------------End of Test---------------------------");
    }
    //6  Print the size of the data list
    @Test
    public void test006() {

        List<HashMap<String,Object>> list=response.extract().path("data");
        int size= list.size();
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The size of the data is: "+size);
        System.out.println("------------------End of Test---------------------------");
    }
//7. Get all the value of the store where store name = Roseville
@Test
public void test007() {

    List<HashMap<String,?>> values = response.extract().path("data.findAll{it.name=='Roseville'}");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The values for store name Roseville: "+ values);
    System.out.println("------------------End of Test---------------------------");
}
//8. Get the address of the store where store name = Roseville
    @Test
    public void test008() {
        List<String> address = response.extract().path("data.findAll{it.name=='Roseville'}.address");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The address is "+address);
        System.out.println("------------------End of Test---------------------------");
    }
//9. Get all the services of 8th store
@Test
public void test009() {

    List<String> service = response.extract().path("data[7].services");

    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The names of the store are:: " + service);
    System.out.println("------------------End of Test---------------------------");
}

//10. Get storeservices of the store where service name = Best Buy Mobile
@Test
public void test0010() {

    HashMap<String,Integer> storeServices = new HashMap<>();
    storeServices = response.extract().path( "data[0].services[1].storeservices" );


    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The names of the store are:: " + storeServices);
    System.out.println("------------------End of Test---------------------------");
}
    //13. Find the store names Where state = MN
@Test
    public void test013() {

        List<String> name=response.extract().path("data.findAll{it.state=='MN'}.name");



        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of the store are:: " + name);
        System.out.println("------------------End of Test---------------------------");
    }



// 14. Find the Total number of services for the store where store name =
    @Test
     public void test014(){
    List<HashMap<String,Integer>> services=response.extract().path("data[2].services");
    int size=services.size();
    System.out.println("Print the services"+services);
}

//16. Find the name of all services Where store name = “Fargo”

    @Test
    public void test0016(){
        List<HashMap<String,?>> names = response.extract().path("data[6].services.name");
        System.out.println("------------------StartingTest---------------------------"  );
        System.out.println("The search query is: "   +names);
        System.out.println("------------------End of Test---------------------------");

    }
    @Test
    //17. Find the zip of all the store
    public void test017(){
        List<String> zip = response.extract().path( "data.zip" );

        System.out.println("------------------StartingTest---------------------------"  );
        System.out.println("The search query is: "   +zip);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    //18.Find the zip of store name = Minnetonka
    public void test018(){
        String zip = response.extract().path( "data[0].zip" );
        System.out.println("------------------StartingTest---------------------------"  );
        System.out.println("The search query is: "   +zip);
        System.out.println("------------------End of Test---------------------------");

    }
    @Test
    //19. Find the storeservices details of the service name = Samsung Experience
    public void test019(){
        List<HashMap<String,Integer>> storeServices = response.extract().path( "data[2].services.storeServices" );
        System.out.println("------------------StartingTest---------------------------"  );
        System.out.println("The search query is: "   +storeServices);
        System.out.println("------------------End of Test---------------------------");
    }
    @Test
    //20. Find the lat of all the stores
    public void test020(){
        List<Double> lat = response.extract().path( "data.lat" );
        System.out.println("------------------StartingTest---------------------------"  );
        System.out.println("The search query is: "   +lat);
        System.out.println("------------------End of Test---------------------------");

    }



}
