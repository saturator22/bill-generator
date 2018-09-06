package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BillGeneratorTest {
    BillGenerator billGenerator = new BillGenerator();
    DataParser dataParser;
    List<Product> productList;
    List<Integer> basket;

    @Test
    void test_fillBasket() {
        dataParser = new DataParser("resources/barcodesTest.txt");
        basket = dataParser.parseTXT();

        billGenerator.fillBasket(basket);

        assertEquals(3, billGenerator.getBasket().size());
        assertEquals(new Integer(1), billGenerator.getBasket().get(new Integer(1001)));
    }

    @Test
    void test_generateBillForNoDiscounts() {
        dataParser = new DataParser("resources/productsTest.csv");
        productList = dataParser.parse();
        dataParser.setFilePath("resources/barcodesTest.txt");
        basket = dataParser.parseTXT();
        billGenerator.fillBasket(basket);

        double bill = billGenerator.generateBill(productList);

        assertEquals(4.55, bill);
    }

    @Test
    void test_generateBillWithDiscounts() {
        dataParser = new DataParser("resources/barcodesTestDiscounts.txt");
        List<Integer> barcodes = dataParser.parseTXT();
        billGenerator.fillBasket(barcodes);
        dataParser.setFilePath("resources/products.csv");
        List<Product> productsList = dataParser.parse();

        double bill = billGenerator.generateBill(productsList);

        assertEquals(7.05, bill);
    }

    @Test
    void test_generateBillOnBothConditions() {
        dataParser = new DataParser("resources/barcodes.txt");
        List<Integer> barcodes = dataParser.parseTXT();
        billGenerator.fillBasket(barcodes);
        dataParser.setFilePath("resources/products.csv");
        List<Product> productsList = dataParser.parse();

        double bill = billGenerator.generateBill(productsList);

        assertEquals(17.00, bill);

    }
}