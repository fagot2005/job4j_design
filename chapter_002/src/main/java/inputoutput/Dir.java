package inputoutput;

import java.io.File;

public class Dir {
    public static void main(String[] args) {
        File file = new File("E:\\Java\\Java_Project\\job4j_design");
if (!file.exists()) {
    throw new IllegalArgumentException(String.format("No exists %s", file.getAbsoluteFile()));
    }
if (!file.isDirectory()) {
    throw new IllegalArgumentException(String.format("No directory %s", file.getAbsoluteFile()));
}
        System.out.println(String.format("size : %s", file.getTotalSpace()));
for (File subfile : file.listFiles()) {
    if (!subfile.isDirectory()) {
        System.out.println("File name " + subfile.getName() + ", size file " + subfile.length() + " b");
    }

}
    }
}
