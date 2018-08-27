package my.education.webapplication;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by bender on 26.08.2018.
 */
public class MainTest {
    public static void main(String[] args) {
        Queue<String> strings = new ArrayDeque<>();
        for(int i=0; i<10; i++){
            strings.add(String.valueOf(i));
        }
        for(int i = 0; i<10; i++){
            System.out.println(strings.element());
        }
    }
}
