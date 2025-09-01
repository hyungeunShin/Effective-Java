package chapter09.item59;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

//59-2
//transferTo 메서드를 이용해 URL의 내용 가져오기 - 자바 9부터 가능하다.
//353P
public class Curl {
    public static void main(String[] args) throws IOException {
        try(InputStream in = new URL("https://www.naver.com").openStream()) {
            in.transferTo(System.out);
        }
    }
}