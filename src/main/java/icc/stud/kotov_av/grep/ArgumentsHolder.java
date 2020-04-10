package icc.stud.kotov_av.grep;

import java.util.ArrayList;
import java.util.List;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.Option;

public class ArgumentsHolder {

    @Option(name = "-i", aliases="-I", usage =  "Ignore case")
    public boolean ignoreCase = false;
 
    @Option(name="-r", aliases="-R", usage="Regex")
    public boolean isRegex = false;
 
    @Option(name = "-v", aliases="-V", usage =  "Inversion")
    public boolean isInverse = false;
 
    @Argument
    List<String> wordAndFileName = new ArrayList();

    public ArgumentsHolder(){}
}
