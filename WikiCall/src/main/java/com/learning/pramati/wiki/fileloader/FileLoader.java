package com.learning.pramati.wiki.fileloader;

import com.learning.pramati.wiki.filereader.factory.MyFileReaderFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileLoader {

    private List<String> keywords;
    private String path;
    Stream<String> lines;

    public FileLoader(String path) {
        try{
            this.path = path;
            keywords=new ArrayList<String>((int) (Files.lines(Paths.get(path)).count()*1.75));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<String> read(){
        try {
            return this.keywords= MyFileReaderFactory.getReader(Files.lines(Paths.get(path)).limit(1).collect(Collectors.toList())).read(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
