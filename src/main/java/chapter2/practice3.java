package chapter2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class practice3 {
    public static void main(String[] args) {
        final String contents;
        try {
            contents = Files.readString(Paths.get("src/main/resources/war_and_peace.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        var words = contents.split("\\P{L}+");
        // Streamを使って一番長い単語を見つける
        long startTime = System.nanoTime();
        Optional<String> longestWordStream = Arrays.stream(words)
                .max(Comparator.comparingInt(String::length));
        long endTime = System.nanoTime();
        longestWordStream.ifPresent(word ->
                System.out.println("Longest word using Stream: " + word)
        );
        var streamResult = (endTime - startTime) / 1_000_000;
        System.out.println("Stream duration: " + streamResult + " ms");

        // ParallelStreamを使って一番長い単語を見つける
        startTime = System.nanoTime();
        Optional<String> longestWordParallelStream = Arrays.stream(words)
                .parallel()
                .max((s1, s2) -> Integer.compare(s1.length(), s2.length())); // ラムダ式で表現する
        endTime = System.nanoTime();
        longestWordParallelStream.ifPresent(word ->
                System.out.println("Longest word using ParallelStream: " + word)
        );

        var parallelStreamResult = (endTime - startTime) / 1_000_000;
        System.out.println("ParallelStream duration: " + parallelStreamResult + " ms");
        System.out.println("diff: " + (streamResult - parallelStreamResult) + " ms");
    }
}
