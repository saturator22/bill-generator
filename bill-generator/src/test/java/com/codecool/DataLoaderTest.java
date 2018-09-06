package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataLoaderTest {

    @Test
    void test_loadCSV() {
        List<String[]> data = DataLoader.loadCSV("resources/products.csv");
        assertEquals("[1001, beer, 1, 1.20]", Arrays.toString(data.get(0)));
    }

    @Test
    void test_loadTXT() {
        List<Integer> data = DataLoader.loadTXT("resources/barcodes.txt");
        assertEquals(new Integer(1001), data.get(0));
    }
}