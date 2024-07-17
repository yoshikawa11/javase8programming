package chapter2;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class practice12 {
    public static void main(String[] args) {
        final AtomicInteger[] shortWords = new AtomicInteger[12];
        Arrays.setAll(shortWords, value -> new AtomicInteger(0));
        Stream.of("January", "February", "March", "April").parallel().forEach(s -> {
            if (s.length() < 12) {
                shortWords[s.length()].getAndIncrement();
            }
        });
        System.out.println(Arrays.toString(shortWords));
    }
}

