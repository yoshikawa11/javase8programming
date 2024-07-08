package chapter2;

import java.util.stream.Stream;

public class practice7 {
    public static void main(String[] args) {
        Stream<Integer> finiteStream = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> infiniteStream = Stream.iterate(0, n -> n + 1);

        System.out.println(isInfinite(finiteStream)); // false
        System.out.println(isInfinite(infiniteStream)); // true
    }

    public static boolean isInfinite(Stream<?> stream) {
        return stream.spliterator().estimateSize() == Long.MAX_VALUE;
    }


}
