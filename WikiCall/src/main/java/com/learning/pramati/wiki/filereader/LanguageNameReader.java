package com.learning.pramati.wiki.filereader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LanguageNameReader implements MyFileReader {
    @Override
    public List<String> read(String path) {
//        List<String> list= new ArrayList<String>((int) (stream.count()*1.75));
        try {
            return Files.lines(Paths.get(path)).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
