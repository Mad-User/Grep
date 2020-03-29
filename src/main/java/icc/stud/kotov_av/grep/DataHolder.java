package icc.stud.kotov_av.grep;

import org.kohsuke.args4j.Option;

public class DataHolder {
    @Option(name="-r", aliases="-R", usage="...")
    public boolean regex;
 
    @Option(name="-v", aliases="-V", usage="...")  
    public boolean inversion;
 
    @Option(name="-i", aliases="-I", usage="...")
    public boolean caseIgnore;

    public String word;

    public String inputFile;
}
