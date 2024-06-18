package chapter1;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class practice2 {
    public static void main (String[] args) {
        var target = ".";
        var allFiles = recursiveGetDirectories(target);
        allFiles.forEach(System.out::println);

    }


    public static List<File> recursiveGetDirectories(String target) {
        var list = new ArrayList<File>();
        // ラムダ式バージョン
        // var subDirs = Arrays.asList(new File(target).listFiles(f -> f.isDirectory()));
        // メソッド参照バージョン
        var subDirs = Arrays.asList(Objects.requireNonNull(new File(target).listFiles(File::isDirectory)));
        subDirs.stream().sorted().forEach((d) -> {
            list.add(d);
            list.addAll(recursiveGetDirectories(d.getPath()));
        });

        return list;
    }
}
