package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataParserTest {
    DataParser dataParser;
    @BeforeEach
    void setUp() {
        dataParser = new DataParser();
    }

    @Test
    void test_parse() {
        Product product = new Product(1001, "beer", 1, 1.20);
        Product productToCompare = dataParser.parse().get(0);

        assertTrue(product.equals(productToCompare));
        assertEquals(5, dataParser.parse().size());
    }
}