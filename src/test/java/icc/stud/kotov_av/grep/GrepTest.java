package icc.stud.kotov_av.grep;

import org.junit.Test;

public class GrepTest {

  @Test
  public void mainTest() {
    String[] args = {"-i", "-V", "2", "3"};
    Grep.main(args);

    args = new String[] {"yhvlyv", "obluyv"};
    Grep.main(args);
  }

}
