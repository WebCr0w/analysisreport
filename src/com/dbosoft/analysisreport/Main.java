package com.dbosoft.analysisreport;

import com.dbosoft.analysisreport.services.GetListFromTxt;
import com.dbosoft.analysisreport.services.GetProductWithMaxProfitService;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        GetProductWithMaxProfitService maxProf = new GetProductWithMaxProfitService();
        GetListFromTxt getListFromTxt =new GetListFromTxt();

        List<String> inputData = getListFromTxt.getData("./src/com/dbosoft/analysisreport/resources/input.txt");

        List<String> mxProf = maxProf.maxProfit(inputData);
        System.out.println(mxProf.get(0) + " " + mxProf.get(1) + " " + mxProf.get(2));

    }
}
