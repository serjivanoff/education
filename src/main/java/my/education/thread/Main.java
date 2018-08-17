package my.education.thread;

import java.util.*;

/**
 * Created by bender on 17.08.2018.
 */
public class Main {
    private final static int NUMBER_OF_ELEMENTS = 50_000_000;

    public static void main(String[] args) throws InterruptedException {
        Integer[] array = new Integer[NUMBER_OF_ELEMENTS];
        Random r = new Random(42);
        for (int i = 0; i < NUMBER_OF_ELEMENTS; i++) {
            array[i] = r.nextInt(Integer.MAX_VALUE);
        }
        long start = System.currentTimeMillis();
        final List<Integer[]> ints = splitArray(array, 4);
        Thread thread = new Thread(() -> parallelSort(ints));
        thread.start();
        thread.join();

        int[] result = stackMerge(ints);
        long stop = System.currentTimeMillis();
        System.out.printf("elapsed time in multithread-thread mode: %d  \n", (stop - start));

        start = System.currentTimeMillis();
        Arrays.sort(array);
        stop = System.currentTimeMillis();
        System.out.printf("elapsed time in single-thread mode: %d \n", (stop - start));
    }

    private static List<Integer[]> parallelSort(List<Integer[]> list) {
        for (int i = 0; i < list.size(); i++) {
            final int ii = i;
            Thread thread = new Thread(() -> Arrays.sort(list.get(ii)));
            thread.start();
        }
        return list;
    }

    private static List<Integer[]> splitArray(Integer[] source, int divider) {
        final int fullSize = source.length, dividedSize = fullSize / divider + (fullSize % divider == 0 ? 0 : 1);
        List<Integer[]> result = initListOfArrays(divider, dividedSize);
        int rDex = 0;

        for (int i = 0; i < fullSize; i++) {
            int index = i % dividedSize;
            if (i != 0 && index == 0) rDex++;
            result.get(rDex)[index] = source[i];
        }
        return result;
    }

    private static List<Integer[]> initListOfArrays(int sizeOfList, int sizeOfArray) {
        List<Integer[]> ints = new ArrayList<>(sizeOfList);
        for (int i = 0; i < sizeOfList; i++) {
            ints.add(new Integer[sizeOfArray]);
        }
        return ints;
    }

    private static void writeArrayToConsole(int[] array) {
        StringJoiner sj = new StringJoiner(" ");
        for (int i : array) {
            sj.add(String.valueOf(i));
        }
        System.out.println("Size of resulting array: " + array.length);
        System.out.println(sj.toString());
    }

    private static int[] stackMerge(List<Integer[]> ints) {
        List<ArrayDeque<Integer>> list = new ArrayList<>(ints.size());
        int finalSize = 0, rDex = 0;
        for (Integer[] arg : ints) {
            list.add(new ArrayDeque<>(Arrays.asList(arg)));
            finalSize += arg.length;
        }
        int[] result = new int[finalSize];
        while (checkCondition(list)) {
            result[rDex++] = popMin(list);
        }
        return result;
    }

    private static int popMin(List<ArrayDeque<Integer>> list) {
        int index = 0;
        while(list.get(index).isEmpty()){
            index++;
        }
        int min = list.get(index).peek();
        for (int i = 0; i < list.size(); i++) {
            ArrayDeque<Integer> deque = list.get(i);
            if (!deque.isEmpty()) {
                if (min > deque.peek()) {
                    min = deque.peek();
                    index = i;
                }
            }
        }
        return list.get(index).pop();
    }

    private static boolean checkCondition(List<ArrayDeque<Integer>> list) {
        for (ArrayDeque<Integer> deque : list) {
            if (!deque.isEmpty()) return true;
        }
        return false;
    }

}
