package com.codecool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BillGenerator {
    private Map<Integer, Integer> basket = new HashMap<>();



    public void fillBasket(List<Integer> barcodes) {

        for(Integer barcode: barcodes) {
            if(!this.basket.containsKey(barcode)) {
                this.basket.put(barcode, 1);
            } else{
                this.basket.put(barcode, this.basket.get(barcode) + 1);
            }
        }
    }

    public Map<Integer,Integer> getBasket() {
        return this.basket;
    }

    public double generateBill(List<Product> productList) {
        double billValue = 0;
        int productAmount;
        int amountForDiscount;

        labelWhenNoBarcodeInBasket:
        for(int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            if(!this.basket.containsKey(product.getBarcode())) {
                continue labelWhenNoBarcodeInBasket;
            }
            productAmount = this.basket.get(product.getBarcode());
            amountForDiscount = product.getAmount();

            while(productAmount >= amountForDiscount) {
                billValue += product.getPrice();
                productAmount -= product.getAmount();
            }
            if(productAmount > 0) {
                billValue += productList.get(++i).getPrice() * productAmount;
            }
            this.basket.remove(product.getBarcode());
        }
        return billValue;
    }
}
