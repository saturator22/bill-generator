package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataParserTest {
    DataParser dataParser;
    @BeforeEach
    void setUp() {
        dataParser = new DataParser("resources/products.csv");
    }

    @Test
    void test_parse() {
        Product product = new Product(3401, "chocolate", 1, 3.15);
        Product productToCompare = dataParser.parse().get(0);

        assertTrue(product.equals(productToCompare));
        assertEquals(5, dataParser.parse().size());
    }
}