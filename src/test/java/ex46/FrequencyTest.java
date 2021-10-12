package ex46;

import ex41.NameSorter;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class FrequencyTest {
    @Test
    public void checkFrequency() throws FileNotFoundException
    {
        File input = new File("src/test/java/ex46/testfile46.txt");
        ArrayList<String> list = new ArrayList<String>();
        list.add("badger");
        list.add("badger");
        list.add("badger");
        list.add("badger");
        list.add("mushroom");
        list.add("mushroom");
        list.add("snake");
        list.add("badger");
        list.add("badger");
        list.add("badger");
        list.add("mushroom");
        list.add("mushroom");
        list.add("mushroom");
        list.add("mushroom");
        list.add("mushroom");
        list.add("mushroom");

        assertEquals(list, WordFrequencyFinder.parseFile(input));

        HashMap<String, Integer> unsortedMap = new HashMap<>();
        unsortedMap.put("badger", 7);
        unsortedMap.put("mushroom", 8);
        unsortedMap.put("snake", 1);

        HashMap<String, Integer> sortedMap = new HashMap<>();
        sortedMap.put("mushroom", 8);
        sortedMap.put("badger", 7);
        sortedMap.put("snake", 1);

        assertEquals(sortedMap, WordFrequencyFinder.sortByFrequency(unsortedMap));
    }
}
