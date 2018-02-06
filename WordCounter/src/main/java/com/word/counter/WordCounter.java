package com.word.counter;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.stream.Stream;

public class WordCounter  implements Callable<Map<String, Integer>>{

    private String path;

    public WordCounter(String path ) {
        this.path = path;
    }


    @Override
    public Map<String, Integer> call() throws Exception {
        Map<String,Integer> retMap=new HashMap<>();
        Stream<String> lines = Files.lines(Paths.get(path));

        lines.forEach(line-> {
            String[] arr=line.split(" ");
            for(String str: arr){
                retMap.computeIfPresent(str, (k,v) -> v+1);
                retMap.putIfAbsent(str,1);
            }
        });
        return retMap;
    }
}
