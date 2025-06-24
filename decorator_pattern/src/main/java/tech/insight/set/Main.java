package tech.insight.set;

import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.time.Instant;

/**
 * @author Max
 * @description
 * @date 2025/6/17 19:41
 */
public class Main {
    public static void main(String[] args) {

        File file = new File("D:\\JavaWeb\\FuxiFuxiFuxiNiumochoubing\\decorator_pattern\\abc.txt");
        long l = Instant.now().toEpochMilli();
        try(RecodingFileInputStream inputStream = new RecodingFileInputStream(new FileInputStream(file))){
            while(true){
                int read = inputStream.read();
                if (read == -1) {
                    break;
                }
            }
            System.out.println(Instant.now().toEpochMilli() - l);
            System.out.println(inputStream.getRecodedCount());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
