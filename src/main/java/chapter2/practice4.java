package chapter2;

import java.util.Arrays;
import java.util.stream.Stream;

public class practice4 {
    public static void main(String[] args) {
        int[] values = {1, 4, 9, 16};
        Stream.of(values).forEach(arr -> System.out.println(Arrays.toString(arr))); // 配列の個々の要素ではなくint型配列が出力される
        Arrays.stream(values).forEach(System.out::println); // 配列の個々の要素が出力される
    }
}
