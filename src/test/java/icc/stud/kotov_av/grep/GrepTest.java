package icc.stud.kotov_av.grep;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class GrepTest {

  @Test
  public void mainTest() {
    String[] args = {"-i", "-V", "hdgc", "file.txt"};
    DataHolder holder = Grep.parseArguments(args);
    assertTrue(holder.caseIgnore);
    assertTrue(holder.inversion);
    assertEquals(holder.word, "hdgc");
    assertEquals(holder.inputFile, "file.txt");

    // args = new String[] {"yhvlyv", "obluyv"};
    // Grep.main(args);

    // args = new String[] {"yhvlyv", "obluyv", "sdgsdg"};
    // Grep.main(args);
  }

}
