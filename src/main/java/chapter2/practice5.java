package chapter2;

import java.util.stream.Stream;

public class practice5 {
    public static void main(String[] args) {
        var a = 2514903917L;
        var c = 11;
        var m = Math.pow(2, 48);
        var seed = System.currentTimeMillis();
        Stream<Long> stream = linearCongruentialGenerator(seed, a, c, m);
        stream.limit(10).forEach(System.out::println);
    }

    static Stream<Long> linearCongruentialGenerator(long seed, long a, int c, double m) {
        return Stream.iterate(seed, x -> (long) ((a * x + c) % m));
    }
}
