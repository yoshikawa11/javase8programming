package chapter2;

import java.util.List;

public class practice2 {
    public static void main(String[] args) {
        List<String> words = List.of("January", "February", "March", "August", "September", "October", "November", "December");
        words.stream().filter(word -> {
              System.out.printf("%s is filtered.",word);
              System.out.println();
              return word.length() > 5;
            })
                .limit(5)
                .forEach(System.out::println);
    }
}
