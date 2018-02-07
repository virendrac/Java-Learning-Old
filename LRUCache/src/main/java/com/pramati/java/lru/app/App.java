package com.pramati.java.lru.app;

import com.pramati.java.lru.data.LRUData;
import com.pramati.java.lru.data.cache.LRUCache;
import com.property.PropertiesGetter;
public class App {

    public static void main(String [] args){

        int cacheSize=Integer.parseInt(PropertiesGetter.getProperty("lruCacheSize"));
        LRUCache<Character> cache=new LRUCache<Character>(3);

        cache.add(new Character('A'));
        cache.add(new Character('B'));
        cache.add(new Character('C'));
        System.out.println("ABC 1");
        cache.printCache();

        cache.add(new Character('D'));
        System.out.println("BCD 2");
        cache.printCache();
        cache.add(new Character('C'));
        System.out.println("BDC 3");
        cache.printCache();
    }
}
