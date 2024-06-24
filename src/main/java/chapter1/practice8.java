package chapter1;

import java.util.ArrayList;
import java.util.List;

public class practice8 {
    public static void main(String[] args) {
        var names = new String[]{"Peter", "Paul", "Marry"};
        forLambda(names);
        forLoopOld(names);
    }

    static void forLambda(String[] names) {
        List<Runnable> runners = new ArrayList<>();
        for (var name : names) runners.add(() -> System.out.println(name));
        runners.forEach(Runnable::run); // 各ラムダ式が異なる値をキャプチャする
    }

    static void forLoopOld(String[] names) {
        List<Runnable> runners = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            var j = i; // 変更される変数を参照できないので事実上のfinalの変数を用意する
            runners.add(() -> System.out.println(names[j]));
        }
        runners.forEach(Runnable::run);
    }
}
