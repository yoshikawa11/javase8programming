package chapter1;

import java.io.File;
import java.util.Arrays;

public class practice3 {
    public static void main (String[] args) {
        var directory = ".";
        var extension = "kts";
        var allFiles = getFileLists(directory, extension);
        if (allFiles != null) Arrays.stream(allFiles).forEach(System.out::println);
    }

    static String[] getFileLists(String path, String extension) {
        // extensionはキャプチャされる
        File dir = new File(path);
        return dir.list((dir1, name) -> {
            File file = new File(dir1, name);
            return file.isFile() && name.endsWith("." + extension);
        });
    }
}
