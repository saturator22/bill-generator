package com.codecool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DataParser {
    String filePath;

    public DataParser(String filePath) {
        this.filePath = filePath;
    }

    public List<Product> parse() {
        List<String[]> products = DataLoader.loadCSV(this.filePath);
        List<Product> productsList = new ArrayList<>();

        for (String[] subData: products) {
            int barcode = Integer.parseInt(subData[0]);
            String name = subData[1];
            int amount = Integer.parseInt(subData[2]);
            double price = Double.parseDouble(subData[3]);

            Product product = new Product(barcode, name, amount, price);
            productsList.add(product);
        }
        Collections.sort(productsList, Comparator.comparing(Product::getBarcode)
                                        .thenComparing(Product::getAmount));
        Collections.reverse(productsList);
        return productsList;
    }

    public List<Integer> parseTXT() {
        return DataLoader.loadTXT(this.filePath);
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
