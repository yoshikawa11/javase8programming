package chapter2;

import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class practice10 {
    public static void main(String[] args) {
        Stream<Double> stream = Stream.of(1.0, 2.0, 3.0, 4.0, 5.0);
        var average = calculateAverage(stream);
        System.out.println("Average: " + average);

        DoubleStream doubleStream = DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0);
        var average2 = doubleStream.average();

        if (average2.isPresent()) {
            System.out.println("Average: " + average2.getAsDouble());
        } else {
            System.out.println("Average: 0.0");
        }
    }

    static Double calculateAverage(Stream<Double> stream) {
        double[] sumAndCount = stream.reduce(
                new double[2],  // 初期値: {合計, カウント}
                (acc, value) -> {
                    acc[0] += value;  // 合計を更新
                    acc[1]++;         // カウントを更新
                    return acc;
                },
                (acc1, acc2) -> {
                    acc1[0] += acc2[0];  // 合計を結合
                    acc1[1] += acc2[1];  // カウントを結合
                    return acc1;
                }
        );

        // 平均を計算
        return sumAndCount[1] > 0 ? sumAndCount[0] / sumAndCount[1] : 0;
    }
}
