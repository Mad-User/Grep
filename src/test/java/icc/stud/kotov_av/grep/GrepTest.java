package icc.stud.kotov_av.grep;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

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
    public void mainTest() {
        String[] args;
        String tFilePath;

        args = new String[] { "if", "src/test/resourses/testFile.txt" };
        tFilePath = "src/test/resourses/___-if.txt";
        try {
            assertArrayEquals(linesInitialization(tFilePath), grepInitialization(args));
        } catch (Exception e) {
            e.printStackTrace();
        }

        args = new String[] { "-i", "if", "src/test/resourses/testFile.txt" };
        tFilePath = "src/test/resourses/i__-if.txt";
        try {
            assertArrayEquals(linesInitialization(tFilePath), grepInitialization(args));
        } catch (Exception e) {
            e.printStackTrace();
        }

        args = new String[] {"-v", "if", "src/test/resourses/testFile.txt"};
        tFilePath = "src/test/resourses/_v_-if.txt";
        try {
            assertArrayEquals(linesInitialization(tFilePath), grepInitialization(args));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        args = new String[] { "-i", "-v", "if", "src/test/resourses/testFile.txt" };
        tFilePath = "src/test/resourses/iv_-if.txt";
        try {
            assertArrayEquals(linesInitialization(tFilePath), grepInitialization(args));
        } catch (Exception e) {
            e.printStackTrace();
        }

        args = new String[] { "-r", ".{1,}[{}]", "src/test/resourses/testFile.txt" };
        tFilePath = "src/test/resourses/__r.txt";
        try {
            assertArrayEquals(linesInitialization(tFilePath), grepInitialization(args));
        } catch (Exception e) {
            e.printStackTrace();
        }

        args = new String[] { "-v", "-r", ".{1,}[{}]", "src/test/resourses/testFile.txt" };
        tFilePath = "src/test/resourses/_vr.txt";
        try {
            assertArrayEquals(linesInitialization(tFilePath), grepInitialization(args));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String[] grepInitialization(String[] args) throws Exception {
        Grep tObj = new Grep(args);
        return tObj.getLines();
    }

    private String[] linesInitialization(String path) throws Exception {
        ArrayList<String> lines = new ArrayList<String>();

        BufferedReader tBr = new BufferedReader(new FileReader(path));
        String line;
        while ((line = tBr.readLine()) != null) {
            lines.add(line);
        }
        tBr.close();

        String[] output = new String[lines.size()];
        output = lines.toArray(output);

        return output;
    }
}
