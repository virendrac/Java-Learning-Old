import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.concurrent.*;
import java.util.stream.Stream;
import com.property.PropertiesGetter;

public class CSVReader {


    public static void main(String[] args){
        try {

            ExecutorService executorService = new ScheduledThreadPoolExecutor(1);

            Stream<String> lines = Files.lines(Paths.get(PropertiesGetter.getProperty("csvFile")));
            final int n=100;
            final int countLine = 0;

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
    static String writeLocation=PropertiesGetter.getProperty("writeLocation");

    public CSVSplitter(List< String>  lines) {
        this.lines=lines;
    }

    @Override
    public void run()  {

        int i = index;
        synchronized ((Object) index) {
            index++;
        }
        try {

            BufferedWriter writer = null;

            writer = Files.newBufferedWriter(Paths.get(writeLocation+"File" + i + ".txt"));

            writer.write(lines.toString());
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
