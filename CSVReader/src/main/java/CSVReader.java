import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class CSVReader {


    public static void main(String[] args){
        try {

            ExecutorService executorService = new ScheduledThreadPoolExecutor(10);

            Stream<String> lines = Files.lines(Paths.get("/Users/virendrac/Training/JavaLearning/CSVReader/src/main/resources/Multithreading_Task1_Books_copy.csv"));
            final int n=100;
            final int countLine = 0;

            List< String> list = new ArrayList<String>((int) (n*1.75));
            List<Future<String>> futureList = new ArrayList<Future<String>>();

            lines.forEach(line-> {

                if(list.size()<n){
                    list.add(line);
                }else{
                    CSVSplitter splitter=new CSVSplitter(new ArrayList<>(list));
                    futureList.add(executorService.submit(splitter));
                    list.clear();
                }


            });
            System.out.println("future");
            System.out.println(futureList.get(0).get());
            System.out.println("completed");



//          List<String> first2Lines = lines.limit(2).collect(Collectors.toList());

        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class CSVSplitter implements Callable<String>{

    static int index=0;
    List< String>  lines;

    public CSVSplitter(List< String>  lines) {
        this.lines=lines;
    }

    @Override
    public String call() throws Exception {

        String retVal;
        BufferedWriter writer=Files.newBufferedWriter(Paths.get("/Users/virendrac/Training/JavaLearning/CSVReader/src/main/resources/tmp/File"+index+".txt"));
        writer.write(lines.toString());
        retVal="File"+index+".txt written";
        index++;
        return retVal;
    }
}
