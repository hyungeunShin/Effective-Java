package chapter02.item09.trywithresources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//9-3
//try-with-resources - 자원을 회수하는 최선책!
//48P
public class TopLine {
    static String firstLineOfFile(String path) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }
}