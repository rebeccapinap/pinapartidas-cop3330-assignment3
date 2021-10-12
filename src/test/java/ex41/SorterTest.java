package ex41;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SorterTest {
    @Test
    public void checkFile() throws FileNotFoundException
    {
        File input = new File("src/test/java/ex41/testfile41.txt");
        ArrayList<String> list = new ArrayList<String>();
        list.add("Doe, John");
        list.add("Allen, Jason");
        list.add("Towers, Joseph");

        assertEquals(list, NameSorter.scanFile(input));
    }
}
