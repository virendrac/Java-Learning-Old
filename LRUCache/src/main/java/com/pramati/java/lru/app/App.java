package com.pramati.java.lru.app;

import com.pramati.java.lru.data.cache.LRUCache;
import com.property.PropertiesGetter;
public class App {

    public static void main(String [] args){

        LRUCache<Character> cache=new LRUCache<Character>(Integer.parseInt(PropertiesGetter.getProperty("lruCacheSize")));

        cache.add(new Character('A'));
        cache.add(new Character('B'));
        cache.add(new Character('C'));

        cache.printCache();

        cache.add(new Character('D'));

        cache.printCache();
        cache.add(new Character('C'));
        cache.printCache();
    }
}
