package chapter1;

import java.util.Arrays;
import java.util.Comparator;

public class practice1 {
    public static void main(String[] args) {
        Arrays.sort(new Integer[]{5, 3, 4, 2, 4}, new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                printThreadName();
                return o2 - o1;
            }
        });

        Arrays.sort(new Integer[]{5, 3, 4, 2, 4}, (o1, o2) -> {
            printThreadName();
            return o2 - o1;
        });
    }

    static void printThreadName() {
        System.out.println("thread-name: " + Thread.currentThread().getName());
    }
}
