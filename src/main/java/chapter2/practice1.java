package chapter2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class practice1 {
    public static void main(String[] args) {
        final String contents;
        try {
            contents = Files.readString(Paths.get("src/main/resources/alice.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<CountThread> threads = getCountThreads(contents);

        int totalCount = 0;
        for (CountThread thread : threads) {
            try {
                thread.join();
                totalCount += thread.getCount();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 結果を出力
        System.out.println("Total count of words with length > 12: " + totalCount);
    }

    private static List<CountThread> getCountThreads(String contents) {
        final List<String> words = Arrays.asList(contents.split("\\P{L}+"));
        int numberOfThreads = 4;
        List<CountThread> threads = new ArrayList<>();
        int chunkSize = (int) Math.ceil((double) words.size() / numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++) {
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, words.size());
            CountThread thread = new CountThread(words, start, end);
            threads.add(thread);
            thread.start();
        }
        return threads;
    }
}


class CountThread extends Thread {
    private final List<String> words;
    private final int start;
    private final int end;
    private int count;

    public CountThread(List<String> words, int start, int end) {
        this.words = words;
        this.start = start;
        this.end = end;
        this.count = 0;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            if (words.get(i).length() > 12) {
                System.out.println(words.get(i));
                count++;
            }
        }
    }
}
