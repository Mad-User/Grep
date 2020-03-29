package icc.stud.kotov_av.grep;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

public class Grep {  

  private static DataHolder parseArguments(final String[] args) {
    final DataHolder dataHolder = new DataHolder();
    final CmdLineParser parser = new CmdLineParser(dataHolder);

    if (args.length < 2 || args.length > 5) {
      System.out.println("Bad arguments...");
      System.exit(-1);
    } 
    else {
      try {
        parser.parseArgument(args);
      } catch (final CmdLineException clEx) {
        System.out.println("Bad arguments...");
        System.exit(-1);
      }

      dataHolder.word = args[args.length - 2];
      dataHolder.inputFile = args[args.length - 1];
    }

    return dataHolder;
  }

  public static void main(final String[] args) {
    parseArguments(args);
  }
}
