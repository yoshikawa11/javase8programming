package chapter2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Stream;


public class practice11 {
    public static void main(String[] args) {
        Stream<Double> doubleStream = Stream.of(1.0, 2.0, 3.0, 4.0, 5.0).parallel();

        List<Double> resultList = doubleStream.collect(toConcurrentArrayList(5));

        resultList.forEach(System.out::println);
    }

    public static <T> Collector<T, List<T>, List<T>> toConcurrentArrayList(int size) {
        return Collector.of(
                () -> {
                    List<T> list = new ArrayList<>(Collections.nCopies(size, null));
                    return list;
                },
                (list, item) -> {
                    synchronized (list) {
                        list.set(list.indexOf(null), item);
                    }
                },
                (left, right) -> {
                    synchronized (left) {
                        int index = left.indexOf(null);
                        for (T item : right) {
                            if (item != null) {
                                left.set(index++, item);
                            }
                        }
                    }
                    return left;
                },
                Collector.Characteristics.CONCURRENT
        );
    }
}

