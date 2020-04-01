package icc.stud.kotov_av.grep;

public class ArgumentsHolder {

    // "-r" || "-R"
    public boolean regex;

    // "-v" || "-V"
    public boolean inversion;

    // "-i" || "-I"
    public boolean caseIgnore;

    public String word;

    public String inputFile;

    public ArgumentsHolder(String[] args) {
        int count = 0;
        for (String arg : args) {
            if (Args.i.match(arg)) {
                caseIgnore = true;
            } else if (Args.r.match(arg)) {
                regex = true;
            } else if (Args.v.match(arg)) {
                inversion = true;
            } else {
                count++;
                if (count == 1) {
                    word = arg;
                } else if (count == 2) {
                    inputFile = arg;
                } else {
                    throw new IllegalArgumentException("");
                }
            }
        }
    }

    private enum Args {
        i, r, v;

        boolean match(String arg) {
            return ("-" + name()).equalsIgnoreCase(arg);
        }
    }
}
