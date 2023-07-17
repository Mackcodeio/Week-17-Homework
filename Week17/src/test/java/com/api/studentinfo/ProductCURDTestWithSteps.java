package com.api.studentinfo;

import com.api.testbase.TestBaseBestBuyApi;
import com.api.utils.TestUtils;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(SerenityRunner.class)
public class ProductCURDTestWithSteps extends TestBaseBestBuyApi {

    static String name = "Energizer" + TestUtils.getRandomValue();
    static String type = "hardgood";
    static int price = 499;
    static String upc = "499" + TestUtils.getRandomValue();
    static int shipping = 0;
    static String description = "4-pack AA alkaline batteries; battery tester included";
    static String manufacturer = "any";
    static String model = "model D";
    static String setUrl = "http://www.bestbuy.com/site/energizer-max-batteries-aa-4-pack/150115.p?id=1051384046217&skuId=150115&cmp=RMXCC";
    static int idNumber;

    @Steps
    ProdtSteps prodtSteps;


    @Test
    public void test001() {


    }


    @Test
    public void test002() {

    }


    @Test
    public void test003() {


//
    }


    @Test
    public void test004() {

//
    }

}
