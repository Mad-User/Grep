package icc.stud.kotov_av.grep;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import org.junit.Test;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

public class GrepTest {

    @Test
    public void testArgumentsHolder() {
        String[] args = { "-i", "-V", "hdgc", "file.txt" };
        ArgumentsHolder holder = new ArgumentsHolder();
        CmdLineParser parser = new CmdLineParser(holder);

        try {
            parser.parseArgument(args);
        } catch (CmdLineException ex) {
            fail(ex.getMessage());
        }

        assertTrue(holder.ignoreCase);
        assertTrue(holder.isInverse);
        assertEquals(holder.wordAndFileName.get(0), "hdgc");
        assertEquals(holder.wordAndFileName.get(1), "file.txt");
    }

    @Test
    public void mainTest() {
        String[] args;
        String tFilePath;

        args = new String[] { "src/test/resourses/notExistFile.txt" };
        try {
            grepInitialization(args);
        } catch (Exception e) {
            assertEquals("Check arguments...\nYou set not enough info.", e.getMessage());
        }

        args = new String[] { "-i", "-v", "-r", ".{1,}[{}]", "src/test/resourses/testFile.txt", "" };
        try {
            grepInitialization(args);
        } catch (Exception e) {
            assertEquals("Check arguments...\nYou set too many info.", e.getMessage());
        }

        args = new String[] { "if", "src/test/resourses/notExistFile.txt" };
        try {
            assertArrayEquals(new String[0], grepInitialization(args));
        } catch (Exception e) {
            assertEquals("Check arguments... File src/test/resourses/notExistFile.txt not found", e.getMessage());
        }

        args = new String[] { "if", "src/test/resourses/testFile.txt" };
        tFilePath = "src/test/resourses/___-if.txt";
        try {
            assertArrayEquals(linesInitialization(tFilePath), grepInitialization(args));
        } catch (Exception e) {
            fail(e.getMessage());
        }

        args = new String[] { "-i", "if", "src/test/resourses/testFile.txt" };
        tFilePath = "src/test/resourses/i__-if.txt";
        try {
            assertArrayEquals(linesInitialization(tFilePath), grepInitialization(args));
        } catch (Exception e) {
            fail(e.getMessage());
        }

        args = new String[] { "-v", "if", "src/test/resourses/testFile.txt" };
        tFilePath = "src/test/resourses/_v_-if.txt";
        try {
            assertArrayEquals(linesInitialization(tFilePath), grepInitialization(args));
        } catch (Exception e) {
            fail(e.getMessage());
        }

        args = new String[] { "-i", "-v", "if", "src/test/resourses/testFile.txt" };
        tFilePath = "src/test/resourses/iv_-if.txt";
        try {
            assertArrayEquals(linesInitialization(tFilePath), grepInitialization(args));
        } catch (Exception e) {
            fail(e.getMessage());
        }

        args = new String[] { "-r", ".{1,}[{}]", "src/test/resourses/testFile.txt" };
        tFilePath = "src/test/resourses/__r.txt";
        try {
            assertArrayEquals(linesInitialization(tFilePath), grepInitialization(args));
        } catch (Exception e) {
            fail(e.getMessage());
        }

        args = new String[] { "-v", "-r", ".{1,}[{}]", "src/test/resourses/testFile.txt" };
        tFilePath = "src/test/resourses/_vr.txt";
        try {
            assertArrayEquals(linesInitialization(tFilePath), grepInitialization(args));
        } catch (Exception e) {
            fail(e.getMessage());
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
