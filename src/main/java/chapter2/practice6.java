package chapter2;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class practice6 {
    public static void main(final String... args) {
        characterStream("Hello,World!!").forEach(System.out::println);
    }

    public static Stream<Character> characterStream(String str) {
        return IntStream.range(0, str.length()).mapToObj(str::charAt);
    }
}
