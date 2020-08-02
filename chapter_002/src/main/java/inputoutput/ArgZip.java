package inputoutput;

import java.io.File;

public class ArgZip {
    private final String[] args;
    private String[] arg;

    public ArgZip(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        String tempString = "";
        for (int i = 0; i < args.length; i++) {
            tempString = tempString + args[i] + " ";
        }
        arg = tempString.split("-");
        if (arg.length != 5) {
            throw new IllegalArgumentException("Don't correct used string of run project: java -jar pack.jar -d E:/Java/Java_Project/job4j_design -e class -o project.zip ");
        }
        if (!arg[2].startsWith("d") || !arg[3].startsWith("e") || !arg[4].startsWith("o")) {
            throw new IllegalArgumentException("Don't correct used key  -d..., -e..., -o...");
        }
        if (!arg[3].substring(arg[3].indexOf(" ")).trim().startsWith(".")) {
            throw new IllegalArgumentException("Exclude files name will start with ., f.e. .txt");
        }
        File file = new File(directiry());
        if (!file.exists()) {
            throw new IllegalArgumentException("Not correct directory patch");
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException("Patch is not directory");
        }
        return true;
    }

    public String directiry() {
        return arg[2].substring(arg[2].indexOf(" ")).trim();
    }

    public String exclude() {
        return arg[3].substring(arg[3].indexOf(" ")).trim();
    }

    public String output() {
        return arg[4].substring(arg[4].indexOf(" ")).trim();
    }
}
