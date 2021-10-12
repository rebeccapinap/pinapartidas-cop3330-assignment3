package ex42;

import ex41.NameSorter;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class ParsingTest {
    @Test
    public void checkParser() throws FileNotFoundException {
        File inputFile = new File("src/test/java/ex42/testfile42.txt");
        Scanner input = new Scanner(inputFile);
        ArrayList<String[]> list = new ArrayList<>();
        String temp;
        String[] indivInput;
        int i, j;

        while(input.hasNextLine())
        {
            temp = input.nextLine();
            indivInput = temp.split(",", 3);
            list.add(indivInput);
        }

        ArrayList<String[]> expected = ParsingFile.parseFile(inputFile);

        assertEquals(true, list.size() == expected.size());

        for(i = 0; i < list.size(); i++)
        {
            for(j = 0; j < 3; j++)
            {
                assertEquals(true, list.get(i)[j].equals(expected.get(i)[j]));
            }
        }
    }
}
