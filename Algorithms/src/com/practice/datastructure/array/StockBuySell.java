package com.practice.datastructure.array;

public class StockBuySell {

    public static void main(String[] args){
        int [] prices = {5,1,5,6,7,1,10};
        int min_price =Integer.MAX_VALUE;
        int max_profit=0;
        for(int price:prices){
            if(price < min_price){
                min_price=price;
            }
            else {
                max_profit = Math.max(max_profit, price-min_price);
            }
        }
    System.out.println("maximum Profit :: " + max_profit);
    }
}
