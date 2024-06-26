package chapter1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class practice9 {
    public static void main(String[] args) {
        class ArrayList2<E> extends ArrayList<E> implements Collection2<E> {
            // do nothing
        }

        ArrayList2<String> list = new ArrayList2<>();
        var names = new String[]{"Peter", "Paul", "Marry"};
        Collections.addAll(list, names);
        list.forEachIf(System.out::println, str -> str.length() == 4);
    }

    public interface Collection2<T> extends Collection<T> {
        default void forEachIf(Consumer<T> action, Predicate<T> filter) {
            this.stream().filter(filter).forEach(action);
        }
    }
}
