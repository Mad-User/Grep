package icc.stud.kotov_av.grep;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

import org.junit.Test;

public class GrepTest {

  @Test
  public void testArgumentsHolder() {
    String[] args = { "-i", "-V", "hdgc", "file.txt" };
    ArgumentsHolder holder = new ArgumentsHolder(args);
    assertTrue(holder.caseIgnore);
    assertTrue(holder.inversion);
    assertEquals(holder.word, "hdgc");
    assertEquals(holder.inputFile, "file.txt");
  }

  @Test
  public void testFileHandle() {
    String[] args = { "i", "not_need_now" };
    ArgumentsHolder ah = new ArgumentsHolder(args);
    FileHandler fh = new FileHandler();
    byte[] baisInput = ("huuyigbxv\n" + "ionoivd'io\n" + "ilbsdhbldb\n").getBytes();
    ByteArrayInputStream bais = new ByteArrayInputStream(baisInput);
    InputStreamReader isr = new InputStreamReader(bais);
    BufferedReader br = new BufferedReader(isr);
    String[] lines = new String[] { "huuyigbxv\n", "ionoivd'io\n", "ilbsdhbldb\n" };

    try {
      fh.execute(ah, br);
      assertArrayEquals(lines, fh.getLines());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
