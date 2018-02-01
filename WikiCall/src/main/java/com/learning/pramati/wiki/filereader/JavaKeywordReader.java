package com.learning.pramati.wiki.filereader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class JavaKeywordReader implements MyFileReader {
    @Override
    public List<String> read(String path) {
//        List<String> list= new ArrayList<String>();
//        stream.skip(1).forEach(line->{
//            String[] arr=line.split(",");
//            for (String str:arr) {
//                if(!str.isEmpty()){
//                    list.add(str);
//                }
//            }
//        });
//        return list;

        try {

            List<String> list=new ArrayList<String>((int)(Files.lines(Paths.get(path)).count()*1.75));
            Files.lines(Paths.get(path)).skip(1).forEach(line->{
                String [] arr=line.split(",");
                for (String str: arr) {
                    if(!str.isEmpty())
                    {
                        list.add(str);
                    }
                }

            });
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
}
