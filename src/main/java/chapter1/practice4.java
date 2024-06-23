package chapter1;

import java.io.File;
import java.util.Arrays;

public class practice4 {
    public static void main(String[] args) {
        File[] target = fileSort(new File(".").listFiles());
        assert target != null;
        Arrays.stream(target).forEach(System.out::println);
    }

    private static File[] fileSort(File[] files) {
        Arrays.sort(files, (f1, f2) -> {
                if (f1.isDirectory() && f2.isDirectory()) {
                    return f1.getName().compareTo(f2.getName());
                } else if (f1.isDirectory()) {
                    return -1;
                } else if (f2.isDirectory()) {
                    return 1;
                } else {
                    return f1.getName().compareTo(f2.getName());
                }
        });

        return files;
    }
}
