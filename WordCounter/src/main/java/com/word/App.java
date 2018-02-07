package com.word;

import com.word.mapper.WordMapper;

import java.util.Scanner;

public class App {

    public static void main(String[] args){

        WordMapper mapper= new WordMapper();
        String ret=mapper.generateMap();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter key for autosuggest:");
        String key=sc.nextLine();
        System.out.println("Key Entered::"+key+"\n Results for Prefix based autosuggest:" +mapper.getPrefixSuggestions(key));
        System.out.println("Key Entered::"+key+"\n Results for Fuzzy based autosuggest:" +mapper.getFuzzySuggestions(key));
    }
}
