package com.dbosoft.analysisreport.services;

import java.util.ArrayList;
import java.util.List;

public class GetProductWithMaxProfitService {

    List<String[]> splitData = new ArrayList<>();
    List<String> productName = new ArrayList<>();
    List<Integer> sum = new ArrayList<>();
    List<String> result = new ArrayList<>();

    public List<String> maxProfit(List<String> input){

        int maxProfit;
        String data;

        splitData = splitInputData(input);
        productName = getProductName(splitData);
        maxProfit = getMaxTotalProfit(productName);



        //get product index with the greatest profit
        int index = 0;
        for (int lo = 0; lo < sum.size(); lo++) {

            if (sum.get(lo) == maxProfit) index = lo;

        }



        data = getDateLastSale(index);

        result.add(productName.get(index));
        result.add(data);
        result.add(String.valueOf(maxProfit));

        return result;

    }

    private List<String[]> splitInputData(List<String> inputData){

        List<String[]> splitData = new ArrayList<>();

        int i =0;
        while(i < inputData.size()){

            splitData.add(inputData.get(i).split("#"));
            i++;
        }

        return splitData;
    }
    private int sum(List<String[]> list, String product){

        int sum = 0;

        for (String[] strings : list) {

            if (product.equals(strings[0])) {

                sum += Integer.parseInt(strings[2]);

            }

        }
        return sum;
    }

    private List<String> getProductName(List<String[]> splData){

        List<String> result = new ArrayList<>();
        for (String[] splDatum : splData) {

            if (!result.contains(splDatum[0])) result.add(splDatum[0]);

        }

        return result;

    }

    private String getDateLastSale(int index){

        String data = "";
        for (String[] s: splitData) {

            if (s[0].equals(productName.get(index))){

                data = s[1];
                break;
            }

        }

        return data;
    }

    private int getMaxTotalProfit(List<String> products){

        for (String s : products) {

            sum.add(sum(splitData, s));
        }

        int max = sum.get(0);
        for (Integer k:sum) {

            if (k>max) {
                max = k;
            }
        }

        return max;
    }

}
