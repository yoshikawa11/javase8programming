package chapter2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

public class practice9 {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1,"January", "February", "March", "April");
        final ArrayList<String> list2 = new ArrayList<>();
        Collections.addAll(list2, "May", "June", "July", "August");
        ArrayList<String> list3 = new ArrayList<>();
        Collections.addAll(list3,"September", "November", "October", "December");

        reduce1(Stream.of(list1, list2, list3)).forEach(System.out::println);
        reduce2(Stream.of(list1, list2, list3)).forEach(System.out::println);
        reduce3(Stream.of(list1, list2, list3)).forEach(System.out::println);
    }

    public static <T> ArrayList<T> reduce1(Stream<ArrayList<T>> stream) {
        return stream.reduce(new ArrayList<>(), (result, list) -> {
            ArrayList<T> newList = new ArrayList<>(result);
            newList.addAll(list);
            return newList;
        });
    }

    public static <T> ArrayList<T> reduce2(Stream<ArrayList<T>> stream) {
        return stream.reduce((result, list) -> {
            ArrayList<T> newList = new ArrayList<>(result);
            newList.addAll(list);
            return newList;
        }).orElse(new ArrayList<>());
    }

    public static <T> ArrayList<T> reduce3(Stream<ArrayList<T>> stream) {
        return stream.reduce(new ArrayList<>(), (result, list) -> {
            ArrayList<T> newList = new ArrayList<>(result);
            newList.addAll(list);
            return newList;
        }, (result1, result2) -> {
            ArrayList<T> newList = new ArrayList<>(result1);
            newList.addAll(result2);
            return newList;
        });
    }
}
