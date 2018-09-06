package com.codecool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {

    public static List<String[]> loadCSV(String csvFile) {

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
    public static List<Integer> loadTXT(String file) {
        String line = "";
        String splitBy = "\n";
        List<Integer> products = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            while ((line = br.readLine()) != null) {
                String[] product = line.split(splitBy);
                products.add(Integer.parseInt(product[0]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }
}
