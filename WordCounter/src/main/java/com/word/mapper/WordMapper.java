package com.word.mapper;


import com.word.MappingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;



public class WordMapper {


    private Map<String, Integer> wordMap;
    private List<Future<Map<String, Integer>>> futureMap;
    private Set<String> wordSet;

    public WordMapper() {
        this.wordMap = new HashMap<String,Integer>();
    }

    public Map<String, Integer> getWordMap() {
        return wordMap;
    }

    public String generateMap() {
        MappingService service=new MappingService();
        futureMap = service.executeMapping();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int index=0;
        while (true){
            if(!futureMap.isEmpty()) {
                if(null!=futureMap.get(index)){
                    if (futureMap.get(index).isDone()){
                        try {
                            Map<String,Integer> m=futureMap.get(index).get();
                            //Map<String, Integer> mx = new HashMap<>(m1);
                            m.forEach((k, v) -> wordMap.merge(k, v, Integer::sum));
                            futureMap.remove(index);
                            index++;
                            if(index>=futureMap.size()){
                                index=0;
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            futureMap.remove(index);
                            index++;
                            if(index>=futureMap.size()){
                                index=0;
                            }
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                            futureMap.remove(index);
                            index++;
                            if(index>=futureMap.size()){
                                index=0;
                            }
                        }
                    }else{
                        index++;
                    }

                }

            }else{
                break;
            }
        }
        wordSet=wordMap.keySet();
        return "Successfully map generated!";
    }


    public List<String> getFuzzySuggestions(String word) {

        List<String >l=new ArrayList<>();
        for (String key : wordSet) {
            if (key.contains(word)) {
                l.add(key);
            }
        }
        return l;
    }

    public List<String> getPrefixSuggestions( String word) {

        List<String >l=new ArrayList<>();
        for (String key : wordSet) {
            if (key.startsWith(word)) {
                l.add(key);
            }
        }
        return l;
    }
}
