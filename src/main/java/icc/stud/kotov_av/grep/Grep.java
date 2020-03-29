package icc.stud.kotov_av.grep;

public class Grep {

  static enum Args {
    i, r, v;

    boolean match(String arg) {
      return ("-" + name()).equalsIgnoreCase(arg);
    }
  }

  static DataHolder parseArguments(final String[] args) throws IllegalArgumentException {
    final DataHolder dataHolder = new DataHolder();

    int count = 0;
    for (String arg : args) {
      if (Args.i.match(arg)) {
        dataHolder.caseIgnore = true;
      } else if (Args.r.match(arg)) {
        dataHolder.regex = true;
      } else if (Args.v.match(arg)) {
        dataHolder.inversion = true;
      } else {
        count++;
        if (count == 1) {
          dataHolder.word = arg;
        } else if (count == 2) {
          dataHolder.inputFile = arg;
        } else {
          throw new IllegalArgumentException("");
        }
      }
    }

    return dataHolder;
  }

  public static void main(final String[] args) {
    parseArguments(args);
  }
}
