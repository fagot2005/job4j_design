package inputoutput;

import java.io.File;

public class ArgFoundFileParam {
    private final String[] args;
    private String[] stringArg;

    public ArgFoundFileParam(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        String tempString = "";
        for (int i = 0; i < args.length; i++) {
            tempString = tempString + args[i] + " ";
        }
        stringArg = tempString.split("-");
        if (stringArg.length != 6) {
            throw new IllegalArgumentException("Don't correct used string of run project: java -jar pack.jar -d E:/Java/Java_Project/job4j_design -e class -o project.zip ");
        }
        if (!stringArg[2].startsWith("d") || !stringArg[3].startsWith("n") || (!(stringArg[4].startsWith("m") || stringArg[4].startsWith("f") || stringArg[4].startsWith("r"))) || !stringArg[5].startsWith("o")) {
            throw new IllegalArgumentException("Don't correct used key  -d..., -e..., -o..., (-m, -f, -r)..., -o");
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
        return stringArg[2].substring(stringArg[2].indexOf(" ")).trim();
    }

    public String selection() {
        return stringArg[3].substring(stringArg[3].indexOf(" ")).trim();
    }

    public String mask() {
        return stringArg[4];
    }

    public String output() {
        return stringArg[5].substring(stringArg[5].indexOf(" ")).trim();
    }
}
