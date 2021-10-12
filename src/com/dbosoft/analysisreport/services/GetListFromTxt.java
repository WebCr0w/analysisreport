package com.dbosoft.analysisreport.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GetListFromTxt {

    public static List<String> getData(String file) throws IOException {

        List<String> list = new ArrayList<>();
        try(Stream<String> stream = Files.lines(Paths.get(file))){

            list = stream.filter(x -> !x.equals("")).collect(Collectors.toList());
            return list;

        }


    }

}
