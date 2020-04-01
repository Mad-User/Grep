package icc.stud.kotov_av.grep;

public class ArgumentsHolder {

    public boolean regex;

    public boolean inversion;

    public boolean caseIgnore;

    public String word;

    public String inputFile;

    public ArgumentsHolder(String[] args) {
        parseArguments(args);
    }

    private void parseArguments(final String[] args) throws IllegalArgumentException {
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
