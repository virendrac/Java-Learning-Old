package com.word;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import com.property.PropertiesGetter;

public class FileFinder {


    public static List<String> filePathFinder(){

        File folder = new File(PropertiesGetter.getProperty("baseFolder"));
        File[] arrayOfFiles = folder.listFiles();
        List<String > listOfFiles= new ArrayList<String>(arrayOfFiles.length*2);

        for(File f: arrayOfFiles){
            if(f.isFile()){
                listOfFiles.add(f.toString());
            }
        }

        return listOfFiles;
    }




}
