package com.varomir.rest;

import com.jayway.restassured.RestAssured;
import com.varomir.ddt.TestDataProvider;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class CoinsConverterTest {

    @BeforeSuite
    public void setDefaults() {
        RestAssured.baseURI = "http://127.0.0.1";
        RestAssured.port = 8080;
        RestAssured.basePath = "/service";
    }

    @Test(dataProvider = "UahToCoinsPrice", dataProviderClass = TestDataProvider.class)
    public void coinsPrice(int coins, float expectedUAH) {
        float actualResult = given().
                param("amount", coins).
                get("/coins").body().jsonPath().
                getFloat("payment.amount");
        assertThat("UAH amount was not as expected!", actualResult, equalTo(expectedUAH));
    }

    @Test(dataProvider = "paymentsPositive", dataProviderClass = TestDataProvider.class)
    public void paymentSystem(String paymentSystem, int coinsAmount, float expectedUAH) {
        float actualResult = given().
                param("method", paymentSystem).
                param("amount", coinsAmount).
                get("/buyCoins").body().jsonPath().
                getFloat("payment.amount");
        assertThat("UAH amount was not as expected!", actualResult, equalTo(expectedUAH));
    }

    @Test(dataProvider = "paymentsNegative", dataProviderClass = TestDataProvider.class)
    public void paymentSystemErrors(String paymentSystem, int coinsAmount) {
        String actualResult = given().
                param("method", paymentSystem).
                param("amount", coinsAmount).
                get("/buyCoins").body().jsonPath().
                getString("payment.error");
        assertThat("Something went wrong, error message was not as expected!", actualResult, equalTo("Your amount is too low"));
    }
}
