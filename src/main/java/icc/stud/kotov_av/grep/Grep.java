package icc.stud.kotov_av.grep;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Grep {
    private ArrayList<String> lines;
    private ArgumentsHolder ah;
    private BufferedReader br;

    public Grep(String[] args) throws Exception {
        lines = new ArrayList<String>();
        ah = new ArgumentsHolder(args);
        br = new BufferedReader(new FileReader(ah.inputFile));
        execute();
    }

    public void print() {
        for (String line : lines) {
            System.out.println(line);
        }
    }

    public String[] getLines() {
        String[] output = new String[lines.size()];
        output = lines.toArray(output);
        return output;
    }

    public void execute() throws Exception {
        int flags = ah.caseIgnore ? Pattern.CASE_INSENSITIVE : 0;
        Pattern pattern = ah.regex ? Pattern.compile(ah.word, flags) : null;

        String search = ah.caseIgnore ? ah.word.toLowerCase() : ah.word;

        String line = null;
        while ((line = br.readLine()) != null) {
            if (pattern != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches() ^ ah.inversion)
                    lines.add(line);
            } else {
                if (ah.caseIgnore) {
                    if (line.toLowerCase().contains(search) ^ ah.inversion)
                        lines.add(line);
                } else {
                    if (line.contains(search) ^ ah.inversion)
                        lines.add(line);
                }
            }
        }
    }

    public static void main(final String[] args) {
        try {
            Grep fh = new Grep(args);
            fh.print();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}