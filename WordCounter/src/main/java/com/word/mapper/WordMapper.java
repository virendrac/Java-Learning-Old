package com.word.mapper;


import com.word.MappingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


@RestController
@RequestMapping("/wordMapper")
public class WordMapper {

    private Map<String, Integer> wordMap;
    private List<Future<Map<String, Integer>>> futureMap;

    public WordMapper() {
        this.wordMap = new HashMap<String,Integer>();
    }

    @RequestMapping(
            value = "/generateMap",
            method = RequestMethod.GET)
    public ResponseEntity<String> generateMap() {
        MappingService service=new MappingService();
        futureMap = service.executeMapping();
        int index=0;
        while (true){
            if(!futureMap.isEmpty()) {
                if (futureMap.get(index).isDone()){
                    try {
                        Map<String,Integer> m=futureMap.get(index).get();
                        //Map<String, Integer> mx = new HashMap<>(m1);
                        m.forEach((k, v) -> wordMap.merge(k, v, Integer::sum));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            }else{
                break;
            }
        }
        return new ResponseEntity<>("Successfully map generated!",HttpStatus.OK);
    }

    @RequestMapping(
            value = "/getSuggestions/fuzzy/{'word'}",
            method = RequestMethod.GET)
    public ResponseEntity<List<String>> getFuzzySuggestions(@RequestParam(value = "word") String word) {

        List<String >l=new ArrayList<>();
        for (Map.Entry<String, Integer> e : wordMap.entrySet()) {
            if (e.getKey().contains(word)) {
                l.add(e.getKey());
            }
        }
        return new ResponseEntity<>(l, HttpStatus.OK);
    }


    @RequestMapping(
            value = "/getSuggestions/prefix/{'word'}",
            method = RequestMethod.GET)
    public ResponseEntity<List<String>> getPrefixSuggestions(@RequestParam(value = "word") String word) {

        List<String> l = new ArrayList<>();
        for (Map.Entry<String, Integer> e : wordMap.entrySet()) {
            if (e.getKey().startsWith(word)) {
                l.add(e.getKey());
            }
        }
        return new ResponseEntity<>(l, HttpStatus.OK);
    }
}
