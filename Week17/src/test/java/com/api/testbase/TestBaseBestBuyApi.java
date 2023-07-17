package com.api.testbase;

import com.api.constants.Path;
import com.api.utils.PropertyReader;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

/**
 * Created by bhavesh
 */
public class TestBaseBestBuyApi {
    public static PropertyReader propertyReader;

    @BeforeClass
    public static void init() {
        propertyReader = PropertyReader.getInstance();
        RestAssured.baseURI = propertyReader.getProperty("bestBuy.BaseUrl"); //localhost
        RestAssured.port = Integer.parseInt(propertyReader.getProperty("bestBuy.Port")); //3030
        RestAssured.basePath = Path.PRODUCTS; // /products
    }

}
