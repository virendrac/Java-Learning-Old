package com.word;


import com.word.counter.WordCounter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class MappingService {

    private Map<String, Integer> wordCount;

    public MappingService(){
        wordCount=new HashMap<String, Integer>();
    }

    public List<Future<Map<String,Integer>>>  executeMapping(){
        List<String> files= FileFinder.filePathFinder();

        ExecutorService executorService = new ScheduledThreadPoolExecutor(10);

        List<Future<Map<String,Integer>>> future=new ArrayList<>();

        files.forEach(file->
        {
            future.add(executorService.submit(new WordCounter(file)));
        });

        return future;

    }

}
