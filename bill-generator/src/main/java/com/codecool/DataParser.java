package com.codecool;

import java.util.ArrayList;
import java.util.List;

public class DataParser {

    public List<Product> parse() {
        List<String[]> data = DataLoader.loadCSV();
        List<Product> productsList = new ArrayList<>();

        for (String[] subData: data) {
            int barcode = Integer.parseInt(subData[0]);
            String name = subData[1];
            int amount = Integer.parseInt(subData[2]);
            double price = Double.parseDouble(subData[3]);

            Product product = new Product(barcode, name, amount, price);
            productsList.add(product);
        }
        return productsList;
    }
}
