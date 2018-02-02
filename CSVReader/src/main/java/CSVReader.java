import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class CSVReader {


    public static void main(String[] args){
        try {

            ExecutorService executorService = new ScheduledThreadPoolExecutor(1);

            Stream<String> lines = Files.lines(Paths.get("/Users/virendrac/Training/JavaLearning/CSVReader/src/main/resources/Multithreading_Task1_Books.csv"));
            final int n=100;
            final int countLine = 0;

            System.out.println("Main start time:: "+new Date());

            List< String> list = new ArrayList<String>((int) (n*1.75));

            lines.forEach(line-> {

                if(list.size()<n){
                    list.add(line);
                }else{
                    CSVSplitter splitter=new CSVSplitter(new ArrayList<>(list));
                    executorService.submit(splitter);
                    list.clear();
                }


            });

            System.out.println("Main Thread End time:: "+new Date());

            executorService.shutdown();

        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class CSVSplitter implements  Runnable {

    static int index=0;
    List< String>  lines;

    public CSVSplitter(List< String>  lines) {
        this.lines=lines;
    }

    @Override
    public void run()  {

        int i = index;
        synchronized ((Object) index) {
            index++;
        }
        System.out.println(Thread.activeCount()+" :: Start time:: "+new Date());
        try {

            BufferedWriter writer = null;

            writer = Files.newBufferedWriter(Paths.get("/Users/virendrac/Training/JavaLearning/CSVReader/src/main/resources/tmp/File" + i + ".txt"));

            writer.write(lines.toString());
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("End time:: "+new Date());

    }

}
