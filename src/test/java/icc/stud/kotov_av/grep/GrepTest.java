package icc.stud.kotov_av.grep;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class GrepTest {

  @Test
  public void mainTest() {
    String[] args = {"-i", "-V", "hdgc", "file.txt"};
    ArgumentsHolder holder = new ArgumentsHolder(args);
    assertTrue(holder.caseIgnore);
    assertTrue(holder.inversion);
    assertEquals(holder.word, "hdgc");
    assertEquals(holder.inputFile, "file.txt");
  }
}
