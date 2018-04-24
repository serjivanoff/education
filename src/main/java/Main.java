import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> myList = new MyList<>();
        myList.addAll(Arrays.asList("J", "L", "V", "K", "J", "M"));
        List<String> dest = new ArrayList<>();
        dest.addAll(Arrays.asList("M", "Z", "V", "X", "Y", "Z"));
        Collections.copy(dest, myList);
        Collections.sort(myList, Comparator.naturalOrder());
        System.out.println(myList.toArray());
        myList.forEach(System.out::println);
    }
}
