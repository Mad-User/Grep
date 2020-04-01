package icc.stud.kotov_av.grep;

import java.io.BufferedReader;
import java.io.FileReader;

public class Grep {
  public static void main(final String[] args) {
    ArgumentsHolder ah = new ArgumentsHolder(args);
    FileHandler fh = new FileHandler();

    try (BufferedReader br = new BufferedReader(new FileReader(ah.inputFile))) {
      fh.execute(ah, br);
      fh.print();
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
  }
}
