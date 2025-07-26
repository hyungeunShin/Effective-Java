package chapter02.item09.trywithresources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//9-5
//try-with-resources를 catch 절과 함께 쓰는 모습
//49P
public class TopLineWithDefault {
    static String firstLineOfFile(String path, String defaultVal) {
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        } catch(IOException e) {
            return defaultVal;
        }
    }
}