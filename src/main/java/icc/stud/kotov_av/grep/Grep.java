package icc.stud.kotov_av.grep;

public class Grep {
  public static void main(final String[] args) {
    
    ArgumentsHolder ah = new ArgumentsHolder(args);

    String[] array = new String[] { "123\n", "321\n", "111\n", "222\n", "333\n", "444\n", "555\n", "666\n", "777\n", "888\n", "999\n", "000\n", "111\n", "222\n", "333\n", "444\n"};

    for (String string : array) {
      System.out.print(string);
    }
  }
}
