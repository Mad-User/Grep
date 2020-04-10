package icc.stud.kotov_av.grep;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.kohsuke.args4j.CmdLineParser;

public class Grep {
    private ArrayList<String> lines;
    private ArgumentsHolder ah;

    public Grep(String[] args) throws Exception {
        if (args.length < 2) {
            throw new Exception("Check arguments...\nYou set not enough info.");
        }
        if (args.length > 5) {
            throw new Exception("Check arguments...\nYou set too many info.");
        }

        lines = new ArrayList<String>();
        ah = new ArgumentsHolder();

        CmdLineParser parser = new CmdLineParser(ah);
        parser.parseArgument(args);

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
        File file = new File(ah.wordAndFileName.get(1));
        if (!file.exists()) {
            throw new Exception("Check arguments... File " + ah.wordAndFileName.get(1) + " not found");
        }

        BufferedReader br = new BufferedReader(new FileReader(file));
        try {
            int flags = ah.ignoreCase ? Pattern.CASE_INSENSITIVE : 0;
            Pattern pattern = ah.isRegex ? Pattern.compile(ah.wordAndFileName.get(0), flags) : null;

            String search = ah.ignoreCase ? ah.wordAndFileName.get(0).toLowerCase() : ah.wordAndFileName.get(0);

            String line = null;
            while ((line = br.readLine()) != null) {
                if (pattern != null) {
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.matches() ^ ah.isInverse)
                        lines.add(line);
                } else {
                    if (ah.ignoreCase) {
                        if (line.toLowerCase().contains(search) ^ ah.isInverse)
                            lines.add(line);
                    } else {
                        if (line.contains(search) ^ ah.isInverse)
                            lines.add(line);
                    }
                }
            }
        } finally {
            br.close();
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