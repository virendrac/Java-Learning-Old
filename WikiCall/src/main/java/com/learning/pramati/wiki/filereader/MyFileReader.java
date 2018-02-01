package com.learning.pramati.wiki.filereader;

import java.util.List;
import java.util.stream.Stream;

public interface MyFileReader {

    public List<String> read(String path);

}
