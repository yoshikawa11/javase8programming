package chapter2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class practice8 {
    public static void main(String[] args) {
        Stream<Integer> stream1 = Stream.of(1, 2, 3);
        Stream<Integer> stream2 = Stream.of(10, 9, 8, 7, 6);

        Stream<Integer> zipedStream = zip(stream1, stream2);
        zipedStream.forEach(System.out::println);

    }

    private static <T> Stream<T> zip(Stream<T> stream1, Stream<T> stream2) {
        Iterator<T> iterator1 = stream1.iterator();
        Iterator<T> iterator2 = stream2.iterator();
        List<T> resultList = new ArrayList<>();

        while (iterator1.hasNext() && iterator2.hasNext()) {
                resultList.add(iterator1.next());
                resultList.add(iterator2.next());
        }

        return resultList.stream();
    }
}
