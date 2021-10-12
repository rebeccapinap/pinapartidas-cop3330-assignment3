package ex45;

import ex41.NameSorter;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class FinderTest {
    @Test
    public void checkFinder() throws FileNotFoundException
    {
        File input = new File("src/test/java/ex45/testfile45.txt");
        String output = "One should never utilize the word \"utilize\" in writing. Use \"use\" instead.\n" +
                "For example, \"She uses an IDE to write her Java programs\" instead of \"She\n" +
                "utilizes an IDE to write her Java programs\".\n";
        String replace = "One should never use the word \"use\" in writing. Use \"use\" instead.\n" +
                "For example, \"She uses an IDE to write her Java programs\" instead of \"She\n" +
                "uses an IDE to write her Java programs\".\n";

        assertEquals(output, WordFinder.scanFile(input));
        assertEquals(replace, WordFinder.replace(output));
    }
}
