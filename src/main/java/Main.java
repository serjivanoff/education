import gUnit.GUnitProcessor;
import gUnit.GUnitUserTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Created by bender on 15.04.2018.
 */
public class Main {
    public static void main(String[] args) {
//        GUnitProcessor.run(GUnitUserTest.class);
        List<String> strings = Arrays.asList("asd", "dsa", "qwe");
        strings.stream().map(String::toUpperCase).forEach(System.out::println);
        strings.stream().flatMap(s -> s.chars().sorted().mapToObj(c -> (char) c)).forEach(System.out::print);
    }
}
