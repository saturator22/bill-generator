package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataLoaderTest {

    @Test
    void test_load() {
        List<String[]> data = DataLoader.load();
        assertEquals("[1001, beer, 1, 1.20]", Arrays.toString(data.get(0)));
    }


}