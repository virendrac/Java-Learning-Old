package com.learning.pramati.wiki.filereader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FortuneCompReader implements MyFileReader {
    @Override
    public List<String> read(String path) {

        try {

            List<String> list=new ArrayList<String>((int)(Files.lines(Paths.get(path)).count()*1.75));
            Files.lines(Paths.get(path)).forEach(line->{
            String [] arr=line.split(" ");
            list.add(arr[1]);
            });
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
