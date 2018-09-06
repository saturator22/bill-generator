package com.codecool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {

    public static List<String[]> load() {

        String csvFile = "resources/products.csv";
        String line = "";
        String cvsSplitBy = ", ";
        List<String[]> products = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                String[] product = line.split(cvsSplitBy);
                products.add(product);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

}
