package com.varomir.ddt;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestDataProvider {

    @DataProvider(name = "UahToCoinsPrice", parallel=true)
    public static Iterator<Object[]> createDataC0001() {
        List<Object[]> data = new ArrayList<Object[]>();

        data.add(new Object[] {-20, 0.0f});     //-20x ? = ???.?
        data.add(new Object[] {-1, 0.0f});      //-1x ? = ???.?
        data.add(new Object[] {0, 0.0f});       //0x0.5 = 0.0

        data.add(new Object[] {1, 0.5f});       //1x0.5 = 0.5
        data.add(new Object[] {3, 1.5f});       //3x0.5 = 1.5
        data.add(new Object[] {5, 2.5f});       //5x0.5 = 2.5

        data.add(new Object[] {6, 2.9f});       //5x0.5 + 1x0.4 = 2.9
        data.add(new Object[] {9, 4.1f});       //5x0.5 + 4x0.4 = 4.1
        data.add(new Object[] {10, 4.5f});      //5x0.5 + 5x0.4 = 4.5
        
        data.add(new Object[] {11, 4.8f});      //5x0.5 + 5x0.4 + 1x0.3 = 4.8
        data.add(new Object[] {15, 6.0f});      //5x0.5 + 5x0.4 + 5x0.3 = 6.0
        data.add(new Object[] {20, 7.5f});      //5x0.5 + 5x0.4 + 10x0.3 = 7.5

        data.add(new Object[] {21, 7.7f});      //5x0.5 + 5x0.4 + 10x0.3 + 1x0.2 = 7.7
        data.add(new Object[] {31, 9.7f});      //5x0.5 + 5x0.4 + 10x0.3 + 11x0.2 = 9.7
        data.add(new Object[] {40, 11.5f});     //5x0.5 + 5x0.4 + 10x0.3 + 20x0.2 = 11.5

        data.add(new Object[] {41, 11.65f});    //5x0.5 + 5x0.4 + 10x0.3 + 20x0.2 + 1x0.15 = 11.65
        data.add(new Object[] {49, 12.85f});    //5x0.5 + 5x0.4 + 10x0.3 + 20x0.2 + 9x0.15 = 12.85
        data.add(new Object[] {60, 14.5f});     //5x0.5 + 5x0.4 + 10x0.3 + 20x0.2 + 20x0.15 = 14.5

        data.add(new Object[] {61, 14.6f});     //5x0.5 + 5x0.4 + 10x0.3 + 20x0.2 + 20x0.15 + 1x0.1 = 14.6
        data.add(new Object[] {65, 15.0f});     //5x0.5 + 5x0.4 + 10x0.3 + 20x0.2 + 20x0.15 + 5x0.1 = 15.0
        data.add(new Object[] {115, 20.0f});    //5x0.5 + 5x0.4 + 10x0.3 + 20x0.2 + 20x0.15 + 55x0.1 = 20.0
        data.add(new Object[] {915, 100.0f});    //5x0.5 + 5x0.4 + 10x0.3 + 20x0.2 + 20x0.15 + 855x0.1 = 100.0
        data.add(new Object[] {65536, 6562.1f});  //5x0.5 + 5x0.4 + 10x0.3 + 20x0.2 + 20x0.15 + 65476x0.1 = 6562.1
        data.add(new Object[] {100059, 10014.4f});  //5x0.5 + 5x0.4 + 10x0.3 + 20x0.2 + 20x0.15 + 99999x0.1 = 10014.4
        data.add(new Object[] {100060, 10014.5f});  //5x0.5 + 5x0.4 + 10x0.3 + 20x0.2 + 20x0.15 + 100000x0.1 = 10014.5
        data.add(new Object[] {200060, 20014.5f});  //5x0.5 + 5x0.4 + 10x0.3 + 20x0.2 + 20x0.15 + 200000x0.1 = 20014.5

        return data.iterator();
    }

    @DataProvider(name = "paymentsPositive", parallel=true)
    public static Iterator<Object[]> createDataC0002() {
        List<Object[]> data = new ArrayList<Object[]>();

        data.add(new Object[] {"paypal", 115, 20.0f});
        data.add(new Object[] {"paypal", 215, 30.0f});

        data.add(new Object[] {"ideal", -4, 0.0f});
        data.add(new Object[] {"ideal", 0, 1.0f});
        data.add(new Object[] {"ideal", 2, 2.0f});
        data.add(new Object[] {"ideal", 115, 21.0f});
        data.add(new Object[] {"ideal", 164, 25.9f});
        data.add(new Object[] {"ideal", 165, 25.0f});
        data.add(new Object[] {"ideal", 315, 40.0f});

        data.add(new Object[] {"creditcard", -4, 0.0f});
        data.add(new Object[] {"creditcard", 0, 0.0f});
        data.add(new Object[] {"creditcard", 1, 0.51f});
        data.add(new Object[] {"creditcard", 2, 1.02f});
        data.add(new Object[] {"creditcard", 115, 20.4f});
        data.add(new Object[] {"creditcard", 164, 25.398f});
        data.add(new Object[] {"creditcard", 165, 25.25f});
        data.add(new Object[] {"creditcard", 315, 40.4f});
        data.add(new Object[] {"creditcard", 414, 50.399f});
        data.add(new Object[] {"creditcard", 415, 50.0f});
        data.add(new Object[] {"creditcard", 1915, 200.0f});

        return data.iterator();
    }

    @DataProvider(name = "paymentsNegative", parallel=true)
    public static Iterator<Object[]> createDataC0003() {
        List<Object[]> data = new ArrayList<Object[]>();

        data.add(new Object[] {"paypal", -415});
        data.add(new Object[] {"paypal", 0});
        data.add(new Object[] {"paypal", 42});
        data.add(new Object[] {"paypal", 114});

        return data.iterator();
    }
}
