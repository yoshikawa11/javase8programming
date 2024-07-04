package memo;

import java.util.ArrayList;
import java.util.List;

public class MultiThreads {
    public static void main(String[] args) {
        int numberOfThreads = 5;
        List<Thread> threads = new ArrayList<>();
        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < numberOfThreads; i++) {
            int threadNumber = i + 1;
            Thread thread = new Thread(() -> { // ラムダ式でスレッドの動作を定義する
                int result = threadNumber * 10; // スレッド番号に基づいた計算
                synchronized (results) {
                    results.add(result); // 同期化してリストに結果を追加
                }
                System.out.println("Thread " + threadNumber + " has result: " + result);
            });

            threads.add(thread);
            thread.start(); // 実行
        }

        // すべてのスレッドが終了するのを待つ
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 集約された結果を出力
        System.out.println("Results: " + results);
    }
}

