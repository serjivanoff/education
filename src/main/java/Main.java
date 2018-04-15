import com.google.common.collect.Collections2;

import java.util.Arrays;
import java.util.List;

/**
 * Created by bender on 15.04.2018.
 */
public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Josh", "Joseph", "Marcel");
        Collections2.permutations(names).forEach(System.out::println);
    }
}
